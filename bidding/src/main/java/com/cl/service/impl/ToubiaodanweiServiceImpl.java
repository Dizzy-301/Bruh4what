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


import com.cl.dao.ToubiaodanweiDao;
import com.cl.entity.ToubiaodanweiEntity;
import com.cl.service.ToubiaodanweiService;
import com.cl.entity.view.ToubiaodanweiView;

@Service("toubiaodanweiService")
public class ToubiaodanweiServiceImpl extends ServiceImpl<ToubiaodanweiDao, ToubiaodanweiEntity> implements ToubiaodanweiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ToubiaodanweiEntity> page = this.selectPage(
                new Query<ToubiaodanweiEntity>(params).getPage(),
                new EntityWrapper<ToubiaodanweiEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<ToubiaodanweiEntity> wrapper) {
        Page<ToubiaodanweiView> page = new Query<ToubiaodanweiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<ToubiaodanweiView> selectListView(Wrapper<ToubiaodanweiEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public ToubiaodanweiView selectView(Wrapper<ToubiaodanweiEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }


}
