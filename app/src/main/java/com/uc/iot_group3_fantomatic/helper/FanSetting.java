package com.uc.iot_group3_fantomatic.helper;

public class FanSetting {
    private String isAuto, isPower;
    private int currentSpeed;

    public FanSetting() {
        this.isAuto = "false";
        this.isPower = "false";
        this.currentSpeed = 0;
    }

    public FanSetting(String isAuto, String isPower) {
        this.isAuto = isAuto;
        this.isPower = isPower;
        this.currentSpeed = 0;
    }

    public FanSetting(String isAuto, String isPower, int currentSpeed) {
        this.isAuto = isAuto;
        this.isPower = isPower;
        this.currentSpeed = currentSpeed;
    }

    public String getIsAuto() {
        return isAuto;
    }

    public void setIsAuto(String isAuto) {
        this.isAuto = isAuto;
    }

    public String getIsPower() {
        return isPower;
    }

    public void setIsPower(String isPower) {
        this.isPower = isPower;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
}
