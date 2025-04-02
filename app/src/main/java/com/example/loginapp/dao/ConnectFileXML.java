package com.example.loginapp.dao;

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
