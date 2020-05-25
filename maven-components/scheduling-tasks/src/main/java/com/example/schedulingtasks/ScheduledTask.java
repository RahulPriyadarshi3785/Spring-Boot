package com.example.schedulingtasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.stereotype.Component;


@Component
public class ScheduledTask {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

	private int count = 0;

	@Autowired
	private ScheduledAnnotationBeanPostProcessor sabpp;
	
//	@Scheduled(fixedRate = 3000)
	public void reportCurrentTime() {
		if(count++ % 4 == 3)
			sabpp.destroy();
		
		log.info(sabpp.toString());
		
	}
}