package observer;

public class SMSNotifier implements OrderObserver {

    @Override
    public void update(String orderId, String oldStatus, String newStatus) {
        System.out.println("[SMS] Notificación enviada para pedido "
                + orderId + " -> Estado: " + newStatus);
    }
}