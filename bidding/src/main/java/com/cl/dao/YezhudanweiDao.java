package com.cl.dao;

import com.cl.entity.YezhudanweiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YezhudanweiView;


/**
 * 业主单位
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
public interface YezhudanweiDao extends BaseMapper<YezhudanweiEntity> {

    List<YezhudanweiView> selectListView(@Param("ew") Wrapper<YezhudanweiEntity> wrapper);

    List<YezhudanweiView> selectListView(Pagination page, @Param("ew") Wrapper<YezhudanweiEntity> wrapper);

    YezhudanweiView selectView(@Param("ew") Wrapper<YezhudanweiEntity> wrapper);


}
