package com.example.sugondese;

public class BookingDetails {

    String restName, time, date;
    int quantity;

    BookingDetails(){}

    BookingDetails(String restName, int quantity, String time, String date)
    {
        this.restName = restName;
        this.quantity = quantity;
        this.time = time;
        this.date = date;
    }

    public String getRestName()
    {
        return restName;
    }

    public void setRestName(String restName)
    {
        this.restName = restName;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public String getDate()
    {
        return date;
    }

    public  void setDate(String date)
    {
        this.date = date;
    }
}
