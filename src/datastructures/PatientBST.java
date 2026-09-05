package datastructures;

import model.Patient;

class BSTNode {
    Patient patient;
    BSTNode left, right;

    public BSTNode(Patient patient) {
        this.patient = patient;
        this.left = this.right = null;
    }
}

public class PatientBST {
    private BSTNode root;

    public void insert(Patient patient) {
        root = insertRec(root, patient);
    }

    private BSTNode insertRec(BSTNode root, Patient patient) {
        if (root == null) {
            root = new BSTNode(patient);
            return root;
        }
        if (patient.id < root.patient.id) {
            root.left = insertRec(root.left, patient);
        } else if (patient.id > root.patient.id) {
            root.right = insertRec(root.right, patient);
        } else {
            System.out.println("-> Patient ID " + patient.id + " already exists!");
        }
        return root;
    }

    public Patient search(int id) {
        BSTNode node = searchRec(root, id);
        return (node != null) ? node.patient : null;
    }

    private BSTNode searchRec(BSTNode root, int id) {
        if (root == null || root.patient.id == id) return root;
        if (id < root.patient.id) return searchRec(root.left, id);
        return searchRec(root.right, id);
    }

    public void delete(int id) {
        root = deleteRec(root, id);
    }

    private BSTNode deleteRec(BSTNode root, int id) {
        if (root == null) return root;
        if (id < root.patient.id) {
            root.left = deleteRec(root.left, id);
        } else if (id > root.patient.id) {
            root.right = deleteRec(root.right, id);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.patient = minValue(root.right);
            root.right = deleteRec(root.right, root.patient.id);
        }
        return root;
    }

    private Patient minValue(BSTNode root) {
        Patient minv = root.patient;
        while (root.left != null) {
            minv = root.left.patient;
            root = root.left;
        }
        return minv;
    }

    public void inOrder() {
        if (root == null) {
            System.out.println("-> Patient BST is empty.");
            return;
        }
        inOrderRec(root);
    }

    private void inOrderRec(BSTNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println("   " + root.patient);
            inOrderRec(root.right);
        }
    }
}