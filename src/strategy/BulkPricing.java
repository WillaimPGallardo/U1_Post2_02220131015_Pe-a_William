package strategy;

public class BulkPricing implements PricingStrategy {

    @Override
    public double calculateFinalPrice(double price) {
        return price * 0.85;
    }

    @Override
    public String getDescription() {
        return "Descuento por compra en volumen 15%";
    }
}