package SetsAndMapsAdvanced.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String inputLine = scanner.nextLine();
        Set<String> parkingInfo = new LinkedHashSet<>();

        while (!inputLine.equals("END")){

            String[] parkingData = inputLine.split(",\\s+");
            String direction = parkingData[0];
            String carNumber = parkingData[1];

            if(direction.equals("IN")){
                parkingInfo.add(carNumber);
            }else if(direction.equals("OUT")){
                parkingInfo.remove(carNumber);
            }

            inputLine = scanner.nextLine();
        }
        if(parkingInfo.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else{
            for (String car: parkingInfo) {
                System.out.println(car);
            }
        }
    }
}
