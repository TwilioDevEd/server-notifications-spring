package com.twilio.notifications.domain.twilio;

import java.util.Map;

public class Credentials {
    private Map<String, String> env;

    public Credentials() {
        env = System.getenv();
    }

    public String getAccountSid() {
        return env.get("TWILIO_ACCOUNT_SID");
    }

    public String getAuthToken() {
        return env.get("TWILIO_AUTH_TOKEN");
    }

    public String getPhoneNumber() {
        return env.get("TWILIO_PHONE_NUMBER");
    }
}

