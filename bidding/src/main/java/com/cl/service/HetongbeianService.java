package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HetongbeianEntity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HetongbeianView;


/**
 * 合同备案
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
public interface HetongbeianService extends IService<HetongbeianEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<HetongbeianView> selectListView(Wrapper<HetongbeianEntity> wrapper);

    HetongbeianView selectView(@Param("ew") Wrapper<HetongbeianEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params, Wrapper<HetongbeianEntity> wrapper);


}

