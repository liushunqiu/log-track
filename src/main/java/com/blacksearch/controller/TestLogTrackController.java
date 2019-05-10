package com.blacksearch.controller;

import com.blacksearch.thread.TrackRunnable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLogTrackController {

	private static final Logger logger = LoggerFactory.getLogger(TestLogTrackController.class);
	@RequestMapping("/logTrack")
	public String logTrack(){
		logger.info("测试");
		return null;
	}

	@RequestMapping("/asynLogTrack")
	public String asynLogTrack(){
		logger.info("ces--------");
		new Thread(new Runnable() {
			@Override
			public void run() {
				logger.info("ces");
			}
		}).start();
		return null;
	}

	@RequestMapping("/asynLogTrackHasTrace")
	public String asynLogTrackHasTrace(){
		logger.info("ces1------");
		new Thread(new TrackRunnable() {
			@Override
			public void trackRun() {
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				logger.info("ces2-----------");
			}
		}).start();
		return null;
	}
}
