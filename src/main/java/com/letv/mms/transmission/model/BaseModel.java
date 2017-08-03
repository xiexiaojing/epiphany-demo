package com.letv.mms.transmission.model;

import java.io.Serializable;

public class BaseModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5822755615614280336L;
	
	private Long id;
	
	private Boolean deleted=false;
	// 分页时开始记录
	private Integer baseStart ;
	// 分页时每页记录数
	private Integer baseSize ;
	private String multiLangId;
	private Integer orderBy; // 0升序 1降序
	private Integer flag;// 该属性用于扩展model的属性
	private java.util.Date beginTime; // 开始时间
	private java.util.Date endTime; // 结束时间

	private Integer beginId;
	private Integer endId;
	
	// model对应的表，有默认实现，如果要特殊处理请 override getTable方法
	private String tableName;
	
	public Integer getBeginId() {
		return beginId;
	}

	public void setBeginId(Integer beginId) {
		this.beginId = beginId;
	}

	public Integer getEndId() {
		return endId;
	}

	public void setEndId(Integer endId) {
		this.endId = endId;
	}

	public Integer getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBaseStart() {
		return baseStart;
	}

	public void setBaseStart(Integer baseStart) {
		this.baseStart = baseStart;
	}

	public Integer getBaseSize() {
		return baseSize;
	}

	public void setBaseSize(Integer baseSize) {
		this.baseSize = baseSize;
	}

	public java.util.Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(java.util.Date beginTime) {
		this.beginTime = beginTime;
	}

	public java.util.Date getEndTime() {
		return endTime;
	}

	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}
	
	public String getMultiLangId() {
        return multiLangId;
    }

    public void setMultiLangId(String multiLangId) {
        this.multiLangId = multiLangId;
    }

    /**
	 * 默认方法，对象名去掉model,每个大写字母断开用下划线区分
	 *
	 * @author zhumingyuan
	 * @date Mar 16, 2015 5:24:47 PM 
	 * @return
	 */
    public String getTableName() {
        if (tableName != null && tableName.length() > 0) {
            return tableName;
        } else {
            String className = this.getClass().getSimpleName();
            // 阶段到model前面
            String subClassName = className.substring(0, className.length() - 5);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < subClassName.length(); i++) {
                char c = subClassName.charAt(i);
                // 大写断开
                if (Character.isUpperCase(c)) {
                    if (i != 0) {
                        // 表分隔符
                        sb.append("_");
                    }
                    sb.append(Character.toLowerCase(c));
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    
}
