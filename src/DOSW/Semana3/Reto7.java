package DOSW.Semana3;


interface DocumentState {
    void approve(Document doc);
    void reject(Document doc);
    String getName();
}

class DraftState implements DocumentState {
    @Override
    public void approve(Document doc) {
        System.out.println("   [State] Borrador aprobado. Transicionando a 'En Revisión'.");
        doc.setState(new InReviewState());
    }
    @Override
    public void reject(Document doc) {
        System.out.println("   [State] Borrador rechazado. Requiere reescritura. Sigue en 'Borrador'.");
    }
    @Override
    public String getName() { return "Borrador"; }
}

class InReviewState implements DocumentState {
    @Override
    public void approve(Document doc) {
        System.out.println("   [State] Revisión superada con éxito. Transicionando a 'Aprobado'.");
        doc.setState(new ApprovedState());
    }
    @Override
    public void reject(Document doc) {
        System.out.println("   [State] Anomalías detectadas en revisión. Transicionando a 'Rechazado'.");
        doc.setState(new RejectedState());
    }
    @Override
    public String getName() { return "En Revisión"; }
}

class ApprovedState implements DocumentState {
    @Override
    public void approve(Document doc) {
        System.out.println("   [State] Acción ignorada: El documento ya cuenta con aprobación final.");
    }
    @Override
    public void reject(Document doc) {
        System.out.println("   [State] Alerta: No es posible rechazar un documento ya emitido y aprobado.");
    }
    @Override
    public String getName() { return "Aprobado"; }
}

class RejectedState implements DocumentState {
    @Override
    public void approve(Document doc) {
        System.out.println("   [State] Reiniciando flujo desde cero. Transicionando a 'Borrador'.");
        doc.setState(new DraftState());
    }
    @Override
    public void reject(Document doc) {
        System.out.println("   [State] Acción ignorada: El documento ya está en estado de rechazo.");
    }
    @Override
    public String getName() { return "Rechazado"; }
}

class Document {
    private final String type;
    private final String content;
    private DocumentState state;

    public Document(String type, String content) {
        this.type = type;
        this.content = content;
        this.state = new DraftState();
    }

    public void setState(DocumentState state) { this.state = state; }
    public String getType() { return type; }
    public String getContent() { return content; }
    public String getStatusInfo() { return "[DOC: " + type + "] Estado actual: " + state.getName(); }

    public void approve() { state.approve(this); }
    public void reject() { state.reject(this); }
}



abstract class DocumentHandler {
    private DocumentHandler next;

    public DocumentHandler setNext(DocumentHandler next) {
        this.next = next;
        return next;
    }

    public void handle(Document doc) {
        if (canHandle(doc)) {
            process(doc);
        } else if (next != null) {
            System.out.println("   -> [" + this.getClass().getSimpleName() + "] no es responsable. Pasando al siguiente eslabón...");
            next.handle(doc);
        } else {
            System.out.println("   -> [Cadena Finalizada] Ningún handler pudo procesar el documento tipo: " + doc.getType());
        }
    }

    protected abstract boolean canHandle(Document doc);
    protected abstract void process(Document doc);
}

class AutorHandler extends DocumentHandler {
    @Override
    protected boolean canHandle(Document doc) {
        return doc.getType().equals("Articulo") || doc.getType().equals("Blog");
    }
    @Override
    protected void process(Document doc) {
        System.out.println("\n[" + this.getClass().getSimpleName() + "] Auditando gramática de contenido...");
        doc.approve();
    }
}

class LiderHandler extends DocumentHandler {
    @Override
    protected boolean canHandle(Document doc) {
        return doc.getType().equals("Tecnico");
    }
    @Override
    protected void process(Document doc) {
        System.out.println("\n[" + this.getClass().getSimpleName() + "] Verificando viabilidad técnica del contenido...");
        if (doc.getContent().contains("Error")) {
            System.out.println("   * Se encontró un error crítico en el reporte técnico.");
            doc.reject();
        } else {
            doc.approve();
        }
    }
}

class JuridicoHandler extends DocumentHandler {
    @Override
    protected boolean canHandle(Document doc) {
        return doc.getType().equals("Legal");
    }
    @Override
    protected void process(Document doc) {
        System.out.println("\n[" + this.getClass().getSimpleName() + "] Estudiando marco regulatorio de contenido...");
        doc.approve();
        doc.approve();
    }
}


public class Reto7 {
    public static void main(String[] args) {
        DocumentHandler pipeline = new AutorHandler();
        pipeline.setNext(new LiderHandler()).setNext(new JuridicoHandler());

        System.out.println("=== CASO A: Contrato de Confidencialidad ===");
        Document docLegal = new Document("Legal", "Cláusulas de privacidad...");
        System.out.println(docLegal.getStatusInfo());
        pipeline.handle(docLegal);
        System.out.println(docLegal.getStatusInfo());

        System.out.println("\n=== CASO B: Reporte de Arquitectura Defectuoso ===");
        Document docTecnico = new Document("Tecnico", "Especificaciones con Error de cálculo.");
        System.out.println(docTecnico.getStatusInfo());

        pipeline.handle(docTecnico);
        System.out.println(docTecnico.getStatusInfo());

        System.out.println("\n=== CASO C: Receta de Cocina ===");
        Document docDesconocido = new Document("Culinario", "Ingredientes secretos...");
        pipeline.handle(docDesconocido);
    }
}
