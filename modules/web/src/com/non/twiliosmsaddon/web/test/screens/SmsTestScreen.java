package com.non.twiliosmsaddon.web.test.screens;

import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.TextField;
import com.non.twiliosmsaddon.service.SMSService;

import javax.inject.Inject;

public class SmsTestScreen extends AbstractWindow {
    @Inject
    private SMSService smsService;
    @Inject
    private TextField message;
    @Inject
    private TextField phoneNumber;

    public void onTestSMSClick() {
        smsService.sendMessage(phoneNumber.getValue(), message.getValue());
    }

    public void onRegisterClick() {
        showNotification(smsService.register(phoneNumber.getValue()).toString());
    }
}