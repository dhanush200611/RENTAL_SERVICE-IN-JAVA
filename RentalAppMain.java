package dhanush;

public class RentalAppMain {
    public static void main(String[] args) {
        RentalService service = new RentalService();

        // Add Properties
        service.addProperty(new Apartment(1, "123 MG Road", 15000, 2000));
        service.addProperty(new House(2, "45 Park Street", 25000, 3000));

        // Add Tenants
        service.addTenant(new Tenant(101, "Raj", "9999999999", 20000));
        service.addTenant(new Tenant(102, "Anita", "8888888888", 15000));

        // List Properties & Tenants
        service.listProperties();
        service.listTenants();

        // Create Lease
        service.createLease(201, 1, 101, "Monthly");

        // Collect Rent
        service.collectRent(1); // full
        service.collectRent(1, "partial", 0);
        service.collectRent(1, "late", 500);

        // Terminate Lease
        service.terminateLease(201);

        // Reports
        service.generateReport();
    }
}
