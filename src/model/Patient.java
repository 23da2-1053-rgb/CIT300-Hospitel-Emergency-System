package model;

import datastructures.VisitLinkedList;

public class Patient {
    public int id;
    public String name;
    public int age;
    public String contact;
    public String medicalCondition;
    public VisitLinkedList visitHistory;

    public Patient(int id, String name, int age, String contact, String medicalCondition) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.medicalCondition = medicalCondition;
        this.visitHistory = new VisitLinkedList();
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Age: " + age + 
               " | Contact: " + contact + " | Condition: " + medicalCondition;
    }
}