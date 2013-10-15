package cn.net.chenjun.cerId.webservice;

import javax.jws.WebService;

@WebService
public interface HelloWorld {
	public String sayHello(String foo);
}