package fiuba.algo3.model.Materiales;

import fiuba.algo3.Excepciones.MaterialRotoException;
import fiuba.algo3.model.Contratos.IGuardable;
import fiuba.algo3.model.Contratos.IOcupable;
import fiuba.algo3.model.Golpe.Golpeable;
import fiuba.algo3.model.Mapa.Posicion;

public abstract class Material implements Golpeable, IOcupable, IGuardable {
    protected  int durabilidad;
    private Posicion posicion;
    public void desgastar(int fuerza) {
        this.durabilidad -= fuerza;
        if (this.durabilidad <= 0){
            throw new MaterialRotoException();
        }
    }

    public int obtenerDurabilidad(){
        return this.durabilidad;
    }

    @Override
    public void definirPosicion(Posicion nuevaPosicion) {
        this.posicion = nuevaPosicion;
    }

    @Override
    public Posicion obtenerPosicionActual() {
        return this.posicion;
    }
}
