package com.wondersgroup.server.dao;

import java.util.List;
import java.util.Map;

public interface IAddressDao {

	void getAddress(String address);

	List getArea(String clevel);

	List<Map<String, Object>> getAreaByCparent(String clevel, String cparent);

	List<Map<String, Object>> getAddressByZm(String address);

	List<Map<String, Object>> getAddressByZfc(String address);

}
