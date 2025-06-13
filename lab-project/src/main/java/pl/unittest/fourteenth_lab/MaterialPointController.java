package pl.unittest.fourteenth_lab;

public class MaterialPointController {

    public MaterialPointController(MaterialPointModel model, MaterialPointView view) {

        view.getLinearScaleButton().addActionListener(ActionEvent -> {

            System.out.println("linear scale");
        });

        view.getLogScaleButton().addActionListener(ActionEvent -> {
           System.out.println("log scale");
        });
    }

}
