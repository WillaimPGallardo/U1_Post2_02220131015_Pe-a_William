import observer.*;
import service.OrderService;
import strategy.*;

public class Main {

    public static void main(String[] args) {

        OrderService service = new OrderService("ORD-001");

        // Observer
        service.subscribe(new EmailNotifier());
        service.subscribe(new SMSNotifier());
        service.subscribe(new LogNotifier());

        // Factory
        service.addProduct("ELECTRONICS", "Laptop", 3000);
        service.addProduct("CLOTHING", "Camisa", 120);
        service.addProduct("FOOD", "Chocolate", 20);

        // Strategy
        PricingStrategy regular = new RegularPricing();
        PricingStrategy member = new MemberPricing();
        PricingStrategy blackFriday = new BlackFridayPricing();

        System.out.println("Total Regular: " +
                service.calculateTotal(regular));

        System.out.println("Total Miembro: " +
                service.calculateTotal(member));

        System.out.println("Total Black Friday: " +
                service.calculateTotal(blackFriday));

        // Cambios de estado
        service.changeStatus("PROCESSING");
        service.changeStatus("SHIPPED");
        service.changeStatus("DELIVERED");

        service.printSummary();
    }
}