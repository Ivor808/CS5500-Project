package com.CS5500.springbootinfrastructure.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;

public class Jsonparser {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = new FileInputStream(new File("C://Users//Karan//Desktop//ALIGN courses//Summer 2021//CS5500//CS5500-Project//src//main//resources//storyline.json"));
        TypeReference<List<DateLog>> typeReference = new TypeReference<List<DateLog>>() {};

        DateLog[] DateLogList = mapper.readValue(inputStream, DateLog[].class);

        for (DateLog itr : DateLogList){
            System.out.print("Date is : " + itr.date + "\n");
        }
    }
}
