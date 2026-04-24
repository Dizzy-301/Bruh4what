package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZhaobiaodailiEntity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhaobiaodailiView;


/**
 * 招标代理
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
public interface ZhaobiaodailiService extends IService<ZhaobiaodailiEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<ZhaobiaodailiView> selectListView(Wrapper<ZhaobiaodailiEntity> wrapper);

    ZhaobiaodailiView selectView(@Param("ew") Wrapper<ZhaobiaodailiEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params, Wrapper<ZhaobiaodailiEntity> wrapper);


}

