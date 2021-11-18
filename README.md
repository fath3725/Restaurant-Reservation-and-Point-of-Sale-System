# Restaurant Reservation and Point of Sale System

Hello! We are [Ong Chun Guan Marcus](https://github.com/MarcusOCG), [Ryan Taw Lin Heng](https://github.com/Ryancodeshard), [Rizwan Nusrath Fathima](https://github.com/fath3725), [Nguyen Vinh Quang](https://github.com/quangnd123), [Sim Kwan Hong Davis](https://github.com/DavisSim) from Nanyang Technological University (NTU). We were tasked to make a Restaurant Reservation and Point of Sale System (RRPSS) Application as part of our coursework for the module CZ2002: Object Oriented Programming. The making of this app allowed us to apply concepts we learnt and gain some hands on experience. You can watch a demo of the app [here.](https://youtu.be/bOsce5OK8L4)

## Quick Summary Of The App
The app serves these 10 main functions:
  1. Create/Update/Remove menu item
  2. Create/Update/Remove promotion
  3. Create order
  4. View order
  5. Add/Remove order item/s to/from order
  6. Create reservation booking
  7. Check/Remove reservation booking
  8. Check table availability
  9. Print order invoice
  10. Print sale revenue report by period (eg day or month)

When using the app for the first time, the restaurant has to be set up. So, number of tables available and their pax, staff and their roles and menu items need to be added before it is ready to use.

## Design Considerations
During the design phase of our RRPSS application, examples of how real life restaurant systems would work were considered. Hence, we believe that our application is close to how a real world system would work based on the given required functional requirements. To compensate for our inexperience in how restaurants work, we had to make assumptions regarding certain aspects of the application.

### Use of Design Principles
To achieve an application with good design, it should have loose coupling and high cohesion between the classes, which we aimed for. We identified classes and entities while still considering its reusability, extensibility and maintainability.The principles we used in our design are the **Single Responsibility Principle (SRP)** and **Open-Closed Principle (OCP).**

To achieve the ***Single Responsibility Principle***, a single class should have a single responsibility as this would make changes easier to handle. As this reduces the number of classes that have to be modified in the event any changes have to be done later on. This enables us to achieve the good design principle of having loose coupling. This can be seen in our Table class which only has one responsibility. 

For the ***Open-Closed Principle*** to be achieved “a module should be open for extension but closed for modification”. This describes that abstraction is key to OCP, and that a class may allow for inheritance but its methods are kept the same so that existing classes that inherit from it would not be disrupted. This principle is applied in our Person class where we can change what the modules Member and Staff do, but without changing the inherited functions.

### Use of Object Oriented Programming Concepts
***Encapsulation*** is used for almost every class as attributes and data should be hidden to protect the data of the restaurant, its employees and its customers.

***Inheritance*** is used in these following instances:
MenuItem class serves as a parent class for Alacarte and PromotionPackage. 
Person class serves as base class for both Staff and Member.

***Polymorphism*** is used in this instance:
Order class inherits from the Menu class and it overrides the addItem and editItem functions.

***Abstraction*** is **NOT** used.

## Assumptions Made
  1. The table will be marked as reserved from 1 hour before the reservation timing till 0.5 hours after. For example, if a reservation is made at 12pm, the table would be        marked as reserved from 11am till 12.30pm to keep the table empty. If at 12.30pm, the customer has not arrived, the reservation will be cancelled.
  2. Using the same example, if customers arrived at their reserved table at 12.29pm, 1 minute before cancellation, it is assumed that their max dining period is 0.5 hours.        Therefore, one can only make a reservation 1 hour after reservation time at 1pm. 
  3. Reservations can only be made for the current year. As such, if it is the end of the year, and reservations are being made for the next year, the employee will need to        change the date of the computer to the next year.
  4. Reservations can only be made 30 minutes in advance. As such, if the time is currently 2pm, they cannot make a reservation at 2.29pm.
  5. For the function, print sale revenue report by period (e.g. day or month), we assumed that a restaurant would have a pre-existing database to store all the information        about their past transactions in the restaurant so that they can easily retrieve the needed information.
  6. Members get a 5% discount.


## UML Class Diagram
![photo1636716524](https://user-images.githubusercontent.com/74095679/142368880-4c367ef8-397d-4f76-a819-7812489eed98.jpeg)
## UML Sequence Diagram 
This is the sequence diagram for the “Check/Remove reservation booking” function.
![photo1636716829](https://user-images.githubusercontent.com/74095679/142368915-c96d4524-7fd0-4c47-a839-4c3f0d22139f.jpeg)
---
Please refer to our Test Cases file for the test cases that were run. Thank you for dropping by.
