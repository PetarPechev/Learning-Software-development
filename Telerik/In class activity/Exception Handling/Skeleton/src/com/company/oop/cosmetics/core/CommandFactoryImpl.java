package com.company.oop.cosmetics.core;

import com.company.oop.cosmetics.commands.*;
import com.company.oop.cosmetics.core.contracts.CommandFactory;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.utils.ParsingHelpers;

public class CommandFactoryImpl implements CommandFactory {

    private static final String INVALID_COMMAND = "Forth parameter should be one of Men, Women or Unisex.";


    @Override
    public Command createCommandFromCommandName(String commandTypeValue, ProductRepository productRepository) {
        //TODO Validate command format
        CommandType commandType = ParsingHelpers.tryParseEnum(commandTypeValue,
                CommandType.class,
                String.format(INVALID_COMMAND));


        switch (commandType) {
            case CREATECATEGORY:
                return new CreateCategoryCommand(productRepository);
            case CREATEPRODUCT:
                return new CreateProductCommand(productRepository);
            case ADDPRODUCTTOCATEGORY:
                return new AddProductToCategoryCommand(productRepository);
            case SHOWCATEGORY:
                return new ShowCategoryCommand(productRepository);
            default:
                throw new IllegalArgumentException(INVALID_COMMAND);
        }
    }

}
