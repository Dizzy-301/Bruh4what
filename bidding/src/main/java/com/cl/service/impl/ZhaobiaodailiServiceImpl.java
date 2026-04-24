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


import com.cl.dao.ZhaobiaodailiDao;
import com.cl.entity.ZhaobiaodailiEntity;
import com.cl.service.ZhaobiaodailiService;
import com.cl.entity.view.ZhaobiaodailiView;

@Service("zhaobiaodailiService")
public class ZhaobiaodailiServiceImpl extends ServiceImpl<ZhaobiaodailiDao, ZhaobiaodailiEntity> implements ZhaobiaodailiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhaobiaodailiEntity> page = this.selectPage(
                new Query<ZhaobiaodailiEntity>(params).getPage(),
                new EntityWrapper<ZhaobiaodailiEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhaobiaodailiEntity> wrapper) {
        Page<ZhaobiaodailiView> page = new Query<ZhaobiaodailiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<ZhaobiaodailiView> selectListView(Wrapper<ZhaobiaodailiEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public ZhaobiaodailiView selectView(Wrapper<ZhaobiaodailiEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }


}
