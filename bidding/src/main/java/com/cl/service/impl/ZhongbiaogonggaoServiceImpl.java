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


import com.cl.dao.ZhongbiaogonggaoDao;
import com.cl.entity.ZhongbiaogonggaoEntity;
import com.cl.service.ZhongbiaogonggaoService;
import com.cl.entity.view.ZhongbiaogonggaoView;

@Service("zhongbiaogonggaoService")
public class ZhongbiaogonggaoServiceImpl extends ServiceImpl<ZhongbiaogonggaoDao, ZhongbiaogonggaoEntity> implements ZhongbiaogonggaoService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhongbiaogonggaoEntity> page = this.selectPage(
                new Query<ZhongbiaogonggaoEntity>(params).getPage(),
                new EntityWrapper<ZhongbiaogonggaoEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhongbiaogonggaoEntity> wrapper) {
        Page<ZhongbiaogonggaoView> page = new Query<ZhongbiaogonggaoView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<ZhongbiaogonggaoView> selectListView(Wrapper<ZhongbiaogonggaoEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public ZhongbiaogonggaoView selectView(Wrapper<ZhongbiaogonggaoEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }


}
