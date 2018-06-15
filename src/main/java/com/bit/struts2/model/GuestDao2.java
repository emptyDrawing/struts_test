package com.bit.struts2.model;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.bit.struts2.model.entity.GuestVo;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class GuestDao2 {

	private SqlMapClient smc;

	public GuestDao2() {
		try {
			Reader reader = Resources.getResourceAsReader("./SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(reader);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<GuestVo> selectAll() throws Exception{
		return smc.queryForList("selectAll");
	}
	
}
