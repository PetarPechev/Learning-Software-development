package com.telerikacademy.core;

import java.util.Scanner;


public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        String[][] usersData = new String[4][2];

        // main loop
        while (!command.equals("end")) {
            String[] commandArgs = command.split(" ");

            // check command
            if (commandArgs[0].equals("register")) {
                registerUser(commandArgs, usersData);
            } else if (commandArgs[0].equals("delete")) {
                deleteUser(commandArgs, usersData);
            }

            // read next command
            command = scanner.nextLine();
        }
    }
    
    private static void registerUser(String[] commandArgs, String[][] usersData) {
        // check for valid data input
        if (!haveValidDataInput(commandArgs)) {
            return;
        }

        // check do username exists
        if (usernameExists(usersData, commandArgs[1])) {
            return;
        }

        // find free slot
        int freeSlotIndex = getFreeSlotIndex(usersData);

        // no free slots
        if (!haveFreeSlot(freeSlotIndex)) {
            return;
        }

        // save user
        saveUser(commandArgs[1], commandArgs[2], freeSlotIndex, usersData);
    }
    private static void deleteUser(String[] commandArgs, String[][] usersData) {
        // check for accurate data input
        if (!haveValidDataInput(commandArgs)) {
            return;
        }

        // find account to delete
        int accountIndex = findAccToDelete(commandArgs[1], commandArgs[2], usersData);

        // Check do user and password are valid
        if (!isValidAccAndPass(accountIndex)) {
            return;
        }

        // delete user
        removeUser(accountIndex, usersData);
    }

    private static boolean haveValidDataInput(String[] commandArgs) {
        // validate arguments
        if (!haveValidArgumentsCount(commandArgs.length)) {
            return false;
        }

        String username = commandArgs[1];
        String password = commandArgs[2];

        // validate username
        if (!haveValidUsernameLength(username.length())) {
            return false;
        }

        // validate password
        if (!haveValidPasswordLength(password.length())) {
            return false;
        }

        return true;
    }

    private static boolean haveValidArgumentsCount(int argumentsCount) {
        if (argumentsCount < 3) {
            System.out.println(ANSI_RED + "Too few parameters." + ANSI_RESET);

            return false;
        }

        return true;
    }

    private static boolean haveValidUsernameLength(int usernameLength) {
        if (usernameLength < 3) {
            System.out.println(ANSI_RED + "Username must be at least 3 characters long." + ANSI_RESET);
            return false;
        }
        return true;
    }

    private static boolean haveValidPasswordLength(int passwordLength) {
        if (passwordLength < 3) {
            System.out.println(ANSI_RED + "Password must be at least 3 characters long." + ANSI_RESET);
            return false;
        }

        return true;
    }

    private static boolean usernameExists(String[][] usersData, String username) {
        boolean usernameExist = false;

        for (String[] usersDatum : usersData) {
            if (username.equals(usersDatum[0])) {
                usernameExist = true;
                break;
            }
        }

        if (usernameExist) {
            System.out.println(ANSI_RED + "Username already exists." + ANSI_RESET);
            return true;
        }

        return false;
    }

    private static int getFreeSlotIndex(String[][] usersData) {
        int freeSlotIndex = -1;

        for (int i = 0; i < usersData.length; i++) {
            if (usersData[i][0] == null) {
                freeSlotIndex = i;
            }
        }

        return freeSlotIndex;
    }

    private static boolean haveFreeSlot(int freeSlotIndex) {
        if (freeSlotIndex == -1) {
            System.out.println(ANSI_RED + "The system supports a maximum number of 4 users." + ANSI_RESET);
            return false;
        }

        return true;
    }

    private static void saveUser(String username, String password, int freeSlotIndex, String[][] usersData) {
        usersData[freeSlotIndex][0] = username;
        usersData[freeSlotIndex][1] = password;

        System.out.println(ANSI_GREEN + "Registered user." + ANSI_RESET);
    }

    private static int findAccToDelete(String username, String password, String[][] usersData) {
        int accountIndex = -1;

        for (int i = 0; i < usersData.length; i++) {
            if (username.equals(usersData[i][0]) && password.equals(usersData[i][1])) {
                accountIndex = i;
            }
        }

        return accountIndex;
    }

    private static boolean isValidAccAndPass(int accountIndex) {
        if (accountIndex == -1) {
            System.out.println(ANSI_RED + "Invalid account/password." + ANSI_RESET);
            return false;
        }

        return true;
    }

    private static void removeUser(int accountIndex, String[][] usersData) {
        usersData[accountIndex][0] = null;
        usersData[accountIndex][1] = null;

        System.out.println(ANSI_GREEN + "Deleted account." + ANSI_RESET);
    }

}
