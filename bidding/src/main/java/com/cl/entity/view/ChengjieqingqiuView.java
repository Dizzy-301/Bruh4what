package com.cl.entity.view;

import com.cl.entity.ChengjieqingqiuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.io.Serializable;

/**
 * 承接申请视图类
 */
@TableName("chengjieqingqiu")
public class ChengjieqingqiuView extends ChengjieqingqiuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public ChengjieqingqiuView() {
    }

    public ChengjieqingqiuView(ChengjieqingqiuEntity chengjieqingqiuEntity) {
        try {
            BeanUtils.copyProperties(this, chengjieqingqiuEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
