package com.company.oop.cosmetics.tests.commands;

import com.company.oop.cosmetics.commands.CreateProductCommand;
import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.core.contracts.ProductRepository;

import com.company.oop.cosmetics.exceptions.DuplicateEntityException;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.GenderType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CreateProductCommandTests {
    private ProductRepository productRepository;
    private Command command;


    @BeforeEach
    public void setUp() {
        productRepository = new ProductRepositoryImpl();
        command = new CreateProductCommand(productRepository);
    }

    @Test
    public void execute_Should_AddNewProductToTheRepository_When_ValidParameters() {
        List<String> parameters = new ArrayList<>(
                List.of("Name", "Brand", "3.14", "MEN"));

        String result = "Product with name Name was created!";

        assertEquals(result, command.execute(parameters));
        assertEquals(1, productRepository.getProducts().size());
    }


    @Test
    public void execute_Should_ThrowException_When_DuplicateProductName() {
        List<String> parameters = new ArrayList<>(
                List.of("Name", "Brand", "3.14", "MEN"));

        productRepository.createProduct(
                "Name",
                "Brand",
                3.14,
                GenderType.MEN
        );

        assertThrows(DuplicateEntityException.class,
                () -> command.execute(parameters));
    }

    @Test
    public void execute_Should_ThrowException_When_MissingParameters() {
        List<String> parameters = new ArrayList<>();

        assertThrows(InvalidUserInputException.class,
                () -> command.execute(parameters));
    }

    @Test
    public void execute_Should_ThrowException_When_PriceIsNotValid() {
        List<String> parameters = new ArrayList<>(
                List.of("Name", "Brand", "INVALID PRICE", "MEN"));

        assertThrows(InvalidUserInputException.class,
                () -> command.execute(parameters));
    }

    @Test
    public void execute_Should_ThrowException_When_GenderTypeIsNotValid() {
        List<String> parameters = new ArrayList<>(
                List.of("Name", "Brand", "3.14", "INVALID GENDER TYPE"));

        assertThrows(InvalidUserInputException.class,
                () -> command.execute(parameters));
    }
}
