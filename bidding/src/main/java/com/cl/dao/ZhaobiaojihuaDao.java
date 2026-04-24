package com.cl.dao;

import com.cl.entity.ZhaobiaojihuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhaobiaojihuaView;


/**
 * 招标计划
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
public interface ZhaobiaojihuaDao extends BaseMapper<ZhaobiaojihuaEntity> {

    List<ZhaobiaojihuaView> selectListView(@Param("ew") Wrapper<ZhaobiaojihuaEntity> wrapper);

    List<ZhaobiaojihuaView> selectListView(Pagination page, @Param("ew") Wrapper<ZhaobiaojihuaEntity> wrapper);

    ZhaobiaojihuaView selectView(@Param("ew") Wrapper<ZhaobiaojihuaEntity> wrapper);


}
