
import java.util.ArrayList;
import java.util.*;
public class Account extends User{


    private int balance;
    private ArrayList<Stocks> StocksWallet = new ArrayList<Stocks>();
    //this is the stocks that someone can own
    Stocks Tesla = new Stocks("Tesla",10, 0);
    Stocks FB = new Stocks("FB",10 , 0);
    Stocks Amazon = new Stocks("Amazon",10 , 0);


//this is a constructor
    public Account( String UserName){
        super(UserName);
        this.balance=0;
        AddStockToArray(Tesla);
        AddStockToArray(FB);
        AddStockToArray(Amazon);
    }
//this is a constructor
    public Account(String UserName ,int balance){
        super(UserName);
        this.balance = balance;
        AddStockToArray(Tesla);
        AddStockToArray(FB);
        AddStockToArray(Amazon);
    }



    public int GetBalance(){
        return this.balance;
    }
//gets balance
    public void deposit(int amount){
        this.balance += amount;
    }
//deposits money
    public void withdraw(int amount){
        this.balance -= amount;
    }
  //withdraws money  
    public String BuyStocks(Stocks BoughtStockName){
        String text = "";
        if (this.GetBalance()> BoughtStockName.GetStockPrice() && BoughtStockName.GetStockName().equals("Tesla") )
        {
            for(Stocks Stock : StocksWallet) {
                if(Stock.GetStockName().equals("Tesla")) {
                    Stock.AddCounter();
                }
            }
            this.withdraw(BoughtStockName.GetStockPrice());
            text = ("Tesla Bought Succesfully");


        }
        else if (this.GetBalance()> BoughtStockName.GetStockPrice() && BoughtStockName.GetStockName().equals("FB") )
        {
            for(Stocks Stock : StocksWallet) {
                if(Stock.GetStockName().equals("FB")) {
                    Stock.AddCounter();
                }
            }
            this.withdraw(BoughtStockName.GetStockPrice());
            text =("FB Stock Bought Succesfully");
        }
        else if (this.GetBalance()> BoughtStockName.GetStockPrice() && BoughtStockName.GetStockName().equals("Amazon") )
        {
            for(Stocks Stock : StocksWallet) {
                if(Stock.GetStockName().equals("Amazon")) {
                    Stock.AddCounter();
                }
            }
            this.withdraw(BoughtStockName.GetStockPrice());
            text =("Amazon Stock Bought Succesfully");



        }

        else{
            text =("Stock Bought Unsuccesfully");
        }
        return text;

    }
//this buys shares
    public String SellStocks(Stocks BoughtStockName){
        boolean sold = false;
        String text = "";


        if (sold == false) {
            if ((BoughtStockName.GetCounter() > 0 && BoughtStockName.GetStockName().equals("Tesla"))) {
                this.deposit(Tesla.GetStockPrice());
                text = ("Tesla Stock Sold Succesfully");
                BoughtStockName.RemoveCounter();
                sold = true;
            }
            if (BoughtStockName.GetCounter() > 0 && BoughtStockName.GetStockName().equals("FB")) {
                this.deposit(FB.GetStockPrice());

                text = ("FB Stock Sold Succesfully");
                BoughtStockName.RemoveCounter();
                sold = true;
            }
            if (BoughtStockName.GetCounter() > 0 && BoughtStockName.GetStockName().equals("Amazon")) {
                this.deposit(Amazon.GetStockPrice());
                text = ("Amazon Stock Sold Succesfully");
                BoughtStockName.RemoveCounter();
                sold = true;
            }
        }
        else{
            text =("Stock Not Owned Account");
        }



        return text;
    }
//this sells shares
    public String SeeWallet() {
        String text = "";
        Iterator<Stocks> it = StocksWallet.iterator();
        while (it.hasNext()) {
            Stocks s = it.next();
            text += s.GetStockName()+  " : "+ s.GetCounter() + " Shares"+"\n";
        }
        return text;
    }
//this shows what stock you own
    public void AddStockToArray(Stocks s ){
        StocksWallet.add(s);
    }
//this adds stock to the stock exchange
    public  Stocks ArrayGetter(int i){
        return StocksWallet.get(i);
    }
//this is a getter
}