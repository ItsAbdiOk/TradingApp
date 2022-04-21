public class Stocks  {

    private String StockName;
    private int StockPrice;
    private int StockInt = 0;

    public Stocks( String StockName, int StockPrice , int Stockint){
        this.StockName = StockName;
        this.StockPrice = StockPrice;
        this.StockInt = 0;

    }
//this is a constructor
    public int GetStockPrice(){
        return this.StockPrice;
    }
//this is a getter
    public String GetStockName(){
        return this.StockName;
    }
//this is a getter
    public void AddCounter(){
        this.StockInt = this.StockInt + 1;
    }
//this changes the counter which tells how much of a stock someone owns
    public void RemoveCounter(){
        this.StockInt = this.StockInt - 1;
    }
//this changes the counter which tells how much of a stock someone owns
    public int GetCounter(){
        return this.StockInt;
    }
//this is a getter
}