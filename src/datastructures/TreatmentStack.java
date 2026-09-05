package datastructures;

import model.TreatmentRecord;

class StackNode {
    TreatmentRecord record;
    StackNode next;

    public StackNode(TreatmentRecord record) {
        this.record = record;
        this.next = null;
    }
}

public class TreatmentStack {
    private StackNode top;

    public void push(TreatmentRecord record) {
        StackNode newNode = new StackNode(record);
        newNode.next = top;
        top = newNode;
        System.out.println("-> Completed treatment recorded in history stack.");
    }

    public void pop() {
        if (top == null) {
            System.out.println("-> Treatment Stack is EMPTY! No records to remove.");
            return;
        }
        System.out.println("-> Removed most recent treatment record: " + top.record);
        top = top.next;
    }

    public void displayStack() {
        if (top == null) {
            System.out.println("-> Treatment History Stack is currently empty.");
            return;
        }
        System.out.println("--- Treatment History Stack (Most Recent First) ---");
        StackNode temp = top;
        while (temp != null) {
            System.out.println("   " + temp.record);
            temp = temp.next;
        }
    }
}