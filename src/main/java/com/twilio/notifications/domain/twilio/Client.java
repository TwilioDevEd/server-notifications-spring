package com.twilio.notifications.domain.twilio;

import com.twilio.http.TwilioRestClient;

public class Client {
    private Credentials credentials;
    private TwilioMessageCreator messageCreator;

    public Client() {
        this.credentials = new Credentials();
        this.messageCreator = new TwilioMessageCreator(
                new TwilioRestClient.Builder(credentials.getAccountSid(), credentials.getAuthToken()).build()
        );
    }

    public Client(TwilioMessageCreator messageCreator, Credentials credentials) {
        this.credentials = credentials;
        this.messageCreator = messageCreator;
    }

    public void sendMessage(String to, String message, String mediaUrl) {
        messageCreator.create(to, credentials.getPhoneNumber(), message, mediaUrl);
    }
}

