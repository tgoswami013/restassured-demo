package com.tg.demo.pojo;

import java.util.LinkedHashMap;
import java.util.Map;

public class Tag {
    private Integer id;
    private String name;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Tag(){

    }

    public Tag( int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}
