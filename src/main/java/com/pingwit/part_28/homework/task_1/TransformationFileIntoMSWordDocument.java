package com.pingwit.part_28.homework.task_1;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class TransformationFileIntoMSWordDocument {
    public static void main(String[] args) throws Exception {
        XWPFDocument document = new XWPFDocument();

        String font = "Gabriola";

        createImage(document, Path.of("src/main/java/com/pingwit/part_28/homework/task_1/1000x1000.jpg"));
        createTitle(document, font, "A.V.G.");
        createSubTitle(document, font, "Я Плачу");

        Files.readAllLines(Path.of("src/main/java/com/pingwit/part_28/homework/task_1/sound.txt"))
                .forEach(line -> createRegularText(document, font, line));

        write(document);
    }

    private static void createTitle(XWPFDocument document, String font, String text) {
        XWPFParagraph title = document.createParagraph();
        title.setAlignment(ParagraphAlignment.CENTER);

        XWPFRun titleRun = title.createRun();
        titleRun.setText(text);
        titleRun.setColor("800000");
        titleRun.setBold(true);
        titleRun.setFontFamily(font);
        titleRun.setFontSize(20);
    }

    private static void createSubTitle(XWPFDocument document, String font, String text) {
        XWPFParagraph subtitle = document.createParagraph();
        subtitle.setAlignment(ParagraphAlignment.CENTER);

        XWPFRun subtitleRun = subtitle.createRun();
        subtitleRun.setText(text);
        subtitleRun.setColor("800080");
        subtitleRun.setBold(true);
        subtitleRun.setFontFamily(font);
        subtitleRun.setFontSize(16);
        subtitleRun.setUnderline(UnderlinePatterns.DOT_DOT_DASH);
    }

    private static void createRegularText(XWPFDocument document, String font, String text) {
        XWPFParagraph subtitle = document.createParagraph();
        subtitle.setAlignment(ParagraphAlignment.LEFT);

        XWPFRun subtitleRun = subtitle.createRun();
        subtitleRun.setText(text);
        subtitleRun.setColor("008000");
        subtitleRun.setBold(true);
        subtitleRun.setFontFamily(font);
        subtitleRun.setFontSize(12);
    }

    private static void createImage(XWPFDocument document, Path imagePath) throws Exception {
        XWPFParagraph imageParagraph = document.createParagraph();
        imageParagraph.setAlignment(ParagraphAlignment.LEFT);

        XWPFRun imageRun = imageParagraph.createRun();
        imageRun.addPicture(
                Files.newInputStream(imagePath),
                XWPFDocument.PICTURE_TYPE_PNG, imagePath.toFile().getName(),
                Units.toEMU(200), Units.toEMU(200)
        );
    }

    private static void write(XWPFDocument document) {
        String currentDirectory = "src/main/java/com/pingwit/part_28/homework/task_1";
        String outputFileName = currentDirectory + "/MyFavouriteSong.docx";

        try (FileOutputStream fos = new FileOutputStream(outputFileName)) {
            document.write(fos);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}