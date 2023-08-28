package com.task.speakingclock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpeakingclockApplicationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testConvertToWords_Success() {
        String url = "http://localhost:" + port + "/convert?time=08:34";

         String url1 = "http://localhost:" + port + "/convert?time=11:25";
        
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        ResponseEntity<String> response = restTemplate.getForEntity(url1, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("It's eight thirty-four", response.getBody());
        assertEquals("It's eleven-twenty five", response.getBody());
    }

    @Test
    public void testConvertToWords_InvalidFormat() {
        String url = "http://localhost:" + port + "/convert?time=08:34:59";
        String url1 = "http://localhost:" + port + "/convert?time=11:25:55";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Invalid time format", response.getBody());
    }
}

