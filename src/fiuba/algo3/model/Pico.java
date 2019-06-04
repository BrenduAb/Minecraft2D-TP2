package fiuba.algo3.model;

import fiuba.algo3.Contratos.IHerramienta;
import fiuba.algo3.Contratos.IMaterial;

public class Pico implements IHerramienta {

    private IMaterial material;

    public Pico(Metal metal){
        this.material = metal;
    }

    public Pico(Madera madera) {
    this.material = madera;
    }


    public Pico(Piedra piedra) {
        this.material = piedra;
    }

    @Override
    public int obtenerDurabilidad() {
        return 0;
    }

    @Override
    public int obtenerFuerza() {
        return 0;
    }

    @Override
    public void usarContra(IMaterial material) {
    }

    @Override
    public int calcularDanio(Madera madera) {
        return 0;
    }

    @Override
    public int calcularDanio(Piedra piedra) {
        return 0;
    }

    @Override
    public int calcularDanio(Metal piedra) {
        if(this.material.getClass() == Piedra.class){
            return 4;
        }
        return 0;
    }
}
