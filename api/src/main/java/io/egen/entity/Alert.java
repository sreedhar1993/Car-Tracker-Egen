package io.egen.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.persistence.Entity;

/**
 * Created by Sreedhar on 6/29/2017.
 */

public class Alert {
    public enum Priority {
        HIGH,
        MEDIUM,
        LOW
    }


    private String alert;
    private Priority priority;


    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}

