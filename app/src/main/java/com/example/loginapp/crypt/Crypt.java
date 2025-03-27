package com.example.loginapp.crypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Crypt {
    public String toEncrypt(String t){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
            return null;
        }
        byte[] hash = md.digest(t.getBytes());
        StringBuffer sb = new StringBuffer();
        for(byte b: hash){
            sb.append(String.format("%02x",b));
        }
        return sb.toString();
    }
}
