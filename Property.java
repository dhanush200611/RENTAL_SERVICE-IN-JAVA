package dhanush;

public abstract class Property {
    protected int propertyId;
    protected String address;
    protected String type;
    protected double rent;
    protected boolean status; // true = available, false = occupied

    public Property(int propertyId, String address, String type, double rent) {
        this.propertyId = propertyId;
        this.address = address;
        this.type = type;
        this.rent = rent;
        this.status = true;
    }

    // Getters and Setters
    public int getPropertyId() { return propertyId; }
    public String getAddress() { return address; }
    public String getType() { return type; }
    public double getRent() { return rent; }
    public boolean isAvailable() { return status; }

    public void setStatus(boolean status) { this.status = status; }

    // Abstract methods → overridden in subclasses
    public abstract double maintenanceCharge();
    public abstract void display();
}
