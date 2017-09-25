/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.script.java_exercise;

import java.io.Serializable;

/**
 *
 * @author marlonvinan
 */
public class Model implements Serializable{
    private Integer monitors;
    private Integer checkRate;
    private Integer history;
    private boolean multipleNotifications;
    private boolean pushNotifications;
    private Double price;

    public Model() {
    }

    public Model(Integer monitors, Integer checkRate, Integer history, boolean multipleNotifications, boolean pushNotifications, Double price) {
        this.monitors = monitors;
        this.checkRate = checkRate;
        this.history = history;
        this.multipleNotifications = multipleNotifications;
        this.pushNotifications = pushNotifications;
        this.price = price;
    }

    public Integer getMonitors() {
        return monitors;
    }

    public void setMonitors(Integer monitors) {
        this.monitors = monitors;
    }

    public Integer getCheckRate() {
        return checkRate;
    }

    public void setCheckRate(Integer checkRate) {
        this.checkRate = checkRate;
    }

    public Integer getHistory() {
        return history;
    }

    public void setHistory(Integer history) {
        this.history = history;
    }

    public boolean isMultipleNotifications() {
        return multipleNotifications;
    }

    public void setMultipleNotifications(boolean multipleNotifications) {
        this.multipleNotifications = multipleNotifications;
    }

    public boolean isPushNotifications() {
        return pushNotifications;
    }

    public void setPushNotifications(boolean pushNotifications) {
        this.pushNotifications = pushNotifications;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    
    
    
}
