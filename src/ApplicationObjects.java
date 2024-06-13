import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationObjects {
    ArrayList<Truck> trucks = new ArrayList<>();
    ArrayList<SportUtilityVehicle> sportUtils = new ArrayList<>();
    ArrayList<Motorcycle> motorcycles = new ArrayList<>();
    ArrayList<Car> cars = new ArrayList<>();

    Scanner input = new Scanner(System.in);

    public void run(){
        int mainMenuSelection;

        System.out.println(" - - [HFC Vehicle Solutions] - - ");
        System.out.println("Welcome, to HFC Vehicle Solutions!");

        do {
            System.out.println("Please choose from the following options: ");
            printMainMenu();
                mainMenuSelection = input.nextInt();
                    input.nextLine();

            while (mainMenuSelection < 1 || mainMenuSelection > 4) {
                System.out.println("Incorrect input selected! Please enter 1-4");
                System.out.println("Please choose from the following options: ");
                printMainMenu();
                    mainMenuSelection = input.nextInt();
                        input.nextLine();
            }

            System.out.println("- - - - - - - - - - - - -");

            switch(mainMenuSelection){
                case 1:
                    createVehicle();
                        break;
                case 2:
                    printList();
                        break;
                case 3:
                    createVehicleListFile();
                    System.out.println("The program will print the vehicle creation list to the file.");
                    mainMenuSelection = 4;
                        break;
            }
        }while(mainMenuSelection != 4);

        System.out.println("Thank you and have a great day!");
    }

    // - - - [ Methods

    public void printMainMenu(){
        System.out.println("\t1. Create Vehicle");
        System.out.println("\t2. View List");
        System.out.println("\t3. Print List to file");
        System.out.println("\t4. Exit Program");
        System.out.print("Selection: ");
    }

    public void printVehicleTypes(){
        System.out.println("\t1. Truck");
        System.out.println("\t2. Sport Utility Vehicle(SUV)");
        System.out.println("\t3. Motorcycle");
        System.out.println("\t4. Car");
        System.out.print("Selection: ");
    }

    public int getAmountOfNewVehicles(Truck truck){
        int amt = 0;

        System.out.println("How many of the following truck's would you like to create? ");
        truck.retrieveTruckInfo();
        System.out.print("Number to create: ");
            amt = input.nextInt();
                input.nextLine();

            while(amt < 0){
                System.out.print("Number to create greater than 0: ");
                    amt = input.nextInt();
                        input.nextLine();
            }

        return amt;
    }

    public int getAmountOfNewVehicles(SportUtilityVehicle SUV){
        int amt = 0;

        System.out.println("How many of the following SUV's would you like to create? ");
        SUV.retrieveSportUtilInfo();
        System.out.print("Number to create: ");
            amt = input.nextInt();
                input.nextLine();

        while(amt < 0){
            System.out.print("Number to create greater than 0: ");
                amt = input.nextInt();
                    input.nextLine();
        }

        return amt;
    }

    public int getAmountOfNewVehicles(Motorcycle motorcycle){
        int amt = 0;

        System.out.println("How many of the following bike's would you like to create? ");
        motorcycle.retrieveMotorcycleInfo();
        System.out.print("Number to create: ");
            amt = input.nextInt();
                input.nextLine();

        while(amt < 0){
            System.out.print("Number to create greater than 0: ");
                amt = input.nextInt();
                    input.nextLine();
        }

        return amt;
    }

    public int getAmountOfNewVehicles(Car car){
        int amt = 0;

        System.out.println("How many of the following cars would you like to create? ");
        car.retrieveCarInfo();
        System.out.print("Number to create: ");
            amt = input.nextInt();
                input.nextLine();

        while(amt < 0){
            System.out.print("Number to create greater than 0: ");
                amt = input.nextInt();
                    input.nextLine();
        }

        return amt;
    }

    // - - - [ Required Methods

    public void createVehicle(){
        int vehicleTypeSelection, amtOfVehiclesToCreate;

        System.out.println("Enter the type of vehicle you wish to create: ");
        printVehicleTypes();
            vehicleTypeSelection = input.nextInt();
                input.nextLine();

            while(vehicleTypeSelection < 1 || vehicleTypeSelection > 4){
                System.out.println("Incorrect input selected! Please enter 1-4");
                printVehicleTypes();
                    vehicleTypeSelection = input.nextInt();
                        input.nextLine();
            }

        switch(vehicleTypeSelection){
            case 1:
                Truck newTruck = new Truck();
                newTruck.addInfo(getGeneralInfo());
                System.out.println("- - - - - - - - - - - - -");
                createTruck(newTruck);

                amtOfVehiclesToCreate = getAmountOfNewVehicles(newTruck);

                for(int i = 0; i < amtOfVehiclesToCreate; i++){
                    trucks.add(newTruck);
                }
                    break;
            case 2:
                SportUtilityVehicle newSUV = new SportUtilityVehicle();
                newSUV.addInfo(getGeneralInfo());
                System.out.println("- - - - - - - - - - - - -");
                createSUV(newSUV);

                amtOfVehiclesToCreate = getAmountOfNewVehicles(newSUV);

                for(int i = 0; i < amtOfVehiclesToCreate; i++){
                    sportUtils.add(newSUV);
                }
                    break;
            case 3:
                Motorcycle newMotorcycle = new Motorcycle();
                newMotorcycle.addInfo(getGeneralInfo());
                System.out.println("- - - - - - - - - - - - -");
                createMotorcycle(newMotorcycle);

                amtOfVehiclesToCreate = getAmountOfNewVehicles(newMotorcycle);

                for(int i = 0; i < amtOfVehiclesToCreate; i++){
                    motorcycles.add(newMotorcycle);
                }
                    break;
            case 4:
                Car newCar = new Car();
                newCar.addInfo(getGeneralInfo());
                System.out.println("- - - - - - - - - - - - -");
                createCar(newCar);

                amtOfVehiclesToCreate = getAmountOfNewVehicles(newCar);

                for(int i = 0; i < amtOfVehiclesToCreate; i++){
                    cars.add(newCar);
                }
                    break;
        }
    }

    public Vehicle getGeneralInfo(){// Get data for vehicle class
        String manufacturer;
        double price;
        int crashRating, doors, wheels, horsepower, numPassengers;

        System.out.print("Who is the manufacturer? ");
            manufacturer = input.nextLine();

        System.out.print("What is the vehicle's price: ");
            price = input.nextDouble();
                input.nextLine();

            while(price < 0.00){
                System.out.print("Invalid price, please enter a positive amount: ");
                    price = input.nextDouble();
                        input.nextLine();
            }

        System.out.print("What is its crash rating? ");
            crashRating = input.nextInt();
                input.nextLine();

            while(crashRating < 0 || crashRating > 5){
                System.out.print("Invalid rating, enter a value from 0 - 5: ");
                    crashRating = input.nextInt();
                        input.nextLine();
            }

        System.out.print("How many doors? ");
            doors = input.nextInt();
                input.nextLine();

            while(doors < 0 || doors > 8){
                System.out.print("Invalid amount of doors, enter a value from 0 - 8: ");
                    doors = input.nextInt();
                        input.nextLine();
            }

        System.out.print("How many wheels? ");
            wheels = input.nextInt();
                input.nextLine();

            while(wheels < 2 || wheels > 8){
                System.out.print("Invalid amount of wheels, enter a value from 2 - 8: ");
                    wheels = input.nextInt();
                        input.nextLine();
            }

        System.out.print("How many horsepower does the engine output? ");
            horsepower = input.nextInt();
                input.nextLine();

            while(horsepower < 100){
                System.out.print("Invalid amount of horsepower, enter a value greater than 100: ");
                    horsepower = input.nextInt();
                        input.nextLine();
            }

        System.out.print("How many passengers it hold? ");
            numPassengers = input.nextInt();
                input.nextLine();

            while(numPassengers < 0){
                System.out.print("Invalud number a passengers, enter a positive number: ");
                    numPassengers = input.nextInt();
                        input.nextLine();
            }

        return (new Vehicle(manufacturer, price, crashRating, doors, wheels, horsepower, numPassengers));
    }

    public Truck createTruck(Truck newTruck){
        String type;
        int selectBedliner;
        double cargoCapacity, towingCapacity;
        boolean bedliner;

        System.out.print("What is the vehicle’s model? ");
            newTruck.setModelName(input.nextLine());

        System.out.print("What is the vehicle’s cargo capacity in pounds? ");
            cargoCapacity = input.nextInt();
                input.nextLine();

            while(cargoCapacity < 0.00){
                System.out.print("Invalid capacity, enter a value in pounds greater than 0: ");
                    cargoCapacity = input.nextInt();
                        input.nextLine();
            }

        System.out.print("What is the vehicle’s towing capacity in pounds? ");
            towingCapacity = input.nextInt();
                input.nextLine();

            while(towingCapacity < 0.00){
                System.out.print("Invalid capacity, enter a value in pounds greater than 0: ");
                    towingCapacity = input.nextInt();
                        input.nextLine();
            }

        System.out.println("Does the vehicle have a bed liner? ");
        System.out.println("\t1. Yes\n\t2. No");
        System.out.print("Selection: ");
            selectBedliner = input.nextInt();
                input.nextLine();

            while(selectBedliner < 1 || selectBedliner > 2){
                System.out.println("Please select 1 or 2 if the truck does or doesn't have a bed liner:");
                System.out.println("\t1. Yes\n\t2. No");
                System.out.print("Selection: ");
                    selectBedliner = input.nextInt();
                        input.nextLine();
            }

            bedliner = (selectBedliner == 1) ? true : false;

        System.out.print("What is the type of the truck? ");
            type = input.nextLine();


        newTruck.setCargoCapacity(cargoCapacity);
        newTruck.setTowingCapacity(towingCapacity);
        newTruck.setBedliner(bedliner);
        newTruck.setType(type);

        return newTruck;
    }

    public SportUtilityVehicle createSUV(SportUtilityVehicle newSUV){
        double towingCapacity;
        int numOfBenchSeats;

        System.out.print("What is the vehicle’s model? ");
            newSUV.setModelName(input.nextLine());

        System.out.print("What is the amount of bench seats? ");
            numOfBenchSeats = input.nextInt();
                input.nextLine();

            while(numOfBenchSeats < 1 || numOfBenchSeats > 6){
                System.out.print("Invalid amount of bench seats, enter a number between 1 - 6: ");
                    numOfBenchSeats = input.nextInt();
                        input.nextLine();
            }

        System.out.print("What is the vehicle’s towing capacity in pounds? ");
            towingCapacity = input.nextInt();
                input.nextLine();

        while(towingCapacity < 0.00){
            System.out.print("Invalid capacity, enter a value in pounds greater than 0: ");
                towingCapacity = input.nextInt();
                    input.nextLine();
        }

        newSUV.setNumOfBenchSeats(numOfBenchSeats);
        newSUV.setTowingCapacity(towingCapacity);

        return newSUV;
    }

    public Motorcycle createMotorcycle(Motorcycle newMotorcycle){
        boolean sidecar, signalLights, radio;
        int hasSidecar, hasSignalLights, hasRadio;

        System.out.print("What is the bike’s model? ");
            newMotorcycle.setModelName(input.nextLine());

        System.out.println("Does the bike have a sidecar?");
        System.out.println("\t1. Yes\n\t2. No");
        System.out.print("Selection: ");
            hasSidecar = input.nextInt();
                input.nextLine();

            while(hasSidecar < 1 || hasSidecar > 2){
                System.out.print("Please select below if the bike does or doesn't have a side car:");
                System.out.println("\t1. Yes\n\t2. No");
                System.out.print("Selection: ");
                    hasSidecar = input.nextInt();
                        input.nextLine();
            }

            sidecar = (hasSidecar == 1) ? true : false;

        System.out.println("Does the bike have signal lights?");
        System.out.println("\t1. Yes\n\t2. No");
        System.out.print("Selection: ");
            hasSignalLights = input.nextInt();
                input.nextLine();

            while(hasSignalLights < 1 || hasSignalLights > 2){
                System.out.print("Please select below if the bike does or doesn't have signal lights:");
                System.out.println("\t1. Yes\n\t2. No");
                System.out.print("Selection: ");
                    hasSignalLights = input.nextInt();
                        input.nextLine();
            }

            signalLights = (hasSignalLights == 1) ? true : false;

        System.out.println("Does the bike have a radio?");
        System.out.println("\t1. Yes\n\t2. No");
        System.out.print("Selection: ");
            hasRadio = input.nextInt();
                input.nextLine();

            while(hasRadio < 1 || hasRadio > 2){
                System.out.print("Please select below if the bike does or doesn't have a radio:");
                System.out.println("\t1. Yes\n\t2. No");
                System.out.print("Selection: ");
                    hasRadio = input.nextInt();
                        input.nextLine();
            }

            radio = (hasRadio == 1) ? true : false;

        newMotorcycle.setSidecar(sidecar);
        newMotorcycle.setSignalLights(signalLights);
        newMotorcycle.setRadio(radio);

        return newMotorcycle;
    }

    public Car createCar(Car newCar){
        String modelName, engineType;
        boolean convertible;
        int hasConvertible;

        System.out.print("What is the vehicle’s model? ");
            newCar.setModelName(input.nextLine());

        System.out.println("Does the vehicle have a convertible mode?");
        System.out.println("\t1. Yes\n\t2. No");
        System.out.print("Selection: ");
            hasConvertible = input.nextInt();
                input.nextLine();

        while(hasConvertible < 1 || hasConvertible > 2){
            System.out.println("Please select below if the vehicle has a convertible mode or not:");
            System.out.println("\t1. Yes\n\t2. No");
            System.out.print("Selection: ");
                hasConvertible = input.nextInt();
                    input.nextLine();
        }

        convertible = (hasConvertible == 1) ? true : false;

        System.out.print("What is the engine's model or type? ");
            newCar.setEngineType(input.nextLine());

        newCar.setConvertible(convertible);

        return newCar;
    }

    public void printList(){// Print all entered vehicles
        if(trucks.isEmpty() && sportUtils.isEmpty() && motorcycles.isEmpty() && cars.isEmpty()){
            System.out.println("No vehicles to show, please create vehicles to see something here.");
            System.out.println("- - - - - - - - - - - - -");
        } else {
            if (!(trucks.isEmpty())) {
                for (Truck e : trucks) {
                    System.out.println(e.retrieveTruckInfo());
                    System.out.println("- - - - - - - - - - - - -");
                }
            }

            if (!(sportUtils.isEmpty())) {
                for (SportUtilityVehicle e : sportUtils) {
                    System.out.println(e.retrieveSportUtilInfo());
                    System.out.println("- - - - - - - - - - - - -");
                }
            }

            if (!(motorcycles.isEmpty())) {
                for (Motorcycle e : motorcycles) {
                    System.out.println(e.retrieveMotorcycleInfo());
                    System.out.println("- - - - - - - - - - - - -");
                }
            }

            if (!(cars.isEmpty())) {
                for (Car e : cars) {
                    System.out.println(e.retrieveCarInfo());
                    System.out.println("- - - - - - - - - - - - -");
                }
            }
        }
    }

    public void createVehicleListFile(){// Send arrays to createFile and print to file
        if(!(trucks.isEmpty() && sportUtils.isEmpty() && motorcycles.isEmpty() && cars.isEmpty())){
            CreateFile createFile = new CreateFile();
            createFile.writeToFile(trucks, sportUtils, motorcycles, cars);
        } else {
            System.out.println("Failed to create file, please create vehicles to print to file!");
            System.out.println("- - - - - - - - - - - - -");
        }
    }
}