package com.cl.dao;

import com.cl.entity.ZhongbiaogonggaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhongbiaogonggaoView;


/**
 * 中标公告
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
public interface ZhongbiaogonggaoDao extends BaseMapper<ZhongbiaogonggaoEntity> {

    List<ZhongbiaogonggaoView> selectListView(@Param("ew") Wrapper<ZhongbiaogonggaoEntity> wrapper);

    List<ZhongbiaogonggaoView> selectListView(Pagination page, @Param("ew") Wrapper<ZhongbiaogonggaoEntity> wrapper);

    ZhongbiaogonggaoView selectView(@Param("ew") Wrapper<ZhongbiaogonggaoEntity> wrapper);


}
