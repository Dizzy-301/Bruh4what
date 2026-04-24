package com.cl.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cl.entity.DailipingjiaEntity;
import com.cl.entity.view.DailipingjiaView;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 代理评价
 */
public interface DailipingjiaDao extends BaseMapper<DailipingjiaEntity> {
	
	List<DailipingjiaView> selectListView(@Param("ew") Wrapper<DailipingjiaEntity> wrapper);

	List<DailipingjiaView> selectListView(Pagination page,@Param("ew") Wrapper<DailipingjiaEntity> wrapper);
	
	DailipingjiaView selectView(@Param("ew") Wrapper<DailipingjiaEntity> wrapper);
}
