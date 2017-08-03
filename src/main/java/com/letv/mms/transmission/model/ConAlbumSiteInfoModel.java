/**
 * 
 */
package com.letv.mms.transmission.model;

import java.util.Date;

/**
 * 专辑多站点Model.
 * 
 * @author mada
 * 
 */
public class ConAlbumSiteInfoModel {

    private Long pid; // 专辑id
    private Integer siteId; // 站点id
    private String playPlatform; // 播放平台
    private String downloadPlatform; // 下载平台
    private String payPlatform; // 付费平台
    private Integer isPay; // 是否付费
    private String picOriginal; // 原图地址
    private String picCollections; // 上传图片
    private String albumPic; // 动态截图前缀
    private Integer contentRating; // 内容分级
    private String releaseDate; // 上线时间
    private Integer canSearch; // 是否搜索
    private Date videoFollowTime; // 视频跟播时间
    private Long userId; // 创建人id
    private Long updateUid; // 修改人id
    private Date createTime; // 创建时间
    private Date updateTime; // 修改时间
    private String extData; // 扩展字段
    private String subCategory; // 二级分类
    private String categoryExt; // 分类扩展字段（以json格式存储除二级分类外的其他分类）
    
    /*******扩展字段包含内容start********/
    private String autoCdnSize; // 动态截图的原图的尺寸
    private String autoCdnOri; // 自动裁图原图vrs本地地址 
    private Boolean deleted=false;
    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getPlayPlatform() {
        return playPlatform;
    }

    public void setPlayPlatform(String playPlatform) {
        this.playPlatform = playPlatform;
    }

    public String getDownloadPlatform() {
        return downloadPlatform;
    }

    public void setDownloadPlatform(String downloadPlatform) {
        this.downloadPlatform = downloadPlatform;
    }

    public String getPayPlatform() {
        return payPlatform;
    }

    public void setPayPlatform(String payPlatform) {
        this.payPlatform = payPlatform;
    }

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    public String getPicOriginal() {
        return picOriginal;
    }

    public void setPicOriginal(String picOriginal) {
        this.picOriginal = picOriginal;
    }

    public String getPicCollections() {
        return picCollections;
    }

    public void setPicCollections(String picCollections) {
        this.picCollections = picCollections;
    }

    public String getAlbumPic() {
        return albumPic;
    }

    public void setAlbumPic(String albumPic) {
        this.albumPic = albumPic;
    }

    public Integer getContentRating() {
        return contentRating;
    }

    public void setContentRating(Integer contentRating) {
        this.contentRating = contentRating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public Integer getCanSearch() {
        return canSearch;
    }
    
    public void setCanSearch(Integer canSearch) {
        this.canSearch = canSearch;
    }
    
    public Date getVideoFollowTime() {
        return videoFollowTime;
    }
    
    public void setVideoFollowTime(Date videoFollowTime) {
        this.videoFollowTime = videoFollowTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUpdateUid() {
        return updateUid;
    }

    public void setUpdateUid(Long updateUid) {
        this.updateUid = updateUid;
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

    public String getExtData() {
        return extData;
    }

    public void setExtData(String extData) {
        this.extData = extData;
    }

    public String getAutoCdnSize() {
        return autoCdnSize;
    }
    
    public void setAutoCdnSize(String autoCdnSize) {
        this.autoCdnSize = autoCdnSize;
    }
    
    public String getAutoCdnOri() {
        return autoCdnOri;
    }
    
    public void setAutoCdnOri(String autoCdnOri) {
        this.autoCdnOri = autoCdnOri;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getCategoryExt() {
        return categoryExt;
    }

    public void setCategoryExt(String categoryExt) {
        this.categoryExt = categoryExt;
    }
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
}
