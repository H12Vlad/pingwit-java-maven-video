package com.pingwit.part_30.homework.task_1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.InputStream;
import java.util.List;

public class StudentsDeserializationMain {
    public static void main(String[] args) throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        InputStream resource = ClassLoader.getSystemResourceAsStream("part_30/homework/task_1/students.xml");

        List<Students> students = xmlMapper.readValue(resource, new TypeReference<>() {
        });

        students.forEach(System.out::println);
    }
}