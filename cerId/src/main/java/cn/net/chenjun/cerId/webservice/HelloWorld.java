package cn.net.chenjun.cerId.webservice;

import javax.jws.WebService;

@WebService()
public interface HelloWorld {
	String sayHello(String foo);
}