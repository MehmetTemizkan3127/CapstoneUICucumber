**CapstoneUICucumber**

A Java-based UI automation framework utilizing Cucumber for Behavior-Driven Development (BDD) and Selenium WebDriver for browser interactions.

📌 **Project Overview**

CapstoneUICucumber is designed to facilitate automated UI testing using Cucumber's Gherkin syntax for writing human-readable test scenarios. The framework integrates with Selenium WebDriver to perform browser automation, enabling efficient and maintainable testing practices.

🛠️ **Technologies Used**

Java: Primary programming language for test implementation.

Cucumber: For writing and running BDD-style tests.

Selenium WebDriver: For browser automation.

Maven: For project dependency management and build automation.


📁 **Project Structure**

<img width="358" height="419" alt="image" src="https://github.com/user-attachments/assets/88f4e2f0-9fc8-4bdf-9903-1290d2ea9f3a" />


⚙️ **Setup & Installation**

Clone the repository:

git clone https://github.com/MehmetTemizkan3127/CapstoneUICucumber.git
cd CapstoneUICucumber


Install dependencies:

Ensure you have Maven installed. Then, run:

mvn install


**Configure WebDriver:**

Download the appropriate WebDriver for your browser (e.g., ChromeDriver) and place it in a directory included in your system's PATH.

Run Tests:

To execute tests using Cucumber:

mvn test

🧪** Writing Tests**

Feature Files: Located in src/test/resources/features/, these files contain Gherkin syntax scenarios.

Step Definitions: Implemented in Java classes within src/test/java/stepdefinitions/, mapping Gherkin steps to Selenium actions.

🔧** Configuration**

configuration.properties: Contains environment-specific settings such as base URLs and browser configurations.
