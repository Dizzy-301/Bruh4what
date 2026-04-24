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


import com.cl.dao.ZhaobiaoxiangmuDao;
import com.cl.entity.ZhaobiaoxiangmuEntity;
import com.cl.service.ZhaobiaoxiangmuService;
import com.cl.entity.view.ZhaobiaoxiangmuView;

@Service("zhaobiaoxiangmuService")
public class ZhaobiaoxiangmuServiceImpl extends ServiceImpl<ZhaobiaoxiangmuDao, ZhaobiaoxiangmuEntity> implements ZhaobiaoxiangmuService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhaobiaoxiangmuEntity> page = this.selectPage(
                new Query<ZhaobiaoxiangmuEntity>(params).getPage(),
                new EntityWrapper<ZhaobiaoxiangmuEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhaobiaoxiangmuEntity> wrapper) {
        Page<ZhaobiaoxiangmuView> page = new Query<ZhaobiaoxiangmuView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<ZhaobiaoxiangmuView> selectListView(Wrapper<ZhaobiaoxiangmuEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public ZhaobiaoxiangmuView selectView(Wrapper<ZhaobiaoxiangmuEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }


}
