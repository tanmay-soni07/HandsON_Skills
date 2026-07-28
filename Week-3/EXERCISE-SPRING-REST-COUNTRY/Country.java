package com.cognizant.springlearn.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {
    
    @JsonProperty("code")
    private String code;
    
    @JsonProperty("name")
    private String name;
    
    public Country() {
    }
    
    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Country country = (Country) obj;
        return code != null && code.equalsIgnoreCase(country.code);
    }
    
    @Override
    public int hashCode() {
        return code != null ? code.toUpperCase().hashCode() : 0;
    }
}
