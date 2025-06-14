package pl.unittest.fourteenth_lab;

public class MaterialPointController {

    public MaterialPointController(MaterialPointModel model, MaterialPointView view) {

        view.getLinearScaleButton().addActionListener(ActionEvent -> {

            view.setLogScale(false);
        });

        view.getLogScaleButton().addActionListener(ActionEvent -> {

            view.setLogScale(true);
        });
    }
}
