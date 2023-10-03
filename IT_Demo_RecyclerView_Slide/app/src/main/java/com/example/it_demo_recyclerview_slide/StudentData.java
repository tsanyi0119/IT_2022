package com.example.it_demo_recyclerview_slide;

public class StudentData {
    int number;
    String phone;
    String name;

    public StudentData(int number,String phone,String name){
        this.number = number;
        this.phone = phone;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
