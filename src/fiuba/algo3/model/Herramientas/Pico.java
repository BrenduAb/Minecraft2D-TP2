package fiuba.algo3.model.Herramientas;

import fiuba.algo3.model.Durabilidad.Desgaste;
import fiuba.algo3.model.Golpe.Golpe;
import fiuba.algo3.model.Materiales.Material;

public class Pico extends Herramienta {

    public Pico(Desgaste desgaste, Golpe golpe) {
        super(desgaste, golpe);
    }

    @Override
    public void usarContra(Material materialARecolectar) {
        this.golpe.golpear(materialARecolectar,this);
    }

    @Override
    public void desgastar(int danio) {
        this.desgaste.desgastar(danio);
    }
}
