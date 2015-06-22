package com.chariotsolutions.intern.meetupnotifier.response;

public class Venue {
    private String zip ;
    private String country;
    private String city;
    private String address_1;
    private String name;
    private int lon;
    private int id;
    private String state;
    private int lat;
    private boolean repinned;

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress_1() {
        return address_1;
    }

    public void setAddress_1(String address_1) {
        this.address_1 = address_1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public boolean isRepinned() {
        return repinned;
    }

    public void setRepinned(boolean repinned) {
        this.repinned = repinned;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", address_1='" + address_1 + '\'' +
                ", name='" + name + '\'' +
                ", lon=" + lon +
                ", id=" + id +
                ", state='" + state + '\'' +
                ", lat=" + lat +
                ", repinned=" + repinned +
                '}';
    }
}
