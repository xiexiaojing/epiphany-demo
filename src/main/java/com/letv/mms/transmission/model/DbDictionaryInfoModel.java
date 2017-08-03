package com.letv.mms.transmission.model;

public class DbDictionaryInfoModel extends BaseModel {
	
	private static final long serialVersionUID = -8785256173672079845L;
	private String value;//   	private Integer typeId;//   	private Long parentValueId;//   
    private String channelId;// 所属频道
    private Integer propertyObject;// 1. 专辑 2. 视频	private Integer level;//   
	private String description;
    private java.util.Date createTime;// 创建时间
    private java.util.Date updateTime;// 修改时间
    private Long userId;// 创建用户
    private Long updateUid;// 修改用户
	private String vrsDicId;
    private String valueHk;// 香港繁体
    private String valueTw;// 台湾繁体
    private String valueEn;// 英文信息
    private String site; // 站点信息
    private String descriptionHk; //香港繁体描述
    private String descriptionTw; // 台湾繁体描述
    private String descriptionEn; //英文描述
    private String audioChannelId;// 音频所属频道
    private Integer audioPropertyObject;//音频 0.全部 3. 专辑 4. 音频
    private Integer starPropertyObject;// 乐词明星 5 明星

    
    public Integer getStarPropertyObject() {
		return starPropertyObject;
	}
	public void setStarPropertyObject(Integer starPropertyObject) {
		this.starPropertyObject = starPropertyObject;
	}
	public String getAudioChannelId() {
        return audioChannelId;
    }
    public void setAudioChannelId(String audioChannelId) {
        this.audioChannelId = audioChannelId;
    }
    public Integer getAudioPropertyObject() {
        return audioPropertyObject;
    }
    public void setAudioPropertyObject(Integer audioPropertyObject) {
        this.audioPropertyObject = audioPropertyObject;
    }
    public static final String ID = "ID";
    public static final String VALUE = "VALUE";
    public static final String TYPE_ID = "TYPE_ID";
    public static final String VRS_DIC_ID = "VRS_DIC_ID";
    public static final String PARENT_VALUE_ID = "PARENT_VALUE_ID";
    public static final String CHANNEL_ID = "CHANNEL_ID";
    public static final String PROPERTY_OBJECT = "PROPERTY_OBJECT";
    public static final String LEVEL = "LEVEL";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String DELETED = "DELETED";
    public static final String CREATE_TIME = "CREATE_TIME";
    public static final String UPDATE_TIME = "UPDATE_TIME";
    public static final String USER_ID = "USER_ID";
    public static final String UPDATE_UID = "UPDATE_UID";
    public static final String VALUE_HK = "VALUE_HK";
    public static final String VALUE_TW = "VALUE_TW";
    public static final String VALUE_EN = "VALUE_EN";
    public static final String SITE = "site";
    public static final String DESCRIPTION_HK = "DESCRIPTION_HK";
    public static final String DESCRIPTION_TW = "DESCRIPTION_TW";
    public static final String DESCRIPTION_EN = "DESCRIPTION_EN";    
    public static final String AUDIO_CHANNEL_ID = "AUDIO_CHANNEL_ID";
    public static final String AUDIO_PROPERTY_OBJECT = "AUDIO_PROPERTY_OBJECT";    
    
	public String getVrsDicId() {
		return vrsDicId;
	}
	public void setVrsDicId(String vrsDicId) {
		this.vrsDicId = vrsDicId;
	}
	public String getValue() {	    return this.value;	}	public void setValue(String value) {	    this.value=value;	}	public Integer getTypeId() {	    return this.typeId;	}	public void setTypeId(Integer typeId) {	    this.typeId=typeId;	}	public Long getParentValueId() {	    return this.parentValueId;	}	public void setParentValueId(Long parentValueId) {	    this.parentValueId=parentValueId;	}	public String getChannelId() {	    return this.channelId;	}	public void setChannelId(String channelId) {	    this.channelId=channelId;	}	public Integer getPropertyObject() {	    return this.propertyObject;	}	public void setPropertyObject(Integer propertyObject) {	    this.propertyObject=propertyObject;	}	public Integer getLevel() {	    return this.level;	}	public void setLevel(Integer level) {	    this.level=level;	}	public java.util.Date getCreateTime() {	    return this.createTime;	}	public void setCreateTime(java.util.Date createTime) {	    this.createTime=createTime;	}	public java.util.Date getUpdateTime() {	    return this.updateTime;	}	public void setUpdateTime(java.util.Date updateTime) {	    this.updateTime=updateTime;	}	public Long getUserId() {	    return this.userId;	}	public void setUserId(Long userId) {	    this.userId=userId;	}	public Long getUpdateUid() {	    return this.updateUid;	}	public void setUpdateUid(Long updateUid) {	    this.updateUid=updateUid;	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

    public String getValueHk() {
        return valueHk;
    }

    public void setValueHk(String valueHk) {
        this.valueHk = valueHk;
    }

    public String getValueTw() {
        return valueTw;
    }

    public void setValueTw(String valueTw) {
        this.valueTw = valueTw;
    }

    public String getValueEn() {
        return valueEn;
    }

    public void setValueEn(String valueEn) {
        this.valueEn = valueEn;
    }
    public String getSite() {
        return site;
    }
    
    public String getDescriptionHk() {
        return descriptionHk;
    }
    
    public String getDescriptionTw() {
        return descriptionTw;
    }
    
    public String getDescriptionEn() {
        return descriptionEn;
    }
    
    public void setDescriptionHk(String descriptionHk) {
        this.descriptionHk = descriptionHk;
    }
    
    public void setDescriptionTw(String descriptionTw) {
        this.descriptionTw = descriptionTw;
    }
    
    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }
    public void setSite(String site) {
        this.site = site;
    }
	public  DbDictionaryInfoModel getChannelNameById(Integer id2) {
		return null;
	}
	
}
