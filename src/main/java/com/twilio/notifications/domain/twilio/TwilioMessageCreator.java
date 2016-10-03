package com.twilio.notifications.domain.twilio;

import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

public class TwilioMessageCreator {
    private final TwilioRestClient client;

    public TwilioMessageCreator(TwilioRestClient client) {
        this.client = client;
    }

    public Message create(String to, String from, String body, String mediaUrl) {
        MessageCreator messageCreator = new MessageCreator(
                new PhoneNumber(to),
                new PhoneNumber(from),
                body);
        messageCreator.setMediaUrl(mediaUrl);

        return messageCreator.create(this.client);
    }
}

