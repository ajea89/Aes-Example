package com.example.ajea.aes.beans;

import com.google.gson.annotations.Expose;

/**
 * Created by ajea on 26/05/16.
 */
public class ResultEncript {

    @Expose
    private MessageEncript data;

    public MessageEncript getData() {
        return data;
    }

    public void setData(MessageEncript data) {
        this.data = data;
    }

    //    @Expose
//    private MessageSinEncriptar MessageSinEncriptar;
//    @Expose
//    private String MessageEncriptado;
//    @Expose
//    private String Hmac;
//    @Expose
//    private String IV;
//    @Expose
//    private String key;
//    @Expose
//    private String Metodo_Cifrado;
//    @Expose
//    private String Algoritmo_Hmac;
//
//
//    public ResultEncript.MessageSinEncriptar getMessageSinEncriptar() {
//        return MessageSinEncriptar;
//    }
//
//    public void setMessageSinEncriptar(ResultEncript.MessageSinEncriptar messageSinEncriptar) {
//        MessageSinEncriptar = messageSinEncriptar;
//    }
//
//    public String getMessageEncriptado() {
//        return MessageEncriptado;
//    }
//
//    public void setMessageEncriptado(String messageEncriptado) {
//        MessageEncriptado = messageEncriptado;
//    }
//
//    public String getHmac() {
//        return Hmac;
//    }
//
//    public void setHmac(String hmac) {
//        Hmac = hmac;
//    }
//
//    public String getIV() {
//        return IV;
//    }
//
//    public void setIV(String IV) {
//        this.IV = IV;
//    }
//
//    public String getKey() {
//        return key;
//    }
//
//    public void setKey(String key) {
//        this.key = key;
//    }
//
//    public String getMetodo_Cifrado() {
//        return Metodo_Cifrado;
//    }
//
//    public void setMetodo_Cifrado(String metodo_Cifrado) {
//        Metodo_Cifrado = metodo_Cifrado;
//    }
//
//    public String getAlgoritmo_Hmac() {
//        return Algoritmo_Hmac;
//    }
//
//    public void setAlgoritmo_Hmac(String algoritmo_Hmac) {
//        Algoritmo_Hmac = algoritmo_Hmac;
//    }
//
//    public static class MessageSinEncriptar{
//
//        @Expose
//        private String FirstName;
//        @Expose
//        private String UserId;
//
//        public String getFirstName() {
//            return FirstName;
//        }
//
//        public void setFirstName(String firstName) {
//            FirstName = firstName;
//        }
//
//        public String getUserId() {
//            return UserId;
//        }
//
//        public void setUserId(String userId) {
//            UserId = userId;
//        }
//    }
}
