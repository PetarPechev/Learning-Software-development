package com.company.oop.cosmetics.tests.commands;

import com.company.oop.cosmetics.commands.CreateCategoryCommand;
import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.core.contracts.ProductRepository;

import com.company.oop.cosmetics.exceptions.DuplicateEntityException;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CreateCategoryCommandTests {
    private ProductRepository productRepository;
    private Command command;

    @BeforeEach
    public void setUp() {
        productRepository = new ProductRepositoryImpl();
        command = new CreateCategoryCommand(productRepository);
    }

    @Test
    public void execute_Should_AddNewCategoryToRepository_When_ValidParameters() {
        List<String> parameters = new ArrayList<>(List.of("category"));

        String result = command.execute(parameters);

        assertEquals("Category with name category was created!", result);
        assertTrue(productRepository.categoryExist("category"));
    }

    @Test
    public void execute_Should_ThrowException_When_MissingParameters() {
        List<String> parameters = new ArrayList<>();

        assertThrows(InvalidUserInputException.class,
                () -> command.execute(parameters));
    }

    @Test
    public void execute_Should_ThrowException_When_DuplicateCategoryName() {
        List<String> parameters = new ArrayList<>(List.of("category"));

        productRepository.createCategory("category");

        assertThrows(DuplicateEntityException.class,
                () -> command.execute(parameters));
    }

}
