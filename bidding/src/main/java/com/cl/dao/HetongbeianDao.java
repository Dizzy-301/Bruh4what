package com.cl.dao;

import com.cl.entity.HetongbeianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HetongbeianView;


/**
 * 合同备案
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
public interface HetongbeianDao extends BaseMapper<HetongbeianEntity> {

    List<HetongbeianView> selectListView(@Param("ew") Wrapper<HetongbeianEntity> wrapper);

    List<HetongbeianView> selectListView(Pagination page, @Param("ew") Wrapper<HetongbeianEntity> wrapper);

    HetongbeianView selectView(@Param("ew") Wrapper<HetongbeianEntity> wrapper);


}
