package com.wondersgroup.base.dao;


import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

@SuppressWarnings("all")
public abstract class BaseDao extends JdbcDaoSupport {

	@Resource(name = "jdbcTemplate")
	protected void setSuperSessionFactory(JdbcTemplate  jdbctemplate ) {
		super.setJdbcTemplate(jdbctemplate);
	}
}
