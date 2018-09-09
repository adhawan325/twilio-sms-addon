package com.non.twiliosmsaddon.service;


public interface SMSService {
    String NAME = "nontso_SMSService";

    void sendMessage(String phone, String message);
    Integer register(String phone);
}