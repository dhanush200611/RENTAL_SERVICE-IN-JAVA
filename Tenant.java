package dhanush;
public class Tenant {
    private int tenantId;
    private String name;
    private String contact;
    private double deposit;
    private boolean activeLease;

    public Tenant(int tenantId, String name, String contact, double deposit) {
        this.tenantId = tenantId;
        this.name = name;
        this.contact = contact;
        this.deposit = deposit;
        this.activeLease = false;
    }

    // Getters/Setters
    public int getTenantId() { return tenantId; }
    public String getName() { return name; }
    public double getDeposit() { return deposit; }
    public boolean hasActiveLease() { return activeLease; }

    public void setActiveLease(boolean activeLease) {
        this.activeLease = activeLease;
    }

    public void addDeposit(double amount) {
        deposit += amount;
    }

    public void deductDeposit(double amount) {
        if (deposit >= amount) deposit -= amount;
    }

    public void display() {
        System.out.println("Tenant ID: " + tenantId +
                ", Name: " + name +
                ", Contact: " + contact +
                ", Deposit: " + deposit +
                ", Active Lease: " + activeLease);
    }
}
