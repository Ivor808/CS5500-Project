package com.CS5500.springbootinfrastructure.controller;

import com.CS5500.springbootinfrastructure.dao.*;
import com.CS5500.springbootinfrastructure.repos.*;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Controller // This means that this class is a Controller
@RequestMapping(path="/activitydb") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private DateLogRepository dateLogRepository;



    @PostMapping(path="/datelog") // Map ONLY POST Requests
    public @ResponseBody
    String addNewDateLog (@RequestParam Integer caloriesIdle) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        DateLog n = new DateLog();

        n.setDate(new Date(System.currentTimeMillis()));
        n.setCaloriesIdle(caloriesIdle);
        n.timestampLastUpdate();
        dateLogRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/datelog")
    public @ResponseBody
    List<DateLog> getAllDates() {
        // This returns a JSON or XML with the users
        return dateLogRepository.getJSONDates();
    }
    @GetMapping(path = "/activity")
    public @ResponseBody
    List<Activity> getAllActivity() {
        return dateLogRepository.getJSONActivities();
    }
    @GetMapping(path = "/move")
    public @ResponseBody
    List<Move> getAllMove() {
        return dateLogRepository.getJSONMoves();
    }

    @GetMapping(path = "/type")
    public @ResponseBody
    List<Type> getAllType() {
        return dateLogRepository.getJSONTypes();
    }

    @GetMapping(path = "/place")
    public @ResponseBody
    List<Place> getAllPlace() {
        return dateLogRepository.getJSONPlaces();
    }

}
