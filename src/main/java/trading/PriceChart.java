package trading;

import java.util.Random;

public class PriceChart implements Runnable {
    private int price = 100;

    public PriceChart() {
        super();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " isAlreadyRunning!");
        for (int i = 1; i <= 100; i++) {
            int random = new Random().nextInt(10);

            if(new Random().nextBoolean()) price += random;
            else price -= random;

            System.out.println(i + " step: " + getPrice() + " USDXBT");

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (Thread.currentThread().isAlive() || getPrice() < 0) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " is interrupted: " + Thread.currentThread().isInterrupted());
    }

    public int getPrice() {
        return price;
    }
}
