package com.pingwit.part_30.homework.task_2;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FilmParserMain {
    public static void main(String[] args) throws IOException {
        InputStream resource = ClassLoader.getSystemResourceAsStream("part_30/homework/task_2/kinogo.html");

        Document document = Jsoup.parse(resource, "UTF-8", "");

        List<Film> films = new ArrayList<>();

        Elements filmElements = document.select(".shortstory");

        for (Element element : filmElements) {
            Film film = new Film();

            film.setMovieName(element.text());
            film.getDescription(element.text());
            films.add(film);
        }
        films.forEach(System.out::println);


    }
}
