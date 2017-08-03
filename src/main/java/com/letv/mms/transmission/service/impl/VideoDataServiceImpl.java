package com.letv.mms.transmission.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.brmayi.epiphany.exception.EpiphanyException;
import com.brmayi.epiphany.service.DataService;
import com.letv.mms.transmission.dao.ConVideoInfoDao;
import com.letv.mms.transmission.model.ConVideoInfoModel;
import com.letv.mms.transmission.service.VideoService;

@Component
public class VideoDataServiceImpl implements DataService {
	
    @Resource
	private ConVideoInfoDao conVideoInfoDao;
	@Resource
	private VideoService videoService;
	
	@Override
	public List<Long> getIds(String beginTime, String endTime)
			throws EpiphanyException {
		return conVideoInfoDao.getIdsByUpdatetime(beginTime, endTime);
	}

	@Override
	public void dealDataByIds(List<Long> dealIds, String path) throws EpiphanyException {
		ConVideoInfoModel[] dealModels = conVideoInfoDao.getByIds(dealIds);
		videoService.dealVideos(dealModels, path==null?true:false, path);
	}

	@Override
	public void dealDataByBeginEnd(long beginId, long endId, String path)throws EpiphanyException {
		ConVideoInfoModel[] videos = conVideoInfoDao.getByStartEnd(beginId, endId);
		videoService.dealVideos(videos, false, path);
	}

	@Override
	public long getMaxId() throws EpiphanyException {
		return conVideoInfoDao.getMaxId();
	}

	@Override
	public long getMinId() throws EpiphanyException {
		return conVideoInfoDao.getMinId();
	}

	@Override
	public List<Long> getNiceQueue() throws EpiphanyException {
		return null;
	}

	@Override
	public List<Long> getIdsByBeginEnd(long beginId, long endId)
			throws EpiphanyException {
		return null;
	}
}
