package com.letv.mms.transmission.model;

import java.util.Date;

/**
 * 图片相关字段对应关系
 * 
 * 图片类型     原图字段 ==> 上传cdn截图前缀字段
 * 1:1    post_origin ==> post_s1 
 * 3:4    head_pic_34 ==> head_pic_web_34 
 * 背板图         back_pic ==> back_pic_web 
 * 
 * Created by lifeng on 2014/11/4.
 */
public class StarInfo{
    /**
     * 
     */
	private Long id;
    private String searchName; // 搜索名字, 可能是中/英文, 别名
    private Integer nameType; // 搜索名字类型
    private Integer infoLang; // 资料语言
    private String name;
    private String nameHk;
    private String nameTw;
    private String nameEn;
    private String otherName;
    private String trueName;
    private Date birthday;
    private Byte gender;
    private Integer area;
    private String description;
    private String descriptionHk;
    private String descriptionTw;
    private String descriptionEn;
    private Byte display;
    private String status;
    private String postS1;
    private String postS2;
    private String postS3;
    private String twitter;
    private Long userCenterId;
    private Byte isEnd;
    private String postOrigin;
    private String pinyinabb;
    private Date createTime;
    private Date updateTime;
    private Integer createUid;
    private Integer updateUid;
    private Integer leId;
    private String leName;
    private String headPic;
    private String headPicWeb;
    private String headPic34;
    private String headPicWeb34;
    private String backPic;
    private String backPicWeb;
    private String xiamiId;

    private String professional ;
    private String logo ;
    private String descriptionXm ;
    private String company ;
    private String source ;
    private String artistNameXiami ;
    private String englishNameXiami ;
    private String starPicInfo;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getInfoLang() {
        return infoLang;
    }

    public void setInfoLang(Integer infoLang) {
        this.infoLang = infoLang;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public Integer getNameType() {
        return nameType;
    }

    public void setNameType(Integer nameType) {
        this.nameType = nameType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameHk() {
        return nameHk;
    }

    public void setNameHk(String nameHk) {
        this.nameHk = nameHk;
    }

    public String getNameTw() {
        return nameTw;
    }

    public void setNameTw(String nameTw) {
        this.nameTw = nameTw;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionHk() {
        return descriptionHk;
    }

    public void setDescriptionHk(String descriptionHk) {
        this.descriptionHk = descriptionHk;
    }

    public String getDescriptionTw() {
        return descriptionTw;
    }

    public void setDescriptionTw(String descriptionTw) {
        this.descriptionTw = descriptionTw;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public Byte getDisplay() {
        return display;
    }

    public void setDisplay(Byte display) {
        this.display = display;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPostS1() {
        return postS1;
    }

    public void setPostS1(String postS1) {
        this.postS1 = postS1;
    }

    public String getPostS2() {
        return postS2;
    }

    public void setPostS2(String postS2) {
        this.postS2 = postS2;
    }

    public String getPostS3() {
        return postS3;
    }

    public void setPostS3(String postS3) {
        this.postS3 = postS3;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public Long getUserCenterId() {
        return userCenterId;
    }

    public void setUserCenterId(Long userCenterId) {
        this.userCenterId = userCenterId;
    }

    public Byte getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(Byte isEnd) {
        this.isEnd = isEnd;
    }

    public String getPostOrigin() {
        return postOrigin;
    }

    public void setPostOrigin(String postOrigin) {
        this.postOrigin = postOrigin;
    }

    public String getPinyinabb() {
        return pinyinabb;
    }

    public void setPinyinabb(String pinyinabb) {
        this.pinyinabb = pinyinabb;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCreateUid() {
        return createUid;
    }

    public void setCreateUid(Integer createUid) {
        this.createUid = createUid;
    }

    public Integer getUpdateUid() {
        return updateUid;
    }

    public void setUpdateUid(Integer updateUid) {
        this.updateUid = updateUid;
    }

    public Integer getLeId() {
        return leId;
    }

    public void setLeId(Integer leId) {
        this.leId = leId;
    }

    public String getLeName() {
        return leName;
    }

    public void setLeName(String leName) {
        this.leName = leName;
    }

    public String getBackPic() {
        return backPic;
    }

    public void setBackPic(String backPic) {
        this.backPic = backPic;
    }

    public String getBackPicWeb() {
        return backPicWeb;
    }

    public void setBackPicWeb(String backPicWeb) {
        this.backPicWeb = backPicWeb;
    }

    public String getXiamiId() {
        return xiamiId;
    }

    public void setXiamiId(String xiamiId) {
        this.xiamiId = xiamiId;
    }


    public String getHeadPic34() {
        return headPic34;
    }

    public void setHeadPic34(String headPic34) {
        this.headPic34 = headPic34;
    }

    public String getHeadPicWeb34() {
        return headPicWeb34;
    }

    public void setHeadPicWeb34(String headPicWeb34) {
        this.headPicWeb34 = headPicWeb34;
    }

    public String getHeadPicWeb() {
        return headPicWeb;
    }

    public void setHeadPicWeb(String headPicWeb) {
        this.headPicWeb = headPicWeb;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

	public String getProfessional() {
		return professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getDescriptionXm() {
		return descriptionXm;
	}

	public void setDescriptionXm(String descriptionXm) {
		this.descriptionXm = descriptionXm;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getArtistNameXiami() {
		return artistNameXiami;
	}

	public void setArtistNameXiami(String artistNameXiami) {
		this.artistNameXiami = artistNameXiami;
	}

	public String getEnglishNameXiami() {
		return englishNameXiami;
	}

	public void setEnglishNameXiami(String englishNameXiami) {
		this.englishNameXiami = englishNameXiami;
	}

	public String getStarPicInfo() {
		return starPicInfo;
	}

	public void setStarPicInfo(String starPicInfo) {
		this.starPicInfo = starPicInfo;
	}
    
    
}
