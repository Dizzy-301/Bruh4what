package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZhaobiaojihuaEntity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhaobiaojihuaView;


/**
 * 招标计划
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
public interface ZhaobiaojihuaService extends IService<ZhaobiaojihuaEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<ZhaobiaojihuaView> selectListView(Wrapper<ZhaobiaojihuaEntity> wrapper);

    ZhaobiaojihuaView selectView(@Param("ew") Wrapper<ZhaobiaojihuaEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params, Wrapper<ZhaobiaojihuaEntity> wrapper);


}

