import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateFile {
    private final Scanner consoleInput;
    private PrintWriter fileWriter;
    private String fileName;

    CreateFile(){
        consoleInput = new Scanner(System.in);
        fileName = "VehicleCreationList.txt";
    }

    // - - - [ Methods

    public void writeToFile(
            ArrayList<Truck> trucks, ArrayList<SportUtilityVehicle> sportUtils,
            ArrayList<Motorcycle> motorcycles, ArrayList<Car> cars
        ){
        try{
            File file = fileCreation();
            fileWriter = new PrintWriter(file);
            String fileContents = readListsIntoString(trucks, sportUtils, motorcycles, cars);

            fileWriter.print(fileContents);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            fileWriter.close();
        }
    }

    private String readListsIntoString(
            ArrayList<Truck> trucks, ArrayList<SportUtilityVehicle> sportUtils,
            ArrayList<Motorcycle> motorcycles, ArrayList<Car> cars
        ){
        StringBuilder s = new StringBuilder();

        if (!(trucks.isEmpty())) {
            s.append(" - - - - - - [Truck's] - - - - - - " + '\n');
            for (Truck e : trucks) {
                s.append(e.retrieveTruckInfo());
                s.append("\n\n");
            }
        }

        if (!(sportUtils.isEmpty())) {
            s.append(" - - - - - - [SUV's] - - - - - - " + '\n');
            for (SportUtilityVehicle e : sportUtils) {
                s.append(e.retrieveSportUtilInfo());
                s.append("\n\n");
            }
        }

        if (!(motorcycles.isEmpty())) {
            s.append(" - - - - - - [Motorcycles] - - - - - - " + '\n');
            for (Motorcycle e : motorcycles) {
                s.append(e.retrieveMotorcycleInfo());
                s.append("\n\n");
            }
        }

        if (!(cars.isEmpty())) {
            s.append(" - - - - - - [Uncategorized Cars] - - - - - - " + '\n');
            for (Car e : cars) {
                s.append(e.retrieveCarInfo());
                s.append("\n\n");
            }
        }

        return s.toString();
    }

    private File fileCreation(){
        File createdFile = new File(fileName);

        if(!(createdFile.exists())){
            return createdFile;
        } else if(createdFile.isFile()) {
            createdFile.delete();
            return createdFile;
        }

        throw new RuntimeException("Fatal error. The file could not be created.");
    }
}
