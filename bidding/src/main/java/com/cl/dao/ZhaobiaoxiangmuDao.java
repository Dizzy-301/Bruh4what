package com.cl.dao;

import com.cl.entity.ZhaobiaoxiangmuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhaobiaoxiangmuView;


/**
 * 招标项目
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
public interface ZhaobiaoxiangmuDao extends BaseMapper<ZhaobiaoxiangmuEntity> {

    List<ZhaobiaoxiangmuView> selectListView(@Param("ew") Wrapper<ZhaobiaoxiangmuEntity> wrapper);

    List<ZhaobiaoxiangmuView> selectListView(Pagination page, @Param("ew") Wrapper<ZhaobiaoxiangmuEntity> wrapper);

    ZhaobiaoxiangmuView selectView(@Param("ew") Wrapper<ZhaobiaoxiangmuEntity> wrapper);


}
