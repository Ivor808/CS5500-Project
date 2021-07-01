package com.CS5500.springbootinfrastructure.controller;


import com.CS5500.springbootinfrastructure.dao.Segment;
import com.CS5500.springbootinfrastructure.repos.SegmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/segment")
public class SegmentController {

  @Autowired
  private SegmentRepository segmentRepository;

  @PostMapping(path = "/add")
  public @ResponseBody
  String addNewSegment(@RequestParam Integer seg_id, @RequestParam Object Move,
      @RequestParam Object field) {
      Segment newSegment = new Segment();
      //TODO add setters.
    return newSegment.toString();
  }

}
