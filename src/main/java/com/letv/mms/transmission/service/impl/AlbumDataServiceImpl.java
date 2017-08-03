package com.letv.mms.transmission.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.brmayi.epiphany.exception.EpiphanyException;
import com.brmayi.epiphany.service.DataService;
import com.letv.mms.transmission.dao.ConAlbumInfoDao;
import com.letv.mms.transmission.model.ConAlbumInfoModel;
import com.letv.mms.transmission.service.AlbumService;

/**
 * 
 * **************************************************************
 * @ClassName: AlbumDataServiceImpl 
 * @Description: 将专辑信息存成json
 * @author <a href='mailto:987489055@qq.com'>Jane Xie</a>
 * @date 2016年8月6日 下午2:16:08
 *  
 * **************************************************************
 */
@Component
public class AlbumDataServiceImpl implements DataService {

	@Resource
	private AlbumService albumService;
	
    @Resource
	private ConAlbumInfoDao conAlbumInfoDao; 

	@Override
	public List<Long> getIds(String beginTime, String endTime) throws EpiphanyException {
		return conAlbumInfoDao.getIdsByUpdatetime(beginTime, endTime);
	}

	@Override
	public void dealDataByIds(List<Long> dealIds, String path) throws EpiphanyException {
		List<ConAlbumInfoModel> albums = conAlbumInfoDao.getByIds(dealIds);
		albumService.dealAlbums(albums, path==null?true:false, path);
	}

	@Override
	public void dealDataByBeginEnd(long beginId, long endId, String path)throws EpiphanyException {
		List<ConAlbumInfoModel> albums = conAlbumInfoDao.getByStartEnd(beginId, endId);
		albumService.dealAlbums(albums, false, path);
	}

	@Override
	public long getMaxId() throws EpiphanyException {
		return conAlbumInfoDao.getMaxId()+10;
	}

	@Override
	public long getMinId() throws EpiphanyException {
		return conAlbumInfoDao.getMinId();
	}

	@Override
	public List<Long> getNiceQueue() throws EpiphanyException {
		return conAlbumInfoDao.getLargeVideosIds();
	}

	@Override
	public List<Long> getIdsByBeginEnd(long beginId, long endId) throws EpiphanyException {
		return conAlbumInfoDao.getIdsByStartEnd(beginId, endId);
	}
}
