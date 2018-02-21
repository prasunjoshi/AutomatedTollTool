package com.example.urja.tollproject;

/**
 * Created by Urja on 06-01-2018.
 */

public class HistoryDetails {
    int _id;
    String _TOLL_ID;
    double _rate;
    String _paid;
    String _date;
    String _regId;
    public HistoryDetails()
    {

    }
    public HistoryDetails(int id, String tollid, double rate, String paid,String date) {
        this._id = id;
        this._TOLL_ID = tollid;
        this._rate = rate;
        this._paid = paid;
        this._date=date;
    }

    public String get_regId() {
        return _regId;
    }

    public void set_regId(String _regId) {
        this._regId = _regId;
    }

    public String get_date() {
        return _date;
    }

    public void set_date(String _date) {
        this._date = _date;
    }

    public double get_rate() {
        return _rate;
    }

    public int get_id() {
        return _id;
    }

    public String get_paid() {
        return _paid;
    }

    public String get_TOLL_ID() {
        return _TOLL_ID;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_paid(String _paid) {
        this._paid = _paid;
    }

    public void set_rate(double _rate) {
        this._rate = _rate;
    }

    public void set_TOLL_ID(String _TOLL_ID) {
        this._TOLL_ID = _TOLL_ID;
    }
}
