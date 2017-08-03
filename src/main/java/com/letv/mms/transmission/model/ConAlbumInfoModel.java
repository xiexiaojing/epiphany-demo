package com.letv.mms.transmission.model;



public class ConAlbumInfoModel {

    private Integer albumType;// 正片、片花、花絮、资讯
    private String alias;// 别名
    private String area;// 地区
    private String cast;// 动漫频道的声优
    private Integer category;// 电影、电视剧、综艺、动漫
    private String compere;// 主持人
    private String copyrightCompany;// 版权公司
    private java.util.Date copyrightEnd;// 版权结束时间
    private java.util.Date copyrightStart;// 版权开始时间
    private Integer copyrightType;// 版权类型
    private java.util.Date createTime;// 创建时间
    private String description;// 描述
    private String directory;// 导演
    private String doubanId;// 豆瓣ID
    private String downloadPlatform;// 允许下载平台
    private String dub;// 配音
    private Integer duration;// 时长
    private Integer episode;// 总集数
    private Integer filmBaseType;// 电影频道分类 1.电影 2.微电影
    private String firstPlayTime;//
    private String fitAge;// 适应年龄
    private String imdb;// IMDB
    private String instructor;// 讲师
    private Integer isEnd;// 是否完结
    private Integer isHeight;// 是否高清
    private Integer isPay;// 是否付费
    private String issueCompany;// 发行公司
    private Integer language;// 内容语言
    private Integer letvMakeStyle;//
    private Integer letvProduceStyle;//
    private java.util.Date letvReleaseDate;// 乐视上映时间
    private String maker;// 制片人
    private String makerCompany;// 出品公司
    private String musicAuthors;// 音乐作词人
    private String musicCompose;// 音乐作曲者
    private String nameCn;// 中文名称
    private String nameEn;// 英文名称
    private String namePinyinAbb;// 名字中每个字的拼音的首字母
    private String officialUrl;// 官方网址
    private String originator;// 原作
    private String payPlatform;// 收费平台
    private String picCollections;// 图片集
    private String picOriginal;// 原图和缩列图
    private String playPlatform;// 允许播放平台
    private String playStatus;// 跟播状态
    private String playTv;// 播出电视台 可能有多个电视台
    private String producer;// 监制
    private String rCompany;//
    private String actor;
    private String releaseDate;// 上映时间
    private String remark;// 备注
    private String school;// 公开课频道 学校字段
    private Float score;// 评分
    private String screenWriter;// 编剧
    private String shortDesc;// 简要描述
    private Integer sourceId;// 20001.网站,20002.大咔，20003.第三方，20004.网站用户上传
    private String starring;// 主演
    private String starringDesc;// 主演介绍
    private String starringPlay;// 主演饰演角色
    private String starringPlayPic;// 主演定妆照
    private Integer status;// 发布状态： 0,未发布 1,已发布 2 发布失败((当前只有  0非删除，3删除，2个状态。其他数值都为历史数据没有 修复))
    private String subCategory;// 动作 言情
    private String subTitle;// 副标题
    private String supervise;// 动漫监督
    private String tag;// 标签
    private java.util.Date updateTime;// 修改时间
    private Long updateUid;// 修改用户ID
    private Long userId;// 创建用户ID
    private String versionTitle;// 版本标题
    private String vipWatchingFocus;// 会员促销看点
    private Integer isHomemade;// 是否是自制剧
    private String relationId;// 专辑关联id
    private Integer varietyShow;// 是否属于综艺频道
    private java.util.Date onTime;// 上线时间
    private java.util.Date offTime;// 下线时间
    private Integer playControlPlatformCntv;// CNTV播放平台
    private Integer playControlPlatformHuashu;// 华数播放平台
    private Integer playControlPlatformGuoguang;// 国广播放平台
    private String appid; // 应用场景
    private java.util.Date videoFollowTime;
    private Integer contentRating;// 内容分级，例如：10~14岁年龄段、20~40年龄段
    private Integer canSearch; // 是否被站内搜索
    private Integer cloneSource;// 专辑克隆来源
    private Integer isAllRefresh; // 是否为全量刷新
    private Integer interval; // 增量刷新，取前interval天的数据.
    private String firstPlayTv; // 首播电视台
    private String repeatPlayTv; // 重播电视台
    private String site;// 站点描述
    private String extData; // 通用字段 存放
    private String style;
    private String coopPlatform; // 合作平台
    private String categoryExt; // 拓展分类，三级，四级...(json格式)
    private String leId; // 乐词ID
    private String audioInfo; // 手机音乐信息
    private String albumPic; // 动态截图前缀
    private String autoCdnSize; // 动态截图的原图的尺寸，放入ext_data字段
    private String subLeId; // 手机订阅关联
    private String autoCdnOri; // 自动裁图原图vrs本地地址
    private String dynamicGraph; // 动态图地址，放入ext_data字段
    private Integer isDanmaku; // 是否弹幕
    private Integer riskLevel; // 盗播风险
    private Integer playMark; // 播放属性（独播，全景）
    private Integer disableType;// 屏蔽类型
    private String controlAreas; // 屏蔽控制地区
    private String copyrightCode; // 版权码
    /******** categor Ext 的中的key ********/

