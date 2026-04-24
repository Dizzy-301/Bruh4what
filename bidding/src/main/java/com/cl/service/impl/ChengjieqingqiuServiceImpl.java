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

import com.cl.dao.ChengjieqingqiuDao;
import com.cl.entity.ChengjieqingqiuEntity;
import com.cl.service.ChengjieqingqiuService;
import com.cl.entity.view.ChengjieqingqiuView;

@Service("chengjieqingqiuService")
public class ChengjieqingqiuServiceImpl extends ServiceImpl<ChengjieqingqiuDao, ChengjieqingqiuEntity> implements ChengjieqingqiuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChengjieqingqiuEntity> page = this.selectPage(
                new Query<ChengjieqingqiuEntity>(params).getPage(),
                new EntityWrapper<ChengjieqingqiuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<ChengjieqingqiuEntity> wrapper) {
          Page<ChengjieqingqiuView> page = new Query<ChengjieqingqiuView>(params).getPage();
            page.setRecords(baseMapper.selectListView(page,wrapper));
            PageUtils pageUtil = new PageUtils(page);
            return pageUtil;
    }
    
    @Override
    public List<ChengjieqingqiuView> selectListView(Wrapper<ChengjieqingqiuEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public ChengjieqingqiuView selectView(Wrapper<ChengjieqingqiuEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }
}
