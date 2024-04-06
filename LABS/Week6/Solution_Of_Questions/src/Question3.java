
public class Question3 {
    public static void main(String[] args) {
        Stock obj = new Stock("ORCL", "Oracle Corporation");
        obj.previousClosingPrice = 34.5;
        obj.currentPrice = 34.35;

        System.out.println("The price change percentage is "+obj.getChangePercent());
    }
}
class Stock {
    String symbol;
    String name;
    double previousClosingPrice;
    double currentPrice;

    Stock(String newSymbol, String newName){
        symbol = newSymbol;
        name = newName;
    }
    public double getChangePercent(){
        return (currentPrice - previousClosingPrice)/(previousClosingPrice)*100;
    }
}