import java.util.Random;

public class HungryCrowd extends Thread{

    Restaurant restaurant;
    private int times;
    private Dish chooseDish;

    public HungryCrowd() {
        this.restaurant = restaurant;
    }

    public void orderDish() {
        Random r = new Random();
        times = r.nextInt(4) +2;
        pickDish();
        for(int i=0; i<getTimes(); i++) {
                restaurant.tryDeliverDish(chooseDish);
        }
    }

    public void pickDish() {
        Random r = new Random();
        int dishNr = r.nextInt(4);
        switch(dishNr) {
            case 0: chooseDish = Dish.IceCream;
            case 1: chooseDish = Dish.Gyros;
            case 2: chooseDish= Dish.Pizza;
            case 3: chooseDish =  Dish.Tortilla;
            case 4: chooseDish = Dish.Steak;
        }
    }

    public int getTimes() {
        return times;
    }

    public  Dish getChooseDish() {
        return chooseDish;
    }

    @Override
    public void run() {
        while(true) {
            Random r = new Random();
            int seconds = (r.nextInt(3) + 1) * 1000;
            try {
                System.out.println("Ordered " + getTimes() + " " + getChooseDish());
                Thread.sleep(seconds);
                orderDish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        HungryCrowd c = new HungryCrowd();
        for(int i=0; i<=5; i++) {
            c.pickDish();
            System.out.println(c.getChooseDish());
        }
    }
}
