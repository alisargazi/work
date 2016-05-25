package com.yush.mk.entity;

import java.sql.Timestamp;

public class Picture {
	private String p_id;
	private String p_url;
	private String p_localsite;
	private Timestamp p_createtime;
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getP_url() {
		return p_url;
	}
	public void setP_url(String p_url) {
		this.p_url = p_url;
	}
	public String getP_localsite() {
		return p_localsite;
	}
	public void setP_localsite(String p_localsite) {
		this.p_localsite = p_localsite;
	}
	public Timestamp getP_createtime() {
		return p_createtime;
	}
	public void setP_createtime(Timestamp p_createtime) {
		this.p_createtime = p_createtime;
	}
}
