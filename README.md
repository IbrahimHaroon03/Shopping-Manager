# Object Oriented Progamming Module Coursework : Shopping Manager
  
### About
As part this modules coursework I was tasked in creating a shopping manager program using a console system for the "manager" and a GUI for the "customer". This was coded on Apache Netbeans 18 as per the university's coursework specification.

### Table of Contents
- [About](#About)
- [Functions](#Functions)
- [Concepts I learnt & how they were used](#Concepts-I-learnt-&-how-they-were-used)

### Functions
The program had seperate frunctions for the manager and customer.

<i>Manager console menu functions:</i>
1. Add a new product
2. Delete a product
3. Print a list of all products
4. Write product list to a text file
5. Read text file

<i>Customer GUI Functions:</i>
1. Select type of product 
2. View list of products 
3. Add to shopping cart
4. View only selected product details

### Concepts I Learnt & How They Were Used
1. <i>Inheritance:</i>
- A super class called 'Product' had the attributes shared across the subclass 'Electronincs' and 'Clothing. This allowed the subclass to have their own unique attributes alongside the attributes they must have. For example, 'Product' has attributes price, productID etc and Clothing has size and color as additional attributes.
2. <i>Interfaces:</i>
- The abstact class is 'ShoppingManager' which contains all the abstract method   declarations and the body for these methods are provided in the subclass 'WestminsterShoppingManager'.
3. <i>Constructors</i>
- Constructors were used to initialise a new Product object when the 'manager' selects the 'add new product' option.
4. <i>Encapsulation: Getters & Setters</i>
- Here getters and setters where used to either retrive specific attributes from a product or to either set a new value to an existing product
5. <i>GUI: AWT & Swing</i>
- With the use of JFrames, JTables and JPanels the user could interact with the system on a GUI.
6. <i>Input Validation</i>
- Using do while loops and functions such as '.hasnextint' to insure the user can only input integers within a range.

