package item2;

import static item2.NyPizza.SIZE.SMALL;
import static item2.Pizza.Topping.HAM;
import static item2.Pizza.Topping.SAUSAGE;

public class Main {

    public static void main(String[] args) {
        Pizza nyPizza = new NyPizza.Builder(SMALL)
                .addToppings(HAM, SAUSAGE)
                .build();

        System.out.println(nyPizza.toString());

        Pizza calzone = new Calzone.Builder(true)
                .addTopping(HAM)
                .addTopping(SAUSAGE)
                .build();

        System.out.println(calzone);
    }
}
