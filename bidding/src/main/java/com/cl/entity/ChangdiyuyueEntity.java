package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 场地预约
 * 数据库通用操作实体类（普通增删改查）
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:04
 */
@TableName("changdiyuyue")
public class ChangdiyuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public ChangdiyuyueEntity() {

    }

    public ChangdiyuyueEntity(T t) {
        try {
            BeanUtils.copyProperties(this, t);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 场地名称
     */

    private String changdimingcheng;

    /**
     * 场地类型
     */

    private String changdileixing;

    /**
     * 项目名称
     */

    private String xiangmumingcheng;

    /**
     * 使用时间
     */

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date shiyongshijian;

    /**
     * 预约时间
     */

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date yuyueshijian;

    /**
     * 投标账号
     */

    private String toubiaozhanghao;

    /**
     * 投标人姓名
     */

    private String toubiaorenxingming;

    /**
     * 是否审核
     */

    private String sfsh;

    /**
     * 回复内容
     */

    private String shhf;


    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addtime;

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 设置：场地名称
     */
    public void setChangdimingcheng(String changdimingcheng) {
        this.changdimingcheng = changdimingcheng;
    }

    /**
     * 获取：场地名称
     */
    public String getChangdimingcheng() {
        return changdimingcheng;
    }

    /**
     * 设置：场地类型
     */
    public void setChangdileixing(String changdileixing) {
        this.changdileixing = changdileixing;
    }

    /**
     * 获取：场地类型
     */
    public String getChangdileixing() {
        return changdileixing;
    }

    /**
     * 设置：项目名称
     */
    public void setXiangmumingcheng(String xiangmumingcheng) {
        this.xiangmumingcheng = xiangmumingcheng;
    }

    /**
     * 获取：项目名称
     */
    public String getXiangmumingcheng() {
        return xiangmumingcheng;
    }

    /**
     * 设置：使用时间
     */
    public void setShiyongshijian(Date shiyongshijian) {
        this.shiyongshijian = shiyongshijian;
    }

    /**
     * 获取：使用时间
     */
    public Date getShiyongshijian() {
        return shiyongshijian;
    }

    /**
     * 设置：预约时间
     */
    public void setYuyueshijian(Date yuyueshijian) {
        this.yuyueshijian = yuyueshijian;
    }

    /**
     * 获取：预约时间
     */
    public Date getYuyueshijian() {
        return yuyueshijian;
    }

    /**
     * 设置：投标账号
     */
    public void setToubiaozhanghao(String toubiaozhanghao) {
        this.toubiaozhanghao = toubiaozhanghao;
    }

    /**
     * 获取：投标账号
     */
    public String getToubiaozhanghao() {
        return toubiaozhanghao;
    }

    /**
     * 设置：投标人姓名
     */
    public void setToubiaorenxingming(String toubiaorenxingming) {
        this.toubiaorenxingming = toubiaorenxingming;
    }

    /**
     * 获取：投标人姓名
     */
    public String getToubiaorenxingming() {
        return toubiaorenxingming;
    }

    /**
     * 设置：是否审核
     */
    public void setSfsh(String sfsh) {
        this.sfsh = sfsh;
    }

    /**
     * 获取：是否审核
     */
    public String getSfsh() {
        return sfsh;
    }

    /**
     * 设置：回复内容
     */
    public void setShhf(String shhf) {
        this.shhf = shhf;
    }

    /**
     * 获取：回复内容
     */
    public String getShhf() {
        return shhf;
    }

}
