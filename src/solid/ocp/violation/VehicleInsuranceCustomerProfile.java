package solid.ocp.violation;

import java.util.Random;

public class VehicleInsuranceCustomerProfile {

    public boolean isLoyalCustomer() {
        return new Random().nextBoolean();
    }
}
