package DOSW.Semana3;

import java.util.ArrayList;
import java.util.List;


class OrderEvent {
    private final String orderId;
    private final String status;

    public OrderEvent(String orderId, String status) {
        this.orderId = orderId;
        this.status = status;
    }

    public String getOrderId() { return orderId; }
    public String getStatus() { return status; }
}

interface Message {
    String getContent();
}

class HtmlMessage implements Message {
    private final String content;
    public HtmlMessage(String content) { this.content = content; }
    @Override public String getContent() { return "<html><body><h2>Estado de Pedido</h2><p>" + content + "</p></body></html>"; }
}

class PlainTextMessage implements Message {
    private final String content;
    public PlainTextMessage(String content) { this.content = content; }
    @Override public String getContent() { return "[SMS - 160 Chars]: " + content; }
}

class JsonMessage implements Message {
    private final String content;
    public JsonMessage(String content) { this.content = content; }
    @Override public String getContent() { return "{ \"appNotification\": { \"alert\": \"" + content + "\" } }"; }
}


interface MessageFactory {
    Message build(OrderEvent event);
}

class EmailMessageFactory implements MessageFactory {
    @Override
    public Message build(OrderEvent event) {
        return new HtmlMessage("Su orden con ID " + event.getOrderId() + " ha cambiado exitosamente al estado: " + event.getStatus());
    }
}

class SmsMessageFactory implements MessageFactory {
    @Override
    public Message build(OrderEvent event) {
        return new PlainTextMessage("Orden " + event.getOrderId() + " paso a " + event.getStatus());
    }
}

class PushMessageFactory implements MessageFactory {
    @Override
    public Message build(OrderEvent event) {
        return new JsonMessage("ID " + event.getOrderId() + " transiciono a " + event.getStatus());
    }
}


interface NotificationObserver {
    void notify(OrderEvent event);
}

class EmailNotifier implements NotificationObserver {
    private final MessageFactory factory = new EmailMessageFactory();
    @Override
    public void notify(OrderEvent event) {
        Message msg = factory.build(event);
        System.out.println("Despachando Correo Electrónico...\nContenido: " + msg.getContent());
    }
}

class SmsNotifier implements NotificationObserver {
    private final MessageFactory factory = new SmsMessageFactory();
    @Override
    public void notify(OrderEvent event) {
        Message msg = factory.build(event);
        System.out.println("Despachando Mensaje SMS...\nContenido: " + msg.getContent());
    }
}

class PushNotifier implements NotificationObserver {
    private final MessageFactory factory = new PushMessageFactory();
    @Override
    public void notify(OrderEvent event) {
        Message msg = factory.build(event);
        System.out.println("Despachando Alerta Push...\nContenido: " + msg.getContent());
    }
}


class Order {
    private final String orderId;
    private String status;
    private final List<NotificationObserver> observers = new ArrayList<>();

    public Order(String orderId) {
        this.orderId = orderId;
        this.status = "PENDIENTE";
    }

    public void attach(NotificationObserver observer) {
        observers.add(observer);
    }

    public void detach(NotificationObserver observer) {
        observers.remove(observer);
    }

    public void changeStatus(String newStatus) {
        this.status = newStatus;
        System.out.println("\n=== NOTIFICACIÓN DE CAMBIO: Pedido " + orderId + " pasa a -> " + newStatus + " ===");
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        OrderEvent event = new OrderEvent(this.orderId, this.status);
        for (NotificationObserver observer : observers) {
            observer.notify(event);
        }
    }
}

public class Reto2 {
    public static void main(String[] args) {
        Order order = new Order("ECI-2026-991");

        NotificationObserver email = new EmailNotifier();
        NotificationObserver sms = new SmsNotifier();
        NotificationObserver push = new PushNotifier();

        order.attach(email);
        order.attach(push);
        order.changeStatus("ENVIADO");

        order.attach(sms);
        order.changeStatus("ENTREGADO");
    }
}
