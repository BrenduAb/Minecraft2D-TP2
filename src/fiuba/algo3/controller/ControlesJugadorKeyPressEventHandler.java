package fiuba.algo3.controller;


import fiuba.algo3.Excepciones.CeldaOcupadaException;
import fiuba.algo3.Excepciones.HerramientaRotaException;
import fiuba.algo3.Excepciones.JugarSinHerramientaEquipadaException;
import fiuba.algo3.Excepciones.PosicionInvalidaException;
import fiuba.algo3.model.Jugador.Jugador;
import fiuba.algo3.model.Mapa.Mapa;
import fiuba.algo3.model.Mapa.Posicion;
import fiuba.algo3.model.Materiales.Material;
import fiuba.algo3.vista.VistaJugador;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;

public class ControlesJugadorKeyPressEventHandler implements EventHandler<KeyEvent> {
    VistaJugador vistaJugador;
    Jugador jugador;
    MediaPlayer mediaPlayer;
    private AudioClip sonidoCesped = new AudioClip(Paths.get("src/fiuba/algo3/vista/sonidos/cesped.mp3").toUri().toString());
    private AudioClip sonidoGolpear = new AudioClip(Paths.get("src/fiuba/algo3/vista/sonidos/golpear.mp3").toUri().toString());

    public ControlesJugadorKeyPressEventHandler(VistaJugador vistaJugador, Jugador jugador) {
        this.vistaJugador = vistaJugador;
        this.jugador = jugador;
    }

    private void play_sound(){
        //= new AudioClip(this.getClass().getResource(Paths.get("src/main/resources/stackoverflow/audio/alert.wav").toUri().toString()));
        sonidoCesped.stop();
        sonidoCesped.play();
    }

    @Override
    public void handle(KeyEvent event) {

        play_sound();

        Posicion pos = null;
        try {
            switch (event.getCode()) {
                case W:
                    pos = jugador.obtenerPosicionActual().posicionSiguienteArriba();
                    jugador.moverHaciArriba();
                    break;
                case S:
                    pos = jugador.obtenerPosicionActual().posicionSiguienteAbajo();
                    jugador.moverHaciAbajo();
                    break;
                case D:
                    pos = jugador.obtenerPosicionActual().posicionSiguienteDerecha();
                    jugador.moverHaciaLaDerecha();
                    break;
                case A:
                    pos = jugador.obtenerPosicionActual().posicionSiguienteIzquierda();
                    jugador.moverHaciaLaIzquierda();
                    break;
            }
        } catch (CeldaOcupadaException ex) {
            try {
                sonidoCesped.stop();
                sonidoGolpear.play();
                Mapa mapa = Mapa.getInstance();
                Material material = (Material) mapa.obtenerCelda(pos).obtenerElemento();
                mapa.chocarJugadorConMaterial(jugador, material);
            } catch (HerramientaRotaException ex2) {

            }catch (JugarSinHerramientaEquipadaException ex3){

            }
        } catch (PosicionInvalidaException ex) {

        }
        vistaJugador.update();
    }
}
