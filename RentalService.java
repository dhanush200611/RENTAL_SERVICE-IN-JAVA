package dhanush;

import java.util.*;
import java.time.LocalDate;

public class RentalService {
    private List<Property> properties = new ArrayList<>();
    private List<Tenant> tenants = new ArrayList<>();
    private List<Lease> leases = new ArrayList<>();
    private double totalIncome = 0.0;

    // Property Management
    public void addProperty(Property property) { properties.add(property); }
    public void listProperties() { for (Property p : properties) p.display(); }

    // Tenant Management
    public void addTenant(Tenant tenant) { tenants.add(tenant); }
    public void listTenants() { for (Tenant t : tenants) t.display(); }

    // Lease Management
    public void createLease(int leaseId, int propertyId, int tenantId, String rentCycle) {
        Property property = findProperty(propertyId);
        Tenant tenant = findTenant(tenantId);

        if (property != null && tenant != null && property.isAvailable() && !tenant.hasActiveLease()) {
            Lease lease = new Lease(leaseId, propertyId, tenantId,
                    LocalDate.now(),
                    LocalDate.now().plusMonths(12),
                    rentCycle);
            leases.add(lease);
            property.setStatus(false);
            tenant.setActiveLease(true);
            System.out.println("Lease created successfully!");
        } else {
            System.out.println("Error: Lease cannot be created.");
        }
    }

    // Rent Collection (Overloading)
    public void collectRent(int propertyId) { collectRent(propertyId, "full", 0); }
    public void collectRent(int propertyId, String type, double extraFee) {
        Property property = findProperty(propertyId);
        if (property != null && !property.isAvailable()) {
            double rentAmount = property.getRent();
            if (type.equals("partial")) rentAmount = rentAmount / 2;
            if (type.equals("late")) rentAmount += extraFee;

            totalIncome += rentAmount;
            System.out.println("Collected rent: " + rentAmount + " for Property " + propertyId);
        } else {
            System.out.println("Property not occupied.");
        }
    }

    public void terminateLease(int leaseId) {
        for (Lease l : leases) {
            if (l.getLeaseId() == leaseId && l.getStatus().equals("Active")) {
                l.terminate();
                Property property = findProperty(l.getPropertyId());
                Tenant tenant = findTenant(l.getTenantId());
                if (property != null) property.setStatus(true);
                if (tenant != null) tenant.setActiveLease(false);
                System.out.println("Lease terminated.");
                return;
            }
        }
        System.out.println("Lease not found or already terminated.");
    }

    public void generateReport() {
        System.out.println("\n--- Monthly Report ---");
        System.out.println("Total Income: " + totalIncome);
        long occupied = properties.stream().filter(p -> !p.isAvailable()).count();
        System.out.println("Occupancy: " + occupied + "/" + properties.size());
    }

    // Helpers
    private Property findProperty(int id) {
        for (Property p : properties) if (p.getPropertyId() == id) return p;
        return null;
    }
    private Tenant findTenant(int id) {
        for (Tenant t : tenants) if (t.getTenantId() == id) return t;
        return null;
    }
}
