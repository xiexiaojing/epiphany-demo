package com.letv.mms.transmission.model;

/**
 * 多语言公用的对象
 *
 * @author zhumingyuan
 * @date Jun 11, 2015 5:41:11 PM
 */
public class MultiLangBaseModel extends BaseModel {
	
	private static final long serialVersionUID = 1L;
	
	private Long relationId;//   专辑的id外键
	private Integer lang;//   语言id字典值
	private java.util.Date createTime;//   创建时间
	private Integer createId;//   创建人
	private java.util.Date updateTime;//   修改时间
	private Integer updateId;//   修改人
	private String name;//   名称

	public String getName() {
	    return this.name;
	}
	public void setName(String name) {
	    this.name=name;
	}
	
	public Long getRelationId() {
		return relationId;
	}
	public void setRelationId(Long relationId) {
		this.relationId = relationId;
	}
	public Integer getLang() {
		return lang;
	}
	public void setLang(Integer lang) {
		this.lang = lang;
	}
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	public Integer getCreateId() {
		return createId;
	}
	public void setCreateId(Integer createId) {
		this.createId = createId;
	}
	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getUpdateId() {
		return updateId;
	}
	public void setUpdateId(Integer updateId) {
		this.updateId = updateId;
	}
	
	
}
