public enum Dish {
    IceCream(8),
    Gyros(12),
    Tortilla(13),
    Pizza(18),
    Steak(20);

    private final int price;

    Dish(int price) {
        this.price = price;
    }

    int getPrice() {
        return price;
    }

    /*
    //TEST
    public static void main(String[] args) {
        Dish[] dishes = Dish.values();
        for(Dish dish:dishes)
        System.out.println("Dish name " + dish.name() + " price: " + dish.price);
    }
     */
}
