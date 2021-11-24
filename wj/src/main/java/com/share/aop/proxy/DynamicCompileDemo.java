package com.share.aop.proxy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;


/**
 * @ClassName DynamicCompileDemo
 * @Author weijian
 * @Date 2021/11/11
 */
public class DynamicCompileDemo {
	private static int count = 0;
	private Method[] methods = null;
	private Map<String, Method> methodMap = new ConcurrentHashMap<>();

	private Map<String, Class[]> argsObj = new ConcurrentHashMap<>();

	public Map<String, Method> getMethodMap() {
		return methodMap;
	}

	public Class<?> eval(Class<?>[] interfaces) {

		if (interfaces == null || interfaces.length == 0) {
			throw new RuntimeException("代理错误！缺少实现的接口！");
		}
		Class clazz = interfaces[0];
		Method[] declaredMethods = clazz.getDeclaredMethods();
		this.methods = declaredMethods;

		for (Method declaredMethod : declaredMethods) {
			methodMap.put(declaredMethod.getName(), declaredMethod);
			Class<?>[] parameterTypes = declaredMethod.getParameterTypes();

			argsObj.put(declaredMethod.getName(), parameterTypes);
		}

		return getClasses(clazz);
	}

	private synchronized Class<?> getClasses(Class clazz) {

		String packageName = clazz.getPackage().getName();
		String clazzName = clazz.getSimpleName();
		String proxyClazzName = "$" + "Proxy" + count;
		//构建一个类的源代码
		StringBuffer sourceCode = new StringBuffer();
		sourceCode.append("package " + packageName + ";").append("\r\n");
		sourceCode.append("import com.share.aop.proxy.InvocationHandler;\n" +
				"import com.share.aop.proxy.ProxyInterface;\n");
		sourceCode.append("import java.lang.reflect.Method;\n" +
				"import java.util.Map;\n" +
				"import java.util.concurrent.ConcurrentHashMap;\n");
		sourceCode.append(String.format("public class %s implements ProxyInterface {", proxyClazzName)).append("\r\n")
				.append("private InvocationHandler invocationHandler;").append("\r\n")
				.append("private Map<String, Method> methodMap = new ConcurrentHashMap<>();").append("\r\n")
				.append(String.format("public %s(InvocationHandler invocationHandler,Map<String, Method> methodMap) {", proxyClazzName)).append("\r\n")
				.append("this.invocationHandler = invocationHandler;").append("\r\n")
				.append("this.methodMap = methodMap;").append("\r\n")
				.append("}").append("\r\n");

		for (Map.Entry<String, Method> entry : methodMap.entrySet()) {
			sourceCode.append("@Override").append("\r\n");
			Class[] classes = argsObj.get(entry.getKey());
			StringBuilder builder = new StringBuilder();
			builder.append("(");
			StringBuilder builder1 = new StringBuilder();
			if (classes != null && classes.length != 0) {
				for (int i = 0; i < classes.length; i++) {
					String simpleName = classes[i].getSimpleName();
					builder.append(simpleName).append(" arg" + i).append(",");
					builder1.append(" arg" + i).append(",");
				}
			}

			builder.deleteCharAt(builder.length() - 1);
			builder1.deleteCharAt(builder1.length() - 1);

			builder.append(")");
			sourceCode.append(String.format("public void %s%s {", entry.getKey(), builder.toString())).append("\r\n")
					.append(String.format("Method method = methodMap.get(\"%s\");", entry.getKey())).append("\r\n")
					.append(String.format("invocationHandler.invoke(%s,method,new Object[]{%s});", "null", builder1.toString())).append("\r\n")
					.append("}").append("\r\n");
		}
		sourceCode.append("}");
		try {
			//将源文件写入到磁盘中
			String javaFileName = proxyClazzName + ".java";

			File sourceDir = new File("C:\\weijian\\codes\\mr_wei\\spring-framework-5.2.x\\wj\\src\\main\\java\\com\\share\\aop\\proxy");
			if (!sourceDir.exists()) {
				sourceDir.mkdirs();

			}
			File javaFile = new File(sourceDir, javaFileName);
			PrintWriter writer = new PrintWriter(new FileWriter(javaFile));
			writer.write(sourceCode.toString());
			writer.flush();
			writer.close();

			//动态编译磁盘中的代码
			//生成的字节码文件存放到<module>/build/classes/main目录下
			File distDir = new File("C:\\weijian\\codes\\mr_wei\\spring-framework-5.2.x\\wj\\out\\production\\classes");
			if (!distDir.exists()) {
				distDir.mkdirs();
			}
			JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
			//JavaCompiler最核心的方法是run, 通过这个方法编译java源文件, 前3个参数传null时,
			//分别使用标准输入/输出/错误流来 处理输入和编译输出. 使用编译参数-d指定字节码输出目录.
			int compileResult = javac.run(null, null, null, "-d", distDir.getAbsolutePath(), javaFile.getAbsolutePath());
			//run方法的返回值: 0-表示编译成功, 否则表示编译失败
			if (compileResult != 0) {
				System.err.println("编译失败!!");
				return null;
			}

			//动态执行 (反射执行)
			Class klass = Class.forName(packageName + "." + proxyClazzName);
			count++;
			return klass;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {

		}
		return null;
	}

}