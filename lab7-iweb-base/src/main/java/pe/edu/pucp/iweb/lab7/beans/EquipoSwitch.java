package pe.edu.pucp.iweb.lab7.beans;

/**
 * Ejercicio 2b: equipo de tipo 'SWITCH'.
 *
 * Soporte mensual (S/) = 0.015 x precio x cantidad
 */
public class EquipoSwitch extends EquipoRed{
    public EquipoSwitch(int idEquipo, String modelo, String tipo, double precio, int cantidad, Sede sede) {
        super(idEquipo, modelo, tipo, precio, cantidad, sede);
    }


    // TODO 2b: debe heredar de EquipoRed


    @Override
    public double calcularSoporteMensual() {
        double soporte = 0.015*getPrecio()*getCantidad();
        return soporte;
    }
    // TODO 2b: implementar calcularSoporteMensual()

}
