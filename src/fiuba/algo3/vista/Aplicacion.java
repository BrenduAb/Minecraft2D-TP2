package fiuba.algo3.vista;

import fiuba.algo3.model.Juego;
import fiuba.algo3.controller.ControlesJugadorKeyPressEventHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {

        stage.setTitle("TP2 ALGOCRAFT");
        Juego juego = new Juego();
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, juego);
        Scene escenaJuego = new Scene(contenedorPrincipal, 640, 480);


        ControlesJugadorKeyPressEventHandler controlesEventHandler = new ControlesJugadorKeyPressEventHandler(contenedorPrincipal.obtenerVistaJugador(), juego.obtenerJugador());
        escenaJuego.setOnKeyPressed(controlesEventHandler);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);

        // add handler to this:
        // stage.setOnCloseRequest()

        stage.setScene(escenaBienvenidos);


        stage.show();

    }

}
