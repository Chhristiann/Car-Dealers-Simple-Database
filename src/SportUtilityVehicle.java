import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SportUtilityVehicle extends Vehicle {
    private String modelName;
    private int numOfBenchSeats;    // 1 - 6
    private double towingCapacity;

    SportUtilityVehicle(){}

    SportUtilityVehicle(String modelName, int numOfBenchSeats, double towingCapacity){
        this.modelName = modelName;
        this.numOfBenchSeats = numOfBenchSeats;
        this.towingCapacity = towingCapacity;
    }

    // - - - [ Methods

    public String retrieveSportUtilInfo(){
        String s = "";

        s += printVehicleInfo() + '\n';
        s += "Model: " + this.modelName + '\n';
        s += "Bench Seats: " + this.numOfBenchSeats + '\n';
        s += "Towing Cap: " + this.towingCapacity;

        return s;
    }

    public void addInfo(Vehicle vehicle){
        setManufacturer(vehicle.getManufacturer());
        setPrice(vehicle.getPrice());
        setCrashRating(vehicle.getCrashRating());
        setDoors(vehicle.getDoors());
        setWheels(vehicle.getWheels());
        setHorsepower(vehicle.getHorsepower());
        setNumPassengers(vehicle.getNumPassengers());
    }
}
