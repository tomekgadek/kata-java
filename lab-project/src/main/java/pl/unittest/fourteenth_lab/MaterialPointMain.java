package pl.unittest.fourteenth_lab;

/*
    Proszę utworzyć aplikację w języku Java, która:

    Wczyta ze standardowego wejścia dane w postaci:

    liczbaPunktowMaterialnych
    wsp_x1 wsp_y1 masa_1
    wsp_x2 wsp_y2 masa_2
    ...
    wsp_xN wsp_yN masa_N

    Zwracam uwagę, że współrzędne i masy podane są w postaci zmiennoprzecinkowej!

    Wyświetli w postaci graficznej obrazek pokazujący położenie punktów materialnych w postaci kół
    (a nie elips) o średnicy proporcjonalnej do masy danego punktu.
    Maksymalna średnica (czyli średnica koła reprezentującego najcięższy punkt) to 10% z minimum
    z wysokości/szerokości panelu. Obraz ma się dostosowywać do rozmiaru okna.
    Cały obraz a nie tylko koła. Rozmiar okna musi się dać zmienić.

    Punkty połączyć liniami w kolejności ich występowania w pliku.

    Będzie zawierać dwa przyciski: SKALA LINIOWA i SKALA LOGARYTMICZNA, które pozwolą na zmianę
    sposobu prezentacji masy. W pierwszym przypadku średnica koła ma być proporcjonalna do masy punktu,
    w drugim do jej logarytmu. Wszystkie masy będą większe od 1!

    Punkty proszę wyświetlać na układzie współrzędnych kartezjańskich.
    Współrzędne dodatnie są na prawo i w górę od środka układu współrzędnych.

    Przykładowe dane wejściowe:

    5
    1.0 2.0 3.5
    -1.0 -2.0 0.5
    -10.0 10.0 0.0
    1.0 1.0 1.5
    2.5 2.5 2.5

    Takie dane jak poniżej także są zgodne z założeniami zadania. Dane są typu rzeczywistego, żadnego limitu ich
    wielkości i ilości nie ma:

    4
    -2000.0 0.0 50.0
    0.0 100.0 0.0
    2000.0 -2000.0 25.0
    0.0 -2000.0 5.0

    Program testuje się za pomocą polecenia:

    java Start < plik_z_punktami.txt

    Warto więc zadbać, aby program dał się w ten sposób uruchomić.
*/

import javax.swing.*;

class MaterialPointMain {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            var allPoints = MaterialPointModel.loadPointsFromInputStream().points();
            var drawingPanel = new MaterialPointDrawingPanelView(allPoints);
            var view = new MaterialPointView(drawingPanel);

            new MaterialPointController(view);
        });
    }
}
