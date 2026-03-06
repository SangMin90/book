package item2;

import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
    public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE};
    final Set<Topping> topping;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> topping = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping) {
            this.topping.add(Objects.requireNonNull(topping));
            return self();
        }
        public T addToppings(Topping... toppings) {
            this.topping.addAll(List.of(toppings));
            return self();
        }

        abstract Pizza build();

        protected abstract T self();
    }

    Pizza(Builder builder) {
        this.topping = builder.topping.clone();
    }

}
