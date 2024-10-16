package com.pingwit.part_30.homework.task_1;

import java.util.Objects;

public final class Students {
    private int id;
    private String firstName;
    private String lastName;
    private String faculty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return id == students.id &&
                Objects.equals(firstName, students.firstName) &&
                Objects.equals(lastName, students.lastName) &&
                Objects.equals(faculty, students.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, faculty);
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", faculty='" + faculty + '\'' +
                '}';
    }
}