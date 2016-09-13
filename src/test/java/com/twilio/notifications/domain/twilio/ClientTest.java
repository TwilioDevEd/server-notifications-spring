package com.twilio.notifications.domain.twilio;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class ClientTest {
    @Test
    public void sendMessage() {
        // Given
        TwilioMessageCreator messageCreator = mock(TwilioMessageCreator.class);
        Credentials credentials = mock(Credentials.class);
        when(credentials.getPhoneNumber()).thenReturn("from");

        // When
        Client client = new Client(messageCreator, credentials);
        client.sendMessage("to", "message", "media-url");

        // Then
        verify(messageCreator, times(1)).create("to", "from", "message", "media-url");
    }
}

