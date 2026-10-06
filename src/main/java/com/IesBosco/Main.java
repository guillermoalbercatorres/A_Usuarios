package com.IesBosco;

import java.sql.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
        static void main() {
// La base de datos está en el directorio de trabajo del proyecto.
            String url = "jdbc:sqlite:prueba.db";


            ResultSet rs = null;
            ResultSet rs1 = null;
            try (Connection conexion = DriverManager.getConnection(url);
                 Statement stmt = conexion.createStatement();
                 Scanner t = new Scanner(System.in);
            ) {
                // Conectar a la base de datos
                System.out.println("Conexión establecida con éxito.");


                System.out.println("Dime su localidad ");
                String localidad1 = t.nextLine();

                System.out.println("Dime el codigo ");
                //t.nextLine();
                int cod1 = t.nextInt();


                // Ejecutar consulta
                /*
                 * Consulta original
                 * select u.cod , telefono from usuarios u
                 * join telefonos t on t.cod =u.cod WHERE u.cod =1 and u.localidad ='Teruel'
                 * */
                String psql = "select u.* from usuarios u " +
                        "join telefonos t on t.cod =u.cod WHERE u.cod =? and u.localidad =?";
                System.out.println(psql);
//            String sql = "select * from usuarios u JOIN telefonos t on t.cod =u.cod group by u.cod ";
//            rs = stmt.executeQuery(sql);
                PreparedStatement pstmt = conexion.prepareStatement(psql);

                pstmt.setString(2, localidad1);
                pstmt.setInt(1, cod1);
                rs1 = pstmt.executeQuery();

                // Mostrar resultados
                System.out.println("Datos de usuarios:");
//            while (rs.next()) {
//                int cod = rs.getInt("cod");
//                String nombre = rs.getString("nombre");
//                String apellidos = rs.getString("apellidos");
//                String direccion = rs.getString("direccion");
//                String localidad = rs.getString("localidad");
//
//                System.out.println(cod + " | " + nombre + " | " + apellidos + " | " + direccion + " | " + localidad);
//            }

                visualizarConsulta(rs1);


            } catch (SQLException e) {
                String ErrorMessaje = "Error al conectar o consultar la base de datos:";
                System.out.println(ErrorMessaje);
                e.printStackTrace();
            }
        }
    private static void visualizarConsulta(ResultSet rs1) throws SQLException {
        while (rs1.next()) {
            int cod = rs1.getInt("cod");
            String nombre = rs1.getString("nombre");
            String apellidos = rs1.getString("apellidos");
            String direccion = rs1.getString("direccion");
            String localidad = rs1.getString("localidad");

            System.out.println(cod + " | " + nombre + " | " + apellidos + " | " + direccion + " | " + localidad);
        }

    }
    }
