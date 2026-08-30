package org.example;

import java.util.Objects;

public class Book {
    private String title;
    private int pages;
    private int year;

    public Book() {}

    public Book(String title, int pages, int year) {
        this.title = title;
        this.pages = pages;
        this.year = year;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && pages == book.pages && year == book.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, pages, year);
    }

    @Override
    public String toString() {
        return String.format("%s (%d p., %d y.)", title, pages, year);
    }
}