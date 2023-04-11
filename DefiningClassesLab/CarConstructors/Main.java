package DefiningClassesLab.CarConstructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] carData = scanner.nextLine().split("\\s+");
            if(carData.length == 1){
                String brand = carData[0];

                Car car = new Car(brand);
                System.out.print(car);
            }else{
                String brand = carData[0];
                String model = carData[1];
                int horsePower = Integer.parseInt(carData[2]);

                Car car = new Car(brand, model, horsePower);
                System.out.print(car);
            }

        }
    }
}
