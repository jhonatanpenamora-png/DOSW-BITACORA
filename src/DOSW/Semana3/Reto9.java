package DOSW.Semana3;

import java.time.LocalTime;

class AccessDeniedException extends RuntimeException {
    public AccessDeniedException(String message) {
        super(message);
    }
}

class AuthRequest {
    private final String username;
    private final String role;
    private final String location;
    private final LocalTime requestTime;

    public AuthRequest(String username, String role, String location, LocalTime requestTime) {
        this.username = username;
        this.role = role;
        this.location = location;
        this.requestTime = requestTime;
    }

    public String getUsername() { return username; }
    public String getRole() { return role; }
    public String getLocation() { return location; }
    public LocalTime getRequestTime() { return requestTime; }
}



interface AuthStrategy {
    boolean authenticate(String username, String credentials);
}

class PasswordStrategy implements AuthStrategy {
    @Override
    public boolean authenticate(String username, String credentials) {
        System.out.println("   [Strategy] Verificando hash de contraseña en Base de Datos Local para: " + username);
        return "12345".equals(credentials);
    }
}

class GoogleStrategy implements AuthStrategy {
    @Override
    public boolean authenticate(String username, String credentials) {
        System.out.println("   [Strategy] Validando Token OAuth2 con los servidores de Google para: " + username);
        return "OAUTH_GOOGLE_TOKEN_VALID".equals(credentials);
    }
}

class BiometricStrategy implements AuthStrategy {
    @Override
    public boolean authenticate(String username, String credentials) {
        System.out.println("   [Strategy] Contrastando patrón de huella dactilar/facial para: " + username);
        return "BIOMETRIC_MATCH".equals(credentials);
    }
}


abstract class SecurityValidator {
    private SecurityValidator next;

    public SecurityValidator setNext(SecurityValidator next) {
        this.next = next;
        return next;
    }

    public void validate(String username, AuthRequest request) {
        check(username, request);
        if (next != null) {
            next.validate(username, request);
        }
    }

    protected abstract void check(String username, AuthRequest request);
}

class CredentialValidator extends SecurityValidator {
    @Override
    protected void check(String username, AuthRequest request) {
        System.out.println("   [Chain 1/4] -> Comprobando que la cuenta de '" + username + "' no esté bloqueada.");
        if ("UsuarioBloqueado".equals(username)) {
            throw new AccessDeniedException("Acceso denegado: La cuenta se encuentra temporalmente suspendida.");
        }
    }
}

class PermissionValidator extends SecurityValidator {
    @Override
    protected void check(String username, AuthRequest request) {
        System.out.println("   [Chain 2/4] -> Validando permisos asignados al rol: " + request.getRole());
        if ("Invitado".equals(request.getRole())) {
            throw new AccessDeniedException("Acceso denegado: El rol 'Invitado' no tiene permisos de entrada al ecosistema corporativo.");
        }
    }
}

class LocationValidator extends SecurityValidator {
    @Override
    protected void check(String username, AuthRequest request) {
        System.out.println("   [Chain 3/4] -> Analizando geolocalización de la IP de origen: " + request.getLocation());
        if ("PaísListaNegra".equals(request.getLocation())) {
            throw new AccessDeniedException("Acceso denegado: Petición de conexión procedente de una ubicación geográfica no autorizada.");
        }
    }
}

class TimeValidator extends SecurityValidator {
    @Override
    protected void check(String username, AuthRequest request) {
        System.out.println("   [Chain 4/4] -> Evaluando ventana horaria laboral permisible.");
        LocalTime inicioLaboral = LocalTime.of(6, 0);
        LocalTime finLaboral = LocalTime.of(22, 0);
        LocalTime horaPeticion = request.getRequestTime();

        if (horaPeticion.isBefore(inicioLaboral) || horaPeticion.isAfter(finLaboral)) {
            throw new AccessDeniedException("Acceso denegado: Intento de inicio de sesión fuera del horario laboral autorizado (06:00 - 22:00).");
        }
    }
}


class SecurityAuthService {
    private final SecurityValidator validationChain;

    public SecurityAuthService(SecurityValidator validationChain) {
        this.validationChain = validationChain;
    }

    public void processAccessRequest(String username, String credentials, AuthStrategy strategy, AuthRequest request) {
        System.out.println("\n=== Iniciando Solicitud de Acceso Corporativo para: " + username + " ===");

        boolean isAuthenticated = strategy.authenticate(username, credentials);

        if (!isAuthenticated) {
            System.out.println("   [RESULTADO]: Error de Autenticación. Credenciales inválidas.");
            return;
        }

        try {
            validationChain.validate(username, request);
            System.out.println("   [RESULTADO EXCELENTE]: Autenticación y Políticas superadas. ¡Acceso Concedido!");
        } catch (AccessDeniedException ex) {
            System.out.println("   [RESULTADO RECHAZADO]: " + ex.getMessage());
        }
    }
}



public class Reto9 {
    public static void main(String[] args) {
        SecurityValidator chain = new CredentialValidator();
        chain.setNext(new PermissionValidator())
                .setNext(new LocationValidator())
                .setNext(new TimeValidator());

        SecurityAuthService authService = new SecurityAuthService(chain);

        AuthRequest req1 = new AuthRequest("jpena", "Administrador", "Colombia", LocalTime.of(14, 30));
        authService.processAccessRequest("jpena", "OAUTH_GOOGLE_TOKEN_VALID", new GoogleStrategy(), req1);

        AuthRequest req2 = new AuthRequest("carlos99", "Desarrollador", "Colombia", LocalTime.of(10, 15));
        authService.processAccessRequest("carlos99", "clave_incorrecta", new PasswordStrategy(), req2);

        AuthRequest req3 = new AuthRequest("marta.gomez", "Supervisor", "Colombia", LocalTime.of(23, 45));
        authService.processAccessRequest("marta.gomez", "BIOMETRIC_MATCH", new BiometricStrategy(), req3);

        AuthRequest req4 = new AuthRequest("anonimo", "Invitado", "Colombia", LocalTime.of(11, 0));
        authService.processAccessRequest("anonimo", "12345", new PasswordStrategy(), req4);
    }
}
