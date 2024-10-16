package com.pingwit.part_30;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
public class SaxParserExample {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = parserFactory.newSAXParser();

//     SAXHandler handler = new SAXHandler();
        InputStream resource = ClassLoader.getSystemResourceAsStream("part_30/employee.xml");
//    parser.parse(resource, handler);

//   List<Employee> empList = handler.getEmployees();

//     empList.forEach(System.out::println);
    }
}
