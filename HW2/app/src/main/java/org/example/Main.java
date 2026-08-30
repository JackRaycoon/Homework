package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);
        System.setOut(out);

        ObjectMapper mapper = new ObjectMapper();

        InputStream inputStream = Main.class.getClassLoader()
                .getResourceAsStream("students.json");

        if (inputStream == null) {
            System.out.println("File students.json not found in resources!");
            return;
        }

        CollectionType listType = mapper.getTypeFactory()
                .constructCollectionType(List.class, Student.class);
        List<Student> students = mapper.readValue(inputStream, listType);

        System.out.println("Students:");

        students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream())
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("\nFound year: " + year),
                        () -> System.out.println("\nNo books after 2000 found")
                );

        System.out.println("\nSuccess end");
    }
}