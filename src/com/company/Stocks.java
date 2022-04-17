package com.company;
public class Stocks  {

    private String StockName;
    private int StockPrice;
    private int StockInt = 0;

    public Stocks( String StockName, int StockPrice , int Stockint){
        this.StockName = StockName;
        this.StockPrice = StockPrice;
        this.StockInt = 0;

    }
    public int GetStockPrice(){
        return this.StockPrice;
    }
    public String GetStockName(){
        return this.StockName;
    }

    public void AddCounter(){
        this.StockInt = this.StockInt + 1;
    }
    public void RemoveCounter(){
        this.StockInt = this.StockInt - 1;
    }
    public int GetCounter(){
        return this.StockInt;
    }
}
