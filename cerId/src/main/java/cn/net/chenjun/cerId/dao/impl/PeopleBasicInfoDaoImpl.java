package cn.net.chenjun.cerId.dao.impl;

import cn.net.chenjun.cerId.dao.PeopleBasicInfoDao;
import cn.net.chenjun.cerId.model.PeopleBasicInfo;

public class PeopleBasicInfoDaoImpl extends
		GenericDaoDao<PeopleBasicInfo, Long> implements
		PeopleBasicInfoDao {
	public PeopleBasicInfoDaoImpl() {
		super(PeopleBasicInfo.class);
	}
}
