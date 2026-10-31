package pe.edu.pucp.iweb.lab7.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pe.edu.pucp.iweb.lab7.beans.EquipoAP;
import pe.edu.pucp.iweb.lab7.beans.EquipoRed;
import pe.edu.pucp.iweb.lab7.beans.EquipoSwitch;
import pe.edu.pucp.iweb.lab7.beans.Sede;

public class EquipoDao extends BaseDao { // TODO 2a: debe heredar de BaseDao

    /**
     * Ejercicio 2c: retorna los equipos de la sede indicada, ordenados por sede y modelo.
     * Si idSede es 0, retorna todos los equipos.
     *
     * Según la columna tipo, cree un objeto EquipoSwitch ('SWITCH') o EquipoAP ('AP').
     * Use PreparedStatement.
     */
    public ArrayList<EquipoRed> listarPorSede(int idSede) {
        ArrayList<EquipoRed> lista = new ArrayList<>();
        // TODO 2c

        Connection conexion = getConnection();
        String sql = """
        select 
        s.idsede,
        s.nombre,
        e.idequipo,
        e.modelo,
        e.tipo,
        e.precio,
        e.cantidad
        
        from sede s
        inner join equipo e
        on s.idsede = e.idsede
        """;

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                int idsede = rs.getInt("idsede");
                String nombreSede = rs.getString("nombre");
                int idequipo = rs.getInt("idequipo");
                String modelo = rs.getString("modelo");
                String tipo = rs.getString("tipo");
                double precio = rs.getDouble("precio");
                int cantidad = rs.getInt("cantidad");


                Sede sede = new Sede(idSede,nombreSede);

                if (tipo == "SWITCH") {
                    EquipoSwitch equipoSwitch = new EquipoSwitch(idequipo,modelo,tipo,precio,cantidad,sede);
                } else if (tipo == "AP") {
                    EquipoAP equipoAP = new EquipoAP(idequipo,modelo,tipo,precio,cantidad,sede);
                }










            }

        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos" + e.getMessage());
        }



        return lista;
    }
}
