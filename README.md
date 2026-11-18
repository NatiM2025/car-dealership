# Car Dealership

A console app that keeps a car dealership's inventory in a CSV file and lets customers and managers search and update it.

## Description of the Project

This is a simple Java car dealership application. Customers can look at all the cars and search by price, make and model, year, color, mileage, and type. Managers can add and remove cars when they come in or go out. The cars are loaded from a CSV file when the app starts, and the file is saved after every add or remove, so the inventory stays up to date.

## Features

- Search cars by price range
- Search cars by make and model
- Search cars by year range
- Search cars by color
- Search cars by mileage range
- Search cars by type (car, truck, SUV, van)
- Show all cars
- Add a car
- Remove a car
- Load the inventory from a CSV file and save it after every add or remove

## User Stories

- As a customer, I want to see all the cars in the inventory so that I can choose the car I want.
- As a customer, I want to filter by year, mileage, or price range so that I can find a specific car.
- As a manager, I want to see all the cars and add or remove them so that the inventory is always up to date.

## Setup

### Prerequisites

- Java 17 (Amazon Corretto), the version used in class.
- IntelliJ IDEA Community Edition: <https://www.jetbrains.com/idea/download/>

### Running the application

1. Clone this repository, or download it as a zip and unzip it.
2. In IntelliJ: File > Open, pick the project folder (the one that holds `pom.xml`), press Open.
3. Wait for IntelliJ to finish indexing (progress bar at the bottom).
4. Open `src/main/java/com/pluralsight/Main.java`.
5. Right-click inside the file and choose Run 'Main.main()'.
6. Type a number from the menu and press Enter.

### Data and configuration

- `inventory.csv` sits at the project root, next to `pom.xml`. The program reads it at start and saves it after every add or remove.
- The first line is the dealership: `name|address|phone`.
- Every other line is one car: `vin|year|make|model|type|color|mileage|price`.


## Technologies Used

- Java 17
- IntelliJ IDEA

## Future Work

## Future Work
- Handle wrong input, like typing letters when a number is needed.
- Save to a temporary file first, so the inventory is safe if the app crashes while saving.
## Resources

- Java YearUp Fall 2026 hub: <https://raymaroun.github.io/yearup-java-fall2026/>
- Pluralsight Workshop 4w: An Object-Oriented Car Dealership

## Author

- **Natanim M Sintayehu**

## Thanks

Thank you to my instructor, for the workbook, the resources, and for teaching us how to build this project.