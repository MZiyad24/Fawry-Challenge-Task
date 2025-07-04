import Components.Cart.Cart;
import Components.Concrete.Cheese;
import Components.Concrete.TV;
import Components.Customer.Customer;
import Components.Market.Market;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        TV sharp = new TV("sharp", 210.0, 10, 2.0);
        TV toshiba = new TV("toshiba", 250.0, 12, 3.6);
        Cheese president = new Cheese("president", 10.0, 500, LocalDate.of(2025, 12, 31), 0.5);
        Cheese parmizan = new Cheese("parmizan", 50.0, 60, LocalDate.of(2025, 4, 20), 2.0);
        market.addToStock(sharp);
        market.addToStock(toshiba);
        market.addToStock(president);
        market.addToStock(parmizan);

        System.out.println("----Test Case: Successful Checkout----");
        try {
            Cart cart = market.createCart();

            cart.add(president.getName(), 200);
            Customer ziyad = new Customer("Ziyad", 2500.0);

            market.checkout(ziyad, cart);

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n----Test Case: Insufficient Balance----\n");
        try{
            Cart cart = market.createCart();
            cart.add(sharp.getName(), 1);
            Customer customer1 = new Customer("ahmed", 200.0);
            market.checkout(customer1, cart);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n----Test Case: Insufficient Quantity in Stock----\n");
        try{
            Cart cart = market.createCart();
             Cheese kraft = new Cheese("kraft", 50.0, 0, LocalDate.of(2025, 4, 20), 2.0);

            market.addToStock(kraft);
            cart.add("kraft",1);
            Customer customer2 = new Customer("customer2",1000.0);
            market.checkout(customer2,cart);

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n----Test Case: Expired Product----\n");
        try{
            Cart cart = market.createCart();

            cart.add("parmisan",1);
            Customer customer3 = new Customer("customer3",1000.0);
            market.checkout(customer3,cart);

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n----Test Case: Empty Cart----\n");
        try{
            Cart cart = market.createCart();

            Customer customer4= new Customer("customer4",1000.0);
            market.checkout(customer4,cart);

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }
}

