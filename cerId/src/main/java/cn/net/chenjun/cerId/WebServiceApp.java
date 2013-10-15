package cn.net.chenjun.cerId;

import javax.xml.ws.Endpoint;

import junit.framework.TestCase;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Assert;

import cn.net.chenjun.cerId.webservice.HelloWorld;
import cn.net.chenjun.cerId.webservice.impl.HelloWorldImpl;

public class WebServiceApp extends TestCase {

	private static final String ADDRESS = "http://localhost:9000/cxfdemo";

	protected void setUp() throws Exception {
		super.setUp();

		System.out.println("Starting Server");
		HelloWorld demo = new HelloWorldImpl();

		Endpoint.publish(ADDRESS, demo);
		System.out.println("Start success");
	}

	public void testSayHello() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(HelloWorld.class);
		factory.setAddress(ADDRESS);
		HelloWorld client = (HelloWorld) factory.create();
		Assert.assertEquals(client.sayHello("foo"), "hello foo");
	}
}