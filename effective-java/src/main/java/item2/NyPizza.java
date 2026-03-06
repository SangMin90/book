package item2;

import java.util.Objects;

public class NyPizza extends Pizza {
    public enum SIZE { SMALL, MEDIUM, LARGE }
    private final SIZE size;

    public static class Builder extends Pizza.Builder<Builder> {

        private final SIZE size;

        public Builder(SIZE size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        Pizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private NyPizza(Builder builder) {
        super(builder);
        this.size = builder.size;
    }

    @Override
    public String toString() {
        return "NyPizza{" +
                "size=" + size +
                ", topping=" + topping +
                '}';
    }
}
