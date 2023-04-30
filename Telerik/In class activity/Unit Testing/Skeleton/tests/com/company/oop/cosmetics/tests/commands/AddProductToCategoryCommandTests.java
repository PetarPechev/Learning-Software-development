package com.company.oop.cosmetics.tests.commands;

import com.company.oop.cosmetics.commands.AddProductToCategoryCommand;
import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.GenderType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class AddProductToCategoryCommandTests {
    private ProductRepository productRepository;
    private Command command;


    @BeforeEach
    public void setUp() {
        productRepository = new ProductRepositoryImpl();
        command = new AddProductToCategoryCommand(productRepository);

        productRepository.createCategory("Category");

        productRepository.createProduct("Product",
                "Brand",
                3.14,
                GenderType.MEN);

    }
    @Test
    public void execute_Should_AddProductToTheCategory_When_ValidParameters() {
        List<String> parameters = new ArrayList<>(
                List.of("Category", "Product"));

        String result = "Product Product added to category Category!";

        assertEquals(result, command.execute(parameters));
        assertEquals(1, productRepository.getProducts().size());
    }

    @Test
    public void execute_Should_ThrowException_When_InvalidParameters() {
        List<String> parameters = new ArrayList<>();

        assertThrows(InvalidUserInputException.class,
                () -> command.execute(parameters));
    }

}
