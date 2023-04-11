package DefiningClassesLab.CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] carData = scanner.nextLine().split("\\s+");
            String brand = carData[0];
            String model = carData[1];
            int horsePower = Integer.parseInt(carData[2]);

            Car car = new Car(brand, model, horsePower);

            System.out.print(car);
        }
        //System.out.println(String.format("The car is: %s %s - %d HP", car.getBrand(), car.getModel(), car.getHorsePower()));


    }
}
