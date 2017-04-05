package com.twilio.notifications.domain.twilio;

import com.twilio.exception.TwilioException;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TwilioMessageCreator {

    private static final Logger logger = LoggerFactory.getLogger(TwilioMessageCreator.class);
    private final TwilioRestClient client;

    public TwilioMessageCreator(TwilioRestClient client) {
        this.client = client;
    }

    public void create(String to, String from, String body, String mediaUrl) {
        MessageCreator messageCreator = new MessageCreator(
                new PhoneNumber(to),
                new PhoneNumber(from),
                body);
        messageCreator.setMediaUrl(mediaUrl);
        try {
            messageCreator.create(this.client);
        } catch (TwilioException e) {
            logger.error(
                    "An exception occurred trying to send a message to {}, exception: {}",
                    to,
                    e.getMessage());
        }
    }
}

