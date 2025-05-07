package com.example.loginapp.dao;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.Nullable;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class ConnectFileXML implements SharedPreferences {
    private String fileName;

    public ConnectFileXML() {
//        getSharedPreferences("AppLoginApp", Context.MODE_PRIVATE);
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

    @Override
    public Map<String, ?> getAll() {
        return Collections.emptyMap();
    }

    @Nullable
    @Override
    public String getString(String key, @Nullable String defValue) {
        return "";
    }

    @Nullable
    @Override
    public Set<String> getStringSet(String key, @Nullable Set<String> defValues) {
        return Collections.emptySet();
    }

    @Override
    public int getInt(String key, int defValue) {
        return 0;
    }

    @Override
    public long getLong(String key, long defValue) {
        return 0;
    }

    @Override
    public float getFloat(String key, float defValue) {
        return 0;
    }

    @Override
    public boolean getBoolean(String key, boolean defValue) {
        return false;
    }

    @Override
    public boolean contains(String key) {
        return false;
    }

    @Override
    public Editor edit() {
        return null;
    }

    @Override
    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {

    }

    @Override
    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {

    }
}
