package com.codecool.shop.model;

public class Address {

    private String zipcode;
    private String country;
    private String city;
    private String street;
    private int userId;
    private int id;

    public Address(String zipcode, String country, String city, String street, int id) {
        this.zipcode = zipcode;
        this.country = country;
        this.city = city;
        this.street = street;
        this.id = id;
    }

    public Address(String zipcode, String country, String city, String street, int userId, int id) {
        this.zipcode = zipcode;
        this.country = country;
        this.city = city;
        this.street = street;
        this.userId = userId;
        this.id = id;
    }

    public Address() {
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "zipcode=" + zipcode +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
