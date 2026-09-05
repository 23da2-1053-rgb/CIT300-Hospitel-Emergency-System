package datastructures;

import model.Patient;

class QueueNode {
    Patient patient;
    QueueNode next;

    public QueueNode(Patient patient) {
        this.patient = patient;
        this.next = null;
    }
}

public class EmergencyQueue {
    private QueueNode front, rear;

    public void enqueue(Patient patient) {
        QueueNode newNode = new QueueNode(patient);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("-> Patient " + patient.name + " added to emergency queue.");
    }

    public Patient dequeue() {
        if (front == null) {
            System.out.println("-> Emergency Queue is EMPTY!");
            return null;
        }
        Patient p = front.patient;
        front = front.next;
        if (front == null) rear = null;
        return p;
    }

    public void displayQueue() {
        if (front == null) {
            System.out.println("-> Emergency Queue is currently empty.");
            return;
        }
        System.out.println("--- Current Emergency Waiting Queue ---");
        QueueNode temp = front;
        while (temp != null) {
            System.out.println("   " + temp.patient);
            temp = temp.next;
        }
    }
}