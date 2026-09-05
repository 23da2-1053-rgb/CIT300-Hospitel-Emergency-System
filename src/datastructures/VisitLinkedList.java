package datastructures;

import model.VisitNode;

public class VisitLinkedList {
    private VisitNode head;

    public void addVisit(int visitId, String visitDate, String doctorName, String diagnosis, String treatment) {
        VisitNode newVisit = new VisitNode(visitId, visitDate, doctorName, diagnosis, treatment);
        if (head == null) {
            head = newVisit;
        } else {
            VisitNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newVisit;
        }
        System.out.println("-> Visit record added successfully.");
    }

    public void removeVisit(int visitId) {
        if (head == null) {
            System.out.println("-> Visit history is empty.");
            return;
        }
        if (head.visitId == visitId) {
            head = head.next;
            System.out.println("-> Visit ID " + visitId + " removed.");
            return;
        }
        VisitNode current = head;
        while (current.next != null && current.next.visitId != visitId) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("-> Visit ID " + visitId + " removed.");
        } else {
            System.out.println("-> Visit ID " + visitId + " not found.");
        }
    }

    public void searchVisit(int visitId) {
        VisitNode temp = head;
        while (temp != null) {
            if (temp.visitId == visitId) {
                System.out.println("Found Visit [ID: " + temp.visitId + ", Date: " + temp.visitDate + 
                                   ", Doctor: " + temp.doctorName + ", Diagnosis: " + temp.diagnosis + 
                                   ", Treatment: " + temp.treatment + "]");
                return;
            }
            temp = temp.next;
        }
        System.out.println("-> Visit ID " + visitId + " not found.");
    }

    public void displayVisits() {
        if (head == null) {
            System.out.println("   No previous visit history.");
            return;
        }
        VisitNode temp = head;
        while (temp != null) {
            System.out.println("   [Visit ID: " + temp.visitId + " | Date: " + temp.visitDate + 
                               " | Doctor: " + temp.doctorName + " | Diagnosis: " + temp.diagnosis + 
                               " | Treatment: " + temp.treatment + "]");
            temp = temp.next;
        }
    }
}