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
 * 招标项目
 * 数据库通用操作实体类（普通增删改查）
 *
 * @author
 * @email
 * @date 2025-12-24 20:45:03
 */
@TableName("zhaobiaoxiangmu")
public class ZhaobiaoxiangmuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public ZhaobiaoxiangmuEntity() {

    }

    public ZhaobiaoxiangmuEntity(T t) {
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
     * 项目名称
     */

    private String xiangmumingcheng;

    /**
     * 企业账号
     */

    private String qiyezhanghao;

    /**
     * 企业名称
     */

    private String qiyemingcheng;

    /**
     * 招标范围
     */

    private String zhaobiaofanwei;

    /**
     * 招标文件
     */

    private String zhaobiaowenjian;

    /**
     * 投标截止时间
     */

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat
    private Date toubiaojiezhishijian;

    /**
     * 开标时间
     */

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat
    private Date kaibiaoshijian;

    /**
     * 项目地点
     */

    private String xiangmudidian;

    /**
     * 项目周期
     */

    private String xiangmuzhouqi;

    /**
     * 合同条款
     */

    private String hetongtiaokuan;

    /**
     * 是否审核
     */

    private String sfsh;

    /**
     * 回复内容
     */

    private String shhf;

    /**
     * 封面
     */

    private String fengmian;

    /**
     * 代理公司账号
     */

    private String dailigongsizhanghao;

    /**
     * 代理公司名称
     */

    private String dailigongsimingcheng;

    /**
     * 项目预算
     */
    private Double xiangmuyusuan;


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
     * 设置：企业账号
     */
    public void setQiyezhanghao(String qiyezhanghao) {
        this.qiyezhanghao = qiyezhanghao;
    }

    /**
     * 获取：企业账号
     */
    public String getQiyezhanghao() {
        return qiyezhanghao;
    }

    /**
     * 设置：企业名称
     */
    public void setQiyemingcheng(String qiyemingcheng) {
        this.qiyemingcheng = qiyemingcheng;
    }

    /**
     * 获取：企业名称
     */
    public String getQiyemingcheng() {
        return qiyemingcheng;
    }

    /**
     * 设置：招标范围
     */
    public void setZhaobiaofanwei(String zhaobiaofanwei) {
        this.zhaobiaofanwei = zhaobiaofanwei;
    }

    /**
     * 获取：招标范围
     */
    public String getZhaobiaofanwei() {
        return zhaobiaofanwei;
    }

    /**
     * 设置：招标文件
     */
    public void setZhaobiaowenjian(String zhaobiaowenjian) {
        this.zhaobiaowenjian = zhaobiaowenjian;
    }

    /**
     * 获取：招标文件
     */
    public String getZhaobiaowenjian() {
        return zhaobiaowenjian;
    }

    /**
     * 设置：投标截止时间
     */
    public void setToubiaojiezhishijian(Date toubiaojiezhishijian) {
        this.toubiaojiezhishijian = toubiaojiezhishijian;
    }

    /**
     * 获取：投标截止时间
     */
    public Date getToubiaojiezhishijian() {
        return toubiaojiezhishijian;
    }

    /**
     * 设置：开标时间
     */
    public void setKaibiaoshijian(Date kaibiaoshijian) {
        this.kaibiaoshijian = kaibiaoshijian;
    }

    /**
     * 获取：开标时间
     */
    public Date getKaibiaoshijian() {
        return kaibiaoshijian;
    }

    /**
     * 设置：项目地点
     */
    public void setXiangmudidian(String xiangmudidian) {
        this.xiangmudidian = xiangmudidian;
    }

    /**
     * 获取：项目地点
     */
    public String getXiangmudidian() {
        return xiangmudidian;
    }

    /**
     * 设置：项目周期
     */
    public void setXiangmuzhouqi(String xiangmuzhouqi) {
        this.xiangmuzhouqi = xiangmuzhouqi;
    }

    /**
     * 获取：项目周期
     */
    public String getXiangmuzhouqi() {
        return xiangmuzhouqi;
    }

    /**
     * 设置：合同条款
     */
    public void setHetongtiaokuan(String hetongtiaokuan) {
        this.hetongtiaokuan = hetongtiaokuan;
    }

    /**
     * 获取：合同条款
     */
    public String getHetongtiaokuan() {
        return hetongtiaokuan;
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

    /**
     * 设置：封面
     */
    public void setFengmian(String fengmian) {
        this.fengmian = fengmian;
    }

    /**
     * 获取：封面
     */
    public String getFengmian() {
        return fengmian;
    }

    /**
     * 设置：代理公司账号
     */
    public void setDailigongsizhanghao(String dailigongsizhanghao) {
        this.dailigongsizhanghao = dailigongsizhanghao;
    }

    /**
     * 获取：代理公司账号
     */
    public String getDailigongsizhanghao() {
        return dailigongsizhanghao;
    }

    /**
     * 设置：代理公司名称
     */
    public void setDailigongsimingcheng(String dailigongsimingcheng) {
        this.dailigongsimingcheng = dailigongsimingcheng;
    }

    /**
     * 获取：代理公司名称
     */
    public String getDailigongsimingcheng() {
        return dailigongsimingcheng;
    }

    public void setXiangmuyusuan(Double xiangmuyusuan) {
        this.xiangmuyusuan = xiangmuyusuan;
    }

    public Double getXiangmuyusuan() {
        return xiangmuyusuan;
    }

}
