package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ChengjieqingqiuEntity;
import com.cl.entity.view.ChengjieqingqiuView;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * 承接申请 Service
 */
public interface ChengjieqingqiuService extends IService<ChengjieqingqiuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    List<ChengjieqingqiuView> selectListView(Wrapper<ChengjieqingqiuEntity> wrapper);
    
    ChengjieqingqiuView selectView(@Param("ew") Wrapper<ChengjieqingqiuEntity> wrapper);
    
    PageUtils queryPage(Map<String, Object> params, Wrapper<ChengjieqingqiuEntity> wrapper);
}
