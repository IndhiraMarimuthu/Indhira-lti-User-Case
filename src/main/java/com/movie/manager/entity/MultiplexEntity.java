package com.movie.manager.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;
@Document(collection = "multiplex")
public class MultiplexEntity {

    private Integer multiplexId;
    private String multiplexName;
    private String address;
    private Set<ScreenEntity> screenEntityList;

    public Integer getMultiplexId() {
        return multiplexId;
    }

    public void setMultiplexId(Integer multiplexId) {
        this.multiplexId = multiplexId;
    }

    public String getMultiplexName() {
        return multiplexName;
    }

    public void setMultiplexName(String multiplexName) {
        this.multiplexName = multiplexName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<ScreenEntity> getScreenEntityList() {
        return screenEntityList;
    }

    public void setScreenEntityList(Set<ScreenEntity> screenEntityList) {
        this.screenEntityList = screenEntityList;
    }
}
