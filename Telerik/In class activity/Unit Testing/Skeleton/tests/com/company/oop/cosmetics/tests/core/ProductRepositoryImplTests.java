package com.company.oop.cosmetics.tests.core;

import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.contracts.Category;
import com.company.oop.cosmetics.models.contracts.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ProductRepositoryImplTests {

    private ProductRepositoryImpl productRepository;

    @BeforeEach
    public void setUp() {
        productRepository = new ProductRepositoryImpl();
        productRepository.createCategory("category");
        productRepository.createProduct("Name", "Brand", 3.14, GenderType.MEN);
    }

    @Test
    public void constructor_Should_InitializeProducts() {
        assertNotNull(productRepository.getProducts());
    }

    @Test
    public void constructor_Should_InitializeCategories() {
        assertNotNull(productRepository.getCategories());
    }

    @Test
    public void getCategories_Should_ReturnCopyOfCollection() {
        productRepository.createCategory("category2");

        List<Category> categoriesCopy = productRepository.getCategories();

        assertNotSame(productRepository.getCategories(), categoriesCopy);
        assertEquals(productRepository.getCategories().size(), categoriesCopy.size());
        assertEquals(productRepository.getCategories(), categoriesCopy);
    }

    @Test
    public void getProducts_Should_ReturnCopyOfCollection() {
        productRepository.createProduct("Name2", "Brand2", 3.14, GenderType.MEN);

        List<Category> productsCopy = productRepository.getCategories();

        assertNotSame(productRepository.getCategories(), productsCopy);
        assertEquals(productRepository.getCategories().size(), productsCopy.size());
        assertEquals(productRepository.getCategories(), productsCopy);
    }

    @Test
    public void categoryExists_Should_ReturnTrue_When_CategoryExists() {
        assertTrue(productRepository.categoryExist("category"));
    }

    @Test
    public void categoryExists_Should_ReturnFalse_When_CategoryDoesNotExist() {
        assertFalse(productRepository.categoryExist("notExist"));
    }

    @Test
    public void productExists_Should_ReturnTrue_When_ProductExists() {
        assertTrue(productRepository.productExist("Name"));
    }

    @Test
    public void productExists_Should_ReturnFalse_When_ProductDoesNotExist() {
        assertFalse(productRepository.productExist("notExist"));
    }

    @Test
    public void createProduct_Should_AddToProducts_When_ArgumentsAreValid() {
        assertEquals(1, productRepository.getProducts().size());
    }

    @Test
    public void createCategory_Should_AddToCategories_When_ArgumentsAreValid() {
        assertEquals(1, productRepository.getCategories().size());
    }

    @Test
    public void findCategoryByName_Should_ReturnCategory_When_Exists() {
        Category foundCategory = productRepository.findCategoryByName("category");

        assertEquals("category", foundCategory.getName());
    }

    @Test
    public void findCategoryByName_Should_ThrowException_When_DoesNotExist() {
        assertThrows(InvalidUserInputException.class,
                () -> productRepository.findCategoryByName("notExist"));
    }

    @Test
    public void findProductByName_Should_ReturnCategory_When_Exists() {
        Product foundProduct = productRepository.findProductByName("Name");

        assertEquals("Name", foundProduct.getName());
    }

    @Test
    public void findProductByName_Should_ThrowException_When_DoesNotExist() {
        assertThrows(InvalidUserInputException.class,
                () -> productRepository.findProductByName("notExist"));
    }

}
