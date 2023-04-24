package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.List;

public class CreateCategoryCommand implements Command {

    private static final String CATEGORY_CREATED = "Category with name %s was created!";
    private static final String CATEGORY_ALREADY_EXISTS = "Category %s already exists!";

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;


    private final ProductRepository productRepository;

    public CreateCategoryCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        //TODO Validate parameters count
        validateArguments(parameters);

        String categoryName = parameters.get(0);

        if (productRepository.categoryExist(categoryName)) {
            return String.format(CATEGORY_ALREADY_EXISTS, categoryName);
        }


        return createCategory(categoryName);
    }

    private String createCategory(String categoryName) {
        //TODO Ensure category name is unique

        productRepository.createCategory(categoryName);

        return String.format(CATEGORY_CREATED, categoryName);
    }

    private void validateArguments(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters,
                EXPECTED_NUMBER_OF_ARGUMENTS,
                "CreateCategory");
    }

}
