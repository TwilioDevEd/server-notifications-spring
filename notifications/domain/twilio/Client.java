package com.twilio.notifications.domain.twilio;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private Credentials credentials;
    private TwilioRestClient client;

    public Client() {
        this.credentials = new Credentials();
        String accountSid = this.credentials.getAccountSid();
        String authToken = this.credentials.getAuthToken();
        this.client = new TwilioRestClient(accountSid, authToken);
    }

    public Client(TwilioRestClient client, Credentials credentials) {
        this.credentials = credentials;
        this.client = client;
    }

    public void sendMessage(String to, String message, String mediaUrl) {
        List<NameValuePair> params = getParams(to, message, mediaUrl);

        try {
            this.client.getAccount().getMessageFactory().create(params);
        } catch (TwilioRestException exception) {
            exception.printStackTrace();
        }
    }

    private List<NameValuePair> getParams(String to, String message, String mediaUrl) {
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("Body", message));
        params.add(new BasicNameValuePair("To", to));
        params.add(new BasicNameValuePair("From", this.credentials.getPhoneNumber()));
        params.add(new BasicNameValuePair("MediaUrl", mediaUrl));

        return params;
    }
}

