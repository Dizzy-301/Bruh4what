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


import com.cl.dao.ZhaobiaogonggaoDao;
import com.cl.entity.ZhaobiaogonggaoEntity;
import com.cl.service.ZhaobiaogonggaoService;
import com.cl.entity.view.ZhaobiaogonggaoView;

@Service("zhaobiaogonggaoService")
public class ZhaobiaogonggaoServiceImpl extends ServiceImpl<ZhaobiaogonggaoDao, ZhaobiaogonggaoEntity> implements ZhaobiaogonggaoService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhaobiaogonggaoEntity> page = this.selectPage(
                new Query<ZhaobiaogonggaoEntity>(params).getPage(),
                new EntityWrapper<ZhaobiaogonggaoEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhaobiaogonggaoEntity> wrapper) {
        Page<ZhaobiaogonggaoView> page = new Query<ZhaobiaogonggaoView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<ZhaobiaogonggaoView> selectListView(Wrapper<ZhaobiaogonggaoEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public ZhaobiaogonggaoView selectView(Wrapper<ZhaobiaogonggaoEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }


}
