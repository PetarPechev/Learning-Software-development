package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.UsageType;
import com.company.oop.cosmetics.utils.ParsingHelpers;
import com.company.oop.cosmetics.utils.ValidationHelpers;

import java.util.List;


public class CreateShampooCommand implements Command {

    private static final String SHAMPOO_ALREADY_EXISTS = "Shampoo with name %s already exists!";

    private static final String SHAMPOO_CREATED = "Shampoo with name %s was created!";

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 6;

    private final CosmeticsRepository cosmeticsRepository;

    public CreateShampooCommand(CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsRepository = cosmeticsRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);

        createShampoo(parameters);

        return String.format(SHAMPOO_CREATED, parameters.get(0));
    }

    private void createShampoo(List<String> parameters) {
        String name = parameters.get(0);
        String brand = parameters.get(1);
        double price = ParsingHelpers.tryParseDouble(parameters.get(2), ParsingHelpers.INVALID_PRICE);
        GenderType genderType = ParsingHelpers.tryParseGender(parameters.get(3));
        int milliliters = ParsingHelpers.tryParseInt(parameters.get(4), ParsingHelpers.INVALID_MILLILITRES);
        UsageType usageType = ParsingHelpers.tryParseUsageType(parameters.get(5));

        if (cosmeticsRepository.productExist(name)) {
            throw new IllegalArgumentException(String.format(SHAMPOO_ALREADY_EXISTS, name));
        }

        cosmeticsRepository.createShampoo(name, brand, price, genderType, milliliters, usageType);
    }

}
