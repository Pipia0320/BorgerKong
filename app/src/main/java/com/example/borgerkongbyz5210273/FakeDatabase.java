package com.example.borgerkongbyz5210273;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeDatabase {

    private static final HashMap<Integer, Food> foods = new HashMap<>();
    private static final HashMap<Integer, Integer> orders = new HashMap<>();

    static{
        foods.put(1, new Food(1, R.drawable.cheeseburger,"Cheese Burger",10.5,"A legendary combo of 100% Aussie beef, onions, pickle, ketchup, mustard and cheese, all in a soft burger bun.", 0));
        foods.put(2, new Food(2, R.drawable.chicken_burger,"Chicken Burger",12.5, "Crispy 100% Aussie Chicken Breast, Cheese, Crispy Lettuce, tomato, creamy garlic aioli all on a sesame seed bun. Yum.", 0));
        foods.put(3, new Food(3, R.drawable.fish_burger,"Fish Burger",13.5, "Dive in and enjoy our Fish Filet. Sourced for its succulent and fresh flavour, we cook tender portions of fish and enhance their great taste with zesty tartar sauce and cheese", 0));
        foods.put(4, new Food(4, R.drawable.pizza,"Borger signature pizza",17.5, "Lots of vegan mozzarella on a tomato base", 0));
        foods.put(5, new Food(5, R.drawable.wrap,"Chicken Wrap",10, "Made with juicy 100% Aussie Chicken Breast Fillet, Lettuce, Rasher Bacon, Shaved Parmesan and Caesar dressing, all wrapped up in a delicious wholemeal tortilla.", 0));
        foods.put(6, new Food(6, R.drawable.sandwich,"Steak Sandwich",11.5, "Top with rocket, then tomato slices, beef, caramelised onion.", 0));
        foods.put(7, new Food(7, R.drawable.pasta,"Pasta",14.5, "Italian styled pasta, served with a tomato sauce ", 0));
        foods.put(8, new Food(8, R.drawable.onion_ring,"Onion Rings",11, "Our thick-cut onion rings are made from whole white onions, battered with a subtle blend of spices, letting the onion’s natural sweetness shine through.", 0));
        foods.put(9, new Food(9, R.drawable.chicken_wings,"Chicken Wings",11.5, "The secret to our spicy Buffalo Chicken Tenders is in the seasoned breading — a flavorsome blend of chili peppers, paprika and black pepper spices.", 0));
        foods.put(10, new Food(10, R.drawable.chicken_nuggets,"Chicken Nuggets",11.5, "Everything's better when it's bite-sized. Like our nuggets made with tender juicy 100% Aussie Chicken McNuggets in a crisp tempura coating", 0));
        foods.put(11, new Food(11, R.drawable.soup,"Tomato Soup",9.5, "Vegetarian soup with small shell pasta, zucchini, carrots, celery, spinach and herbs simmered in a sweet tomato broth",0));
        foods.put(12, new Food(12, R.drawable.fries,"Fries",7, "We only use the highest quality potatoes to create those delicious strands of crispy fluffiness that you love, now fried in a superior and healthier blend including canola and sunflower oils.",0));
        foods.put(13, new Food(13, R.drawable.salad,"Salad",8.5, "Chicken, lettuce, bacon, shaved parmesan and your choice of creamy Caesar dressing.", 0));
        foods.put(14, new Food(14, R.drawable.cookies,"Cookies",5.5, "Don’t say we didn’t warn you, our cookies are irresistible", 0));
        foods.put(15, new Food(15, R.drawable.coke,"Coke",3, "A can of frozen coke", 0));
        foods.put(16, new Food(16, R.drawable.fanta,"Fanta",3, "A can of frozen Fanta", 0));
        foods.put(17, new Food(17, R.drawable.sprite,"Sprite",3, "A can of frozen Sprite", 0));
        foods.put(18, new Food(18, R.drawable.milkshake,"Milkshake",6, "Made with creamy, fresh milk ingredients and chocolate syrup, it's so thick it barely makes it up the straw.", 0));

        }
        public static Food getFoodById (int foodID) {return foods.get(foodID);}

        public static ArrayList<Food> getAllFoods() {
            return new ArrayList<Food>((List) Arrays.asList(foods.values().toArray()));
        }

    public static double getOrdersTotal() {
        double total = 0;

        for (Map.Entry me : orders.entrySet()) {
            int id = (int) me.getKey();
            int amount = (int) me.getValue();

            Food food = FakeDatabase.getFoodById(id);

            total = total + (food.getFoodPrice() * amount);
        }

        return total;
    }

    public static ArrayList<Food> getAllOrders() {
        ArrayList<Food> temp_items = new ArrayList<Food>();

        for (Map.Entry me : orders.entrySet()) {
            int id = (int) me.getKey();
            int amount = (int) me.getValue();

            Food food = FakeDatabase.getFoodById(id);

            food.setQuantity(amount);
            temp_items.add(food);
        }

        return temp_items;
    }

    public static void add_one(int itemID) {
        if (orders.containsKey(itemID)) {
            orders.put(itemID, orders.get(itemID) + 1);
        } else {
            orders.put(itemID, 1);
        }
    }

    public static void minus_one(int itemID) {

        if (orders.containsKey(itemID)) {
            if (orders.get(itemID) > 0) {
                orders.put(itemID, orders.get(itemID) - 1);
            }
        } else {
            orders.put(itemID, 0);
        }

    }


}
