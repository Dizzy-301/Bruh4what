package com.cl.dao;

import com.cl.entity.ToubiaodanweiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ToubiaodanweiView;


/**
 * 投标单位
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
public interface ToubiaodanweiDao extends BaseMapper<ToubiaodanweiEntity> {

    List<ToubiaodanweiView> selectListView(@Param("ew") Wrapper<ToubiaodanweiEntity> wrapper);

    List<ToubiaodanweiView> selectListView(Pagination page, @Param("ew") Wrapper<ToubiaodanweiEntity> wrapper);

    ToubiaodanweiView selectView(@Param("ew") Wrapper<ToubiaodanweiEntity> wrapper);


}
