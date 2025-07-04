package Components.Concrete;
import Components.Interface.Expireable;
import Components.Interface.Shipabble;
import Components.Product.Product;
import java.time.LocalDate;

public class Cheese extends Product implements Expireable, Shipabble {
    public LocalDate expirityDate;
    public Double weight;
    public Cheese(String name, Double price, int quantity, LocalDate expirityDate, Double weight) {
        super(name, price, quantity);
        this.expirityDate=expirityDate;
        this.weight=weight;
    }

    @Override
    public LocalDate getExpirityDate() {
        return expirityDate;
    }

    @Override
    public Double getWeight() {
        return this.weight;
    }

    @Override
    public Product clone(int quantity) {
        return new Cheese(name,price,quantity,expirityDate,weight);
    }
}