    private Integer playGuoguang; // 国广是否审核
    private String isVipDownload;//是否仅会员可缓存下载
    private Integer isRemark; // 是否评论
    private Integer lang; // 内容使用语言
    private Long id;
	private Boolean deleted=false;
	private Integer siteId;
	public Integer getAlbumType() {
		return albumType;
	}
	public void setAlbumType(Integer albumType) {
		this.albumType = albumType;
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
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
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
	public String getCopyrightCompany() {
		return copyrightCompany;
	}
	public void setCopyrightCompany(String copyrightCompany) {
		this.copyrightCompany = copyrightCompany;
	}
	public java.util.Date getCopyrightEnd() {
		return copyrightEnd;
	}
	public void setCopyrightEnd(java.util.Date copyrightEnd) {
		this.copyrightEnd = copyrightEnd;
	}
	public java.util.Date getCopyrightStart() {
		return copyrightStart;
	}
	public void setCopyrightStart(java.util.Date copyrightStart) {
		this.copyrightStart = copyrightStart;
	}
	public Integer getCopyrightType() {
		return copyrightType;
	}
	public void setCopyrightType(Integer copyrightType) {
		this.copyrightType = copyrightType;
	}
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
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
	public String getDoubanId() {
		return doubanId;
	}
	public void setDoubanId(String doubanId) {
		this.doubanId = doubanId;
	}
	public String getDownloadPlatform() {
		return downloadPlatform;
	}
	public void setDownloadPlatform(String downloadPlatform) {
		this.downloadPlatform = downloadPlatform;
	}
	public String getDub() {
		return dub;
	}
	public void setDub(String dub) {
		this.dub = dub;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Integer getEpisode() {
		return episode;
	}
	public void setEpisode(Integer episode) {
		this.episode = episode;
	}
	public Integer getFilmBaseType() {
		return filmBaseType;
	}
	public void setFilmBaseType(Integer filmBaseType) {
		this.filmBaseType = filmBaseType;
	}
	public String getFirstPlayTime() {
		return firstPlayTime;
	}
	public void setFirstPlayTime(String firstPlayTime) {
		this.firstPlayTime = firstPlayTime;
	}
	public String getFitAge() {
		return fitAge;
	}
	public void setFitAge(String fitAge) {
		this.fitAge = fitAge;
	}
	public String getImdb() {
		return imdb;
	}
	public void setImdb(String imdb) {
		this.imdb = imdb;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public Integer getIsEnd() {
		return isEnd;
	}
	public void setIsEnd(Integer isEnd) {
		this.isEnd = isEnd;
	}
	public Integer getIsHeight() {
		return isHeight;
	}
	public void setIsHeight(Integer isHeight) {
		this.isHeight = isHeight;
	}
	public Integer getIsPay() {
		return isPay;
	}
	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
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
	public Integer getLetvMakeStyle() {
		return letvMakeStyle;
	}
	public void setLetvMakeStyle(Integer letvMakeStyle) {
		this.letvMakeStyle = letvMakeStyle;
	}
	public Integer getLetvProduceStyle() {
		return letvProduceStyle;
	}
	public void setLetvProduceStyle(Integer letvProduceStyle) {
		this.letvProduceStyle = letvProduceStyle;
	}
	public java.util.Date getLetvReleaseDate() {
		return letvReleaseDate;
	}
	public void setLetvReleaseDate(java.util.Date letvReleaseDate) {
		this.letvReleaseDate = letvReleaseDate;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getMakerCompany() {
		return makerCompany;
	}
	public void setMakerCompany(String makerCompany) {
		this.makerCompany = makerCompany;
	}
	public String getMusicAuthors() {
		return musicAuthors;
	}
	public void setMusicAuthors(String musicAuthors) {
		this.musicAuthors = musicAuthors;
	}
	public String getMusicCompose() {
		return musicCompose;
	}
	public void setMusicCompose(String musicCompose) {
		this.musicCompose = musicCompose;
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
	public String getOriginator() {
		return originator;
	}
	public void setOriginator(String originator) {
		this.originator = originator;
	}
	public String getPayPlatform() {
		return payPlatform;
	}
	public void setPayPlatform(String payPlatform) {
		this.payPlatform = payPlatform;
	}
	public String getPicCollections() {
		return picCollections;
	}
	public void setPicCollections(String picCollections) {
		this.picCollections = picCollections;
	}
	public String getPicOriginal() {
		return picOriginal;
	}
	public void setPicOriginal(String picOriginal) {
		this.picOriginal = picOriginal;
	}
	public String getPlayPlatform() {
		return playPlatform;
	}
	public void setPlayPlatform(String playPlatform) {
		this.playPlatform = playPlatform;
	}
	public String getPlayStatus() {
		return playStatus;
	}
	public void setPlayStatus(String playStatus) {
		this.playStatus = playStatus;
	}
	public String getPlayTv() {
		return playTv;
	}
	public void setPlayTv(String playTv) {
		this.playTv = playTv;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getrCompany() {
		return rCompany;
	}
	public void setrCompany(String rCompany) {
		this.rCompany = rCompany;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
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
	public String getScreenWriter() {
		return screenWriter;
	}
	public void setScreenWriter(String screenWriter) {
		this.screenWriter = screenWriter;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public Integer getSourceId() {
		return sourceId;
	}
	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}
	public String getStarring() {
		return starring;
	}
	public void setStarring(String starring) {
		this.starring = starring;
	}
	public String getStarringDesc() {
		return starringDesc;
	}
	public void setStarringDesc(String starringDesc) {
		this.starringDesc = starringDesc;
	}
	public String getStarringPlay() {
		return starringPlay;
	}
	public void setStarringPlay(String starringPlay) {
		this.starringPlay = starringPlay;
	}
	public String getStarringPlayPic() {
		return starringPlayPic;
	}
	public void setStarringPlayPic(String starringPlayPic) {
		this.starringPlayPic = starringPlayPic;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public String getSupervise() {
		return supervise;
	}
	public void setSupervise(String supervise) {
		this.supervise = supervise;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime) {
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
	public String getVersionTitle() {
		return versionTitle;
	}
	public void setVersionTitle(String versionTitle) {
		this.versionTitle = versionTitle;
	}
	public String getVipWatchingFocus() {
		return vipWatchingFocus;
	}
	public void setVipWatchingFocus(String vipWatchingFocus) {
		this.vipWatchingFocus = vipWatchingFocus;
	}
	public Integer getIsHomemade() {
		return isHomemade;
	}
	public void setIsHomemade(Integer isHomemade) {
		this.isHomemade = isHomemade;
	}
	public String getRelationId() {
		return relationId;
	}
	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}
	public Integer getVarietyShow() {
		return varietyShow;
	}
	public void setVarietyShow(Integer varietyShow) {
		this.varietyShow = varietyShow;
	}
	public java.util.Date getOnTime() {
		return onTime;
	}
	public void setOnTime(java.util.Date onTime) {
		this.onTime = onTime;
	}
	public java.util.Date getOffTime() {
		return offTime;
	}
	public void setOffTime(java.util.Date offTime) {
		this.offTime = offTime;
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
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public java.util.Date getVideoFollowTime() {
		return videoFollowTime;
	}
	public void setVideoFollowTime(java.util.Date videoFollowTime) {
		this.videoFollowTime = videoFollowTime;
	}
	public Integer getContentRating() {
		return contentRating;
	}
	public void setContentRating(Integer contentRating) {
		this.contentRating = contentRating;
	}
	public Integer getCanSearch() {
		return canSearch;
	}
	public void setCanSearch(Integer canSearch) {
		this.canSearch = canSearch;
	}
	public Integer getCloneSource() {
		return cloneSource;
	}
	public void setCloneSource(Integer cloneSource) {
		this.cloneSource = cloneSource;
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
	public String getFirstPlayTv() {
		return firstPlayTv;
	}
	public void setFirstPlayTv(String firstPlayTv) {
		this.firstPlayTv = firstPlayTv;
	}
	public String getRepeatPlayTv() {
		return repeatPlayTv;
	}
	public void setRepeatPlayTv(String repeatPlayTv) {
		this.repeatPlayTv = repeatPlayTv;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getExtData() {
		return extData;
	}
	public void setExtData(String extData) {
		this.extData = extData;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getCoopPlatform() {
		return coopPlatform;
	}
	public void setCoopPlatform(String coopPlatform) {
		this.coopPlatform = coopPlatform;
	}
	public String getCategoryExt() {
		return categoryExt;
	}
	public void setCategoryExt(String categoryExt) {
		this.categoryExt = categoryExt;
	}
	public String getLeId() {
		return leId;
	}
	public void setLeId(String leId) {
		this.leId = leId;
	}
	public String getAudioInfo() {
		return audioInfo;
	}
	public void setAudioInfo(String audioInfo) {
		this.audioInfo = audioInfo;
	}
	public String getAlbumPic() {
		return albumPic;
	}
	public void setAlbumPic(String albumPic) {
		this.albumPic = albumPic;
	}
	public String getAutoCdnSize() {
		return autoCdnSize;
	}
	public void setAutoCdnSize(String autoCdnSize) {
		this.autoCdnSize = autoCdnSize;
	}
	public String getSubLeId() {
		return subLeId;
	}
	public void setSubLeId(String subLeId) {
		this.subLeId = subLeId;
	}
	public String getAutoCdnOri() {
		return autoCdnOri;
	}
	public void setAutoCdnOri(String autoCdnOri) {
		this.autoCdnOri = autoCdnOri;
	}
	public String getDynamicGraph() {
		return dynamicGraph;
	}
	public void setDynamicGraph(String dynamicGraph) {
		this.dynamicGraph = dynamicGraph;
	}
	public Integer getIsDanmaku() {
		return isDanmaku;
	}
	public void setIsDanmaku(Integer isDanmaku) {
		this.isDanmaku = isDanmaku;
	}
	public Integer getRiskLevel() {
		return riskLevel;
	}
	public void setRiskLevel(Integer riskLevel) {
		this.riskLevel = riskLevel;
	}
	public Integer getPlayMark() {
		return playMark;
	}
	public void setPlayMark(Integer playMark) {
		this.playMark = playMark;
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
	public String getCopyrightCode() {
		return copyrightCode;
	}
	public void setCopyrightCode(String copyrightCode) {
		this.copyrightCode = copyrightCode;
	}
	public Integer getPlayGuoguang() {
		return playGuoguang;
	}
	public void setPlayGuoguang(Integer playGuoguang) {
		this.playGuoguang = playGuoguang;
	}
	public String getIsVipDownload() {
		return isVipDownload;
	}
	public void setIsVipDownload(String isVipDownload) {
		this.isVipDownload = isVipDownload;
	}
	public Integer getIsRemark() {
		return isRemark;
	}
	public void setIsRemark(Integer isRemark) {
		this.isRemark = isRemark;
	}
	public Integer getLang() {
		return lang;
	}
	public void setLang(Integer lang) {
		this.lang = lang;
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
}
