# Server Notifications on Spring

[![Build Status](https://travis-ci.org/TwilioDevEd/server-notifications-spring.svg?branch=master)](https://travis-ci.org/TwilioDevEd/server-notifications-spring)

Use Twilio to send SMS alerts so that you never miss a critical issue.

[Read the full tutorial here](https://www.twilio.com/docs/tutorials/walkthrough/server-notifications/java/spring)!

### Local Development

1. First clone this repository and `cd` into it:
   ```
   git clone git@github.com:TwilioDevEd/server-notifications-spring.git
   cd server-notifications-spring
   ```

2. Export the environment variables:

   You can find the AccountSID and the AuthToken at https://www.twilio.com/user/account/settings.

   ```
   export TWILIO_ACCOUNT_SID=your account sid
   export TWILIO_AUTH_TOKEN=your auth token
   ```

   The Twilio Phone Number can be found at https://www.twilio.com/user/account/phone-numbers/incoming.

   ```
   export TWILIO_PHONE_NUMBER=your Twilio phone number
   ```

3. Make sure the tests succeed:

   ```
   mvn compile test
   ```

4. Run the application.

   ```
   mvn compile exec:java -Dexec.mainClass=com.twilio.notifications.WebServer
   ```

5. Check it out at [http://localhost:8080](http://localhost:8080)
