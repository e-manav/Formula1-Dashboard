package com.electronica.formula_1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//NOTE: This is model for all circuit in formula 1
@Entity
public class Circuit{
  @Id
  private String circuitId;
  private String circuitRef;
  private String name;
  private String location;
  private String country;
  private String lat;
  private String lng;
  private String alt;
  private String url;


  public String getCircuitId() {
    return circuitId;
  }

  public void setCircuitId(String circuitId) {
    this.circuitId = circuitId;
  }

  public String getCircuitRef() {
    return circuitRef;
  }

  public void setCircuitRef(String circuitRef) {
    this.circuitRef = circuitRef;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getLat() {
    return lat;
  }

  public void setLat(String lat) {
    this.lat = lat;
  }

  public String getLng() {
    return lng;
  }

  public void setLng(String lng) {
    this.lng = lng;
  }

  public String getAlt() {
    return alt;
  }

  public void setAlt(String alt) {
    this.alt = alt;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
