import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;

@Getter
@Setter
public class Vehicle {
    private String manufacturer;
    private double price;
    private int crashRating;    // 0-5
    private int doors;          // d >= 0 && d <= 8
    private int wheels;         // w >= 2 && w <= 8
    private int horsepower;     // > 100
    private int numPassengers;

    private DecimalFormat df = new DecimalFormat("#,##0.00");

    Vehicle(){}

    // Q: If i need a non-default constructor, give a reason why i need it here.
    // A: having a non-default constructor for this class would be more efficient for when i need to add data to
    //    the vehicle class rather than using vehicle.set 7 times.

    Vehicle(String manufacturer, double price, int crashRating, int doors, int wheels, int horsepower, int numPassengers){
        this.manufacturer = manufacturer;
        this.price = price;
        this.crashRating = crashRating;
        this.doors = doors;
        this.wheels = wheels;
        this.horsepower = horsepower;
        this.numPassengers = numPassengers;
    }

    // - - - [ Methods

    public String printVehicleInfo(){
        String s = "";

        s += "Manufacturer: " + this.manufacturer + '\n';
        s += "Price: $" + df.format(this.price) + '\n';
        s += "Wheels: " + this.wheels + '\n';
        s += "Doors: " + this.doors + '\n';
        s += "Horsepower: " + this.horsepower + '\n';
        s += "Passengers: " + this.numPassengers + '\n';
        s += "Crash Rating: " + this.crashRating + " stars";

        return s;
    }
}
