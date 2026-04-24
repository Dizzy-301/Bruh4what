package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 承接申请
 */
@TableName("chengjieqingqiu")
public class ChengjieqingqiuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    private String xiangmumingcheng;
    private String qiyezhanghao;
    private String dailigongsizhanghao;
    private String dailigongsimingcheng;
    private String lianxidianhua;
    private String fuwuchengnuo;
    private String zizhiwenjian;

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addtime;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getXiangmumingcheng() { return xiangmumingcheng; }
    public void setXiangmumingcheng(String xiangmumingcheng) { this.xiangmumingcheng = xiangmumingcheng; }

    public String getQiyezhanghao() { return qiyezhanghao; }
    public void setQiyezhanghao(String qiyezhanghao) { this.qiyezhanghao = qiyezhanghao; }

    public String getDailigongsizhanghao() { return dailigongsizhanghao; }
    public void setDailigongsizhanghao(String dailigongsizhanghao) { this.dailigongsizhanghao = dailigongsizhanghao; }

    public String getDailigongsimingcheng() { return dailigongsimingcheng; }
    public void setDailigongsimingcheng(String dailigongsimingcheng) { this.dailigongsimingcheng = dailigongsimingcheng; }

    public String getLianxidianhua() { return lianxidianhua; }
    public void setLianxidianhua(String lianxidianhua) { this.lianxidianhua = lianxidianhua; }

    public String getFuwuchengnuo() { return fuwuchengnuo; }
    public void setFuwuchengnuo(String fuwuchengnuo) { this.fuwuchengnuo = fuwuchengnuo; }

    public String getZizhiwenjian() { return zizhiwenjian; }
    public void setZizhiwenjian(String zizhiwenjian) { this.zizhiwenjian = zizhiwenjian; }

    public Date getAddtime() { return addtime; }
    public void setAddtime(Date addtime) { this.addtime = addtime; }
}
