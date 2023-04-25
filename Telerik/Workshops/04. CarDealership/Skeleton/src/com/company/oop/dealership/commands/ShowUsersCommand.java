package com.company.oop.dealership.commands;

import com.company.oop.dealership.core.contracts.VehicleDealershipRepository;
import com.company.oop.dealership.models.contracts.User;

import java.util.List;

public class ShowUsersCommand extends BaseCommand {

    public ShowUsersCommand(VehicleDealershipRepository vehicleDealershipRepository) {
        super(vehicleDealershipRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        if (!getVehicleDealershipRepository().getLoggedInUser().isAdmin()) {
            throw new IllegalArgumentException("You are not an admin!");
        }

        return (getUsersAsString(getVehicleDealershipRepository().getUsers()));
    }

    @Override
    protected boolean requiresLogin() {
        return true;
    }
    private String getUsersAsString(List<User> users) {
        StringBuilder sb = new StringBuilder("--USERS--")
                .append(System.lineSeparator());

        for (User user : users) {
            sb.append(users.indexOf(user) + 1).append(". ")
                    .append(user.toString());

            if (!user.equals(users.get(users.size() - 1))) {
                sb.append(System.lineSeparator());
            }
        }

        return sb.toString();
    }

}
