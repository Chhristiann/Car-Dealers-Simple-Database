import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car extends Vehicle {
    private String modelName;
    private boolean convertible;
    private String engineType;

    Car(){}

    Car(String modelName, boolean convertible, String engineType){
        this.modelName = modelName;
        this.convertible = convertible;
        this.engineType = engineType;
    }

    // - - - [ Methods

    public String retrieveCarInfo(){
        String s = "";

        s += printVehicleInfo() + '\n';
        s += "Model: " + this.modelName + '\n';
        s += "Convertible: " + this.convertible + '\n';
        s += "Engine: " + this.engineType;

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
