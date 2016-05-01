package com.wondersgroup.server.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wondersgroup.base.dao.BaseDao;
import com.wondersgroup.server.dao.IAddressDao;
@Repository
public class IAddressDaoImpl extends BaseDao implements IAddressDao{

	@Override
	public void getAddress(String address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List getArea(String clevel) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer();
		sql.append("	select *			 ");
		sql.append("		from 	      	 ");
		sql.append("	c_jkgl_area 		 ");
		sql.append("	where clevel=?     ");
		return this.getJdbcTemplate().queryForList(sql.toString(),new Object[]{clevel},new int[]{12});
	}

	@Override
	public List<Map<String, Object>> getAreaByCparent(String clevel, String cparent) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer();
		sql.append("	select *			 ");
		sql.append("		from 	      	 ");
		sql.append("	c_jkgl_area 		 ");
		sql.append("	where clevel=? and cparent=?    ");
		return this.getJdbcTemplate().queryForList(sql.toString(),new Object[]{clevel,cparent},new int[]{12,12});
	}

	@Override
	public List<Map<String, Object>> getAddressByZm(String address) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer();
		sql.append("	select *			 ");
		sql.append("		from 	      	 ");
		sql.append("	tb_dic_address_reference 		 ");
		sql.append("	where helpcode like ?  and rownum <'200'    ");
		return this.getJdbcTemplate().queryForList(sql.toString(),new Object[]{"%"+address+"%"},new int[]{12});
	}

	@Override
	public List<Map<String, Object>> getAddressByZfc(String address) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer();
		sql.append("	select *			 ");
		sql.append("		from 	      	 ");
		sql.append("	tb_dic_address_reference 		 ");
		sql.append("	where pa_full like ?  and rownum <'200'  ");
		return this.getJdbcTemplate().queryForList(sql.toString(),new Object[]{"%"+address+"%"},new int[]{12});
	}


}
