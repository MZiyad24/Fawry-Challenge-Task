import Components.Cart.Cart;
import Components.Concrete.Cheese;
import Components.Concrete.TV;
import Components.Customer.Customer;
import Components.Market.Market;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();

        Cart cart = market.createCart();

        TV sharp = new TV("sharp",210.0,10,2.0);
        TV toshiba = new TV("toshiba",250.0,12,3.6);
        Cheese president = new Cheese("president",10.0,500, LocalDate.of(2025, 12, 31),0.5);
        Cheese parmizan = new Cheese("parmizan",50.0,60,LocalDate.of(2025,4,20),2.0);
        market.addToStock(sharp);
        market.addToStock(toshiba);
        market.addToStock(president);
        market.addToStock(parmizan);

        cart.add(president.getName(), 200);
        Customer ziyad = new Customer("Ziyad",2500.0);


        market.checkout(ziyad,cart);
    }
}

