package Components.ShippingService;

import Components.Interface.Shipabble;
import Components.Product.Product;

import java.util.List;

public class ShippingService {

    private int amountPerKG = 5;

    public ShippingService() {

    }


    public Double getShippingFees(List<Product>products)
    {
        Double sum = 0.0;
        for(Product item : products)
        {
            if(item instanceof Shipabble)
            {
                sum+=(((Shipabble) item).getWeight()*item.getQuantity())*amountPerKG;
            }
        }

        return sum;
    }

    public void getShipmentStatement(List<Product>products){
        System.out.println("** Shipment notice **\n");
        Double sum = 0.0;
        Double weight = 0.0;
        for(Product item : products)
        {
            if(item instanceof Shipabble)
            {
                sum+=((Shipabble) item).getWeight()*amountPerKG*item.getQuantity();
                weight+=((Shipabble) item).getWeight();
                System.out.println(item.getQuantity()+"x "+item.getName()+"\t"+((Shipabble) item).getWeight());
            }
        }
        System.out.println("Total Package Weight: "+weight+"KG");
    }
}
