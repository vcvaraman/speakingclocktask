package com.task.speakingclock.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.task.speakingclock.service.SpeakingClockService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class SpeakingClockControllerTest {

    @InjectMocks
    private SpeakingClockController speakingClockController;

    @Mock
    private speakingClockService speakingClockService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void testConvertToWords_Success() {
        String timeStr = "08:34";
        String expectedResponse = "It's eight thirty-four";

        when(speakingClockService.convertToWords(timeStr)).thenReturn(expectedResponse);

        ResponseEntity<String> response = speakingClockController.convertToWords(timeStr);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }

    @Test
    public void testConvertToWords_InvalidFormat() {
        String timeStr = "08:34:59";

        ResponseEntity<String> response = speakingClockController.convertToWords(timeStr);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Invalid time format", response.getBody());
    }
}
