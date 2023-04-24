package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.utils.ParsingHelpers;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.List;

public class CreateProductCommand implements Command {

    private static final String PRODUCT_CREATED = "Product with name %s was created!";
    private static final String PRODUCT_ALREADY_EXISTS = "Product %s already exists!";

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 4;


    private final ProductRepository productRepository;

    private String name;
    private String brand;
    private double price;
    private GenderType gender;

    public CreateProductCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        //TODO Validate parameters count
        validateArguments(parameters);
        parseParameters(parameters);

        String name = parameters.get(0);
        String brand = parameters.get(1);
        //TODO Validate price format
        double price = Double.parseDouble(parameters.get(2));
        //TODO Validate gender format
        GenderType gender = GenderType.valueOf(parameters.get(3).toUpperCase());

        return createProduct(name, brand, price, gender);
    }

    private void parseParameters(List<String> parameters) {

        price = ParsingHelpers.tryParseDouble(parameters.get(2));
    }

    private void validateArguments(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters,
                EXPECTED_NUMBER_OF_ARGUMENTS,
                "CreateProduct");
    }

    private String createProduct(String name, String brand, double price, GenderType gender) {
        //TODO Ensure product name is unique

        if (productRepository.productExist(name)) {
            throw new IllegalArgumentException(String.format(PRODUCT_ALREADY_EXISTS, name));
        }

        productRepository.createProduct(name, brand, price, gender);

        return String.format(PRODUCT_CREATED, name);
    }

}
