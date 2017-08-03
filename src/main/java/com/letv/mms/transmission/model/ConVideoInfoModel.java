package com.letv.mms.transmission.model;

import java.util.Date;

public class ConVideoInfoModel {

	private String categoryExt; // 分类拓展
	private String childCate; // 儿童分类
	private Integer isPushChild; // 是否推送儿童
	private String funcProperty; // 功能属性
	private Integer playGuoguang; // 国广是否审核
	private Integer isRemark;
    private String actor;// 演员
    private String actorPlay;// 饰演角色
    private String adPoint;// 广告插入点
    private String alias;// 别名
    private String area;// 地区
    private Integer btime;// 片头时间
    private Integer category;// 电视剧 电影
    private String compere;// 主持人
    private Integer disableType; // 0.全部屏蔽 1.全部允许 2.部分屏蔽 3.部分允许
    private String controlAreas; // 屏蔽地区
    private String copyrightCompany;// 版权公司
    private Date copyrightEnd;// 版权结束时间
    private Date copyrightStart;// 版权开始时间
    private Integer copyrightType;// 版权类型
    private Date createTime;// 创建时间
    private String description;// 描述
    private String directory;// 导演
    private String downloadPlatform;// 允许下载平台
    private Integer duration;// 时长
    private String episode;// 在动漫频道，可能有2.5集， 也有可能一个视频文件，包含两集
    private Integer etime;// 片尾时间
    private String firstPlayTime;// 首播时间
    private String guest;// 嘉宾
    private String issueCompany;// 发行公司
    private Integer language;// 语言
    private String mid;// 媒资ID, 一个视频可能对应着多个媒资id(比如一个视频国语音轨，也有粤语的音轨，就会转出两个媒资id)
    private String musicAuthors;// 音乐作词人
    private String nameCn;// 中文名称
    private String nameEn;// 英文名称
    private String namePinyinAbb;// 名称拼音简写
    private String officialUrl;// 官网地址
	private Integer param1;//
	private String param2;//
    private String payPlatform;// 付费平台
    private String picOriginal;// 原图
    private Long pid;// 专辑ID
    private String playPlatform;// 推送平台
    private Integer porder;// 在专辑顺序
    private Integer pre;// 关联类型，娱乐频道
    private String recordCompany;// 唱片公司
    private String relativeContent;// 关联内容
    private String releaseDate;// 发行时间
    private String remark;// 备注
    private String school;// 学校
	private Float score;//
    private String shortDesc;// 简要描述
    private String singer;// 歌手
    private String singerType;// 歌手类型
    private String singleName;// 动漫频道 单集名称
    private Integer sourceId;// 所属渠道
    private Integer status;// 审核状态： 0,未审核 1正在审核2审核通过(当前只有  0非删除，3删除，2个状态。其他数值都为历史数据没有 修复)
    private String style;// 分类
    private String subCategory;// 动作 言情 惊悚 都市，所属学科
    private String subTitle;// 副标题
    private String tag;// 标签
    private String team;// 球队(体育)
    private Date updateTime;// 修改时间
	private Long updateUid;//
    private Long userId;// 用户ID
    private Integer videoType;// 视频类型
    private String watchingFocus;// 看点
    private String starring;// 主演(纪录片中的演员)
    private String instructor;// 公开课中的讲师
    private String startringPlay;// 主演饰演(纪录片中的人物)
    private String quality;// 大咔拍摄质量
    private Integer direction;// 大咔拍摄方向 横拍 竖拍
    private String maker;// 音乐频道制片人监制
    private Integer isHomemade;// 是否是自制剧
    private Date onTime;// 上线时间
    private Integer logoNum; // 0默认乐视水印 1不加水印
    private String transcodeTag; // 转码
    private String playTv;// 播出电视台 可能是多值
    private String tempPlayPlatform;// 临时存放转码完成前的播放平台内容
    private Integer playControlPlatformCntv;// CNTV播放平台
    private Integer playControlPlatformHuashu;// 华数播放平台
    private Integer playControlPlatformGuoguang;// 国广播放平台
	private String viki; // viki id
    private String appid; // 应用场景
    private Integer folkartType;// 曲艺项目类型
    private String fitAge;// 亲子频道的适应年龄段
    private Integer contentRating;// 内容分级。例如：20~43年龄段
    private Integer cloneSource;// 视频克隆来源
    private Integer canSearch; // 是否被站内搜索 1：搜索 0：屏蔽
	private String picUpload;
	private Integer isAllRefresh;
	private Integer interval;
    private String recommend; // 推荐权重
    private String nameTw;// 繁体名称
    private String activityId;// 活动ID
    private String drmFlag; // 数字版权标识
    private String site;// 站点描述
    private Integer isFirstLook;//是否为抢先看
    private String extData; // 通用字段 存放
    private String coopPlatform; // 合作平台
    private String sourceSite; //上传 视频的站点
    private String leId; // 乐词ID
    private String autoVideoPic; // 动态截图前缀
    private Integer isPay; // 是否付费  0否  1是
    private String copyrightCode; // 版权码
    private String shareCopy;//分享文案
    
