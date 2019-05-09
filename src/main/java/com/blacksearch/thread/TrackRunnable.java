package com.blacksearch.thread;

import com.blacksearch.interceptor.LogHandlerInterceptor;

public abstract class TrackRunnable implements Runnable {

	public abstract void trackRun();

	private String track = LogHandlerInterceptor.getTrack();

	@Override
	public void run() {
		try {
			LogHandlerInterceptor.setTrace(track);
			trackRun();
		}finally {
			LogHandlerInterceptor.remove();
		}
	}
}
