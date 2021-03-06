package fiuba.algo3.model.Durabilidad;

import fiuba.algo3.Excepciones.HerramientaRotaException;

public class DesgasteAbrupto extends Desgaste{

    private int cantidadUsosPosibles;
    private int vecesUsado;

    public DesgasteAbrupto(double durabilidad, int cantUsos) {
        super(durabilidad);
        cantidadUsosPosibles = cantUsos;
        vecesUsado = 0;
    }

    @Override
    public void desgastar(int fuerza) {
        this.vecesUsado += 1;
        if (cantidadUsosPosibles <= vecesUsado){
            throw new HerramientaRotaException();
        }
    }
}
