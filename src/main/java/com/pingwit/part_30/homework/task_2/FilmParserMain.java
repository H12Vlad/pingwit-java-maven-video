package com.pingwit.part_30.homework.task_2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FilmParserMain {
    public static void main(String[] args) throws Exception, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        InputStream resource = ClassLoader.getSystemResourceAsStream("part_30/employee.xml");
        Document document = documentBuilder.parse(resource);

        List<Film> films = new ArrayList<>();

        NodeList nodeList = document.getDocumentElement().getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node instanceof Element) {
                Film film = new Film();

                NodeList childNodes = node.getChildNodes();

                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node cNode = childNodes.item(j);

                    if (cNode instanceof Element) {
                        String content = cNode.getTextContent().trim();

                        switch (cNode.getNodeName()) {
                            case "title" -> film.setTitle(content);
                            case "year" -> film.setYear(content);
                            case "country" -> film.setCountry(content);
                            case "genre" -> film.setGenre(content);
                            case "duration" -> film.setDuration(content);
                            case "description" -> film.setDescription(content);
                            case "director" -> film.setDirector(content);
                        }
                    }
                }
                films.add(film);
            }
        }

        films.forEach(System.out::println);
    }
}