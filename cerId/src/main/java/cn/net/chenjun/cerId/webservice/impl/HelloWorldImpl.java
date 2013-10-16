package cn.net.chenjun.cerId.webservice.impl;

import javax.jws.WebService;

import cn.net.chenjun.cerId.dao.PeopleBasicInfoDao;
import cn.net.chenjun.cerId.model.PeopleBasicInfo;
import cn.net.chenjun.cerId.webservice.HelloWorld;

@WebService(serviceName = "helloworld", targetNamespace = "http://webservice.cerId.chenjun.net.cn/")
public class HelloWorldImpl implements HelloWorld {

	private PeopleBasicInfoDao peopleBasicInfoDao;

	public void setPeopleBasicInfoDao(PeopleBasicInfoDao peopleBasicInfoDao) {
		this.peopleBasicInfoDao = peopleBasicInfoDao;
	}

	public String sayHello(String foo) {
		PeopleBasicInfo pbi = peopleBasicInfoDao.get(1L);
		return "hello, foo! Is your cardNo " + pbi.getIdCardNo() + "?";
	}
}