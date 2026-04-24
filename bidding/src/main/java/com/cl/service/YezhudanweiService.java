package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YezhudanweiEntity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YezhudanweiView;


/**
 * 业主单位
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
public interface YezhudanweiService extends IService<YezhudanweiEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<YezhudanweiView> selectListView(Wrapper<YezhudanweiEntity> wrapper);

    YezhudanweiView selectView(@Param("ew") Wrapper<YezhudanweiEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params, Wrapper<YezhudanweiEntity> wrapper);


}

