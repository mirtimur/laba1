package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {

        Cheese cheese = new Cheese();

        ChewingGum chewingGumСherry = new ChewingGum("вишня");
        ChewingGum chewingGumMint = new ChewingGum("мята");
        ChewingGum chewingGumWatermelon = new ChewingGum("арбуз");

        Apple appleSmall = new Apple("малый");
        Apple appleMiddle = new Apple("средний");
        Apple appleBid = new Apple("большой");

        List<Food> foodList = new ArrayList<>(20);

        for (String arg : args) {
            switch (arg) {
                case "-calories":
                    if (foodList.isEmpty()) {
                        System.out.println("Нет продуктов в корзине(Каллорийность 0)");
                    } else {
                        int calories = foodList.stream().map(Nutritious::calculateCalories).
                                mapToInt(Integer::intValue).sum();
                        System.out.println("Колличество каллорий: " + calories);
                    }
                    continue;

                case "-sort": foodList.sort((o1,o2)->o2.calculateCalories() - o1.calculateCalories());
                    continue;
            }

            String[] parts = arg.split("/");
           /* switch (parts[0].toLowerCase()) {
                case "cheese":
                    foodList.add(new Cheese());
                    break;
                case "apple":
                    foodList.add(new Apple(parts[1]));
                    break;
                case "chewinggum":
                    foodList.add(new ChewingGum(parts[1]));
                    break;
                default:
                    System.out.println("Такого продукта нет");
            }*/

            if (parts[0].equals("Cheese")){
                foodList.add(new Cheese());

            }else
                if (parts[0].equals("Apple")){
                    foodList.add(new Apple(parts[1]));
                }else
                    if (parts[0].equals("ChewingGum")){
                        foodList.add(new ChewingGum(parts[1]));
                    }else System.out.println("Такого продукта нет");


        }


        int appleSmallCount=0;
        int appleMiddleCount=0;
        int appleBigCount=0;
        int cheesCount = 0;
        int gumCherryCount=0;
        int gumMintCount=0;
        int gumWatermelonCount=0;

        for (int i =0 ; i < foodList.size(); i++){
            if (cheese.equals(foodList.get(i))){
                cheesCount++;
            }
            if (appleSmall.equals(foodList.get(i))){
                appleSmallCount++;
            }
            if (appleMiddle.equals(foodList.get(i))){
                appleMiddleCount++;
            }
            if (appleBid.equals(foodList.get(i))){
                appleBigCount++;
            }
            if (chewingGumСherry.equals(foodList.get(i))){
                gumCherryCount++;
            }
            if (chewingGumMint.equals(foodList.get(i))){
                gumMintCount++;
            }
            if (chewingGumWatermelon.equals(foodList.get(i))){
                gumWatermelonCount++;
            }
        }


        for (Food item : foodList) {
            if (item != null) {
                item.consume();
            } else
                break;
        }
        if (cheesCount > 0)       System.out.println("Мы съели Сыр в количестве " + cheesCount );
        if (appleBigCount > 0)    System.out.println("Мы съели Яблоко размером БОЛЬШОЙ в количестве " + appleBigCount );
        if (appleMiddleCount > 0) System.out.println("Мы съели Яблоко размером СРЕДНИЙ в количестве " + appleMiddleCount );
        if (appleSmallCount > 0)  System.out.println("Мы съели Яблоко размером МАЛЫЙ в количестве " + appleSmallCount );
        if (gumCherryCount > 0)   System.out.println("Мы съели Жевательную резинку вкуса ВИШНЯ в количестве " + gumCherryCount );
        if (gumMintCount > 0)   System.out.println("Мы съели Жевательную резинку вкуса МЯТА в количестве " + gumMintCount );
        if (gumWatermelonCount > 0)   System.out.println("Мы съели Жевательную резинку вкуса АРБУЗ в количестве " + gumWatermelonCount );

        System.out.println("Всего хорошего!");
    }

}
