package com.letv.mms.transmission.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.letv.mms.transmission.common.TaskUtilService;

public class VideoListModel {
	private long id;
	private String nameCn;
	private String subTitle;
	private long pid;
	private String mid;
	private Integer sourceId;
	private Integer category;
	private Integer isPay;
	private Integer canSearch;
	private Integer videoType;
	private String playPlatform;
	private String downloadPlatform;
	private String episode;
	private Integer porder;
	private String releaseDate;
	private Integer duration;
	private String actor;
	private String starring;
	private String guest;
	private String autoVideoPic;
	private String picUpload;
	private String videoPic;
	private String extData;
	private int deleted;
	private int siteId;
	private int lang;
	private int playControlPlatformGuoguang;
	private Date createTime;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNameCn() {
		return nameCn;
	}
	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public Integer getSourceId() {
		return sourceId;
	}
	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public Integer getIsPay() {
		return isPay;
	}
	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}
	public Integer getCanSearch() {
		return canSearch;
	}
	public void setCanSearch(Integer canSearch) {
		this.canSearch = canSearch;
	}
	public Integer getVideoType() {
		return videoType;
	}
	public void setVideoType(Integer videoType) {
		this.videoType = videoType;
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
	public String getEpisode() {
		return episode;
	}
	public void setEpisode(String episode) {
		this.episode = episode;
	}
	public Integer getPorder() {
		return porder;
	}
	public void setPorder(Integer porder) {
		this.porder = porder;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getStarring() {
		return starring;
	}
	public void setStarring(String starring) {
		this.starring = starring;
	}
	public String getGuest() {
		return guest;
	}
	public void setGuest(String guest) {
		this.guest = guest;
	}
	public String getAutoVideoPic() {
		return autoVideoPic;
	}
	public void setAutoVideoPic(String autoVideoPic) {
		this.autoVideoPic = autoVideoPic;
	}
	public String getPicUpload() {
		return picUpload;
	}
	public void setPicUpload(String picUpload) {
		this.picUpload = picUpload;
	}
	public String getVideoPic() {
		return videoPic;
	}
	public void setVideoPic(String videoPic) {
		this.videoPic = videoPic;
	}
	public String getExtData() {
		return extData;
	}
	public void setExtData(String extData) {
		this.extData = extData;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	public int getLang() {
		return lang;
	}
	public void setLang(int lang) {
		this.lang = lang;
	}
	public int getPlayControlPlatformGuoguang() {
		return playControlPlatformGuoguang;
	}
	public void setPlayControlPlatformGuoguang(int playControlPlatformGuoguang) {
		this.playControlPlatformGuoguang = playControlPlatformGuoguang;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
}
