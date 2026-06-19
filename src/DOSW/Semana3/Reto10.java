package DOSW.Semana3;

import java.util.ArrayList;
import java.util.List;


interface Image {
    String render();
}

class BaseImage implements Image {
    private final String filename;

    public BaseImage(String filename) {
        this.filename = filename;
    }

    @Override
    public String render() {
        return "Contenido Puro de [" + filename + "]";
    }
}

abstract class ImageDecorator implements Image {
    protected Image wrappedImage;

    public ImageDecorator(Image image) {
        this.wrappedImage = image;
    }

    @Override
    public String render() {
        return wrappedImage.render();
    }

    public Image getWrapped() {
        return wrappedImage;
    }

    public void setWrapped(Image image) {
        this.wrappedImage = image;
    }
}

class GrayscaleDecorator extends ImageDecorator {
    public GrayscaleDecorator(Image image) { super(image); }

    @Override
    public String render() {
        return super.render() + " + [Filtro: Blanco y Negro]";
    }
}

class SepiaDecorator extends ImageDecorator {
    public SepiaDecorator(Image image) { super(image); }

    @Override
    public String render() {
        return super.render() + " + [Filtro: Sepia]";
    }
}

class BrightnessDecorator extends ImageDecorator {
    public BrightnessDecorator(Image image) { super(image); }

    @Override
    public String render() {
        return super.render() + " + [Filtro: Brillo +20%]";
    }
}

class ImageEditor {
    private final Image baseImage;
    private Image currentPipeline;

    public ImageEditor(String filename) {
        this.baseImage = new BaseImage(filename);
        this.currentPipeline = this.baseImage;
    }

    public Image getCurrentImage() {
        return currentPipeline;
    }

    public void applyDecorator(ImageDecorator decorator) {
        this.currentPipeline = decorator;
    }

    public void removeDecorator(Class<? extends ImageDecorator> decoratorClass) {
        if (currentPipeline instanceof BaseImage) return;

        if (currentPipeline.getClass().equals(decoratorClass)) {
            currentPipeline = ((ImageDecorator) currentPipeline).getWrapped();
            return;
        }

        ImageDecorator current = (ImageDecorator) currentPipeline;
        while (current != null && !(current.getWrapped() instanceof BaseImage)) {
            if (current.getWrapped().getClass().equals(decoratorClass)) {
                ImageDecorator target = (ImageDecorator) current.getWrapped();
                current.setWrapped(target.getWrapped());
                return;
            }
            current = current.getWrapped() instanceof ImageDecorator ? (ImageDecorator) current.getWrapped() : null;
        }
    }

    public void display() {
        System.out.println("   [Canvas de Renderizado]: " + currentPipeline.render());
    }
}


interface ImageCommand {
    void execute();
    void undo();
    String getName();
}

class ApplyFilterCommand implements ImageCommand {
    private final ImageEditor editor;
    private final Class<? extends ImageDecorator> filterClass;
    private ImageDecorator decoratorInstance;

    public ApplyFilterCommand(ImageEditor editor, Class<? extends ImageDecorator> filterClass) {
        this.editor = editor;
        this.filterClass = filterClass;
    }

    @Override
    public void execute() {
        try {
            this.decoratorInstance = filterClass.getConstructor(Image.class).newInstance(editor.getCurrentImage());
            editor.applyDecorator(decoratorInstance);
        } catch (Exception e) {
            System.out.println("Error al aplicar filtro de forma dinámica.");
        }
    }

    @Override
    public void undo() {
        editor.removeDecorator(filterClass);
    }

    @Override
    public String getName() {
        return filterClass.getSimpleName().replace("Decorator", "");
    }
}

public class Reto10 {
    public static void main(String[] args) {
        ImageEditor editor = new ImageEditor("foto_vacaciones.png");
        List<ImageCommand> history = new ArrayList<>();

        System.out.println("--- ESTADO INICIAL ---");
        editor.display();

        System.out.println("\n--- APLICANDO FILTROS ACUMULATIVOS ---");

        ImageCommand cmd1 = new ApplyFilterCommand(editor, GrayscaleDecorator.class);
        cmd1.execute(); history.add(cmd1);
        editor.display();

        ImageCommand cmd2 = new ApplyFilterCommand(editor, SepiaDecorator.class);
        cmd2.execute(); history.add(cmd2);
        editor.display();

        ImageCommand cmd3 = new ApplyFilterCommand(editor, BrightnessDecorator.class);
        cmd3.execute(); history.add(cmd3);
        editor.display();

        System.out.println("\n--- DEMOSTRACIÓN DE UNDO INDIVIDUAL (No el último) ---");
        System.out.println("Historial de comandos aplicados:");
        for (int i = 0; i < history.size(); i++) {
            System.out.println("   [" + i + "] Comando: Filtro " + history.get(i).getName());
        }

        System.out.println("\n-> Ejecutando UNDO selectivo sobre el comando [1] (Filtro Sepia)...");
        history.get(1).undo();
        history.remove(1);

        editor.display();

        System.out.println("\n-> Ejecutando UNDO selectivo sobre el comando [0] (Filtro Blanco y Negro)...");
        history.get(0).undo();
        history.remove(0);

        editor.display();
    }
}