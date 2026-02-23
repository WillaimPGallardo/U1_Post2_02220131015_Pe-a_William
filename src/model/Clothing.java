package model;

public class Clothing extends Product {

    private String size;

    public Clothing(String name, double basePrice, String size) {
        super(name, basePrice, "Clothing");
        this.size = size;
    }

    @Override
    public double calculateShipping() {
        return 10;
    }

    @Override
    public String getDescription() {
        return name + " [Ropa] - Talla: " + size;
    }
}