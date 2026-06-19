package DOSW.Semana3;

import java.util.ArrayList;
import java.util.List;


interface RecommendationAlgorithm {
    List<String> recommend(User user);
}

class GenreStrategy implements RecommendationAlgorithm {
    @Override
    public List<String> recommend(User user) {
        return List.of("Película Sci-Fi 1", "Serie de Acción 2", "Documental de Naturaleza");
    }
}

class PopularityStrategy implements RecommendationAlgorithm {
    @Override
    public List<String> recommend(User user) {
        return List.of("Top 1 Global (Tendencia)", "Estreno Más Visto del Mes");
    }
}

class HistoryStrategy implements RecommendationAlgorithm {
    @Override
    public List<String> recommend(User user) {
        return List.of("Continuar Viendo: Episodio 5", "Porque viste 'Breaking Bad'");
    }
}


interface PreferenceObserver {
    void onPreferenceChanged(User user);
}

class HomePageComponent implements PreferenceObserver {
    @Override
    public void onPreferenceChanged(User user) {
        System.out.println("  [UI - Home Page]: Renderizando carrusel principal con -> " + user.getRecommendations());
    }
}

class SuggestedListComponent implements PreferenceObserver {
    @Override
    public void onPreferenceChanged(User user) {
        System.out.println("  [UI - Sidebar]: Actualizando barra lateral de 'Sugeridos para ti'.");
    }
}

class NotificationService implements PreferenceObserver {
    @Override
    public void onPreferenceChanged(User user) {
        System.out.println("  [Backend - Notificaciones]: Silenciando alertas antiguas y preparando nuevas notificaciones push.");
    }
}


class User {
    private final String username;
    private RecommendationAlgorithm algorithm;
    private final List<PreferenceObserver> observers = new ArrayList<>();

    public User(String username, RecommendationAlgorithm defaultAlgorithm) {
        this.username = username;
        this.algorithm = defaultAlgorithm;
    }

    public void addObserver(PreferenceObserver observer) {
        observers.add(observer);
    }

    public List<String> getRecommendations() {
        return algorithm.recommend(this);
    }

    public void setRecommendationAlgorithm(RecommendationAlgorithm newAlgorithm) {
        this.algorithm = newAlgorithm;
        System.out.println("\n*** EVENTO: '" + username + "' ha cambiado su motor de recomendación ***");
        notifyObservers();
    }

    private void notifyObservers() {
        for (PreferenceObserver obs : observers) {
            obs.onPreferenceChanged(this);
        }
    }
}


public class Reto6 {
    public static void main(String[] args) {
        User user = new User("Camilo", new PopularityStrategy());

        HomePageComponent homePage = new HomePageComponent();
        SuggestedListComponent sidebar = new SuggestedListComponent();
        NotificationService notifier = new NotificationService();

        user.addObserver(homePage);
        user.addObserver(sidebar);
        user.addObserver(notifier);

        System.out.println("--- CARGA INICIAL DE LA APLICACIÓN ---");
        System.out.println("Motor activo: " + user.getRecommendations());

        user.setRecommendationAlgorithm(new HistoryStrategy());

        user.setRecommendationAlgorithm(new GenreStrategy());
    }
}