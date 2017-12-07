package com.chltec.jpa.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Author joker
 * Date 2017/11/16 上午9:23
 * Description 移动设备
 */
@Entity
@Table(name = "mobiles")
public class Mobile implements java.io.Serializable {

    @Id
    @JSONField(name = "device_id")
    private String deviceId;

    @JSONField(name = "device_brand")
    private String deviceBrand;

    @JSONField(name = "os_type")
    private Integer osType;

    @JSONField(name = "app_version")
    private String appVersion;

    @JSONField(name = "baidu_channel_id")
    private String baiduChannelId;

    @JSONField(name = "jiguang_channel_id")
    private String jiguangChannelId;


    public Mobile() {
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public Integer getOsType() {
        return osType;
    }

    public void setOsType(Integer osType) {
        this.osType = osType;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getBaiduChannelId() {
        return baiduChannelId;
    }

    public void setBaiduChannelId(String baiduChannelId) {
        this.baiduChannelId = baiduChannelId;
    }

    public String getJiguangChannelId() {
        return jiguangChannelId;
    }

    public void setJiguangChannelId(String jiguangChannelId) {
        this.jiguangChannelId = jiguangChannelId;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "deviceId='" + deviceId + '\'' +
                ", osType=" + osType +
                ", appVersion='" + appVersion + '\'' +
                ", baiduChannelId='" + baiduChannelId + '\'' +
                ", jiguangChannelId='" + jiguangChannelId + '\'' +
                '}';
    }
}
