package com.cl.dao;

import com.cl.entity.ZhaobiaodailiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhaobiaodailiView;


/**
 * 招标代理
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
public interface ZhaobiaodailiDao extends BaseMapper<ZhaobiaodailiEntity> {

    List<ZhaobiaodailiView> selectListView(@Param("ew") Wrapper<ZhaobiaodailiEntity> wrapper);

    List<ZhaobiaodailiView> selectListView(Pagination page, @Param("ew") Wrapper<ZhaobiaodailiEntity> wrapper);

    ZhaobiaodailiView selectView(@Param("ew") Wrapper<ZhaobiaodailiEntity> wrapper);


}
