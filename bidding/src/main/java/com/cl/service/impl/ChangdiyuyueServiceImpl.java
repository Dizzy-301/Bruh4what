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


import com.cl.dao.ChangdiyuyueDao;
import com.cl.entity.ChangdiyuyueEntity;
import com.cl.service.ChangdiyuyueService;
import com.cl.entity.view.ChangdiyuyueView;

@Service("changdiyuyueService")
public class ChangdiyuyueServiceImpl extends ServiceImpl<ChangdiyuyueDao, ChangdiyuyueEntity> implements ChangdiyuyueService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChangdiyuyueEntity> page = this.selectPage(
                new Query<ChangdiyuyueEntity>(params).getPage(),
                new EntityWrapper<ChangdiyuyueEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<ChangdiyuyueEntity> wrapper) {
        Page<ChangdiyuyueView> page = new Query<ChangdiyuyueView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<ChangdiyuyueView> selectListView(Wrapper<ChangdiyuyueEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public ChangdiyuyueView selectView(Wrapper<ChangdiyuyueEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }


}
