package com.company.oop.cosmetics.tests.models;

import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.ProductImpl;
import com.company.oop.cosmetics.models.contracts.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ProductImplTests {

    private static final String VALID_NAME = "ValidName";
    private static final String INVALID_SHORT_NAME = "No";
    private static final String INVALID_LONG_NAME = "InvalidLongName";
    private static final String VALID_BRAND = "ValidBrand";
    private static final String INVALID_SHORT_BRAND = "N";
    private static final String INVALID_LONG_BRAND = "InvalidLongBrand";
    private static final double VALID_PRICE = 3.14;
    private static final double INVALID_PRICE = -3.14;

    @Test
    public void constructor_should_createProduct_when_argumentsAreValid() {
        Product product = new ProductImpl(VALID_NAME, VALID_BRAND, VALID_PRICE, GenderType.MEN);

        assertEquals(VALID_NAME, product.getName());
        assertEquals(VALID_BRAND, product.getBrand());
        assertEquals(VALID_PRICE, product.getPrice());
        assertEquals(GenderType.MEN, product.getGender());
    }

    @Test
    public void should_throwException_when_productNameIsShorterThanExpected() {
        assertThrows(InvalidUserInputException.class,
                () -> new ProductImpl(INVALID_SHORT_NAME, VALID_BRAND, VALID_PRICE, GenderType.MEN));
    }

    @Test
    public void should_throwException_when_productNameIsLongerThanExpected() {
        assertThrows(InvalidUserInputException.class,
                () -> new ProductImpl(INVALID_LONG_NAME, VALID_BRAND, VALID_PRICE, GenderType.MEN));
    }

    @Test
    public void should_throwException_when_productBrandIsShorterThanExpected() {
        assertThrows(InvalidUserInputException.class,
                () -> new ProductImpl(VALID_NAME, INVALID_SHORT_BRAND, VALID_PRICE, GenderType.MEN));
    }

    @Test
    public void should_throwException_when_productBrandIsLongerThanExpected() {
        assertThrows(InvalidUserInputException.class,
                () -> new ProductImpl(VALID_NAME, INVALID_LONG_BRAND, VALID_PRICE, GenderType.MEN));
    }

    @Test
    public void should_throwException_when_priceIsNegativeNumber() {
        assertThrows(InvalidUserInputException.class,
                () -> new ProductImpl(VALID_NAME, VALID_BRAND, INVALID_PRICE, GenderType.MEN));
    }

    @Test
    public void should_printProduct_when_productExists() {
        Product product = new ProductImpl(VALID_NAME, VALID_BRAND, VALID_PRICE, GenderType.MEN);

        String result = String.format(
                "#%s %s%n" +
                        " #Price: $%.2f%n" +
                        " #Gender: %s%n",
                product.getName(),
                product.getBrand(),
                product.getPrice(),
                product.getGender());

        assertEquals(result, product.print());
    }


}
