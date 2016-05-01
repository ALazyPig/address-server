package com.wondersgroup.server.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wondersgroup.server.dao.IAddressDao;
import com.wondersgroup.server.service.IAddressService;
@Service
public class IAddressServiceImpl implements IAddressService {
	
@Autowired private IAddressDao dao;

	@Override
	public void getAddress(String address) {
		// TODO Auto-generated method stub
		dao.getAddress(address);
	}
	
	@Override
	public List getArea(String clevel) {
		// TODO Auto-generated method stub
		return dao.getArea(clevel);
	}

	@Override
	public List<Map<String, Object>> getAreaByCparent(String clevel, String cparent) {
		// TODO Auto-generated method stub
		return dao.getAreaByCparent(clevel,cparent);
	}

	@Override
	public List<Map<String, Object>> getAddressByZm(String address) {
		// TODO Auto-generated method stub
		return dao.getAddressByZm(address);
	}

	@Override
	public List<Map<String, Object>> getAddressByZfc(String address) {
		// TODO Auto-generated method stub
		return dao.getAddressByZfc(address);
	}

}
