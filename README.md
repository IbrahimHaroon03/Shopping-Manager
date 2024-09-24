# Object Oriented Progamming Module Coursework : Shopping Manager
  
### About
As part this modules coursework I was tasked in creating a shopping manager program using a console system for the "manager" and a GUI for the "customer". This was coded on Apache Netbeans 18 as per the university's coursework specification.

### Table of Contents
- [About](#About)
- [Functions](#Functions)
- [Concepts I learnt & how they were used](#Concepts-I-learnt-&-how-they-were-used)
- [Example Images](#Example-Images)

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

### Example Images
<i>Manager Console Menu</i><br>
<img width="295" alt="Screenshot 2024-09-24 at 16 41 28" src="https://github.com/user-attachments/assets/d8827a60-ba7a-4e09-9f65-d8b2c701fa7f">

<i>Adding a new product</i><br>
<img width="309" alt="Screenshot 2024-09-24 at 16 43 29" src="https://github.com/user-attachments/assets/d9033eac-d869-4c47-a1b7-e9c82db52907">
<img width="310" alt="Screenshot 2024-09-24 at 16 44 47" src="https://github.com/user-attachments/assets/6bd87574-1573-4bad-a78d-d07a20edc76b">

<i>Print list of products</i><br>
<img width="1078" alt="Screenshot 2024-09-24 at 16 46 34" src="https://github.com/user-attachments/assets/6b78eda2-73fd-4d3d-9489-24e480e89811">

<i>GUI: View products</i><br>
<img width="1008" alt="Screenshot 2024-09-24 at 16 47 50" src="https://github.com/user-attachments/assets/b4f52bbc-84ff-4b96-b2f1-164d5e62a4f6">

<i>Select Product Type</i><br>
<img width="1011" alt="Screenshot 2024-09-24 at 16 49 21" src="https://github.com/user-attachments/assets/5bdc9fe0-00b3-4328-ae1b-58ddec72cc18">
<img width="1014" alt="Screenshot 2024-09-24 at 16 50 01" src="https://github.com/user-attachments/assets/9f298755-260d-4cdc-8c0f-f1a304328e37">

<i>View Selected Product Details</i><br>
<img width="1011" alt="Screenshot 2024-09-24 at 16 50 41" src="https://github.com/user-attachments/assets/f2f16b85-dee0-4937-9076-7c1351c53eac">

<i>Shopping Cart</i><br>
<img width="407" alt="Screenshot 2024-09-24 at 16 51 18" src="https://github.com/user-attachments/assets/fd1611f4-5f08-47e4-9467-353cbae1dedf">


