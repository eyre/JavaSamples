package com.chltec.jfinalmaven.mongodb;

import com.cybermkd.mongo.kit.MongoBean;

import java.io.Serializable;
import java.sql.Timestamp;

public class StationLogBean extends MongoBean implements Serializable{
    private String station_id;                   //用户id
    private Integer work_mode;                     //工作模式，1：等待，2：并网，3：故障，4：升级
    private String fault_msg;                     //逆变器错误消息
    private Double pv1_volt;                       //PV1电压(V)
    private Double pv1_curr;                       //PV1电流(A)
    private Double pv1_power;                     //PV1功率(W)
    private Double pv2_volt;                       //PV2电压(V)
    private Double pv2_curr;                       //PV2电流(A)
    private Double pv2_power;                     //PV2功率(W)
    private Double pv3_volt;                       //PV3电压(V)
    private Double pv3_curr;                       //PV3电流(A)
    private Double pv3_power;                     //PV3功率(W)
    private Double bus_volt;                       //BUS电压(V)
    private Double inv_temperature;         //逆变器温度
    private Double gfci;                               //gfci(mA)
    private Double active_power;               //有功功率(W)
    private Double wattless_power;           //无功功率(W)
    private Double power_factor;               //功率因数
    private Double l1_phase_volt;             //L1相电压(V)
    private Double l1_phase_curr;             //L1相电流(A)
    private Double l1_phase_freq;             //L1相频率(Hz)
    private Double l1_dci;                           //L1相直流分量(mA)
    private Double l1_power;                       //L1功率(W)
    private Double l1_power_factor;         //L1功率因数
    private Double l2_phase_volt;             //L2相电压(V)
    private Double l2_phase_curr;             //L2相电流(A)
    private Double l2_phase_freq;             //L2相频率(Hz)
    private Double l2_dci;                           //L2相直流分量(mA)
    private Double l2_power;                       //L2功率(W)
    private Double l2_power_factor;         //L2功率因数
    private Double l3_phase_volt;             //L3相电压(V)
    private Double l3_phase_curr;             //L3相电流(A)
    private Double l3_phase_freq;             //L3相频率(Hz)
    private Double l3_dci;                           //L3相直流分量(mA)
    private Double l3_power;                       //L3功率(W)
    private Double l3_power_factor;         //L3功率因数
    private Double is01;                               //PV1+_ISO(kΩ)
    private Double is02;                               //PV2+_ISO(kΩ)
    private Double is03;                               //PV3+_ISO(kΩ)
    private Double is04;                               //PV4+_ISO(kΩ)
    private Double today_energy;               //逆变器当日发电量
    private Double month_energy;               //逆变器当月发电量
    private Double year_energy;                 //逆变器当年发电量
    private Double total_energy;                 //逆变器总发电量
    private Double today_hour;                   //逆变器当日工作小时数
    private Double total_hour;                   //逆变器当年工作小时数
    private Integer err_count;                     //逆变器错误数
    private Timestamp log_time;               //逆变器此记录的时间

    private Double yesterday_energy;         //逆变器昨日发电量
    private Double last_month_energy;         //逆变器上月发电量
    private Timestamp created_at;

