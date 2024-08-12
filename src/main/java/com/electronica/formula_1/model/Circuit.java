package com.electronica.formula_1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//NOTE: This is model for all circuit in formula 1
@Entity
public class Circuit{
  @Id
  private int circuitId;
  private String circuitRef;
  private String name;
  private String location;
  private String country;
  private double lat;
  private double lng;
  private int alt;
  private String url;


  public int getCircuitId() {
    return circuitId;
  }

  public void setCircuitId(int circuitId) {
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

  public double getLat() {
    return lat;
  }

  public void setLat(double lat) {
    this.lat = lat;
  }

  public double getLng() {
    return lng;
  }

  public void setLng(double lng) {
    this.lng = lng;
  }

  public int getAlt() {
    return alt;
  }

  public void setAlt(int alt) {
    this.alt = alt;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
