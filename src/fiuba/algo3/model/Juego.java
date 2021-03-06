package fiuba.algo3.model;

import fiuba.algo3.model.Jugador.Jugador;
import fiuba.algo3.model.Mapa.Mapa;
import fiuba.algo3.model.Mapa.Posicion;
import fiuba.algo3.model.Materiales.*;
import fiuba.algo3.model.MesaDeCrafteo.CrafteadorHerramientas;
import fiuba.algo3.model.MesaDeCrafteo.MesaDeCrafteo;

public class

Juego {

    private int POS_X_JUGADOR = 7;
    private int POS_Y_JUGADOR = 7;


    private Jugador jugador;
    private MesaDeCrafteo mesa;

    public Juego() {
        Mapa mapa = Mapa.getInstance();

        Posicion posicionJugador = new Posicion(POS_X_JUGADOR, POS_Y_JUGADOR);

        Jugador jugador = new Jugador(posicionJugador, mapa);

        this.inicializarTerreno(mapa);

        this.jugador = jugador;

        this.mesa = new MesaDeCrafteo(new CrafteadorHerramientas());
    }

    private void inicializarTerreno(Mapa mapa) {
        for (int x = 1; x < 3; x++) {
            for (int y = 1; y < 3; y++) {
                Posicion posicion = new Posicion(x, y);
                Metal metal = new Metal();
                mapa.ocuparTerreno(posicion, metal);
            }
        }

        for (int x = 1; x < 5; x++) {
            for (int y = 4; y < 8; y++) {
                Posicion posicion = new Posicion(x, y);
                Madera madera = new Madera();
                mapa.ocuparTerreno(posicion, madera);
            }
        }

        for (int x = 5; x < 7; x++) {
            for (int y = 1; y < 3; y++) {
                Posicion posicion = new Posicion(x, y);
                Piedra piedra = new Piedra();
                mapa.ocuparTerreno(posicion, piedra);
            }
        }

        for (int x = 9; x < 11; x++) {
            for (int y = 1; y < 3; y++) {
                Posicion posicion = new Posicion(x, y);
                Diamante diamante = new Diamante();
                mapa.ocuparTerreno(posicion, diamante);
            }
        }
    }

    public Jugador obtenerJugador() {
        return this.jugador;
    }

    public MesaDeCrafteo obtenerMesaDeCrafteo() {
        return this.mesa;
    }

    public void agregarMaterialEnMesa(Posicion posicion, Material material) {
        this.mesa.agregarMaterial(posicion, material);
        this.jugador.removerGuardable(material);
    }
}
