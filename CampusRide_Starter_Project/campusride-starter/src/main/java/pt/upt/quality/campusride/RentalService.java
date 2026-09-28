
package pt.upt.quality.campusride;

public class RentalService {

    private final Fleet fleet;

    public RentalService(Fleet fleet) {
        this.fleet = fleet;
    }

    // Procura o veículo e valida o ID
    private Vehicle getVehicle(String id) {
        Vehicle vehicle = fleet.findById(id);

        if (vehicle == null) {
            throw new IllegalArgumentException(
                    "Unknown vehicle ID: " + id
            );
        }

        return vehicle;
    }

    // Alugar um veículo
    public void rentVehicle(String id) {
        Vehicle vehicle = getVehicle(id);
        vehicle.rent();
    }

    // Devolver um veículo
    public void returnVehicle(String id) {
        Vehicle vehicle = getVehicle(id);
        vehicle.returnVehicle();
    }

    // Calcular o preço do aluguer
    public double estimatePrice(String id, int minutes) {
        Vehicle vehicle = getVehicle(id);
        return vehicle.calculatePrice(minutes);
    }
}
