package com.cl.entity.view;

import com.cl.entity.DailipingjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 代理评价
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("dailipingjia")
public class DailipingjiaView extends DailipingjiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DailipingjiaView() {
	}

	public DailipingjiaView(DailipingjiaEntity dailipingjiaEntity) {
		try {
			BeanUtils.copyProperties(this, dailipingjiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
