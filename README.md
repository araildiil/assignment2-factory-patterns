# Assignment 2 — Factory Method and Abstract Factory

## Project purpose
A console logistics application that delivers cargo by road or sea and renders a
matching Windows or macOS UI component pair. **Factory Method** creates the transport
(`Truck` / `Ship`); **Abstract Factory** creates a matching `Button` + `Checkbox` pair
for the chosen platform. Both patterns run together in one program.

## Package structure
```
org.example
├── Main.java
├── app/
│   └── DeliveryApplication.java
├── transport/
│   ├── Transport.java
│   ├── Truck.java
│   ├── Ship.java
│   ├── Logistics.java
│   ├── RoadLogistics.java
│   └── SeaLogistics.java
└── ui/
    ├── Button.java
    ├── Checkbox.java
    ├── WindowsButton.java
    ├── WindowsCheckbox.java
    ├── MacOSButton.java
    ├── MacOSCheckbox.java
    ├── GUIFactory.java
    ├── WindowsFactory.java
    └── MacOSFactory.java
```

## Prerequisites
- JDK 17
- Maven 3.8+ (or run via an IDE such as IntelliJ IDEA)

## Build and run

mvn compile
mvn exec:java -Dexec.mainClass="org.example.Main"

Or, after building, run the compiled class directly, or run `Main.main` from your IDE.

## Supported input values
The program accepts the two selections either as command-line arguments
(`<mode> <platform>`, e.g. `ROAD WINDOWS`) or interactively via console prompts if no
arguments are given (or if a given value is invalid — the program re-prompts).

- Delivery mode: `ROAD`, `SEA` (case-insensitive)
- UI platform: `WINDOWS`, `MACOS` (case-insensitive)

An unsupported or missing value prints a clear validation message and either asks
again (interactive input) or stops cleanly (no more input available).

## Sample run

Delivery mode: ROAD
UI platform: WINDOWS
Rendering Windows button
Rendering Windows checkbox
Truck delivers laboratory equipment to Aktau warehouse by road


## Repository / submission notes
- Submitted commit: <fill in the commit hash before submitting>
- GitHub repository link: <fill in>