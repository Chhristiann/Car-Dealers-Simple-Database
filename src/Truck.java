import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;

@Getter
@Setter
public class Truck extends Vehicle {
    private String modelName;
    private double cargoCapacity;
    private double towingCapacity;
    private boolean bedliner;
    private String type;

    Truck(){}

    Truck(String modelName, double cargoCapacity, double towingCapacity, boolean bedliner, String type){
        this.modelName  = modelName;
        this.cargoCapacity  = cargoCapacity;
        this.towingCapacity  = towingCapacity;
        this.bedliner  = bedliner;
        this.type  = type;
    }

    // - - - [ Methods

    public String retrieveTruckInfo(){
        String s = "";

        s += printVehicleInfo() + '\n';
        s += "Model: " + this.modelName + '\n';
        s += "Cargo Cap.: " + this.cargoCapacity + '\n';
        s += "Towing Cap.: " + this.towingCapacity + '\n';
        s += "Bed Liner: " + this.bedliner + '\n';
        s += "Type: " + this.type;

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
