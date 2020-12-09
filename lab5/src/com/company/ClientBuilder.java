package com.company;

public class ClientBuilder{
    private String firstName, secondName, address, passport;

    public ClientBuilder(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public ClientBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public ClientBuilder setPassport(String passport) {
        this.passport = passport;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getAddress() {
        return address;
    }

    public String getPassport() {
        return passport;
    }
}
