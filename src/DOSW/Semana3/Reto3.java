package DOSW.Semana3;


abstract class ReportGenerator {

    public final void generate() {
        fetchData();
        processData();
        applyFormat();
        exportFile();
    }

    private void fetchData() {
        System.out.println("[Paso 1/4]: Extrayendo datos desde la base de datos centralizada...");
    }

    private void processData() {
        System.out.println("[Paso 2/4]: Computando métricas y procesando la información...");
    }

    protected abstract void applyFormat();
    protected abstract void exportFile();
}

class PdfReport extends ReportGenerator {
    @Override
    protected void applyFormat() {
        System.out.println("[Paso 3/4 - PDF]: Aplicando hojas de estilo vectoriales y maquetación de páginas.");
    }

    @Override
    protected void exportFile() {
        System.out.println("[Paso 4/4 - PDF]: Compilando binario y guardando archivo con extensión .pdf");
    }
}

class ExcelReport extends ReportGenerator {
    @Override
    protected void applyFormat() {
        System.out.println("[Paso 3/4 - Excel]: Estructurando celdas, aplicando fórmulas y auto-ajuste de columnas.");
    }

    @Override
    protected void exportFile() {
        System.out.println("[Paso 4/4 - Excel]: Escribiendo libro de trabajo y guardando archivo con extensión .xlsx");
    }
}

class CsvReport extends ReportGenerator {
    @Override
    protected void applyFormat() {
        System.out.println("[Paso 3/4 - CSV]: Convirtiendo matrices a texto plano.");
    }

    @Override
    protected void exportFile() {
        System.out.println("[Paso 4/4 - CSV]: Concatenando valores por comas (,) y guardando archivo con extensión .csv");
    }
}


class ReportFactory {
    public static ReportGenerator createReport(String formatType) {
        if (formatType == null) {
            throw new IllegalArgumentException("El tipo de formato no puede ser nulo.");
        }

        switch (formatType.toUpperCase()) {
            case "PDF":
                return new PdfReport();
            case "EXCEL":
                return new ExcelReport();
            case "CSV":
                return new CsvReport();
            default:
                throw new IllegalArgumentException("Formato de reporte no soportado de forma nativa: " + formatType);
        }
    }
}

public class Reto3 {
    public static void main(String[] args) {
        System.out.println("=== SOLICITUD 1: Reporte Financiero de Cierre ===");
        ReportGenerator reporteFinanciero = ReportFactory.createReport("PDF");
        reporteFinanciero.generate();

        System.out.println("\n=== SOLICITUD 2: Reporte de Inventario para Auditoría ===");
        ReportGenerator repoInventario = ReportFactory.createReport("Excel");
        repoInventario.generate();

        System.out.println("\n=== SOLICITUD 3: Volcado Rápido de Logs de Datos ===");
        ReportGenerator repoLogs = ReportFactory.createReport("CSV");
        repoLogs.generate();
    }
}