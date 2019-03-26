package ca.bcit.infosys;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class DbConnector {
    public static void main (String args[]) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("Driver failed to load.");
            return;
        }

        Properties properties = new Properties();
        InputStream input = null;

        String user = null;
        String password = null;
        Connection conn = null;

        try {
            input = new FileInputStream("credentials.properties");
            properties.load(input);
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection("jdbc:mysql:///inventory",user,password);

            int userExecution = 0;
            Scanner scan = new Scanner(System.in);
            SupplierController supplierController = new SupplierController();

            do {
                System.out.println("Lab 6, Supplier");
                System.out.println("Enter the number that you want to execute:");
                System.out.println("1: Prints the list of suppliers");
                System.out.println("2: Add a supplier");
                System.out.println("3: Edit one supplier");
                System.out.println("4: Delete one supplier");
                System.out.println("5: Search supplier by ID");
                System.out.println("6: Search supplier by Name");
                System.out.println("7: Quit");

                userExecution = scan.nextInt();

                switch (userExecution) {
                    case 1:
                        supplierController.getAll(conn);
                        break;
                    case 2:
                        supplierController.askToAdd(conn);
                        break;
                    case 3:
                        supplierController.askToEdit(conn);
                        break;
                    case 4:
                        supplierController.askToDelete(conn);
                        break;
                    case 5:
                        supplierController.askToSearchById(conn);
                        break;
                    case 6:
                        supplierController.askToSearchByName(conn);
                        break;
                    default:
                        break;
                }

            } while (userExecution == 1 || userExecution == 2 || userExecution == 3 || userExecution == 4
                    || userExecution == 5 || userExecution == 6);

            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
}


