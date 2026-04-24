package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ChangdiyuyueEntity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChangdiyuyueView;


/**
 * 场地预约
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:04
 */
public interface ChangdiyuyueService extends IService<ChangdiyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<ChangdiyuyueView> selectListView(Wrapper<ChangdiyuyueEntity> wrapper);

    ChangdiyuyueView selectView(@Param("ew") Wrapper<ChangdiyuyueEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params, Wrapper<ChangdiyuyueEntity> wrapper);


}

