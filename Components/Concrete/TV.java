package Components.Concrete;

import Components.Interface.Shipabble;
import Components.Product.Product;

public class TV extends Product implements Shipabble {
    public Double weight;
    public TV(String name, Double price, int quantity, Double weight) {
        super(name, price, quantity);
        this.weight=weight;
    }

    @Override
    public Double getWeight() {
        return this.weight;
    }

    @Override
    public Product clone(int quantity) {
        return new TV(name,price,quantity,weight);
    }
}
