package solid.ocp.violation;

public class InsurancePremiumDiscountCalculator {

    public int calculatePremiumDiscountPercent(HealthInsuranceCustomerProfile customer) {
        if (customer.isLoyalCustomer())
            return 20;
        return 0;
    }

    public int calculatePremiumDiscountPercent(VehicleInsuranceCustomerProfile vehicle) {
        if (vehicle.isLoyalCustomer())
            return 20;
        return 0;
    }
}
