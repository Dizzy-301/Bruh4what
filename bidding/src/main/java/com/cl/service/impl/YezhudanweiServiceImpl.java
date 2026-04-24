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


import com.cl.dao.YezhudanweiDao;
import com.cl.entity.YezhudanweiEntity;
import com.cl.service.YezhudanweiService;
import com.cl.entity.view.YezhudanweiView;

@Service("yezhudanweiService")
public class YezhudanweiServiceImpl extends ServiceImpl<YezhudanweiDao, YezhudanweiEntity> implements YezhudanweiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YezhudanweiEntity> page = this.selectPage(
                new Query<YezhudanweiEntity>(params).getPage(),
                new EntityWrapper<YezhudanweiEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<YezhudanweiEntity> wrapper) {
        Page<YezhudanweiView> page = new Query<YezhudanweiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<YezhudanweiView> selectListView(Wrapper<YezhudanweiEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public YezhudanweiView selectView(Wrapper<YezhudanweiEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }


}
