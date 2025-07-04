package Components.Market;

import Components.Cart.Cart;
import Components.Interface.Expireable;
import Components.Interface.Shipabble;
import Components.Product.Product;
import Components.Customer.Customer;
import Components.ShippingService.ShippingService;

import java.util.*;

public class Market {
    public List<Product> stock;

    public Market(){
        this.stock=new ArrayList<>();
    }

    public Cart createCart() {
        return new Cart(this);
    }

    public void addToStock(Product product)
    {
        boolean exist = false;
        if(!stock.isEmpty()) {
            ListIterator<Product> iterator = stock.listIterator();
            while (iterator.hasNext()) {
                Product item = iterator.next();
                if (item.equals(product)) {
                    exist = true;
                    item.setQuantity(item.quantity + product.quantity);
                    break;
                }
            }
        }
        if(!exist)
            stock.add(product);
    }

    public int getStockQuantity(String product){
        for(Product item : stock)
        {
            if(item.getName()==product)
            {
                return item.getQuantity();
            }
        }
        return 0;
    }

    public Product getProduct(String product)
    {
        for ( Product item : stock)
        {
            if(item.getName().equals(product))
                return item;
        }
        return null;
    }

    public void removeFromStock(String product, int quantity)
    {
        for ( Product item : stock)
        {
            if(item.getName().equals(product))
                item.setQuantity(item.getQuantity()-quantity);
        }
    }
    public void checkout(Customer customer, Cart cart)
    {
        if(cart.isEmpty()) throw new Error("Components.Cart.Cart is Empty!");
        List<Product> items = cart.getItems();

        ShippingService service = new ShippingService();
        Double shipFees = service.getShippingFees(items);
        Double total = shipFees + cart.getTotalCart();

        if(customer.getBalance() < total) {
            System.out.println("insufficient balance!\nneeded:"
                    + total + " found: " + customer.getBalance());
            System.exit(0);
        }

        service.getShipmentStatement(items);

        System.out.println("\n** Checkout receipt **");
        for(Product item : items)
        {
            System.out.println(item.getQuantity()+
                    "x "+item.getName()+"\t"+(item.getPrice()*item.getQuantity()));
        }
        System.out.println("----------------------\n" +
                "Subtotal:\t"+cart.getTotalCart()+'\n'+
                "Shipping:\t"+shipFees+'\n'+
                "Amount:\t"+total+"\n");

        customer.pay(total);
    }

    public List<Shipabble> getShipabbles(){
        List<Shipabble> list = new ArrayList<>();
        for(Product item : stock)
        {
            if(item instanceof Shipabble)
                list.add((Shipabble) item);
        }
        return list;
    }

    public List<Expireable> getExpireables(){
        List<Expireable> list = new ArrayList<>();
        for(Product item : stock)
        {
            if(item instanceof Expireable)
                list.add((Expireable) item);
        }
        return list;
    }

}
