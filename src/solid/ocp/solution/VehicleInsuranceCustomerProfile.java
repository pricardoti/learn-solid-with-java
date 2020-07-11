package solid.ocp.solution;

import java.util.Random;

public class VehicleInsuranceCustomerProfile implements CustomerProfile {

    @Override
    public boolean isLoyalCustomer() {
        return new Random().nextBoolean();
    }
}
