package determinante.controller;

public class ControllerGeneral extends Controller {

    @Override
    public void start() {

        System.out.println(this.getClass().getSimpleName()+" loaded.");

        ControllerGUI controllerGUI = new ControllerGUI();
        controllerGUI.start();

    }
    
}
