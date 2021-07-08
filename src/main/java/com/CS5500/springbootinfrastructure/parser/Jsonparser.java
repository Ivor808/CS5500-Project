package com.CS5500.springbootinfrastructure.parser;

import com.CS5500.springbootinfrastructure.dao.DateLog;
import com.CS5500.springbootinfrastructure.dao.Type;
import com.CS5500.springbootinfrastructure.helper.Activity_helper;
import com.CS5500.springbootinfrastructure.helper.DateLog_helper;
import com.CS5500.springbootinfrastructure.helper.Segment_helper;
import com.CS5500.springbootinfrastructure.helper.Summary_helper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jsonparser {
    public static DateLog[] getPOJO() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
//        InputStream inputStream = new FileInputStream(new File("src//main//resources//storyline.json"));
//        TypeReference<List<DateLog_helper>> typeReference = new TypeReference<>() {};
//        TypeReference<List<Summary_helper>> placeReference = new TypeReference<>() {};

        PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator
                .builder()
                .allowIfBaseType(Type.class)
                .build();


        mapper.activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.NON_FINAL);

        DateLog[] dates = new ObjectMapper().readerFor(DateLog[].class).readValue(new File("src//main//resources//storyline.json"));

        return dates;
        /*int count = 0;
        for (DateLog itr : dates) {
            if (count > 10) {
                break;
            }
            System.out.println(itr.toString());
            count++;
        }*/
        /*DateLog_helper[] DateLogList = mapper.readValue(inputStream, DateLog_helper[].class);

        //Summary array
        Summary_helper[] summ;
        List<Summary_helper[]> SummaryList = new ArrayList<>();

        //Segment array
        Segment_helper seg;
        List<Segment_helper> SegmentList = new ArrayList<>();

        //Activity array
        Activity_helper[] act;
        List<Activity_helper[]> ActivityList = new ArrayList<>();

        int i = 0;
        for (DateLog_helper itr : DateLogList){
            //System.out.print("Date is : " + itr.date + "\n" + i);

            //Accessing Summary
            summ = DateLogList[i].summary;
            SummaryList.add(summ);

            //Accessing Segment
            seg = DateLogList[i].segments;
            SegmentList.add(seg);

            i++;
        }*/

        /*//extract items from summary array, change j to access different items
        for (i = 0; i < SummaryList.size(); i++){
            Summary_helper[] iter = SummaryList.get(i);
            if (iter != null) {
                for (int j = 0; j < iter.length; j++) {
                    //System.out.print("Place is : " + iter[j].activity + "\n");
                }
            }
        }

        //extract items from segment array, change j to access different items
        //type is always place or move
        //also extracting activity from the segment
        for (i = 0; i < SegmentList.size(); i++){
            Segment_helper iter = SegmentList.get(i);
            if (iter != null) {
                for (int j = 0; j < iter.length; j++) {
                    //System.out.print("Segment is : " + iter[j].type + "\n");
                    //Accessing activity
                    act = iter[j].activities;
                    ActivityList.add(act);
                }
            }
        }

        //use this to access the
        for (i = 0; i < ActivityList.size(); i++){
            Activity_helper[] iter = ActivityList.get(i);
            if (iter != null) {
                for (int j = 0; j < iter.length; j++) {
                    System.out.print("Activity is : " + iter[j].activity + "\n");

                    //Setting start and end times for each activity
                    //the setter here takes in string and converts to SimpleDateFormat
                    if (iter[j].startTime == null) {
                        iter[j].setStart_time(null);
                    } else {
                        iter[j].setStart_time(iter[j].startTime);}

                    if (iter[j].endTime == null) {
                        iter[j].setEnd_time(null);
                    } else {
                        iter[j].setEnd_time(iter[j].endTime);
                    }

                }
            }
        }*/

    }
}
