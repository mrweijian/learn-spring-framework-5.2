package com.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName MyEventPublisher
 * @Author weijian
 * @Date 2021/8/30
 */
@Component
public class MyEventPublisher {

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@PostConstruct
	public void publishEvent(Object event) {
		applicationEventPublisher.publishEvent(event);
	}
}
