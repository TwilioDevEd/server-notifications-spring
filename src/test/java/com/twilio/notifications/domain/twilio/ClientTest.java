package com.twilio.notifications.domain.twilio;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class ClientTest {
    @Test
    public void sendMessage() throws TwilioRestException {
        List<NameValuePair> params = new ArrayList<>();

        TwilioRestClient mockClient = mock(TwilioRestClient.class);
        MessageFactory mockMessageFactory = mock(MessageFactory.class);
        Account mockAccount = mock(Account.class);
        Credentials mockCredentials = mock(Credentials.class);

        when(mockMessageFactory.create(params)).thenReturn(new Message(mockClient));
        when(mockAccount.getMessageFactory()).thenReturn(mockMessageFactory);
        when(mockClient.getAccount()).thenReturn(mockAccount);
        when(mockCredentials.getPhoneNumber()).thenReturn("phone-number");

        new Client(mockClient, mockCredentials).sendMessage("to", "message", "media-url");

        verify(mockClient).getAccount();
        verify(mockAccount).getMessageFactory();
        params.add(new BasicNameValuePair("Body", "message"));
        params.add(new BasicNameValuePair("To", "to"));
        params.add(new BasicNameValuePair("From", "phone-number"));
        params.add(new BasicNameValuePair("MediaUrl", "media-url"));

        verify(mockMessageFactory).create(params);
    }
}

