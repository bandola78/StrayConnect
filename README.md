![Stray Connect Logo](https://github.com/bandola78/StrayConnect/blob/main/images/logo.png)

## Project Overview

Stray Connect is not just a console application; it is a mission-driven platform designed to improve the lives of stray animals and promote community involvement. Built using Java, it serves as a digital bridge to facilitate animal adoption, foster care, donations, and pet registration. Through its comprehensive set of features, Stray Connect simplifies processes, reduces barriers to participation, and empowers individuals to make a difference.

Our primary goal is to address the plight of stray animals while leveraging technology to engage the community. Stray Connect aligns with **Sustainable Development Goal 15: Life on Land**, which underscores the importance of conserving biodiversity and fostering sustainable ecosystems. By integrating Object-Oriented Programming (OOP) principles, Stray Connect ensures that the platform is robust, scalable, and ready to expand its impact on animal welfare and community collaboration.

---

## Features

| Feature                       | Description                                                           |
|------------------------       |-----------------------------------------------------------------------|
| 🐾 **Adopt a Stray Animal**  | Users can view and adopt available stray animals.                      |
| 🏡 **Surrender a Stray**     | Allows individuals to surrender stray animals to the system.           |
| ❤️ **Foster a Stray**        | Facilitates the fostering of stray animals.                            |
| 💰 **Donate**                | Accepts donations to support animal welfare activities.                |
| 🐕 **Register a Pet**        | Maintains records of registered pets for better tracking.              |
| 🙋 **Volunteer**             | Allows users to register as volunteers.                                |
| 📊 **Generate Reports**      | Generates detailed reports on adoptions, donations, and volunteers.    |
| 📍 **View Center Address**    | Displays information about the Stray Connect rescue center.            |

---

## How It Works

Stray Connect is an interactive console application that provides a menu-based system for users to navigate through its features. Below is an overview of how the program works:

| Step                  | Description                                                                 |
|-----------------------|-----------------------------------------------------------------------------|
| **Main Menu**         | Displays the main menu with all available options.                          |
| **Adoption Process**  | Shows a list of adoptable animals and allows users to select one.           |
| **Surrender Workflow**| Prompts users to provide details about the animal being surrendered.        |
| **Foster Process**    | Displays eligible animals for fostering and collects necessary information. |
| **Donation Workflow** | Logs donations made by users.                                               |
| **Volunteer Signup**  | Collects information from users to register as volunteers.                  |
| **Report Generation** | Displays adoption reports.                                                  |

### Demo
Below are screenshots of the application in action:

**Main Menu**        

![Main Menu](https://github.com/bandola78/StrayConnect/blob/main/images/Main%20Menu.png)  

Displays the list of features available.      

**Adoption Process** 

![Adoption Process](https://github.com/bandola78/StrayConnect/blob/main/images/Adoption.png) 

Step-by-step flow of how users can adopt a stray animal.  

**Surrender Workflow**   

![Surrender Workflow](https://github.com/bandola78/StrayConnect/blob/main/images/Surrender.png) 

Captures details of stray animals being surrendered.  

**Foster Process** 

![Foster Process](https://github.com/bandola78/StrayConnect/blob/main/images/foster.png) 

Guides users through selecting and fostering an animal.    

**Adoption Report** 

![Reports](https://github.com/bandola78/StrayConnect/blob/main/images/Report.png) 

Displays generated reports for adoptions.          

## OOP Principles Applied

### 1. **Encapsulation**
- Data fields in the classes are declared as `private`, with controlled access provided through getters and setters. This ensures proper data handling and minimizes unintended changes to the internal state of objects.

```java
public class StrayAnimal {
    private String name;
    private String species;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
```

### 2. **Inheritance**
- Classes such as `StrayAnimal` and `Pet` inherit from a common parent class, demonstrating code reuse and hierarchical relationships.

```java
public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void displayInfo();
}

public class StrayAnimal extends Animal {
    private String species;

    public StrayAnimal(String name, String species) {
        super(name);
        this.species = species;
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + getName() + ", Species: " + species);
    }
}
```

### 3. **Polymorphism**
- Polymorphism is demonstrated through method overriding. For instance, the `displayInfo()` method in different subclasses provides unique implementations specific to each type of animal or user.

```java
public class Pet extends Animal {
    private String ownerName;

    public Pet(String name, String ownerName) {
        super(name);
        this.ownerName = ownerName;
    }

    @Override
    public void displayInfo() {
        System.out.println("Pet Name: " + getName() + ", Owner: " + ownerName);
    }
}

Animal stray = new StrayAnimal("Loonie", "Dog");
Animal pet = new Pet("Mittens", "John Doe");

stray.displayInfo(); 
// Output: Name: Buddy, Species: Dog
pet.displayInfo();   
// Output: Pet Name: Mittens, Owner: John Doe
```

### 4. **Abstraction**
- Abstract classes and interfaces are used to hide implementation details while exposing essential functionalities. For example, an abstract class `Animal` is implemented by classes like `StrayAnimal` and `Pet` to define shared behavior.

```java
public interface Reportable {
    void generateReport();
}

public class AdoptionReport implements Reportable {
    @Override
    public void generateReport() {
        System.out.println("Generating adoption report...");
    }
}

public class DonationReport implements Reportable {
    @Override
    public void generateReport() {
        System.out.println("Generating donation report...");
    }
}

Reportable report = new AdoptionReport();
report.generateReport(); 
// Output: Generating adoption report...
```

---

## Sustainable Development Goal (SDG)

### **Goal 15: Life on Land**

![Life on Land - SDG15](https://github.com/bandola78/StrayConnect/blob/main/images/sdg15.png)

Stray Connect directly contributes to the preservation of terrestrial ecosystems and biodiversity by addressing a growing concern: the welfare of stray animals. Here’s how:

- **Promoting Animal Welfare**: Through features like adoption and fostering, Stray Connect ensures that stray animals are given homes and care, reducing their vulnerability and improving their quality of life.

- **Engaging the Community**: The application fosters community involvement by enabling users to volunteer, donate, or take direct actions that benefit the ecosystem.

- **Educational Impact**: By encouraging responsible pet ownership and spreading awareness about the importance of animal conservation, Stray Connect helps build a culture of empathy and sustainability.

- **Sustainable Development in Practice**: Stray Connect aligns with the UN’s call for global efforts to halt biodiversity loss and enhance the well-being of all species by providing a practical, scalable solution to a pressing local issue.

This platform demonstrates how technology can be leveraged to achieve meaningful impacts while supporting a global vision of sustainability.

---

## How to Run the Program

| Step                     | Description                                                                |
|--------------------------|----------------------------------------------------------------------------|
| **Prerequisites**        | Ensure Java Development Kit (JDK) and an IDE (e.g., VS Code) are installed.|
| **Download the Project** | Clone or download the repository and extract the files.                    |
| **Run in IDE**           | Open `StrayConnectMain.java` in the IDE and run it.                        |
| **Command Line**         | Compile and run using the terminal (instructions provided below).          |

### Setup and Run Instructions ▶️

1. **Using an IDE (e.g., Visual Studio Code)**
   - Open the project folder in your IDE.
   - Locate the main file `StrayConnectMain.java` and run it.

2. **Using Command Prompt or Terminal**
   - Navigate to the project directory:
     ```bash
     cd path/to/your/project/src
     ```
   - Compile the program:
     ```bash
     javac -d out main/*.java models/*.java services/*.java reports/*.java utils/*.java
     ```
   - Run the program:
     ```bash
     java -cp out main.StrayConnectMain
     ```

---

## File Structure

```
   src/
   |
   ├── main/
   │   └── StrayConnectMain.java
   |
   ├── models/
   |    └── AdoptionRecord.java
   |    └── Animal.java
   |    └── AnimalAttributes.java
   |    └── Donation.java
   |    └── RegisteredPet.java
   |    └── StrayAnimal.java
   |    └── Volunteer.java
   ├── services/
   |    └── AnimalServices.java
   |    └── DonationServices.java
   |    └── FosterServices.java
   |    └── PetRegistrationServices.java
   |    └── VolunteerServices.java
   ├── reports/
   |    └── ReportsGenerator.java
   ├── utils/
   |    └── DataValidator.java
   |    └── InputHelper.java
   README.md
   ```

5. **Troubleshooting**
   - Ensure your JDK is installed correctly.
   - Check for any missing files or compilation errors.

---

## File Structure

```
src/
├── main/
│   └── StrayConnectMain.java  # Main class
├── models/
│   ├── StrayAnimal.java       # Animal-related models
│   └── AdoptionRecord.java    # Adoption record model
├── services/
│   ├── AnimalServices.java    # Services for animal handling
│   ├── VolunteerServices.java # Volunteer registration services
│   └── DonationServices.java  # Donation management services
├── reports/
│   └── ReportsGenerator.java  # Report generation logic
└── utils/
    ├── InputHelper.java       # Input handling and utility methods
    └── ConsoleUtils.java      # Console-related utilities
```

---

## About the Developer

Hi, I'm Jobelyn Bandola, the developer of Stray Connect. This project was created as part of my Object-Oriented Programming (OOP) final project, adhering to OOP principles while contributing to Sustainable Development Goals. Developing Stray Connect has been a rewarding experience, allowing me to refine my programming skills and explore software development concepts like database management and logic building.

Thank you for exploring my project! Stray Connect represents not just an academic milestone but also a step toward meaningful community service. I hope to continue improving and expanding this project in the future.

---
