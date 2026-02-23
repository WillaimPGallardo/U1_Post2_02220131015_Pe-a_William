package model;

public class Food extends Product {

    private int expirationDays;

    public Food(String name, double basePrice, int expirationDays) {
        super(name, basePrice, "Food");
        this.expirationDays = expirationDays;
    }

    @Override
    public double calculateShipping() {
        return basePrice * 0.02;
    }

    @Override
    public String getDescription() {
        return name + " [Alimento] - Expira en "
                + expirationDays + " días";
    }
}