package com.company;
public class Agent{

    private static Account acc;



    public Agent(String Name){
        acc = new Account(Name);
    }


    public static String GetUserInfo(){
        String text = "";
        text += "Name: " + acc.GetName() + "\n";
        text += "Funds: " + acc.GetBalance() + "\n";

        return text;
    }
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
    public String SeeWallet(){
        String text = acc.SeeWallet();
        return text;
    }


    public void addStock(Stocks S){
        acc.AddStockToArray(S);
    }

    public void deposit(int amount){
        acc.deposit(amount);
    }
    public void withdraw(int amount){
        if (amount <= acc.GetBalance()){
            acc.withdraw(amount);
        }
    }
}