package DOSW.Semana3;


class LegacyBankService {
    public void connectTcp() { System.out.println("   [Legacy] 1/8: Conectando vía TCP..."); }
    public void handshake() { System.out.println("   [Legacy] 2/8: Realizando handshake de seguridad..."); }
    public void authenticate() { System.out.println("   [Legacy] 3/8: Autenticando credenciales mainframe..."); }
    public void openSession() { System.out.println("   [Legacy] 4/8: Abriendo sesión transaccional..."); }
    public void loadContext() { System.out.println("   [Legacy] 5/8: Cargando contexto de usuario..."); }
    public void verifyCert() { System.out.println("   [Legacy] 6/8: Verificando certificados X.509..."); }
    public void lockResources() { System.out.println("   [Legacy] 7/8: Bloqueando recursos para concurrencia..."); }
    public void ready() { System.out.println("   [Legacy] 8/8: Sistema listo para operar."); }

    public void executeTransaction(String accountCode, int cents) {
        System.out.println("   [Legacy Tx]: Procesando transacción en cuenta " + accountCode + " por " + cents + " centavos.");
    }
}

interface PaymentProcessor {
    void pay(double amount);
}

class LegacyBankAdapter implements PaymentProcessor {
    private final LegacyBankService legacy;

    public LegacyBankAdapter(LegacyBankService legacy) {
        this.legacy = legacy;
    }
    @Override
    public void pay(double amount) {
        int cents = (int) (amount * 100);
        System.out.println("   [Adapter]: Traduciendo monto moderno ($" + amount + ") a legacy (" + cents + " centavos).");

        legacy.executeTransaction("ACC-MODERN-01", cents);
    }
}


class BankFacade {
    public void procesarPago(double monto) {
        System.out.println("--- Iniciando proceso de pago simplificado ---");

        LegacyBankService legacyBank = new LegacyBankService();

        legacyBank.connectTcp();
        legacyBank.handshake();
        legacyBank.authenticate();
        legacyBank.openSession();
        legacyBank.loadContext();
        legacyBank.verifyCert();
        legacyBank.lockResources();
        legacyBank.ready();

        PaymentProcessor adapter = new LegacyBankAdapter(legacyBank);
        adapter.pay(monto);

        System.out.println("--- Transacción Finalizada con Éxito ---\n");
    }
}

public class Reto5 {
    public static void main(String[] args) {
        BankFacade facade = new BankFacade();

        System.out.println("Solicitando pago de $150.75");
        facade.procesarPago(150.75);

        System.out.println("Solicitando pago de $45.00");
        facade.procesarPago(45.00);
    }
}