package com.pingwit.part_29.homework.task_1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pingwit.part_29.homework.task_1.ATM;

import java.io.InputStream;
import java.util.List;

public class ATMMain {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        InputStream filePath = ClassLoader.getSystemResourceAsStream("part_29/homework/task_1/atms.json");

        List<ATM> atms = mapper.readValue(filePath, new TypeReference<>() {
        });

        atms.forEach(System.out::println);
    }
}