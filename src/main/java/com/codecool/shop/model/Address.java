package com.codecool.shop.model;

public class Address {

    private String zipcode;
    private String country;
    private String city;
    private String address;

    public Address(String zipcode, String country, String city, String address) {
        this.zipcode = zipcode;
        this.country = country;
        this.city = city;
        this.address = address;
    }

    public Address() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "zipcode=" + zipcode +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
