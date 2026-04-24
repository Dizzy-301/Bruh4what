package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;

import com.cl.dao.DailipingjiaDao;
import com.cl.entity.DailipingjiaEntity;
import com.cl.service.DailipingjiaService;
import com.cl.entity.view.DailipingjiaView;

@Service("dailipingjiaService")
public class DailipingjiaServiceImpl extends ServiceImpl<DailipingjiaDao, DailipingjiaEntity> implements DailipingjiaService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DailipingjiaEntity> page = this.selectPage(
                new Query<DailipingjiaEntity>(params).getPage(),
                new EntityWrapper<DailipingjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DailipingjiaEntity> wrapper) {
		  Page<DailipingjiaView> page = new Query<DailipingjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DailipingjiaView> selectListView(Wrapper<DailipingjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DailipingjiaView selectView(Wrapper<DailipingjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
