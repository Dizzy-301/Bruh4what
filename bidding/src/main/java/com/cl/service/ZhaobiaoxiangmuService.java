package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZhaobiaoxiangmuEntity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhaobiaoxiangmuView;


/**
 * 招标项目
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
public interface ZhaobiaoxiangmuService extends IService<ZhaobiaoxiangmuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<ZhaobiaoxiangmuView> selectListView(Wrapper<ZhaobiaoxiangmuEntity> wrapper);

    ZhaobiaoxiangmuView selectView(@Param("ew") Wrapper<ZhaobiaoxiangmuEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params, Wrapper<ZhaobiaoxiangmuEntity> wrapper);


}

