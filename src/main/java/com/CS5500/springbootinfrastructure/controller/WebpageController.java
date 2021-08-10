package com.CS5500.springbootinfrastructure.controller;

import com.CS5500.springbootinfrastructure.dao.Activity;
import com.CS5500.springbootinfrastructure.dao.DateLog;
import com.CS5500.springbootinfrastructure.dao.Move;
import com.CS5500.springbootinfrastructure.dao.Type;
import com.CS5500.springbootinfrastructure.repos.DateLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
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

    @GetMapping("/records/{date}/add-type")
    public String getAddTypePage(@PathVariable Date date, Model model) {
        model.addAttribute("newType", new TypeContModel());
        model.addAttribute("date", date);
        return "type_post";
    }

    @PostMapping("/records/{date}/add-type")
    public String addType(@PathVariable Date date, @ModelAttribute TypeContModel type) {
        Optional<DateLog> opt = dateRepo.findById(date);
        if (opt.isEmpty()) {
            return "error_page";
        }

        DateLog dl = opt.get();
        List<Type> lt = dl.getTypes();
        Type toAdd = new Type();
        toAdd.setDate(dl);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int yyyy = cal.get(Calendar.YEAR);
        int mm = cal.get(Calendar.MONTH);
        int dd = cal.get(Calendar.DAY_OF_MONTH);

        int hh = type.start_hh;
        int min = type.start_mm;
        int ss = type.start_ss;
        Timestamp start = Timestamp.valueOf(yyyy + "-" + mm + "-" + dd + " " + hh + ":" +
                mm + ":" + ss);
        toAdd.setStartTime(start);

        hh = type.end_hh;
        min = type.end_mm;
        ss = type.end_ss;

        Timestamp end = Timestamp.valueOf(yyyy + "-" + mm + "-" + dd + " " + hh + ":" +
                mm + ":" + ss);
        toAdd.setEndTime(end);
        toAdd.setLastUpdate(new Timestamp(System.currentTimeMillis()));

        String kind = type.type;

        switch (kind) {
            case "Move":
                Move newMove = (Move) toAdd;

        }
        lt.add(type);
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
