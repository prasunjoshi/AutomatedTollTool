package com.example.urja.tollproject;

/**
 * Created by Urja on 06-01-2018.
 */

public class HistoryDataModel
{
    String date;
    String tollId;
    String payment;
    public HistoryDataModel(String date,String tollId , String payment)
    {
        this.date=date;
        this.tollId=tollId;
        this.payment=payment;
    }

    public String getDate() {
        return date;
    }

    public String getTollId() {
        return tollId;
    }

    public String getPayment() {
        return payment;
    }
}
