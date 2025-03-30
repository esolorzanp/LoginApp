package com.example.loginapp.dao;

import android.content.Context;
import android.content.SharedPreferences;

public class ConnectFileXML {
    private String fileName;

    public ConnectFileXML() {
        this.fileName = "";
    }

    public ConnectFileXML(String fileName) {
        this.fileName = fileName;
    }

    public void getSP(){
        //SharedPreferences sp = getSharedPreferences("AppConversionMonedas", Context.MODE_PRIVATE);
    }

    public void setFileName(String fn) {
        this.fileName = fn;
    }
}
