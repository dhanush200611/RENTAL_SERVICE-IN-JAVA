package dhanush;

public class House extends Property {
    private double lawnMaintenanceFee;

    public House(int propertyId, String address, double rent, double lawnMaintenanceFee) {
        super(propertyId, address, "House", rent);
        this.lawnMaintenanceFee = lawnMaintenanceFee;
    }

    @Override
    public double maintenanceCharge() {
        return lawnMaintenanceFee;
    }

    @Override
    public void display() {
        System.out.println("House ID: " + propertyId +
                ", Address: " + address +
                ", Rent: " + rent +
                ", Lawn Fee: " + lawnMaintenanceFee +
                ", Available: " + status);
    }
}
