package fiuba.algo3.model.MesaDeCrafteo;

import fiuba.algo3.model.Herramientas.Herramienta;
import fiuba.algo3.model.Mapa.Posicion;
import fiuba.algo3.model.Materiales.Madera;

public class CrafteoHachaMadera extends CrafteoHerramientas{


    public CrafteoHachaMadera(){

        crafteo.put(new Posicion(0,0), new Madera());
        crafteo.put(new Posicion(0,1), new Madera());
        crafteo.put(new Posicion(1,0), new Madera());
        crafteo.put(new Posicion(1,1), new Madera());
        crafteo.put(new Posicion(1,2), new Madera());
    }


    @Override
    public Herramienta crearHerramienta() {
        return constructor.construirHachaDeMadera();
    }
}
