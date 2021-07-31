package com.CS5500.springbootinfrastructure.controller;

import com.CS5500.springbootinfrastructure.dao.Activity;
import com.CS5500.springbootinfrastructure.dao.DateLog;
import com.CS5500.springbootinfrastructure.dao.Type;
import com.CS5500.springbootinfrastructure.repos.DateLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class WebpageController {

    @Autowired
    private DateLogRepository dateRepo;

    @PostMapping("/records/add-record")
    public String greetingSubmit(@ModelAttribute DateLogContModel newLog, Model model) {
        model.addAttribute("newLog", newLog);

        DateLog dl = new DateLog();
        dl.setDate(Date.valueOf(newLog.getYyyy() + "-"
        + newLog.getMm() + "-"
        + newLog.getDd()));
        dl.setCaloriesIdle(newLog.getCaloriesIdle());
        dl.timestampLastUpdate();

        dateRepo.save(dl);

        return "save_success";
    }

    @GetMapping("/records/add-record")
    public String addRecordPage(Model model) {
        model.addAttribute("newLog", new DateLogContModel());
        return "date_post";
    }

    @GetMapping(path="/records")
    public String fetchHomePage(Model model) {
        List<DateLog> logs = dateRepo.getJSONDates();
        model.addAttribute("allDates", logs);
        return "homepage";
    }

    @GetMapping(path = "/records/types")
    public String fetchTypes(Model model) {
        List<Type> types = dateRepo.getJSONTypes();
        model.addAttribute("allTypes", types);
        return "types_all";
    }

    @GetMapping(path = "/records/{date}/types")
    public String fetchTypesByDateId(@PathVariable("date") Date date, Model model) {
        Optional optionalDL = dateRepo.findById(date);
        if (optionalDL.isPresent()) {
            DateLog dateLog = (DateLog) optionalDL.get();
            List<Type> types = dateLog.getTypes();
            model.addAttribute("typesForDate", types);

            return "types_id";
        }

        return "types_error";
    }

    @GetMapping(path = "records/types/{tid}/activities")
    public String fetchActivitiesByTypeId(@PathVariable("tid") long tid, Model model) {
        Type type = dateRepo.getTypeById(tid);

        if (type != null) {
            List<Activity> activities = type.getActivities();
            model.addAttribute("activitiesForId", activities);

            return "activities_id";
        }

        return "activities_error";
    }
}
