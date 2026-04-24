package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ToubiaoxinxiEntity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ToubiaoxinxiView;


/**
 * 投标信息
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
public interface ToubiaoxinxiService extends IService<ToubiaoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<ToubiaoxinxiView> selectListView(Wrapper<ToubiaoxinxiEntity> wrapper);

    ToubiaoxinxiView selectView(@Param("ew") Wrapper<ToubiaoxinxiEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params, Wrapper<ToubiaoxinxiEntity> wrapper);


}