    public StationLogBean() {
    }

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }

    public Integer getWork_mode() {
        return work_mode;
    }

    public void setWork_mode(Integer work_mode) {
        this.work_mode = work_mode;
    }

    public String getFault_msg() {
        return fault_msg;
    }

    public void setFault_msg(String fault_msg) {
        this.fault_msg = fault_msg;
    }

    public Double getPv1_volt() {
        return pv1_volt;
    }

    public void setPv1_volt(Double pv1_volt) {
        this.pv1_volt = pv1_volt;
    }

    public Double getPv1_curr() {
        return pv1_curr;
    }

    public void setPv1_curr(Double pv1_curr) {
        this.pv1_curr = pv1_curr;
    }

    public Double getPv1_power() {
        return pv1_power;
    }

    public void setPv1_power(Double pv1_power) {
        this.pv1_power = pv1_power;
    }

    public Double getPv2_volt() {
        return pv2_volt;
    }

    public void setPv2_volt(Double pv2_volt) {
        this.pv2_volt = pv2_volt;
    }

    public Double getPv2_curr() {
        return pv2_curr;
    }

    public void setPv2_curr(Double pv2_curr) {
        this.pv2_curr = pv2_curr;
    }

    public Double getPv2_power() {
        return pv2_power;
    }

    public void setPv2_power(Double pv2_power) {
        this.pv2_power = pv2_power;
    }

    public Double getPv3_volt() {
        return pv3_volt;
    }

    public void setPv3_volt(Double pv3_volt) {
        this.pv3_volt = pv3_volt;
    }

    public Double getPv3_curr() {
        return pv3_curr;
    }

    public void setPv3_curr(Double pv3_curr) {
        this.pv3_curr = pv3_curr;
    }

    public Double getPv3_power() {
        return pv3_power;
    }

    public void setPv3_power(Double pv3_power) {
        this.pv3_power = pv3_power;
    }

    public Double getBus_volt() {
        return bus_volt;
    }

    public void setBus_volt(Double bus_volt) {
        this.bus_volt = bus_volt;
    }

    public Double getInv_temperature() {
        return inv_temperature;
    }

    public void setInv_temperature(Double inv_temperature) {
        this.inv_temperature = inv_temperature;
    }

    public Double getGfci() {
        return gfci;
    }

    public void setGfci(Double gfci) {
        this.gfci = gfci;
    }

    public Double getActive_power() {
        return active_power;
    }

    public void setActive_power(Double active_power) {
        this.active_power = active_power;
    }

    public Double getWattless_power() {
        return wattless_power;
    }

    public void setWattless_power(Double wattless_power) {
        this.wattless_power = wattless_power;
    }

    public Double getPower_factor() {
        return power_factor;
    }

    public void setPower_factor(Double power_factor) {
        this.power_factor = power_factor;
    }

    public Double getL1_phase_volt() {
        return l1_phase_volt;
    }

    public void setL1_phase_volt(Double l1_phase_volt) {
        this.l1_phase_volt = l1_phase_volt;
    }

    public Double getL1_phase_curr() {
        return l1_phase_curr;
    }

    public void setL1_phase_curr(Double l1_phase_curr) {
        this.l1_phase_curr = l1_phase_curr;
    }

    public Double getL1_phase_freq() {
        return l1_phase_freq;
    }

    public void setL1_phase_freq(Double l1_phase_freq) {
        this.l1_phase_freq = l1_phase_freq;
    }

    public Double getL1_dci() {
        return l1_dci;
    }

    public void setL1_dci(Double l1_dci) {
        this.l1_dci = l1_dci;
    }

    public Double getL1_power() {
        return l1_power;
    }

    public void setL1_power(Double l1_power) {
        this.l1_power = l1_power;
    }

    public Double getL1_power_factor() {
        return l1_power_factor;
    }

    public void setL1_power_factor(Double l1_power_factor) {
        this.l1_power_factor = l1_power_factor;
    }

    public Double getL2_phase_volt() {
        return l2_phase_volt;
    }

    public void setL2_phase_volt(Double l2_phase_volt) {
        this.l2_phase_volt = l2_phase_volt;
    }

    public Double getL2_phase_curr() {
        return l2_phase_curr;
    }

    public void setL2_phase_curr(Double l2_phase_curr) {
        this.l2_phase_curr = l2_phase_curr;
    }

    public Double getL2_phase_freq() {
        return l2_phase_freq;
    }

    public void setL2_phase_freq(Double l2_phase_freq) {
        this.l2_phase_freq = l2_phase_freq;
    }

    public Double getL2_dci() {
        return l2_dci;
    }

    public void setL2_dci(Double l2_dci) {
        this.l2_dci = l2_dci;
    }

    public Double getL2_power() {
        return l2_power;
    }

    public void setL2_power(Double l2_power) {
        this.l2_power = l2_power;
    }

    public Double getL2_power_factor() {
        return l2_power_factor;
    }

    public void setL2_power_factor(Double l2_power_factor) {
        this.l2_power_factor = l2_power_factor;
    }

    public Double getL3_phase_volt() {
        return l3_phase_volt;
    }

    public void setL3_phase_volt(Double l3_phase_volt) {
        this.l3_phase_volt = l3_phase_volt;
    }

    public Double getL3_phase_curr() {
        return l3_phase_curr;
    }

    public void setL3_phase_curr(Double l3_phase_curr) {
        this.l3_phase_curr = l3_phase_curr;
    }

    public Double getL3_phase_freq() {
        return l3_phase_freq;
    }

    public void setL3_phase_freq(Double l3_phase_freq) {
        this.l3_phase_freq = l3_phase_freq;
    }

    public Double getL3_dci() {
        return l3_dci;
    }

    public void setL3_dci(Double l3_dci) {
        this.l3_dci = l3_dci;
    }

    public Double getL3_power() {
        return l3_power;
    }

    public void setL3_power(Double l3_power) {
        this.l3_power = l3_power;
    }

    public Double getL3_power_factor() {
        return l3_power_factor;
    }

    public void setL3_power_factor(Double l3_power_factor) {
        this.l3_power_factor = l3_power_factor;
    }

    public Double getIs01() {
        return is01;
    }

    public void setIs01(Double is01) {
        this.is01 = is01;
    }

    public Double getIs02() {
        return is02;
    }

    public void setIs02(Double is02) {
        this.is02 = is02;
    }

    public Double getIs03() {
        return is03;
    }

    public void setIs03(Double is03) {
        this.is03 = is03;
    }

    public Double getIs04() {
        return is04;
    }

    public void setIs04(Double is04) {
        this.is04 = is04;
    }

    public Double getToday_energy() {
        return today_energy;
    }

    public void setToday_energy(Double today_energy) {
        this.today_energy = today_energy;
    }

    public Double getMonth_energy() {
        return month_energy;
    }

    public void setMonth_energy(Double month_energy) {
        this.month_energy = month_energy;
    }

    public Double getYear_energy() {
        return year_energy;
    }

    public void setYear_energy(Double year_energy) {
        this.year_energy = year_energy;
    }

    public Double getTotal_energy() {
        return total_energy;
    }

    public void setTotal_energy(Double total_energy) {
        this.total_energy = total_energy;
    }

    public Double getToday_hour() {
        return today_hour;
    }

    public void setToday_hour(Double today_hour) {
        this.today_hour = today_hour;
    }

    public Double getTotal_hour() {
        return total_hour;
    }

    public void setTotal_hour(Double total_hour) {
        this.total_hour = total_hour;
    }

    public Integer getErr_count() {
        return err_count;
    }

    public void setErr_count(Integer err_count) {
        this.err_count = err_count;
    }

    public Timestamp getLog_time() {
        return log_time;
    }

    public void setLog_time(Timestamp log_time) {
        this.log_time = log_time;
    }

    public Double getYesterday_energy() {
        return yesterday_energy;
    }

    public void setYesterday_energy(Double yesterday_energy) {
        this.yesterday_energy = yesterday_energy;
    }

    public Double getLast_month_energy() {
        return last_month_energy;
    }

    public void setLast_month_energy(Double last_month_energy) {
        this.last_month_energy = last_month_energy;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
