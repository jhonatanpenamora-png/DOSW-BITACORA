import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


interface OrderObserver {
    void onOrderConfirmed(RestaurantOrder order);
}

class KitchenService implements OrderObserver {
    @Override
    public void onOrderConfirmed(RestaurantOrder order) {
        System.out.println(" [Cocina] Preparando: " + order.getBurgerDescription());
    }
}

class BillingService implements OrderObserver {
    @Override
    public void onOrderConfirmed(RestaurantOrder order) {
        System.out.println(" [Facturación] Recibo generado para " + order.getTotalItems() + " items.");
    }
}

class RestaurantOrder {
    private final String size;
    private final String meat;
    private final List<String> toppings;
    private final List<String> sides;
    private final List<OrderObserver> observers = new ArrayList<>();

    protected RestaurantOrder(String size, String meat, List<String> toppings, List<String> sides) {
        this.size = size;
        this.meat = meat;
        this.toppings = toppings;
        this.sides = sides;
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void confirm() {
        System.out.println("\n--- Confirmando RestaurantOrder ---");
        for (OrderObserver obs : observers) {
            obs.onOrderConfirmed(this);
        }
    }

    public String getBurgerDescription() {
        return "Hamburguesa " + size + " (" + meat + ") con " + String.join(", ", toppings);
    }

    public int getTotalItems() {
        return 1 + sides.size();
    }
}

class OrderBuilder {
    private String size = "Mediana";
    private String meat = "Res Sencilla";
    private final List<String> toppings = new ArrayList<>();
    private final List<String> sides = new ArrayList<>();

    public OrderBuilder setSize(String size) { this.size = size; return this; }
    public OrderBuilder setMeat(String meat) { this.meat = meat; return this; }
    public OrderBuilder addTopping(String... t) { this.toppings.addAll(Arrays.asList(t)); return this; }
    public OrderBuilder addSide(String... s) { this.sides.addAll(Arrays.asList(s)); return this; }

    public RestaurantOrder build() {
        return new RestaurantOrder(size, meat, new ArrayList<>(toppings), new ArrayList<>(sides));
    }
}

public class Reto8 {
    public static void main(String[] args) {
        RestaurantOrder myOrder = new OrderBuilder()
                .setSize("GRANDE")
                .setMeat("Angus")
                .addTopping("Queso", "Tocineta")
                .build();

        myOrder.addObserver(new KitchenService());
        myOrder.addObserver(new BillingService());

        myOrder.confirm();
    }
}