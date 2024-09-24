/** Kreacyjny wzorzec projektowy: Singleton. */

/*
 * Jego celem jest ograniczenie możliwości tworzenia obiektów danej klasy do jednej instancji oraz
 * zapewnienie globalnego dostępu do utworzonego obiektu.
 */

import java.util.HashMap;
import java.util.Map;

class ApplicationSettings {

    private static ApplicationSettings settings = null;

    private Map<String, String> params = null;

    private ApplicationSettings() {
        this.params = prepareParams();
    }

    public static synchronized ApplicationSettings config() {

        if(settings == null) {
            settings = new ApplicationSettings();
        }

        return settings;
    }

    public String readValue(final String key) {
        return this.params.get(key);
    }

    private Map<String, String> prepareParams() {
        var params = new HashMap<String, String>();

        params.put("app.name", "Tweeter");
        params.put("app.main-color", "#000066");

        return params;
    }

}

class Main {

    public static void main(String[] args) {

        var appConfig = ApplicationSettings.config();

        System.out.println("App name : " + appConfig.readValue("app.name"));
        System.out.println("Hashcode : " + appConfig.hashCode());

        appConfig = ApplicationSettings.config();

        System.out.println("App color: " + appConfig.readValue("app.main-color"));
        System.out.println("Hashcode : " + appConfig.hashCode());
    }
}
