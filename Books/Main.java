package Books;

import Books.Entityes.Product;
import Books.Model.CRUDProduct;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static Object input;

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        CRUDProduct crudProduct = new CRUDProduct();
        Product product = new Product();


        while (true) {
            System.out.println("1.Them Giu Lieu");
            System.out.println("2.Luu Giu Lieu");
            System.out.println("3.Xoat Giu Lieu");
            System.out.println("4.Thoat");
            String line = scanner.nextLine();
            switch (line) {
                case "1": {
                    System.out.println("Them Giu Lieu");
                    System.out.println("id");
                    int id = scanner.nextInt();
                    System.out.println("name");
                    String name = scanner.next();
                    System.out.println("price");
                    double price = scanner.nextDouble();
                    System.out.println("author");
                    String author = scanner.next();
                    Product product1 = new Product(id, name,author,price);
                    crudProduct.insert(product1);
                    System.out.println("them thanh cong");
                    break;
                }
                case "2": {
                    System.out.println("Luu Giu Lieu");
                    System.out.println("id");
                    int id = scanner.nextInt();
                    System.out.println("name");
                    String name = scanner.next();
                    System.out.println("price");
                    double price = scanner.nextDouble();
                    System.out.println("author");
                    String author = scanner.next();
                    Product product2 = new Product(id, name,author,price);
                    crudProduct.insert(product2);
                    break;
                }

                case "3": {
                    crudProduct.getAll();
                    break;
                }
                case "4": {
                    return;
                }
                default:
                    System.out.println("Thoat Chuong Trinh");
                    continue;
            }
        }
    }
}

