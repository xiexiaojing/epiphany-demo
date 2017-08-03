package com.letv.mms.transmission.model;

import java.io.Serializable;
import java.util.Date;

public class CmsNocopyrightContent implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String contentid;
	private String title;
	private String externalUrl;
	private String cityBlackList;
	private String cityLevel;
	private String btime;
	private String etime;
	private String operator;
	private int status;
	private Date mtime;
	private Date ctime;
	private String shieldCityList;
	private int channel;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContentid() {
		return contentid;
	}
	public void setContentid(String contentid) {
		this.contentid = contentid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getExternalUrl() {
		return externalUrl;
	}
	public void setExternalUrl(String externalUrl) {
		this.externalUrl = externalUrl;
	}
	public String getCityBlackList() {
		return cityBlackList;
	}
	public void setCityBlackList(String cityBlackList) {
		this.cityBlackList = cityBlackList;
	}
	public String getCityLevel() {
		return cityLevel;
	}
	public void setCityLevel(String cityLevel) {
		this.cityLevel = cityLevel;
	}
	public String getBtime() {
		return btime;
	}
	public void setBtime(String btime) {
		this.btime = btime;
	}
	public String getEtime() {
		return etime;
	}
	public void setEtime(String etime) {
		this.etime = etime;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getMtime() {
		return mtime;
	}
	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	public String getShieldCityList() {
		return shieldCityList;
	}
	public void setShieldCityList(String shieldCityList) {
		this.shieldCityList = shieldCityList;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
}