	/*************拓展字段使用key start*********************/
    private String audioInfo;//手机音乐
    private String cutoffPlatform; // 断流平台
    private String cutoffTime; // 断流时间
	private int isPlayLock = 0; // 播放锁，默认false
	private String autoCdnOri; // 自动裁图原图vrs本地地址
	private String autoCdnSize; // 动态截图的原图的尺寸，放入ext_data字段
	private int isBigPic; // 确认大图
	private Integer isDanmaku; // 是否弹幕
	private Long liveId; // 直播id
	private String vtypeFlag; // 直播id
	private String relPositiveAlbumIds; // 关联电影专辑
	private String motorBrand;//汽车频道品牌
	private String motorModel;//汽车频道车型
	private String isVipDownload;//是否仅会员可缓存下载
	private Integer contentMark; // 内容标记
	/*************拓展字段使用key end***********************/

    private boolean isUpdate = false; // 转码程序使用
    private String videoPic;// 视频截图的转码前缀
    private Date offTime;// 下线时间
    
    private String pName;// 专辑名称；
    private Integer lang; // 上传客户端使用，内容使用语言
    
    private String guid; // 海外合作方ID
    private Long id;
	private Boolean deleted=false;
	private Integer siteId;
	public String getCategoryExt() {
		return categoryExt;
	}
	public void setCategoryExt(String categoryExt) {
		this.categoryExt = categoryExt;
	}
	public String getChildCate() {
		return childCate;
	}
	public void setChildCate(String childCate) {
		this.childCate = childCate;
	}
	public Integer getIsPushChild() {
		return isPushChild;
	}
	public void setIsPushChild(Integer isPushChild) {
		this.isPushChild = isPushChild;
	}
	public String getFuncProperty() {
		return funcProperty;
	}
	public void setFuncProperty(String funcProperty) {
		this.funcProperty = funcProperty;
	}
	public Integer getPlayGuoguang() {
		return playGuoguang;
	}
	public void setPlayGuoguang(Integer playGuoguang) {
		this.playGuoguang = playGuoguang;
	}
	public Integer getIsRemark() {
		return isRemark;
	}
	public void setIsRemark(Integer isRemark) {
		this.isRemark = isRemark;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getActorPlay() {
		return actorPlay;
	}
	public void setActorPlay(String actorPlay) {
		this.actorPlay = actorPlay;
	}
	public String getAdPoint() {
		return adPoint;
	}
	public void setAdPoint(String adPoint) {
		this.adPoint = adPoint;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Integer getBtime() {
		return btime;
	}
	public void setBtime(Integer btime) {
		this.btime = btime;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public String getCompere() {
		return compere;
	}
	public void setCompere(String compere) {
		this.compere = compere;
	}
	public Integer getDisableType() {
		return disableType;
	}
	public void setDisableType(Integer disableType) {
		this.disableType = disableType;
	}
	public String getControlAreas() {
		return controlAreas;
	}
	public void setControlAreas(String controlAreas) {
		this.controlAreas = controlAreas;
	}
	public String getCopyrightCompany() {
		return copyrightCompany;
	}
	public void setCopyrightCompany(String copyrightCompany) {
		this.copyrightCompany = copyrightCompany;
	}
	public Date getCopyrightEnd() {
		return copyrightEnd;
	}
	public void setCopyrightEnd(Date copyrightEnd) {
		this.copyrightEnd = copyrightEnd;
	}
	public Date getCopyrightStart() {
		return copyrightStart;
	}
	public void setCopyrightStart(Date copyrightStart) {
		this.copyrightStart = copyrightStart;
	}
	public Integer getCopyrightType() {
		return copyrightType;
	}
	public void setCopyrightType(Integer copyrightType) {
		this.copyrightType = copyrightType;
	}

	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDirectory() {
		return directory;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	public String getDownloadPlatform() {
		return downloadPlatform;
	}
	public void setDownloadPlatform(String downloadPlatform) {
		this.downloadPlatform = downloadPlatform;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getEpisode() {
		return episode;
	}
	public void setEpisode(String episode) {
		this.episode = episode;
	}
	public Integer getEtime() {
		return etime;
	}
	public void setEtime(Integer etime) {
		this.etime = etime;
	}
	public String getFirstPlayTime() {
		return firstPlayTime;
	}
	public void setFirstPlayTime(String firstPlayTime) {
		this.firstPlayTime = firstPlayTime;
	}
	public String getGuest() {
		return guest;
	}
	public void setGuest(String guest) {
		this.guest = guest;
	}
	public String getIssueCompany() {
		return issueCompany;
	}
	public void setIssueCompany(String issueCompany) {
		this.issueCompany = issueCompany;
	}
	public Integer getLanguage() {
		return language;
	}
	public void setLanguage(Integer language) {
		this.language = language;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMusicAuthors() {
		return musicAuthors;
	}
	public void setMusicAuthors(String musicAuthors) {
		this.musicAuthors = musicAuthors;
	}
	public String getNameCn() {
		return nameCn;
	}
	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public String getNamePinyinAbb() {
		return namePinyinAbb;
	}
	public void setNamePinyinAbb(String namePinyinAbb) {
		this.namePinyinAbb = namePinyinAbb;
	}
	public String getOfficialUrl() {
		return officialUrl;
	}
	public void setOfficialUrl(String officialUrl) {
		this.officialUrl = officialUrl;
	}
	public Integer getParam1() {
		return param1;
	}
	public void setParam1(Integer param1) {
		this.param1 = param1;
	}
	public String getParam2() {
		return param2;
	}
	public void setParam2(String param2) {
		this.param2 = param2;
	}
	public String getPayPlatform() {
		return payPlatform;
	}
	public void setPayPlatform(String payPlatform) {
		this.payPlatform = payPlatform;
	}
	public String getPicOriginal() {
		return picOriginal;
	}
	public void setPicOriginal(String picOriginal) {
		this.picOriginal = picOriginal;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getPlayPlatform() {
		return playPlatform;
	}
	public void setPlayPlatform(String playPlatform) {
		this.playPlatform = playPlatform;
	}
	public Integer getPorder() {
		return porder;
	}
	public void setPorder(Integer porder) {
		this.porder = porder;
	}
	public Integer getPre() {
		return pre;
	}
	public void setPre(Integer pre) {
		this.pre = pre;
	}
	public String getRecordCompany() {
		return recordCompany;
	}
	public void setRecordCompany(String recordCompany) {
		this.recordCompany = recordCompany;
	}
	public String getRelativeContent() {
		return relativeContent;
	}
	public void setRelativeContent(String relativeContent) {
		this.relativeContent = relativeContent;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public Float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getSingerType() {
		return singerType;
	}
	public void setSingerType(String singerType) {
		this.singerType = singerType;
	}
	public String getSingleName() {
		return singleName;
	}
	public void setSingleName(String singleName) {
		this.singleName = singleName;
	}
	public Integer getSourceId() {
		return sourceId;
	}
	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}

	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Long getUpdateUid() {
		return updateUid;
	}
	public void setUpdateUid(Long updateUid) {
		this.updateUid = updateUid;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getVideoType() {
		return videoType;
	}
	public void setVideoType(Integer videoType) {
		this.videoType = videoType;
	}
	public String getWatchingFocus() {
		return watchingFocus;
	}
	public void setWatchingFocus(String watchingFocus) {
		this.watchingFocus = watchingFocus;
	}
	public String getStarring() {
		return starring;
	}
	public void setStarring(String starring) {
		this.starring = starring;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getStartringPlay() {
		return startringPlay;
	}
	public void setStartringPlay(String startringPlay) {
		this.startringPlay = startringPlay;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public Integer getDirection() {
		return direction;
	}
	public void setDirection(Integer direction) {
		this.direction = direction;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public Integer getIsHomemade() {
		return isHomemade;
	}
	public void setIsHomemade(Integer isHomemade) {
		this.isHomemade = isHomemade;
	}

	public Date getOnTime() {
		return onTime;
	}
	public void setOnTime(Date onTime) {
		this.onTime = onTime;
	}
	public Integer getLogoNum() {
		return logoNum;
	}
	public void setLogoNum(Integer logoNum) {
		this.logoNum = logoNum;
	}
	public String getTranscodeTag() {
		return transcodeTag;
	}
	public void setTranscodeTag(String transcodeTag) {
		this.transcodeTag = transcodeTag;
	}
	public String getPlayTv() {
		return playTv;
	}
	public void setPlayTv(String playTv) {
		this.playTv = playTv;
	}
	public String getTempPlayPlatform() {
		return tempPlayPlatform;
	}
	public void setTempPlayPlatform(String tempPlayPlatform) {
		this.tempPlayPlatform = tempPlayPlatform;
	}
	public Integer getPlayControlPlatformCntv() {
		return playControlPlatformCntv;
	}
	public void setPlayControlPlatformCntv(Integer playControlPlatformCntv) {
		this.playControlPlatformCntv = playControlPlatformCntv;
	}
	public Integer getPlayControlPlatformHuashu() {
		return playControlPlatformHuashu;
	}
	public void setPlayControlPlatformHuashu(Integer playControlPlatformHuashu) {
		this.playControlPlatformHuashu = playControlPlatformHuashu;
	}
	public Integer getPlayControlPlatformGuoguang() {
		return playControlPlatformGuoguang;
	}
	public void setPlayControlPlatformGuoguang(Integer playControlPlatformGuoguang) {
		this.playControlPlatformGuoguang = playControlPlatformGuoguang;
	}
	public String getViki() {
		return viki;
	}
	public void setViki(String viki) {
		this.viki = viki;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public Integer getFolkartType() {
		return folkartType;
	}
	public void setFolkartType(Integer folkartType) {
		this.folkartType = folkartType;
	}
	public String getFitAge() {
		return fitAge;
	}
	public void setFitAge(String fitAge) {
		this.fitAge = fitAge;
	}
	public Integer getContentRating() {
		return contentRating;
	}
	public void setContentRating(Integer contentRating) {
		this.contentRating = contentRating;
	}
	public Integer getCloneSource() {
		return cloneSource;
	}
	public void setCloneSource(Integer cloneSource) {
		this.cloneSource = cloneSource;
	}
	public Integer getCanSearch() {
		return canSearch;
	}
	public void setCanSearch(Integer canSearch) {
		this.canSearch = canSearch;
	}
	public String getPicUpload() {
		return picUpload;
	}
	public void setPicUpload(String picUpload) {
		this.picUpload = picUpload;
	}
	public Integer getIsAllRefresh() {
		return isAllRefresh;
	}
	public void setIsAllRefresh(Integer isAllRefresh) {
		this.isAllRefresh = isAllRefresh;
	}
	public Integer getInterval() {
		return interval;
	}
	public void setInterval(Integer interval) {
		this.interval = interval;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public String getNameTw() {
		return nameTw;
	}
	public void setNameTw(String nameTw) {
		this.nameTw = nameTw;
	}
	public String getActivityId() {
		return activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	public String getDrmFlag() {
		return drmFlag;
	}
	public void setDrmFlag(String drmFlag) {
		this.drmFlag = drmFlag;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public Integer getIsFirstLook() {
		return isFirstLook;
	}
	public void setIsFirstLook(Integer isFirstLook) {
		this.isFirstLook = isFirstLook;
	}
	public String getExtData() {
		return extData;
	}
	public void setExtData(String extData) {
		this.extData = extData;
	}
	public String getCoopPlatform() {
		return coopPlatform;
	}
	public void setCoopPlatform(String coopPlatform) {
		this.coopPlatform = coopPlatform;
	}
	public String getSourceSite() {
		return sourceSite;
	}
	public void setSourceSite(String sourceSite) {
		this.sourceSite = sourceSite;
	}
	public String getLeId() {
		return leId;
	}
	public void setLeId(String leId) {
		this.leId = leId;
	}
	public String getAutoVideoPic() {
		return autoVideoPic;
	}
	public void setAutoVideoPic(String autoVideoPic) {
		this.autoVideoPic = autoVideoPic;
	}
	public Integer getIsPay() {
		return isPay;
	}
	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}
	public String getCopyrightCode() {
		return copyrightCode;
	}
	public void setCopyrightCode(String copyrightCode) {
		this.copyrightCode = copyrightCode;
	}
	public String getShareCopy() {
		return shareCopy;
	}
	public void setShareCopy(String shareCopy) {
		this.shareCopy = shareCopy;
	}
	public String getAudioInfo() {
		return audioInfo;
	}
	public void setAudioInfo(String audioInfo) {
		this.audioInfo = audioInfo;
	}
	public String getCutoffPlatform() {
		return cutoffPlatform;
	}
	public void setCutoffPlatform(String cutoffPlatform) {
		this.cutoffPlatform = cutoffPlatform;
	}
	public String getCutoffTime() {
		return cutoffTime;
	}
	public void setCutoffTime(String cutoffTime) {
		this.cutoffTime = cutoffTime;
	}
	public int getIsPlayLock() {
		return isPlayLock;
	}
	public void setIsPlayLock(int isPlayLock) {
		this.isPlayLock = isPlayLock;
	}
	public String getAutoCdnOri() {
		return autoCdnOri;
	}
	public void setAutoCdnOri(String autoCdnOri) {
		this.autoCdnOri = autoCdnOri;
	}
	public String getAutoCdnSize() {
		return autoCdnSize;
	}
	public void setAutoCdnSize(String autoCdnSize) {
		this.autoCdnSize = autoCdnSize;
	}
	public int getIsBigPic() {
		return isBigPic;
	}
	public void setIsBigPic(int isBigPic) {
		this.isBigPic = isBigPic;
	}
	public Integer getIsDanmaku() {
		return isDanmaku;
	}
	public void setIsDanmaku(Integer isDanmaku) {
		this.isDanmaku = isDanmaku;
	}
	public Long getLiveId() {
		return liveId;
	}
	public void setLiveId(Long liveId) {
		this.liveId = liveId;
	}
	public String getVtypeFlag() {
		return vtypeFlag;
	}
	public void setVtypeFlag(String vtypeFlag) {
		this.vtypeFlag = vtypeFlag;
	}
	public String getRelPositiveAlbumIds() {
		return relPositiveAlbumIds;
	}
	public void setRelPositiveAlbumIds(String relPositiveAlbumIds) {
		this.relPositiveAlbumIds = relPositiveAlbumIds;
	}
	public String getMotorBrand() {
		return motorBrand;
	}
	public void setMotorBrand(String motorBrand) {
		this.motorBrand = motorBrand;
	}
	public String getMotorModel() {
		return motorModel;
	}
	public void setMotorModel(String motorModel) {
		this.motorModel = motorModel;
	}
	public String getIsVipDownload() {
		return isVipDownload;
	}
	public void setIsVipDownload(String isVipDownload) {
		this.isVipDownload = isVipDownload;
	}
	public Integer getContentMark() {
		return contentMark;
	}
	public void setContentMark(Integer contentMark) {
		this.contentMark = contentMark;
	}
	public boolean isUpdate() {
		return isUpdate;
	}
	public void setUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
	public String getVideoPic() {
		return videoPic;
	}
	public void setVideoPic(String videoPic) {
		this.videoPic = videoPic;
	}

	public Date getOffTime() {
		return offTime;
	}
	public void setOffTime(Date offTime) {
		this.offTime = offTime;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Integer getLang() {
		return lang;
	}
	public void setLang(Integer lang) {
		this.lang = lang;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	public Integer getSiteId() {
		return siteId;
	}
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	@Override
	public String toString() {
		return "ConVideoInfoModel [categoryExt=" + categoryExt + ", childCate="
				+ childCate + ", isPushChild=" + isPushChild
				+ ", funcProperty=" + funcProperty + ", playGuoguang="
				+ playGuoguang + ", isRemark=" + isRemark + ", actor=" + actor
				+ ", actorPlay=" + actorPlay + ", adPoint=" + adPoint
				+ ", alias=" + alias + ", area=" + area + ", btime=" + btime
				+ ", category=" + category + ", compere=" + compere
				+ ", disableType=" + disableType + ", controlAreas="
				+ controlAreas + ", copyrightCompany=" + copyrightCompany
				+ ", copyrightEnd=" + copyrightEnd + ", copyrightStart="
				+ copyrightStart + ", copyrightType=" + copyrightType
				+ ", createTime=" + createTime + ", description=" + description
				+ ", directory=" + directory + ", downloadPlatform="
				+ downloadPlatform + ", duration=" + duration + ", episode="
				+ episode + ", etime=" + etime + ", firstPlayTime="
				+ firstPlayTime + ", guest=" + guest + ", issueCompany="
				+ issueCompany + ", language=" + language + ", mid=" + mid
				+ ", musicAuthors=" + musicAuthors + ", nameCn=" + nameCn
				+ ", nameEn=" + nameEn + ", namePinyinAbb=" + namePinyinAbb
				+ ", officialUrl=" + officialUrl + ", param1=" + param1
				+ ", param2=" + param2 + ", payPlatform=" + payPlatform
				+ ", picOriginal=" + picOriginal + ", pid=" + pid
				+ ", playPlatform=" + playPlatform + ", porder=" + porder
				+ ", pre=" + pre + ", recordCompany=" + recordCompany
				+ ", relativeContent=" + relativeContent + ", releaseDate="
				+ releaseDate + ", remark=" + remark + ", school=" + school
				+ ", score=" + score + ", shortDesc=" + shortDesc + ", singer="
				+ singer + ", singerType=" + singerType + ", singleName="
				+ singleName + ", sourceId=" + sourceId + ", status=" + status
				+ ", style=" + style + ", subCategory=" + subCategory
				+ ", subTitle=" + subTitle + ", tag=" + tag + ", team=" + team
				+ ", updateTime=" + updateTime + ", updateUid=" + updateUid
				+ ", userId=" + userId + ", videoType=" + videoType
				+ ", watchingFocus=" + watchingFocus + ", starring=" + starring
				+ ", instructor=" + instructor + ", startringPlay="
				+ startringPlay + ", quality=" + quality + ", direction="
				+ direction + ", maker=" + maker + ", isHomemade=" + isHomemade
				+ ", onTime=" + onTime + ", logoNum=" + logoNum
				+ ", transcodeTag=" + transcodeTag + ", playTv=" + playTv
				+ ", tempPlayPlatform=" + tempPlayPlatform
				+ ", playControlPlatformCntv=" + playControlPlatformCntv
				+ ", playControlPlatformHuashu=" + playControlPlatformHuashu
				+ ", playControlPlatformGuoguang="
				+ playControlPlatformGuoguang + ", viki=" + viki + ", appid="
				+ appid + ", folkartType=" + folkartType + ", fitAge=" + fitAge
				+ ", contentRating=" + contentRating + ", cloneSource="
				+ cloneSource + ", canSearch=" + canSearch + ", picUpload="
				+ picUpload + ", isAllRefresh=" + isAllRefresh + ", interval="
				+ interval + ", recommend=" + recommend + ", nameTw=" + nameTw
				+ ", activityId=" + activityId + ", drmFlag=" + drmFlag
				+ ", site=" + site + ", isFirstLook=" + isFirstLook
				+ ", extData=" + extData + ", coopPlatform=" + coopPlatform
				+ ", sourceSite=" + sourceSite + ", leId=" + leId
				+ ", autoVideoPic=" + autoVideoPic + ", isPay=" + isPay
				+ ", copyrightCode=" + copyrightCode + ", shareCopy="
				+ shareCopy + ", audioInfo=" + audioInfo + ", cutoffPlatform="
				+ cutoffPlatform + ", cutoffTime=" + cutoffTime
				+ ", isPlayLock=" + isPlayLock + ", autoCdnOri=" + autoCdnOri
				+ ", autoCdnSize=" + autoCdnSize + ", isBigPic=" + isBigPic
				+ ", isDanmaku=" + isDanmaku + ", liveId=" + liveId
				+ ", vtypeFlag=" + vtypeFlag + ", relPositiveAlbumIds="
				+ relPositiveAlbumIds + ", motorBrand=" + motorBrand
				+ ", motorModel=" + motorModel + ", isVipDownload="
				+ isVipDownload + ", contentMark=" + contentMark
				+ ", isUpdate=" + isUpdate + ", videoPic=" + videoPic
				+ ", offTime=" + offTime + ", pName=" + pName + ", lang="
				+ lang + ", guid=" + guid + ", id=" + id + ", deleted="
				+ deleted + ", siteId=" + siteId + "]";
	}
}
