## OOP Workshop - Cosmetics Shop 1

### Preface

Before you start coding, read this document from top to bottom. It has some valuable information that will make your work way easier.

### Description

You are given a software system that is used to manage a cosmetics shop. The system already has a working Engine. You can explore how it works, but you do not have to modify anything in it.

Each product in the system has **name, brand, price and gender**.

There are **categories** of products. Each **category** has **name** and products can be **added or removed** from it. The same product can be added to a category more than once.

There is also a **shopping cart**. Products can be **added or removed** from it. The same product can be added to the shopping cart more than once. The shopping cart can calculate the **total price** of all products in it.

> *Note: We haven't yet talked about exceptions but all you need to know for now is that they are there to indicate if something goes wrong. If you write `throw new IllegalArgumentException()`, you are "throwing and exception".*

### Objective

Your task is to **design an object-oriented class hierarchy** to model the cosmetics shop, **using the best practices for object-oriented design** (OOD) and **object-oriented programming** (OOP). Encapsulate correctly all fields and use validation whenever needed.

#### 1. The `Product` class

- Minimum product name’s length is 3 symbols and maximum is 10 symbols.
- Minimum brand name’s length is 2 symbols and maximum is 10 symbols.
- Price cannot be negative.
- Gender type can be one of "Men", "Women" or "Unisex".

#### 2. The `Category` class

- Minimum category name’s length is 2 symbols and maximum is 15 symbols.
- Adding the same product to one category more than once is allowed.
- When removing product from category, if the product is not found you should throw an exception.
- Category’s `print` method should return text in the following format:

```
#Category: {category name}
 #Name Brand
 #Price: {price}
 #Gender: {genderType}
 ===
 #Name Brand
 #Price: {price}
 #Gender: {genderType}
 ===
```

```
#Category: Shampoos
 #No product in this category
```

#### 3. The `ShoppingCart` class

- Adding the same product more than once is allowed.
- When removing a product from the shopping cart throw an exception if it is not in it.

### Constraints

- Look into the example below to get better understanding of the printing format.
- Format all floating-point values to have two digits after the decimal point ([*hint*](https://www.google.com/search?q=java+format+two+decimal+places)).

> *Hint: Use exceptions for validation (research how to throw `IllegalArgumentException`).*

> *Hint: Check out the `ValidationHelpers` class. It has some methods that might be useful.*

### Additional notes

- To simplify your work you are given an already built execution engine that executes a sequence of commands read from the console using the classes and interfaces in your project (see the `CosmeticsEngineImpl` class).
- Put your classes in the `models` package.

### Input example

```
CreateProduct MyMan Nivea 10.99 Men
CreateCategory Shampoos
AddToCategory Shampoos MyMan
AddToShoppingCart MyMan
ShowCategory Shampoos
TotalPrice
RemoveFromCategory Shampoos MyMan
ShowCategory Shampoos
RemoveFromShoppingCart MyMan
TotalPrice
Exit
```

### Output Example

```
Product with name MyMan was created!
Category with name Shampoos was created!
Product MyMan added to category Shampoos!
Product MyMan was added to the shopping cart!
#Category: Shampoos
 #MyMan Nivea
 #Price: $10.99
 #Gender: MEN
 ===
$10.99 total price currently in the shopping cart!
Product MyMan removed from category Shampoos!
#Category: Shampoos
 #No product in this category
Product MyMan was removed from the shopping cart!
No product in shopping cart!
```

### Unit Tests

- You have been given unit tests to keep track off your progress. Run them by right-clicking the `tests` package and selecting `Run 'All Tests'`.
- Should you get stuck, check out the tests' names to guide you what you should do.

## Step by step guide

> *Hint: You don't need to modify the `Engine` class and the `main()` method but of course you could try to understand how they work.*

> *Hint: Run the tests whenever you finish a task to check if it's implemented correctly.*

1. Start with the `Product` class
   - Apply the Encapsulation principle to all the fields (make sure all fields are private, add provide getters and setters for them).

1. Navigate to the `CosmeticsRepositoryImpl` class

    - Implement the `find` methods - they should go through the respective collections and return the item that has the given name. What should happen if there is no item with that name? Maybe throw an exception?
    - Implement the `create` methods - they accept the needed arguments to create a category or a product.
    - Implement the `exists` methods - they go through the respective collections and return `true` if there is an item that has the given name.

1. Finish the `ShoppingCart` class

    - Encapsulate it (don't allow direct access to it).
    - Initialize the `products` collection.

    ```java
    public ShoppingCart() {
        product = new ArrayList<Product>();
    }
    ```

    - Implement the methods that add or remove products from the collection.

1. Finish the `Category` class

   - Initialize the collection.
   - Implement the methods that add or remove products from the collection.

1. Implement `print()` methods in both the `Category` and `Product` classes.

   - To test the `print()` method you need to run the application, pass the sample input and check the output.
