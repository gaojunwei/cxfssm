package com.wlsq.oauth.quartz;


public class SpringQtz {
	private static int counter = 0;

	protected void execute() {
		long ms = System.currentTimeMillis();
		System.out.println("quartz ��ʱ����ϵͳ--ִ�д�����"+(++counter));
	}
}
