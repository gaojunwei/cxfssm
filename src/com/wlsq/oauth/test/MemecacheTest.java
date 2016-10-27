package com.wlsq.oauth.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.danga.MemCached.MemCachedClient;
import com.wlsq.oauth.entity.User;


public class MemecacheTest {
	/**
	 * memcached ������
	 * <br>------------------------------<br>
	 */
	@Test
	public void testInsert() {
		String id = "5058184ec85607e42c4bfad8";
		getUserDao().set("1", id);
		System.out.println("success");
	}
	
	/**
	 * memcached ȡ����
	 * <br>------------------------------<br>
	 */
	@Test
	public void testGet() {
		//ɾ���������25��
		String id =(String) getUserDao().get("1");
		System.out.println("id is:"+id);
	}
	
	public MemCachedClient getUserDao() {
		String configLocations = "spring/spring-context.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocations);
		MemCachedClient memcachedClient = applicationContext.getBean("memCachedClient", MemCachedClient.class);
		return memcachedClient;
	}
}
