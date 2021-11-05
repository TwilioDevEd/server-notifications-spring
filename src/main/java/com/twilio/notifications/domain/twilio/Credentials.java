package com.twilio.notifications.domain.twilio;

import java.util.Map;
import io.github.cdimascio.dotenv.Dotenv;

public class Credentials {
    private String twilioAccountSid;
    private String twilioAuthToken;
    private String twilioPhoneNumber; 

    public Credentials() {
        Dotenv env = Dotenv.configure().ignoreIfMissing().load();
        this.twilioAccountSid = env.get("TWILIO_ACCOUNT_SID");
        this.twilioAuthToken = env.get("TWILIO_AUTH_TOKEN");
        this.twilioPhoneNumber = env.get("TWILIO_PHONE_NUMBER");
    }

    public String getAccountSid() {
        return twilioAccountSid;
    }

    public String getAuthToken() {
        return twilioAuthToken;
    }

    public String getPhoneNumber() {
        return twilioPhoneNumber;
    }
}

