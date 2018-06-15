package com.bit.struts2.action;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.bit.struts2.model.GuestDao;
import com.bit.struts2.model.entity.GuestVo;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class GuestAction implements ModelDriven<GuestVo>, Preparable {
	// POJO... 
	
	Logger log = Logger.getLogger(getClass());
	private List list;
	private String msg;
	private int idx;
	private GuestVo bean;
	private GuestDao dao = new GuestDao();
		
	public List getList() {
		return list;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void setIdx(int idx) {
		this.idx = idx;
	}

	public void setBean(GuestVo bean) {
		this.bean = bean;
	}
	public GuestVo getBean() {
		return bean;
	}
	
	public String one() throws SQLException{
		log.debug("detail()");
		bean = dao.selectOne(idx);
		return "success";
	}
	
	public String list() throws Exception{
		list = dao.selectAll();
		return "success";
	}
	
	public String update() throws Exception{
		
		log.debug("업데이트 전 "+bean.getName());
		int result = dao.updateOne(bean);
		log.debug("업데이트 후 "+result);
		if(result>0) return "success";
		else return "error";
	}
	
	public String delete() throws Exception{
		if(dao.deleteOne(idx)>0) return "success";
		else return "error";
	}
	
	public String execute() throws Exception{
		return "success";
	}
	
	public String add() throws Exception{
		dao.insertOne(bean);
		return "success";
	}

	@Override
	public GuestVo getModel() {
		return bean;
	}

	@Override
	public void prepare() throws Exception {
		bean = new GuestVo();
	}
	
}
