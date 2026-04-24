package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 代理评价
 * 数据库通用操作实体类（普通增删改查）
 */
@TableName("dailipingjia")
public class DailipingjiaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addtime;

    private String dailigongsizhanghao;
    private String dailigongsimingcheng;
    private Integer manyidu;
    private String pingjianeirong;
    private String yezhuzhanghao;
    private String yezhumingcheng;
    private String xiangmumingcheng;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getDailigongsizhanghao() {
        return dailigongsizhanghao;
    }

    public void setDailigongsizhanghao(String dailigongsizhanghao) {
        this.dailigongsizhanghao = dailigongsizhanghao;
    }

    public String getDailigongsimingcheng() {
        return dailigongsimingcheng;
    }

    public void setDailigongsimingcheng(String dailigongsimingcheng) {
        this.dailigongsimingcheng = dailigongsimingcheng;
    }

    public Integer getManyidu() {
        return manyidu;
    }

    public void setManyidu(Integer manyidu) {
        this.manyidu = manyidu;
    }

    public String getPingjianeirong() {
        return pingjianeirong;
    }

    public void setPingjianeirong(String pingjianeirong) {
        this.pingjianeirong = pingjianeirong;
    }

    public String getYezhuzhanghao() {
        return yezhuzhanghao;
    }

    public void setYezhuzhanghao(String yezhuzhanghao) {
        this.yezhuzhanghao = yezhuzhanghao;
    }

    public String getYezhumingcheng() {
        return yezhumingcheng;
    }

    public void setYezhumingcheng(String yezhumingcheng) {
        this.yezhumingcheng = yezhumingcheng;
    }

    public String getXiangmumingcheng() {
        return xiangmumingcheng;
    }

    public void setXiangmumingcheng(String xiangmumingcheng) {
        this.xiangmumingcheng = xiangmumingcheng;
    }
}
