import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class Restaurant extends Thread {

    private LinkedList<Dish> availableDishes = new LinkedList<Dish>();
    private int moneyEarned;
    private int moneyLost;

    public Restaurant(int initialDishCount) {
        addStartingDishes(initialDishCount);
    }

    public LinkedList<Dish> getAvailableDishes() {
        return availableDishes;
    }

    public int getMoneyEarned() {
        return moneyEarned;
    }

    public int getMoneyLost() {
        return moneyLost;
    }

    private void addStartingDishes(int nrOfEachDish) {
        for (int i=0; i<nrOfEachDish; i++) {
            availableDishes.add(Dish.IceCream);
            availableDishes.add(Dish.Gyros);
            availableDishes.add(Dish.Tortilla);
            availableDishes.add(Dish.Pizza);
            availableDishes.add(Dish.Steak);
        }
    }

    public void prepareDish() {
        addStartingDishes(1);
    }

    public void tryDeliverDish(Dish dish) {
        if(availableDishes.contains(dish)) {
            availableDishes.remove(dish);
            moneyEarned+=dish.getPrice();
        }
        else moneyLost += dish.getPrice();
    }

    @Override
    public void run() {
        try {
            while(true) {
                Thread.sleep(5000);
                synchronized (availableDishes) {
                    prepareDish();
                }
                System.out.println("Money earned/lost: " + getMoneyEarned() + "/" + getMoneyLost() + "Current dishes available: " + getAvailableDishes());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
