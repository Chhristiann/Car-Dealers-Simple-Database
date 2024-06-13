import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testCases {
    Car car = new Car("MachE", false, "Electric");
    Car testCar = new Car();

    Motorcycle motorcycle = new Motorcycle("Speedster 600 Series", false, true, false);
    Motorcycle testMotorcycle = new Motorcycle();

    @Test
    void testObjectModifier_1(){
        testCar.setModelName("MachE");
        testCar.setConvertible(false);
        testCar.setEngineType("Electric");
        testCar.setManufacturer("Ford");

        assertEquals(car.getEngineType(), testCar.getEngineType());
    }

    @Test
    void testObjectModifier_2(){
        motorcycle.setManufacturer("Bucatti");

        testMotorcycle.setModelName("Speedster 600 Series");
        testMotorcycle.setManufacturer("Bucatti");

        assertEquals(motorcycle.getModelName(), testMotorcycle.getModelName());
    }
}
