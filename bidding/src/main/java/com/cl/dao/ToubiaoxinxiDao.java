package com.cl.dao;

import com.cl.entity.ToubiaoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ToubiaoxinxiView;


/**
 * 投标信息
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
public interface ToubiaoxinxiDao extends BaseMapper<ToubiaoxinxiEntity> {

    List<ToubiaoxinxiView> selectListView(@Param("ew") Wrapper<ToubiaoxinxiEntity> wrapper);

    List<ToubiaoxinxiView> selectListView(Pagination page, @Param("ew") Wrapper<ToubiaoxinxiEntity> wrapper);

    ToubiaoxinxiView selectView(@Param("ew") Wrapper<ToubiaoxinxiEntity> wrapper);


}
