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


import com.cl.dao.HetongbeianDao;
import com.cl.entity.HetongbeianEntity;
import com.cl.service.HetongbeianService;
import com.cl.entity.view.HetongbeianView;

@Service("hetongbeianService")
public class HetongbeianServiceImpl extends ServiceImpl<HetongbeianDao, HetongbeianEntity> implements HetongbeianService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HetongbeianEntity> page = this.selectPage(
                new Query<HetongbeianEntity>(params).getPage(),
                new EntityWrapper<HetongbeianEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<HetongbeianEntity> wrapper) {
        Page<HetongbeianView> page = new Query<HetongbeianView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<HetongbeianView> selectListView(Wrapper<HetongbeianEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public HetongbeianView selectView(Wrapper<HetongbeianEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }


}
