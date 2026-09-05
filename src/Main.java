import java.util.Scanner;
import model.Patient;
import model.TreatmentRecord;
import datastructures.PatientBST;
import datastructures.EmergencyQueue;
import datastructures.TreatmentStack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientBST bst = new PatientBST();
        EmergencyQueue queue = new EmergencyQueue();
        TreatmentStack stack = new TreatmentStack();

        while (true) {
            System.out.println("\n==================================================");
            System.out.println("  MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM");
            System.out.println("==================================================");
            System.out.println("1.  Insert New Patient (BST)");
            System.out.println("2.  Search Patient by ID (BST)");
            System.out.println("3.  Delete Patient (BST)");
            System.out.println("4.  Display All Patients Ascending Order (BST)");
            System.out.println("5.  Enqueue Patient to Emergency Queue (Queue)");
            System.out.println("6.  Dequeue Patient for Treatment (Queue)");
            System.out.println("7.  Display Waiting Emergency Queue (Queue)");
            System.out.println("8.  Complete Treatment & Push to History (Stack)");
            System.out.println("9.  Pop Most Recent Treatment Record (Stack)");
            System.out.println("10. Display Treatment History Stack (Stack)");
            System.out.println("11. Add Visit to Patient History (Linked List)");
            System.out.println("12. Remove Visit from Patient History (Linked List)");
            System.out.println("13. Search Visit in Patient History (Linked List)");
            System.out.println("14. Display Patient Visit History (Linked List)");
            System.out.println("0.  Exit System");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Patient Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Contact Number: ");
                    String contact = sc.nextLine();
                    System.out.print("Enter Medical Condition: ");
                    String cond = sc.nextLine();

                    Patient p = new Patient(id, name, age, contact, cond);
                    bst.insert(p);
                    System.out.println("-> Patient added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Patient ID to search: ");
                    int searchId = sc.nextInt();
                    Patient found = bst.search(searchId);
                    if (found != null) {
                        System.out.println("-> Patient Found: " + found);
                    } else {
                        System.out.println("-> Patient ID " + searchId + " not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Patient ID to delete: ");
                    int delId = sc.nextInt();
                    bst.delete(delId);
                    System.out.println("-> Patient deletion operation executed.");
                    break;

                case 4:
                    System.out.println("--- Registered Patients List (BST In-Order) ---");
                    bst.inOrder();
                    break;

                case 5:
                    System.out.print("Enter Patient ID to enqueue: ");
                    int qId = sc.nextInt();
                    Patient qPatient = bst.search(qId);
                    if (qPatient != null) {
                        queue.enqueue(qPatient);
                    } else {
                        System.out.println("-> Patient ID not registered in BST. Please register first!");
                    }
                    break;

                case 6:
                    Patient dequeuedP = queue.dequeue();
                    if (dequeuedP != null) {
                        System.out.println("-> Treatment started for: " + dequeuedP.name);
                    }
                    break;

                case 7:
                    queue.displayQueue();
                    break;

                case 8:
                    System.out.print("Enter Patient ID completing treatment: ");
                    int tId = sc.nextInt(); sc.nextLine();
                    Patient tPatient = bst.search(tId);
                    if (tPatient != null) {
                        System.out.print("Enter Treatment Summary/Details: ");
                        String details = sc.nextLine();
                        TreatmentRecord tr = new TreatmentRecord(tPatient, details);
                        stack.push(tr);
                    } else {
                        System.out.println("-> Patient ID not found!");
                    }
                    break;

                case 9:
                    stack.pop();
                    break;

                case 10:
                    stack.displayStack();
                    break;

                case 11:
                    System.out.print("Enter Patient ID: ");
                    int pIdVis = sc.nextInt(); sc.nextLine();
                    Patient vPatient = bst.search(pIdVis);
                    if (vPatient != null) {
                        System.out.print("Enter Visit ID: ");
                        int vId = sc.nextInt(); sc.nextLine();
                        System.out.print("Enter Visit Date (e.g. 2026-09-05): ");
                        String vDate = sc.nextLine();
                        System.out.print("Enter Doctor Name: ");
                        String dName = sc.nextLine();
                        System.out.print("Enter Diagnosis: ");
                        String diag = sc.nextLine();
                        System.out.print("Enter Treatment: ");
                        String trt = sc.nextLine();

                        vPatient.visitHistory.addVisit(vId, vDate, dName, diag, trt);
                    } else {
                        System.out.println("-> Patient ID not found!");
                    }
                    break;

                case 12:
                    System.out.print("Enter Patient ID: ");
                    int rPid = sc.nextInt();
                    Patient rPatient = bst.search(rPid);
                    if (rPatient != null) {
                        System.out.print("Enter Visit ID to remove: ");
                        int rVid = sc.nextInt();
                        rPatient.visitHistory.removeVisit(rVid);
                    } else {
                        System.out.println("-> Patient ID not found!");
                    }
                    break;

                case 13:
                    System.out.print("Enter Patient ID: ");
                    int sPid = sc.nextInt();
                    Patient sPatient = bst.search(sPid);
                    if (sPatient != null) {
                        System.out.print("Enter Visit ID to search: ");
                        int sVid = sc.nextInt();
                        sPatient.visitHistory.searchVisit(sVid);
                    } else {
                        System.out.println("-> Patient ID not found!");
                    }
                    break;

                case 14:
                    System.out.print("Enter Patient ID to view visit history: ");
                    int vPid = sc.nextInt();
                    Patient dispPatient = bst.search(vPid);
                    if (dispPatient != null) {
                        System.out.println("--- Visit History for " + dispPatient.name + " ---");
                        dispPatient.visitHistory.displayVisits();
                    } else {
                        System.out.println("-> Patient ID not found!");
                    }
                    break;

                case 0:
                    System.out.println("Exiting System... Thank you!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}