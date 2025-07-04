import static java.lang.System.in;

public class Cart {
    public Product[] items;

    public Cart(){}
    public Cart(Product[] items) {
        this.items = items;
    }

    public void add(Product product, Number quantity)
    {

    }

    public Product[] getItems() {
        return items;
    }

    public int getSize(){
        return this.items.length;
    }

    public boolean isEmpty(){
        return this.items.length <= 0;
    }

    public Double getTotalCart(){
        Double sum = 0.0 ;
        for ( Product item : this.items){
            sum += item.price;
        }
        return sum;
    }
}
