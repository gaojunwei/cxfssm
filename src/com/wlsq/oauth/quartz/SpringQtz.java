package com.wlsq.oauth.quartz;


public class SpringQtz {
	private static int counter = 0;

	protected void execute() {
		long ms = System.currentTimeMillis();
		System.out.println("quartz 定时任务系统--执行次数："+(++counter));
	}
}
