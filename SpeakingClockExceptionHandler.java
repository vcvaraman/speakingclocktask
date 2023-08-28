package com.task.speakingclock.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.format.DateTimeParseException;

@ControllerAdvice
public class SpeakingClockExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(SpeakingClockExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public final ResponseEntity<String> handleGenericException(Exception ex) {
        logger.error("Generic Error", ex);
        return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = DateTimeParseException.class)
    public final ResponseEntity<String> handleDateTimeParseException(Exception ex) {
        logger.error("Something wrong with Datetime parsing", ex);
        return new ResponseEntity("Something went wonrg with Date Time Conversion.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
