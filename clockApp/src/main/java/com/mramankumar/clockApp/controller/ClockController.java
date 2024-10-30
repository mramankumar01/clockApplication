package com.mramankumar.clockApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

@Controller
public class ClockController {

    @GetMapping("/")
    public String getClockPage(Model model) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");

        // Current time, day, and date
        String currentTime = LocalTime.now().format(timeFormatter);
        String currentDay = LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        String currentDate = LocalDate.now().format(dateFormatter);

        // Add attributes to the model
        model.addAttribute("currentTime", currentTime);
        model.addAttribute("currentDay", currentDay);
        model.addAttribute("currentDate", currentDate);

        return "index"; // Returns index.html
    }
}

