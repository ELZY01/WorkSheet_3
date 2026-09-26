package pt.upt.quality.campusride;

import java.util.ArrayList;
import java.util.List;

public class FleetReport {
    private final Fleet fleet;

    public FleetReport(Fleet fleet) {
        this.fleet = fleet;
    }

    public List<String> availableVehicleIds() {
        List<String> ids = new ArrayList<>();

        for (Vehicle vehicle : fleet.getVehicles()) {
            if (vehicle.isAvailable()) {
                ids.add(vehicle.getId());
            }
        }

        return ids;
    }

    public double estimateTotalPrice(int minutes) {
        double total = 0.0;

        for (Vehicle vehicle : fleet.getVehicles()) {
            total += vehicle.calculatePrice(minutes);
        }

        return total;
    }
}
