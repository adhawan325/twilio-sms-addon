package com.non.twiliosmsaddon.service;

import com.haulmont.cuba.core.sys.AppContext;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.ValidationRequest;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service(SMSService.NAME)
public class SMSServiceBean implements SMSService {
    @Override
    public void sendMessage(String phone, String message)
    {
        Twilio.init(AppContext.getProperty("crm.sms.accountSID"),
                AppContext.getProperty("crm.sms.authToken"));

        Message tMessage = Message
                .creator(new PhoneNumber(phone), new PhoneNumber(AppContext.getProperty("crm.sms.sourcePhoneNumber")),
                        message).create();
    }

    @Override
    public Integer register(String phone) {
        Twilio.init(AppContext.getProperty("crm.sms.accountSID"),
                AppContext.getProperty("crm.sms.authToken"));

        ValidationRequest validationRequest = ValidationRequest.creator(new PhoneNumber(phone)).create();
        return validationRequest.getValidationCode();
    }
}