package com.CS5500.springbootinfrastructure.controller;


import com.CS5500.springbootinfrastructure.dao.Activity;
import com.CS5500.springbootinfrastructure.dao.DateLog;
import com.CS5500.springbootinfrastructure.dao.Location;
import com.CS5500.springbootinfrastructure.dao.Move;
import com.CS5500.springbootinfrastructure.dao.Segment;
import com.CS5500.springbootinfrastructure.dao.Summary;
import com.CS5500.springbootinfrastructure.repos.ActivityRepository;
import com.CS5500.springbootinfrastructure.repos.DateLogRepository;
import com.CS5500.springbootinfrastructure.repos.LocationRepository;
import com.CS5500.springbootinfrastructure.repos.MoveRepository;
import com.CS5500.springbootinfrastructure.repos.PlaceRepository;
import com.CS5500.springbootinfrastructure.repos.SegmentRepository;
import com.CS5500.springbootinfrastructure.repos.SummaryRepository;
import com.CS5500.springbootinfrastructure.repos.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;

@Controller // This means that this class is a Controller
@RequestMapping(path="/activitydb") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private DateLogRepository dateLogRepository;
    private ActivityRepository activityRepository;
    private LocationRepository locationRepository;
    private MoveRepository moveRepository;
    private PlaceRepository placeRepository;
    private SegmentRepository segmentRepository;
    private SummaryRepository summaryRepository;
    private TypeRepository typeRepository;


    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewDateLog (@RequestParam Date dateOf
            , @RequestParam Integer caloriesIdle) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        DateLog n = new DateLog();
        n.setDate(dateOf);
        n.setCaloriesIdle(caloriesIdle);
        n.timestampLastUpdate();
        dateLogRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/getDateLog")
    public @ResponseBody Iterable<DateLog> getAllUsers() {
        // This returns a JSON or XML with the users
        return dateLogRepository.findAll();
    }

    @GetMapping(path="/getActivity")
    public @ResponseBody Iterable<Activity> getAllActivity() {
        return activityRepository.findAll();
    }

    @GetMapping(path="/getLocation")
    public @ResponseBody Iterable<Location> getAllLocation() {
        return locationRepository.findAll();
    }

    @GetMapping(path="/getMove")
    public @ResponseBody Iterable<Move> getAllMove() {
        return moveRepository.findAll();
    }

    @GetMapping(path="/getSegment")
    public @ResponseBody Iterable<Segment> getAllSegment() {
        return segmentRepository.findAll();
    }

    @GetMapping(path="/getSummary")
    public @ResponseBody Iterable<Summary> getAllSummary() {
        return summaryRepository.findAll();
    }

    @GetMapping(path="/getType")
    public @ResponseBody
    Iterable getAllType() {
        return typeRepository.findAll();
    }

}
