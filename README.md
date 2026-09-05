# CIT300 Mini Hospital Emergency Management System

A Java-based Mini Hospital Emergency Management System developed for the CIT300 - Data Structures and Algorithms assignment. This system simulates the management of emergency patients, treatment histories, and individual patient visit records using optimal data structures.

---

## 📌 Student Details

* **Name:** T.Santhiya
* **Student ID:** 23da2-1053
* **Email:** 23da2-1053@sltc.ac.lk
* **Course:** CIT300 - Data Structures and Algorithms

---

## 📌 Project Overview

This project implements core data structures to efficiently manage hospital operations:
- **Binary Search Tree (BST):** Main patient registry ordered by Patient ID for fast insertion, deletion, and searching.
- **Queue (FIFO):** Emergency waiting room queue to ensure patients are attended to in order of arrival.
- **Stack (LIFO):** Completed treatment history log allowing quick retrieval of recent treatments.
- **Singly Linked List:** Individual patient visit records tracking medical history (Doctor, Diagnosis, Treatment).

---

## 🛠️ Data Structures Used

| Feature | Data Structure | Principle / Logic |
| :--- | :--- | :--- |
| **Patient Records** | Binary Search Tree (BST) | Key: Patient ID (In-order traversal displays sorted patients) |
| **Emergency Queue** | Queue | First-In, First-Out (FIFO) |
| **Treatment History** | Stack | Last-In, First-Out (LIFO) |
| **Patient Visit History** | Singly Linked List | Linear chaining of visit history nodes |

---

## 📂 Project Structure

```text
CIT300-Hospitel-Emergency-System/
├── src/
│   ├── Main.java                 # CLI Menu and Interface
│   ├── model/
│   │   ├── Patient.java          # Patient Entity
│   │   ├── TreatmentRecord.java  # Treatment Entity
│   │   └── VisitNode.java        # Visit History Node Entity
│   └── datastructures/
│       ├── PatientBST.java       # Binary Search Tree Implementation
│       ├── EmergencyQueue.java   # Queue Implementation
│       ├── TreatmentStack.java   # Stack Implementation
│       └── VisitLinkedList.java  # Singly Linked List Implementation
├── .gitignore
└── README.md
