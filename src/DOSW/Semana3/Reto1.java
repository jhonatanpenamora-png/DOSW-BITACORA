package DOSW.Semana3;


interface PaymentStrategy {
    void process(double amount);
}

class TarjetaStrategy implements PaymentStrategy {
    @Override
    public void process(double amount) {
        System.out.println("Validando franquicia y procesando pago de $" + amount + " con Tarjeta de Crédito.");
    }
}

class PseStrategy implements PaymentStrategy {
    @Override
    public void process(double amount) {
        System.out.println("Redirigiendo a la sucursal virtual. Pago de $" + amount + " procesado mediante PSE.");
    }
}

class NequiStrategy implements PaymentStrategy {
    @Override
    public void process(double amount) {
        System.out.println("Enviando notificación push al número. Pago de $" + amount + " procesado mediante Nequi.");
    }
}

class PayPalStrategy implements PaymentStrategy {
    @Override
    public void process(double amount) {
        System.out.println("Autenticando token y procesando pago de $" + amount + " mediante PayPal.");
    }
}

interface PaymentFactory {
    PaymentStrategy create(String type);
}

class ColombiaPaymentFactory implements PaymentFactory {
    @Override
    public PaymentStrategy create(String type) {
        switch (type.toUpperCase()) {
            case "PSE":
                return new PseStrategy();
            case "NEQUI":
                return new NequiStrategy();
            case "TARJETA":
                return new TarjetaStrategy();
            default:
                throw new IllegalArgumentException("Método de pago no soportado en Colombia: " + type);
        }
    }
}

class UsaPaymentFactory implements PaymentFactory {
    @Override
    public PaymentStrategy create(String type) {
        switch (type.toUpperCase()) {
            case "PAYPAL":
                return new PayPalStrategy();
            case "TARJETA":
                return new TarjetaStrategy();
            default:
                throw new IllegalArgumentException("Método de pago no soportado en USA: " + type);
        }
    }
}

class Checkout {
    public void processCheckout(PaymentFactory factory, String paymentType, double amount) {
        System.out.println("--- Iniciando Checkout ---");
        try {
            PaymentStrategy strategy = factory.create(paymentType);
            strategy.process(amount);
            System.out.println("Checkout finalizado con éxito.\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }
}


public class Reto1 {
    public static void main(String[] args) {
        Checkout checkout = new Checkout();

        PaymentFactory colombiaFactory = new ColombiaPaymentFactory();
        checkout.processCheckout(colombiaFactory, "Nequi", 150000.0);
        checkout.processCheckout(colombiaFactory, "PSE", 85000.50);

        PaymentFactory usaFactory = new UsaPaymentFactory();
        checkout.processCheckout(usaFactory, "PayPal", 120.99);
        checkout.processCheckout(usaFactory, "Tarjeta", 50.00);

        checkout.processCheckout(colombiaFactory, "PayPal", 20000.0);
    }
}