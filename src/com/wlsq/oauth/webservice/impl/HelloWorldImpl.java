package com.wlsq.oauth.webservice.impl;

import javax.jws.WebService;

import com.wlsq.oauth.webservice.HelloWorld;


@WebService(endpointInterface="com.wlsq.oauth.webservice.HelloWorld",serviceName="helloWorld",targetNamespace="http://dao.cxf.ws.com/")
public class HelloWorldImpl implements HelloWorld{

	public String sayHello(String username) {
		System.out.println("sayHello() is called");
		return username +" helloWorld";
	}
}