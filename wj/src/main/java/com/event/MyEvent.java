package com.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyEvent
 * @Author weijian
 * @Date 2021/8/30
 */

@Component
public class MyEvent extends ApplicationEvent{

	public MyEvent(MyEvent event) {
		super(event);
	}
}
