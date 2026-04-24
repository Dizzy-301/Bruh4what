package com.cl.dao;

import com.cl.entity.ChangdiyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChangdiyuyueView;


/**
 * 场地预约
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:04
 */
public interface ChangdiyuyueDao extends BaseMapper<ChangdiyuyueEntity> {

    List<ChangdiyuyueView> selectListView(@Param("ew") Wrapper<ChangdiyuyueEntity> wrapper);

    List<ChangdiyuyueView> selectListView(Pagination page, @Param("ew") Wrapper<ChangdiyuyueEntity> wrapper);

    ChangdiyuyueView selectView(@Param("ew") Wrapper<ChangdiyuyueEntity> wrapper);


}
