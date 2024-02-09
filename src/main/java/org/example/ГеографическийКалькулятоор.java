package org.example;
import java.util.Scanner;

public class ГеографическийКалькулятоор {


    private static final double ZEMLYA_RADIUS_KM = 6371.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите координаты первой точки:");
        double scpomps = Координаты ("Широта");
        double kop = Координаты("Долгота");
        System.out.println("\nВведите координаты второй точки:");
        double pips = Координаты("Широта");
        double pops = Координаты("Долгота");
        double distance = Дистанция(scpomps, kop, pips, pops);

        System.out.printf(String.valueOf(distance));

        scanner.close();
    }

    private static double Координаты(String coordinateType) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(coordinateType + ": ");
        return scanner.nextDouble();
    }

    private static double Дистанция (double scpomps, double kop, double pips, double pops) {

        scpomps = Math.toRadians(scpomps);
        kop = Math.toRadians(kop);
        pips = Math.toRadians(pips);
        pops = Math.toRadians(pops);

        double dLat = pips - scpomps;
        double dLon = pops - kop;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(scpomps) * Math.cos(pips) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return ZEMLYA_RADIUS_KM * c;
}
}
