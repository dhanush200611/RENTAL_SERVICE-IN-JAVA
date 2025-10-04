package dhanush;
import java.time.LocalDate;

public class Lease {
    private int leaseId;
    private int propertyId;
    private int tenantId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String rentCycle;
    private String status; // Active / Terminated

    public Lease(int leaseId, int propertyId, int tenantId,
                 LocalDate startDate, LocalDate endDate, String rentCycle) {
        this.leaseId = leaseId;
        this.propertyId = propertyId;
        this.tenantId = tenantId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentCycle = rentCycle;
        this.status = "Active";
    }

    // Getters/Setters
    public int getLeaseId() { return leaseId; }
    public int getPropertyId() { return propertyId; }
    public int getTenantId() { return tenantId; }
    public String getStatus() { return status; }

    public void terminate() {
        if (status.equals("Active")) {
            status = "Terminated";
        }
    }

    public void display() {
        System.out.println("Lease ID: " + leaseId +
                ", Property: " + propertyId +
                ", Tenant: " + tenantId +
                ", Status: " + status);
    }
}

