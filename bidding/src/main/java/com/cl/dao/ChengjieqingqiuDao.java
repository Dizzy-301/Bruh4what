package com.cl.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cl.entity.ChengjieqingqiuEntity;
import com.cl.entity.view.ChengjieqingqiuView;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 承接申请 DAO
 */
public interface ChengjieqingqiuDao extends BaseMapper<ChengjieqingqiuEntity> {
    
    List<ChengjieqingqiuView> selectListView(@Param("ew") Wrapper<ChengjieqingqiuEntity> wrapper);

    List<ChengjieqingqiuView> selectListView(Pagination page,@Param("ew") Wrapper<ChengjieqingqiuEntity> wrapper);
    
    ChengjieqingqiuView selectView(@Param("ew") Wrapper<ChengjieqingqiuEntity> wrapper);
}
