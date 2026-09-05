package model;

public class VisitNode {
    public int visitId;
    public String visitDate;
    public String doctorName;
    public String diagnosis;
    public String treatment;
    public VisitNode next;

    public VisitNode(int visitId, String visitDate, String doctorName, String diagnosis, String treatment) {
        this.visitId = visitId;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.next = null;
    }
}