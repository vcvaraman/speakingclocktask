package com.task.speakingclock.controller;

import com.demo.service.SpeakingClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/speakingclock")
public class SpeakingClockController {

    @Autowired
    private SpeakingClockService speakingClockService;

    @GetMapping("/currentTimeWords")
    public String getCurentTimeInWords(){
        return speakingClockService.getCurrentTimeInWords("");
    }

    @GetMapping("/words/time/{time}")
    public String getTimeInWords(@PathVariable("time") String time){
        return speakingClockService.getCurrentTimeInWords(time);
    }

}

