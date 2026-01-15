package Mattiazerbini;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Mattiazerbini.entities.Customer;
import Mattiazerbini.entities.Order;
import Mattiazerbini.entities.Product;

public class Application {



    public static void main(String[] args) {
            Product p1 = new Product( 1L, "La bella addormentata", "Books", 13.00);
            Product p2 = new Product( 2L, "Dumbo", "Baby", 40.00);
            Product p3 = new Product( 3L, "Pallone", "Boys", 20.00);
            Product p4 = new Product( 4L, "Playsytion", "Boys", 300.00);
            Product p5 = new Product( 5L, "Peter Pan", "Books", 120.00);
            Product p6 = new Product( 6L, "Puzzle ", "Baby", 10.00);

            //Listof serve a creare una lista invariabile di elementi, in modo rapido e corto
            List<Product> products = List.of(p1,p2,p3,p4,p5,p6);

            Customer c1 = new Customer(7L, "Paolo", 1);
            Customer c2 = new Customer(8L, "Antonio", 3);
            Customer c3 = new Customer(9L, "Giangiorgio", 2);


            //LocalDate.of crea una data specifica e usa anno-mese-giorno
            Order o1 = new Order(10L, "In arrivo", LocalDate.of(2025, 1, 10), LocalDate.of(2025, 1, 15), List.of(p2, p5), c1);
            Order o2 = new Order(11L, "Imballaggio", LocalDate.of(2025, 1, 14), LocalDate.of(2025, 1, 21), List.of(p3), c2);
            Order o3 = new Order(12L, "Consegnato al corriere", LocalDate.of(2025, 1, 12), LocalDate.of(2025, 1, 18), List.of(p4, p1, p6), c3);
            Order o4 = new Order(13L, "In consegna", LocalDate.of(2025, 1, 13), LocalDate.of(2025, 1, 19), List.of(p1, p3, p6), c1);

            List<Order> orders = List.of(o1, o2, o3, o4);



        System.out.println("ESERCIZIO 1: ");
        Map<Customer, List<Order>> ordiniPerCliente =
                orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));
                ordiniPerCliente.forEach((customer, customerOrders)
                -> System.out.println(customer.getName() + " ha effettuato " + customerOrders.size() + " ordini"));
    }
}
