package org.example;
import java.util.Scanner;

public class ГеографическийКалькулятоор {


    private static final double ZEMLYA_RADIUS_KM = 6371.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите координаты первой точки:");
        double lat1 = Координаты ("Широта");
        double lon1 = Координаты("Долгота");

        System.out.println("\nВведите координаты второй точки:");
        double lat2 = Координаты("Широта");
        double lon2 = Координаты("Долгота");

        double distance = Дистанция(lat1, lon1, lat2, lon2);

        System.out.printf("\nРасстояние между точками: %.2f км\n", distance);

        scanner.close();
    }

    private static double Координаты(String coordinateType) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(coordinateType + ": ");
        return scanner.nextDouble();
    }

    private static double Дистанция (double lat1, double lon1, double lat2, double lon2) {

        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return ZEMLYA_RADIUS_KM * с;
}
}
