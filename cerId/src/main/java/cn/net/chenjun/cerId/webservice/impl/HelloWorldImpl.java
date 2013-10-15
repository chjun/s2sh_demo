package cn.net.chenjun.cerId.webservice.impl;

import javax.jws.WebService;

import cn.net.chenjun.cerId.webservice.HelloWorld;

@WebService(serviceName="helloWorld")
public class HelloWorldImpl implements HelloWorld {
	public HelloWorldImpl() {
		System.out.println(123);
	}

	public String sayHello(String foo) {
		return "hello " + foo;
	}
}