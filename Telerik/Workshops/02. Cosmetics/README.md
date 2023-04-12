## OOP Workshop - Cosmetics shop 2

### Description

You are given a software system for managing a cosmetics shop. The system already has a working Engine. You do not have to touch anything in it. Just use it.

There should be two types of products for now, Shampoos and Toothpastes.

- Each Shampoo has **name, brand, price, gender, milliliters, usage**.
- Each Toothpaste has **name, brand, price, gender, ingredients**.

There are also Categories and Shopping Carts.

- Categories have a **name and a list of products**.
- Shopping Cart has a **list of products**.

### Task

Your task is to **design an object-oriented class hierarchy** to model the cosmetics shop, **using the best practices for object-oriented design** (OOD) and **object-oriented programming** (OOP). Encapsulate correctly all fields and use validation whenever needed.

> *Note*: The project won't compile initially. First you need to build to correct interfaces hierarchy.

#### 1. ShampooImpl

- Implements Shampoo
- Has a name, brand, price, gender, milliliters, and usage type
- The name’s length should be between 3 and 10 symbols.
- The brand name’s length should be between 2 and 10 symbols.
- The price cannot be negative.
- Gender type can be one of **"Men"**, **"Women"** or **"Unisex"**.
- Milliliters cannot be negative.
- Usage type can be one of **"Every_Day"** or **"Medical"**.

#### 2. ToothpasteImpl

- Implements Toothpaste.
- Has name, brand, price, gender, and ingredients.
- The name’s length should be between 3 and 10 symbols.
- The brand name’s length should be between 2 and 10 symbols.
- The price cannot be negative.
- Gender type can be one of **"Men"**, **"Women"** or **"Unisex"**.

#### 3. CosmeticsRepositoryImpl

- Stores all the application's data.
- Handles creation of new objects.
- Used to find already existing objects.

#### 4. Interfaces

- All the needed interfaces are already there. **You must use them all** in order to achieve the best OOP design.
- When doing the advanced task you need to **create** and use interfaces.

### Constraints

- Look into the example below to get better understanding of the printing format.
- All floating-point numbers should be printed rounded to two decimal places.
- All methods in the above interfaces are mandatory (cannot return null or empty).

### Additional notes

- To simplify your work you are given an already built execution engine that executes a sequence of commands read from the console using the classes and interfaces in your project.
- Please, put your classes in **cosmetics.models** package.
- If you decide to create and use new classes and/or interfaces you are allowed to do so.
- When you implement an unfinished method (one that throws `UnsupportedOperationException`), make sure to delete the `throws new...` line.

### Unit Tests

You are given unit tests to keep track of your progress.

## Step by step guide

> *Hint*: You don't need to modify the Engine class and the Main method but of course you could try to understand how they work.

> *Hint*: Run the Unit tests whenever you finish a task.

> *Important*: See what methods are there in `ParsingHelpers` and `ValidationHelpers` classes and use them whenever possible!

1. Implement the classes for shampoo and toothpaste

   - Implement the necessary interfaces.
   - Look at the **models.contracts** package and think about how to build a correct hierarchy.
   - Create the necessary fields and initialize them in the constructor.
   - Validate all the fields according to the constraints above.
   - Implement all the necessary methods. Leave the print method for later.
   - Did you notice the repeating code in the ShampooImpl and ToothpasteImpl classes (the common fields/methods)? What could you do in order to avoid the repetition?

1. Implement the unfinished methods in `CosmeticsRepositoryImpl`.

   - This is where the creation of the object should be.
   - Add the newly created object to the list.

1. Implement `CreateShampooCommand` and `CreateToothpasteCommand`.

   - In the `execute` method validate that the input parameters' count match the expected count. Next, they should be extracted and parsed, and after that used to create the Shampoo/Toothpaste.

    > *Hint*: Look at `CreateCategoryCommand` if you get stuck.

1. Implement methods in `CommandFactoryImpl`.

   - This is where we connect the incoming command from the console with the class that implements that certain command.

1. Implement the `print()` methods

**6. ADVANCED TASK**

- Implement new product and its creation in the engine class.
- Cream (name, brand, price, gender, scent)
  - name minimum 3 symbols and maximum 15
  - brand minimum 3 symbols and maximum 15
  - price greater than zero
  - gender (men, women, unisex)
  - scent (lavender, vanilla, rose)
- Implement product creation in the Factory and the Repository
  - Just look at the other products
- Test it if it works correctly

### Input example

```none
CreateShampoo MyMan Nivea 10.99 Men 1000 Every_Day
CreateToothpaste White Colgate 10.99 Men calcium,fluorid
CreateCategory Shampoos
CreateCategory Toothpastes
AddToCategory Shampoos MyMan
AddToCategory Toothpastes White
AddToShoppingCart MyMan
AddToShoppingCart White
ShowCategory Shampoos
ShowCategory Toothpastes
TotalPrice
RemoveFromCategory Shampoos MyMan
ShowCategory Shampoos
RemoveFromShoppingCart MyMan
TotalPrice
Exit
```

### Output Example

```none
Shampoo with name MyMan was created!
Toothpaste with name White was created!
Category with name Shampoos was created!
Category with name Toothpastes was created!
Product MyMan added to category Shampoos!
Product White added to category Toothpastes!
Product MyMan was added to the shopping cart!
Product White was added to the shopping cart!
#Category: Shampoos
#MyMan Nivea
 #Price: $10.99
 #Gender: Men
 #Milliliters: 1000
 #Usage: EveryDay
 ===
#Category: Toothpastes
#White Colgate
 #Price: $10.99
 #Gender: Men
 #Ingredients: [calcium, fluorid]
 ===
$21.98 total price currently in the shopping cart.
Product MyMan removed from category Shampoos!
#Category: Shampoos
 #No product in this category
Product MyMan was removed from the shopping cart!
$10.99 total price currently in the shopping cart.
```
