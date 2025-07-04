package Components.Customer;

public class Customer {
    public String name;
    public Double balance;

    public Customer(String name, Double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void pay(Double balance)
    {
        setBalance(this.balance-balance);
        System.out.println("payment done successfully." +
                "\n Your current balance is: "+this.balance+"$");
    }
}
