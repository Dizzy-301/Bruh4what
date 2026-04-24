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


import com.cl.dao.ZhaobiaojihuaDao;
import com.cl.entity.ZhaobiaojihuaEntity;
import com.cl.service.ZhaobiaojihuaService;
import com.cl.entity.view.ZhaobiaojihuaView;

@Service("zhaobiaojihuaService")
public class ZhaobiaojihuaServiceImpl extends ServiceImpl<ZhaobiaojihuaDao, ZhaobiaojihuaEntity> implements ZhaobiaojihuaService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhaobiaojihuaEntity> page = this.selectPage(
                new Query<ZhaobiaojihuaEntity>(params).getPage(),
                new EntityWrapper<ZhaobiaojihuaEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhaobiaojihuaEntity> wrapper) {
        Page<ZhaobiaojihuaView> page = new Query<ZhaobiaojihuaView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<ZhaobiaojihuaView> selectListView(Wrapper<ZhaobiaojihuaEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public ZhaobiaojihuaView selectView(Wrapper<ZhaobiaojihuaEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }


}
