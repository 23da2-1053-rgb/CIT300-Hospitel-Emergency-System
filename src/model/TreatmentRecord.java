package model;

public class TreatmentRecord {
    public Patient patient;
    public String treatmentDetails;

    public TreatmentRecord(Patient patient, String treatmentDetails) {
        this.patient = patient;
        this.treatmentDetails = treatmentDetails;
    }

    @Override
    public String toString() {
        return "Patient: " + patient.name + " (ID: " + patient.id + ") | Treatment: " + treatmentDetails;
    }
}
