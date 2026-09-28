package pt.upt.quality.campusride;

public class App {
    public static void main(String[] args) {
        Fleet fleet = new Fleet();
        fleet.addVehicle(new Bike("B1"));
        fleet.addVehicle(new Scooter("S10", 80));

        RentalService rentalService = new RentalService(fleet);
        FleetReport report = new FleetReport(fleet);

        System.out.println("=== CampusRide ===");
        fleet.getVehicles().forEach(System.out::println);
        runTeamFeatures(fleet, rentalService, report);
    }

    private static void runTeamFeatures(Fleet fleet,
                                        RentalService rentalService,
                                        FleetReport report) {
        System.out.println("S10 / 40 min = " + rentalService.calculateRentalPrice("S10", 40) + " EUR");
        EBike eBike = new EBike("E20", 95);
        eBike.charge(20);
        System.out.println("E20 battery = " + eBike.getBatteryLevel());

        rentalService.rentVehicle("B1");

        System.out.println("B1 available after rent = "
                + fleet.findById("B1").isAvailable());

        rentalService.returnVehicle("B1");

    }
}