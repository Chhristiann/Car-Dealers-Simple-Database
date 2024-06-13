import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Motorcycle extends Vehicle {
    private String modelName;
    private boolean sidecar;
    private boolean signalLights;
    private boolean radio;

    Motorcycle(){}

    Motorcycle(String modelName, boolean sidecar, boolean signalLights, boolean radio){
        this.modelName = modelName;
        this.sidecar = sidecar;
        this.signalLights = signalLights;
        this.radio = radio;
    }

    // - - - [ Methods

    public String retrieveMotorcycleInfo(){
        String s = "";

        s += printVehicleInfo() + '\n';
        s += "Model: " + this.modelName + '\n';
        s += "Side Car: " + this.sidecar + '\n';
        s += "Signal Lights: " + this.signalLights + '\n';
        s += "Radio: " + this.radio;

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
