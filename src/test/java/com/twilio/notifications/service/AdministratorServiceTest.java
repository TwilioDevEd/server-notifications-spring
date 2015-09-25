package com.twilio.notifications.service;

import com.twilio.notifications.domain.Administrator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AdministratorServiceTest {
    @Test
    public void getAdministrators_ArrayOfAdministrators() {
        String filePath = getClass().getClassLoader().getResource("administrators.sample.json").getPath();
        AdministratorService repository = new AdministratorService(filePath);

        Administrator[] administrators = repository.getAdministrators();

        assertThat(administrators.length).isEqualTo(1);
        assertThat(administrators[0].getName()).isEqualTo("Bob");
        assertThat(administrators[0].getPhoneNumber()).isEqualTo("+12025550197");
    }
}

