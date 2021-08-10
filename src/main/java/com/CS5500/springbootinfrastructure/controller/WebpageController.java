package com.CS5500.springbootinfrastructure.controller;

import com.CS5500.springbootinfrastructure.dao.Activity;
import com.CS5500.springbootinfrastructure.dao.DateLog;
import com.CS5500.springbootinfrastructure.dao.Type;
import com.CS5500.springbootinfrastructure.repos.DateLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class WebpageController {

    @Autowired
    private DateLogRepository dateRepo;

    @GetMapping("records/delete/{date}")
    public String deleteLog(@PathVariable("date") Date date, Model model) {
        try {
            dateRepo.deleteById(date);
            return "update_success";
        } catch(Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("error", "could not delete log");
        return "error_page";
    }

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

        return "update_success";
    }
    @PutMapping("/records/edit-record")
    public String editSubmit(@ModelAttribute DateLogContModel newLog, Model model) {
        model.addAttribute("newLog", newLog);

        DateLog dl = dateRepo.getDateLogByDateIs(Date.valueOf(newLog.getYyyy() + "-"
            + newLog.getMm() + "-"
            + newLog.getDd()));
        dl.setCaloriesIdle(newLog.getCaloriesIdle());
        dl.timestampLastUpdate();
        dateRepo.save(dl);

        return "update_success";
    }


    /*@PostMapping("/records/{date}/add-type")
    public String addType(Type type) {
        DateLog dl = dateRepo.findById(date);
        List<Type> lt = dl.getTypes();
        lt.add(type);
        dl.setTypes(lt);
        dateRepo.save(dl);
    }*/

    @GetMapping("/records/add-record")
    public String addRecordPage(Model model) {
        model.addAttribute("newLog", new DateLogContModel());
        return "date_post";
    }

    @GetMapping("/records/edit-record")
    public String editRecordPage(Model model) {
        model.addAttribute("newLog", new DateLogContModel());
        return "date_Edit";
    }
    @GetMapping("/records/edit-this")
    public String editSubmit(Model model) {
        model.addAttribute("newLog", new DateLogContModel());
        return "edit_this";
    }
    @PutMapping("/records/edit-this/{date}")
    public String editThisRecord(@ModelAttribute DateLogContModel newLog, Date date,Model model) {
        model.addAttribute("newLog", new DateLogContModel());
        DateLog dl = dateRepo.getDateLogByDateIs(date);
        dl.setCaloriesIdle(newLog.getCaloriesIdle());
        dl.timestampLastUpdate();
        dateRepo.save(dl);
        return "update_success";
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

    @PutMapping("/records/{date}/edit-record")
    public String editDateLog(@PathVariable("date") Date date, Model model) {

        return "save_success";
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
