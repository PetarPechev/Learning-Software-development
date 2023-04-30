package com.company.oop.cosmetics.tests.models;

import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.CategoryImpl;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.ProductImpl;
import com.company.oop.cosmetics.models.contracts.Category;
import com.company.oop.cosmetics.models.contracts.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class CategoryImplTests {

    private static final String VALID_NAME = "ValidName";
    private static final String INVALID_SHORT_NAME = "No";
    private static final String INVALID_LONG_NAME = "InvalidLongName";


    private Category category;
    private Product product;


    @BeforeEach
    public void setUp() {
        category = new CategoryImpl(VALID_NAME);
        product = new ProductImpl("name", "brand", 3.14, GenderType.MEN);
    }
    @Test
    public void constructor_Should_InitializeName_When_ArgumentsAreValid() {
        assertEquals(VALID_NAME, category.getName());
    }

    @Test
    public void constructor_Should_InitializeProducts_When_ArgumentsAreValid() {
        assertNotNull(category.getProducts());
    }

    @Test
    public void constructor_Should_ThrowException_When_NameIsShorterThanExpected() {
        assertThrows(InvalidUserInputException.class,
                () -> new CategoryImpl(INVALID_SHORT_NAME));
    }

    @Test
    public void constructor_Should_ThrowException_When_NameIsLongerThanExpected() {
        assertThrows(InvalidUserInputException.class,
                () -> new CategoryImpl(INVALID_LONG_NAME));
    }

    @Test
    public void addProduct_Should_AddProductToList() {
        category.addProduct(product);

        assertEquals(1, category.getProducts().size());
        assertEquals(product, category.getProducts().get(0));
    }

    @Test
    public void removeProduct_Should_RemoveProductFromList_When_ProductExist() {
        category.addProduct(product);
        category.removeProduct(product);

        assertEquals(0, category.getProducts().size());
    }

    @Test
    public void removeProduct_should_notRemoveProductFromList_when_productNotExist() {
        Product product2 = new ProductImpl("name2", "brand2", 3.14, GenderType.MEN);

        category.addProduct(product);
        category.removeProduct(product2);

        assertEquals(1, category.getProducts().size());
    }

    @Test
    public void print_should_printNoProductsInThisCategory_when_productDoesntExist() {
        String output = String.format(
                "#Category: %s%n" +
                        " #No product in this category",
                category.getName());

        assertEquals(output, category.print());
    }

    @Test
    public void print_should_printProductsInThisCategory_when_productsExist() {
        Product product2 = new ProductImpl("name2", "brand2", 3.14, GenderType.MEN);
        category.addProduct(product);
        category.addProduct(product2);

        StringBuilder result = new StringBuilder();
        result.append(String.format("#Category: %s%n", category.getName()));

        for (Product productFromCategory : category.getProducts()) {
            result.append(productFromCategory.print())
                    .append(String.format(" ===%n"));
        }

        assertEquals(result.toString(), category.print());
    }

}
