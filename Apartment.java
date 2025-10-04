package dhanush;

public class Apartment extends Property {
    private double societyFee;

    public Apartment(int propertyId, String address, double rent, double societyFee) {
        super(propertyId, address, "Apartment", rent);
        this.societyFee = societyFee;
    }

    @Override
    public double maintenanceCharge() {
        return societyFee;
    }

    @Override
    public void display() {
        System.out.println("Apartment ID: " + propertyId +
                ", Address: " + address +
                ", Rent: " + rent +
                ", Society Fee: " + societyFee +
                ", Available: " + status);
    }
}
