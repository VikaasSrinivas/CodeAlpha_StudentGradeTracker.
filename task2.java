import java.util.*;

class Stock {
    String symbol;
    double price;

    Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }
}

class UserPortfolio {
    String name;
    Map<String, Integer> holdings = new HashMap<>();

    UserPortfolio(String name) {
        this.name = name;
    }

    void buy(String symbol, int quantity) {
        holdings.put(symbol, holdings.getOrDefault(symbol, 0) + quantity);
    }

    void sell(String symbol, int quantity) {
        holdings.put(symbol, Math.max(holdings.getOrDefault(symbol, 0) - quantity, 0));
    }

    void viewPortfolio() {
        System.out.println("Portfolio of " + name + ": " + holdings);
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Stock> market = new ArrayList<>();
        market.add(new Stock("AAPL", 150.5));
        market.add(new Stock("GOOG", 2750.0));
        market.add(new Stock("TSLA", 710.0));

        UserPortfolio user = new UserPortfolio("Trader");

        int choice;
        do {
            System.out.println("\n1. View Market\n2. Buy\n3. Sell\n4. View Portfolio\n5. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    for (Stock s : market)
                        System.out.println(s.symbol + ": $" + s.price);
                    break;
                case 2:
                    System.out.print("Enter stock symbol: ");
                    String buySymbol = sc.next();
                    System.out.print("Enter quantity: ");
                    int qtyBuy = sc.nextInt();
                    user.buy(buySymbol, qtyBuy);
                    break;
                case 3:
                    System.out.print("Enter stock symbol: ");
                    String sellSymbol = sc.next();
                    System.out.print("Enter quantity: ");
                    int qtySell = sc.nextInt();
                    user.sell(sellSymbol, qtySell);
                    break;
                case 4:
                    user.viewPortfolio();
                    break;
            }
        } while (choice != 5);

        sc.close();
    }
}
