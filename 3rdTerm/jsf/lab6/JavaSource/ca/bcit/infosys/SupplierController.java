package ca.bcit.infosys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SupplierController {

    List<Integer> supplierNumberList = new ArrayList<>();
    List<String> supplierColumnList = new ArrayList<>();

    public SupplierController() {

    }

    public void getAll(Connection conn) throws SQLException {
        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM inventory.suppliers");

            ResultSetMetaData rsmd = result.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            Supplier supplier;
            Map<String, String> supplierMap;

            while (result.next()) {
                supplierMap = new HashMap<>();
                for (int i = 1; i <= columnsNumber; i++) {
                    supplierMap.put(rsmd.getColumnName(i), result.getString(i));
                }
                supplier = new Supplier(supplierMap);
                System.out.println(supplier);
            }

         } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void askToAdd(Connection conn) throws SQLException {
        Scanner scan = new Scanner(System.in);
        Integer supplierNumber = null;
        ResultSet result = null;

        do {
            System.out.print("Enter supplier ID that does not exist in database, reprompt if it exists: ");

            try {
                supplierNumber = scan.nextInt();
            } catch (Exception e) {
                System.out.println("You should enter a number");
                return;
            }

            Statement stmt = conn.createStatement();
            result = stmt.executeQuery("SELECT * FROM inventory.suppliers WHERE SUPPLIERID=" + supplierNumber);

        } while (result.next());

        Map<String, String> userInput = new HashMap<>();

        userInput.put("SupplierID", supplierNumber.toString());
        System.out.println("Enter supplier name: ");
        userInput.put("SupplierName", scan.next());
        System.out.println("Enter contact name: ");
        userInput.put("ContactName", scan.next());
        System.out.println("Enter contact title: ");
        userInput.put("ContactTitle", scan.next());
        System.out.println("Enter address: ");
        userInput.put("Address", scan.next());
        System.out.println("Enter city: ");
        userInput.put("City", scan.next());
        System.out.println("Enter postal code: ");
        userInput.put("PostalCode", scan.next());
        System.out.println("Enter state or province: ");
        userInput.put("StateOrProvince", scan.next());
        System.out.println("Enter country: ");
        userInput.put("Country", scan.next());
        System.out.println("Enter phone number: ");
        userInput.put("PhoneNumber", scan.next());
        System.out.println("Enter fax number: ");
        userInput.put("FaxNumber", scan.next());
        System.out.println("Enter payment terms: ");
        userInput.put("PaymentTerms", scan.next());
        System.out.println("Enter email address: ");
        userInput.put("EmailAddress", scan.next());
        System.out.println("Enter notes: ");
        userInput.put("Notes", scan.next());

        Supplier supplier = new Supplier(userInput);

        System.out.println(supplier);

        try {
            String insertTable = "INSERT INTO inventory.suppliers "
                    + "(SUPPLIERID, SUPPLIERNAME, CONTACTNAME, CONTACTTITLE, ADDRESS, CITY, POSTALCODE,"
                    + "STATEORPROVINCE, COUNTRY, PHONENUMBER, FAXNUMBER, PAYMENTTERMS, EMAILADDRESS, "
                    + "NOTES) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertTable);
            preparedStatement.setInt(1, supplier.getSupplierId());
            preparedStatement.setString(2,  supplier.getSupplierName());
            preparedStatement.setString(3,  supplier.getContactName());
            preparedStatement.setString(4,  supplier.getContactTitle());
            preparedStatement.setString(5,  supplier.getAddress());
            preparedStatement.setString(6,  supplier.getCity());
            preparedStatement.setString(7,  supplier.getPostalCode());
            preparedStatement.setString(8,  supplier.getStateOrProvince());
            preparedStatement.setString(9,  supplier.getCountry());
            preparedStatement.setString(10,  supplier.getPhoneNumber());
            preparedStatement.setString(11,  supplier.getFaxNumber());
            preparedStatement.setString(12,  supplier.getPaymentTerms());
            preparedStatement.setString(13,  supplier.getEmailAddress());
            preparedStatement.setString(14,  supplier.getNotes());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void askToEdit(Connection conn) throws SQLException {
        Scanner scan = new Scanner(System.in);
        Integer supplierNumber;
        ResultSet result;

        do {
            System.out.print("Enter supplier ID that does exist in database, reprompt if it does not exist: ");

            try {
                supplierNumber = scan.nextInt();
            } catch (Exception e) {
                System.out.println("You should enter a number");
                return;
            }

            Statement stmt = conn.createStatement();
            result = stmt.executeQuery("SELECT * FROM inventory.suppliers WHERE SUPPLIERID=" + supplierNumber);

        } while (!result.next());

        System.out.print("Enter the column you want to change : ");
        String columnToChange = scan.next();
        System.out.print("Enter the new value you want to put : ");
        String columnValueToChange = scan.next();

        try {
            String updateRow = "UPDATE inventory.suppliers SET " + columnToChange + "=? WHERE supplierId="
                    + supplierNumber;
            PreparedStatement preparedStatement = conn.prepareStatement(updateRow);
            preparedStatement.setString(1,  columnValueToChange);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void askToDelete(Connection conn) throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the supplier number you want to delete : ");
        Integer supplierNumber = scan.nextInt();

        try {
            String deleteRow = "DELETE FROM inventory.suppliers WHERE supplierId=" + supplierNumber + ";";
            PreparedStatement preparedStatement = conn.prepareStatement(deleteRow);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void askToSearchById(Connection conn) throws SQLException {
        ResultSet result;

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the supplier ID you want to search : ");
        Integer supplierNumber = scan.nextInt();

        Statement stmt = conn.createStatement();
        result = stmt.executeQuery("SELECT * FROM inventory.suppliers WHERE SUPPLIERID=" + supplierNumber);
        ResultSetMetaData rsmd = result.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        Supplier supplier;
        Map<String, String> supplierMap;

        while (result.next()) {
            supplierMap = new HashMap<>();
            for (int i = 1; i <= columnsNumber; i++) {
                supplierMap.put(rsmd.getColumnName(i), result.getString(i));
            }
            supplier = new Supplier(supplierMap);
            System.out.println(supplier);
        }
    }

    public void askToSearchByName(Connection conn) throws SQLException {
        ResultSet result;

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the supplier NAME you want to search : ");
        String supplierName = scan.next();

        String searchName = "SELECT * FROM inventory.suppliers WHERE SUPPLIERNAME LIKE ?";
        PreparedStatement preparedStatement = conn.prepareStatement(searchName);
        preparedStatement.setString(1, "%" + supplierName+"%");
        result = preparedStatement.executeQuery();
        ResultSetMetaData rsmd = result.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        Supplier supplier;
        Map<String, String> supplierMap;

        while (result.next()) {
            supplierMap = new HashMap<>();
            for (int i = 1; i <= columnsNumber; i++) {
                supplierMap.put(rsmd.getColumnName(i), result.getString(i));
            }
            supplier = new Supplier(supplierMap);
            System.out.println(supplier);
        }
    }

}
