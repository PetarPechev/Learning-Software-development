package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.UsageType;
import com.company.oop.cosmetics.utils.ParsingHelpers;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.Arrays;
import java.util.List;

public class CreateToothpasteCommand implements Command {

    private static final String TOOTHPASTE_ALREADY_EXISTS = "Toothpaste with name %s already exists!";

    private static final String TOOTHPASTE_CREATED = "Toothpaste with name %s was created!";

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 5;

    private final CosmeticsRepository cosmeticsRepository;

    public CreateToothpasteCommand(CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsRepository = cosmeticsRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);

        createToothpaste(parameters);

        return String.format(TOOTHPASTE_CREATED, parameters.get(0));
    }

    private void createToothpaste(List<String> parameters) {
        String name = parameters.get(0);
        String brand = parameters.get(1);
        double price = ParsingHelpers.tryParseDouble(parameters.get(2), ParsingHelpers.INVALID_PRICE);
        GenderType genderType = ParsingHelpers.tryParseGender(parameters.get(3));
        String[] ingredients = parameters.get(4).split(",");

        if (cosmeticsRepository.productExist(name)) {
            throw new IllegalArgumentException(String.format(TOOTHPASTE_ALREADY_EXISTS, name));
        }

        cosmeticsRepository.createToothpaste(name, brand, price, genderType, Arrays.asList(ingredients));
    }

}