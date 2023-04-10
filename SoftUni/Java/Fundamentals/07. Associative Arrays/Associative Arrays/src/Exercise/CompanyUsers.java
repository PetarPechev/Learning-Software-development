package Exercise;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> companyUsers = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String company = input.split(" -> ")[0];
            String employeeID = input.split(" -> ")[1];

            addCompanyAndUsers(companyUsers, company, employeeID);

            input = scanner.nextLine();
        }

        printCompanyUsers(companyUsers);
    }

    private static void addCompanyAndUsers(Map<String, List<String>> companyUsers, String company, String employeeID) {
        companyUsers.putIfAbsent(company, new ArrayList<>());

        if (!companyUsers.get(company).contains(employeeID)) {
            companyUsers.get(company).add(employeeID);
        }
    }

    private static void printCompanyUsers(Map<String, List<String>> companyUsers) {
        for (Map.Entry<String, List<String>> company : companyUsers.entrySet()) {
            System.out.println(company.getKey());
            for (String employeeID : company.getValue()) {
                System.out.println("-- " + employeeID);
            }
        }
    }
}
