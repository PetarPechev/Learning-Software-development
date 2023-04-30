package com.company.oop.cosmetics.tests.commands;

import com.company.oop.cosmetics.commands.ShowCategoryCommand;
import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ShowCategoryCommandTests {
    private ProductRepository productRepository;
    private Command command;

    @BeforeEach
    public void setUp() {
        productRepository = new ProductRepositoryImpl();
        command = new ShowCategoryCommand(productRepository);
    }

    @Test
    public void execute_should_showCategory_when_parametersAreValid() {
        List<String> parameters = new ArrayList<>(List.of("category"));

        productRepository.createCategory(parameters.get(0));

        String result = productRepository.getCategories().get(0).print();

        assertEquals(result, command.execute(parameters));
    }

    @Test
    public void execute_should_throwException_when_invalidParametersCount() {
        List<String> parameters = new ArrayList<>();

        assertThrows(InvalidUserInputException.class,
                () -> command.execute(parameters));
    }

}
