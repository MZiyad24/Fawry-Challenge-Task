package Components.Cart;

import Components.Product.Product;
import Components.Market.Market;
import Components.Interface.*;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static java.lang.System.console;
import static java.lang.System.in;

public class Cart {
    public List<Product> items = new ArrayList<>();
    private Market market;

    public Cart(Market market){
        this.market=market;

    }

    public void add(String product, int quantity)
    {
        if(market.getStockQuantity(product)>=quantity && quantity>0)
        {
            Product product1 = market.getProduct(product);
            if(product1 instanceof Expireable)
            {
                if (((Expireable) product1).getExpirityDate().isBefore(LocalDate.now())) {
                    System.out.println("This item: " + product1.getName() + " is Expired!");
                    System.exit(0);
                }

            }
            Product cloned = product1.clone(quantity);
            items.add(cloned);
            market.removeFromStock(product,quantity);
        }
        else {
            System.out.println(product + " quantity isn't available in stock!.");
            System.exit(0);
        }
    }

    public List<Product> getItems() {
        return items;
    }

    public int getSize(){
        return this.items.size();
    }

    public boolean isEmpty(){
        return this.items.size() <= 0;
    }

    public Double getTotalCart(){
        Double sum = 0.0 ;
        for ( Product item : this.items){
            sum += item.price*item.getQuantity();
        }
        return sum;
    }
}
