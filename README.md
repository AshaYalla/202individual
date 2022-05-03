# Individualproject-asha


# Problem Statement

Created a java application that contains the inventory information in which the user is allowed to purchase products from three categories i.e Essentials, Luxury, Misc. There is a limited cap of items on the purchase from each category. If the user request is satisfied, we generate the TXT file with the total amount to be paid and the card number is used for the payment.

# Steps to run the application


  * Run the following command in the Terminal:  
  
    Compile:
      Javac Project.java
  * Run:
  *  
java Project "/Users/ashayalla/Downloads/individual-project-asha/resources/CreditCards.csv" "/Users/ashayalla/Downloads/individual-project-asha/resources/Dataset.csv" "/Users/ashayalla/Downloads/individual-project-asha/resources/Input1 - Sheet1.csv" 
Output files will be created in the directory as the files provided as arguments to run the JAR.






# Design Patterns

* Singleton
* Factory

   * Singleton:
        * It's a creational design pattern that lets you to assure that a class only has one instance while yet offering global access to that instance.
        * Used this pattern to store the data for the entire application. Class implemented using singleton pattern is StockRepository.java.
        * An instance of the StockRepository is created and the getter methods is called in the required classes by only one instance and it can be reused.

  *  Factory Pattern:
       * Factory Method is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of            objects that will be created.
       * Used this pattern by creating an interface "InputReadDataFactory.java" which is implemented by "InputFileReader.java" and "CardReader.java"
       * 


Class Diagram

<img width="826" alt="Screen Shot 2021-12-05 at 11 32 03 PM" src="https://user-images.githubusercontent.com/88958925/144823760-b2c7cc8d-64b7-46c3-97ce-ed0eaba283d0.png">

# Screenshots of Test Cases

### Test Case 1: 
<img width="601" alt="Screen Shot 2021-12-06 at 1 31 11 AM" src="https://user-images.githubusercontent.com/88958925/144821849-f1106fa6-f0ba-41ca-94e5-fc739b5781ff.png">


### Test Case 2:

<img width="1440" alt="Screen Shot 2021-12-06 at 1 16 01 AM" src="https://user-images.githubusercontent.com/88958925/144821103-70d25532-59fb-49b5-bfe2-66ef162f038b.png">


### Test Case 3:

<img width="1440" alt="Screen Shot 2021-12-05 at 11 44 07 PM" src="https://user-images.githubusercontent.com/88958925/144820978-5bb9a099-fc88-47a5-b3ce-6ab35edafdc7.png">







