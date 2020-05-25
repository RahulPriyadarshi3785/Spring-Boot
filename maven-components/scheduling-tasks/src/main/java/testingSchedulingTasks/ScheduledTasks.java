package testingSchedulingTasks;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private int count = 0;

	@Autowired
	private ScheduledAnnotationBeanPostProcessor sabpp;

	ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
	boolean open = true;
	
	public void reportCurrentTime() {
		
		hello();
	}

	@Scheduled(fixedDelay = 5000)
	public void hello() {
		if(count++ % 4 == 1) {
//			sabpp.destroy(); // prefer in gradle build
			/* other way to cancel it*/
			for(ScheduledTask s: sabpp.getScheduledTasks()) {
				s.cancel();
				log.warn("Cancelled Scheduled Task");
			}
			if(!ses.isShutdown()) {
				ses.shutdown();
				log.info("Scheduler down");
			}
			if(!open)
				log.warn("Restarted Process down");
			log.info("Restarting Scheduler");
			restartingScheduler();
			open = false;
		}
		
		log.info(sabpp.getScheduledTasks().size() + " -> " + sabpp.toString().substring(sabpp.toString().indexOf("@")));
		
	}
	
	protected void restartingScheduler() {
		ses = Executors.newSingleThreadScheduledExecutor();
		ses.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				hello();
			}
		}, 3, 7, TimeUnit.SECONDS);
	}
}