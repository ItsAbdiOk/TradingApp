public class Agent{

    private static Account acc;



    public Agent(String Name){
        acc = new Account(Name);
    }

//this is a constructor
    public String GetUserInfo(){
        String text = "";
        text += "Name: " + acc.GetName() + "\n";
        text += "Funds: " + acc.GetBalance() + "\n";

        return text;
    }
//this is a constructor

    public String BuyShares(String StockName){
        String found = "";
        for (int i = 0; i <3; i++) {
            Stocks U = acc.ArrayGetter(i);
            if (U.GetStockName().equals(StockName)) {
                found = acc.BuyStocks(U);
            }
        }
        return found;
    }
//this buys shares
    public String SellShares( String StockName){
        String found = "";
        for (int i = 0; i <3; i++) {
            Stocks U = acc.ArrayGetter(i);
            if (U.GetStockName().equals(StockName)) {
                found = acc.SellStocks(U);
            }
        }
        return found;
    }
//this sells shares
    public String SeeWallet(){
        String text = acc.SeeWallet();
        return text;
    }
//this shows what stocks are owned
    public void addStock(Stocks S){
        acc.AddStockToArray(S);
    }
//this adds stock to the stock exchange
    public void deposit(int amount){
        acc.deposit(amount);
    }
//deposits money
    public void withdraw(int amount){
        if (amount <= acc.GetBalance()){
            acc.withdraw(amount);
        }
    }
//withdraws money  
}