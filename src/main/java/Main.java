import trading.PriceChart;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Trading Framework!");

        Thread RunnablePrice = new Thread(new PriceChart());
        RunnablePrice.setName("RunnablePrice");
        RunnablePrice.start();
    }
}
