package org.example;

import org.example.app.DeliveryApplication;
import org.example.transport.Logistics;
import org.example.transport.RoadLogistics;
import org.example.transport.SeaLogistics;
import org.example.ui.GUIFactory;
import org.example.ui.MacOSFactory;
import org.example.ui.WindowsFactory;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String modeInput = args.length >= 1 ? args[0] : null;
        String platformInput = args.length >= 2 ? args[1] : null;

        Logistics logistics = null;
        while (logistics == null) {
            if (modeInput == null || modeInput.isBlank()) {
                System.out.print("Delivery mode (ROAD/SEA): ");
                if (!scanner.hasNextLine()) {
                    System.out.println("No input provided for delivery mode. Stopping.");
                    return;
                }
                modeInput = scanner.nextLine().trim();
            }
            logistics = createLogistics(modeInput);
            if (logistics == null) {
                System.out.println("Unsupported delivery mode: '" + modeInput + "'. Please enter ROAD or SEA.");
                modeInput = null;
            }
        }

        GUIFactory guiFactory = null;
        while (guiFactory == null) {
            if (platformInput == null || platformInput.isBlank()) {
                System.out.print("UI platform (WINDOWS/MACOS): ");
                if (!scanner.hasNextLine()) {
                    System.out.println("No input provided for UI platform. Stopping.");
                    return;
                }
                platformInput = scanner.nextLine().trim();
            }
            guiFactory = createGuiFactory(platformInput);
            if (guiFactory == null) {
                System.out.println("Unsupported UI platform: '" + platformInput + "'. Please enter WINDOWS or MACOS.");
                platformInput = null;
            }
        }

        System.out.println("Delivery mode: " + modeInput.toUpperCase(Locale.ROOT));
        System.out.println("UI platform: " + platformInput.toUpperCase(Locale.ROOT));

        DeliveryApplication app = new DeliveryApplication(guiFactory, logistics);
        app.run();
    }

    private static Logistics createLogistics(String mode) {
        switch (mode.trim().toUpperCase(Locale.ROOT)) {
            case "ROAD":
                return new RoadLogistics();
            case "SEA":
                return new SeaLogistics();
            default:
                return null;
        }
    }

    private static GUIFactory createGuiFactory(String platform) {
        switch (platform.trim().toUpperCase(Locale.ROOT)) {
            case "WINDOWS":
                return new WindowsFactory();
            case "MACOS":
                return new MacOSFactory();
            default:
                return null;
        }
    }
}