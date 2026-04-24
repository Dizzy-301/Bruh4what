package com.cl.dao;

import com.cl.entity.ZhaobiaogonggaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhaobiaogonggaoView;


/**
 * 招标公告
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:04
 */
public interface ZhaobiaogonggaoDao extends BaseMapper<ZhaobiaogonggaoEntity> {

    List<ZhaobiaogonggaoView> selectListView(@Param("ew") Wrapper<ZhaobiaogonggaoEntity> wrapper);

    List<ZhaobiaogonggaoView> selectListView(Pagination page, @Param("ew") Wrapper<ZhaobiaogonggaoEntity> wrapper);

    ZhaobiaogonggaoView selectView(@Param("ew") Wrapper<ZhaobiaogonggaoEntity> wrapper);


}
