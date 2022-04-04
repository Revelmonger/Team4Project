package com.example.application;

public class EncryptDecrypt {

static Integer key =2;
static String enc = "";
static String dec = "";


public static String Encrypt(String s)

{
    char[] chars = s.toCharArray();
    enc ="";

    for (char c : chars) {
        c += key;
        enc += String.valueOf(c);
    }

    return enc;
}

public static String Decrypt(String s)

{
    char[] chars = s.toCharArray();
    dec ="";

    for (char c : chars) {
        c -= key;
        dec += String.valueOf(c);
    }

    return dec;
}

    



}
