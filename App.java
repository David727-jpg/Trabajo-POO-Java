package registroequipos;

import javax.swing.*;
import java.util.ArrayList;
import registroequipos.model.*;

public class App {
    private static ArrayList<Desktop> desktops = new ArrayList<>();
    private static ArrayList<Laptop> laptops = new ArrayList<>();
    private static ArrayList<Tablet> tablets = new ArrayList<>();

    public static void main(String[] args) {
        String menu = "1. Registrar equipo\n2. Ver equipos\n3. Salir";
        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion) {
                case 1:
                    registrarEquipo();
                    break;
                case 2:
                    verEquipos();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        } while (opcion != 3);
    }

    private static void registrarEquipo() {
        String tipo = JOptionPane.showInputDialog("Registrar:\n1. Desktop\n2. Laptop\n3. Tablet");

        switch (tipo) {
            case "1":
                desktops.add(new Desktop(
                        pedirDato("Fabricante"),
                        pedirDato("Modelo"),
                        pedirDato("Microprocesador"),
                        pedirDato("Memoria"),
                        pedirDato("Tarjeta gráfica"),
                        pedirDato("Tamaño torre"),
                        pedirDato("Capacidad disco")
                ));
                break;
            case "2":
                laptops.add(new Laptop(
                        pedirDato("Fabricante"),
                        pedirDato("Modelo"),
                        pedirDato("Microprocesador"),
                        pedirDato("Memoria"),
                        pedirDato("Tamaño pantalla"),
                        pedirDato("Capacidad disco")
                ));
                break;
            case "3":
                tablets.add(new Tablet(
                        pedirDato("Fabricante"),
                        pedirDato("Modelo"),
                        pedirDato("Microprocesador"),
                        pedirDato("Tamaño pantalla"),
                        pedirDato("¿Capacitiva/Resistiva?"),
                        pedirDato("Memoria NAND"),
                        pedirDato("Sistema operativo")
                ));
                break;
            default:
                JOptionPane.showMessageDialog(null, "Tipo inválido");
        }
    }

    private static void verEquipos() {
        String tipo = JOptionPane.showInputDialog("Ver:\n1. Desktops\n2. Laptops\n3. Tablets");
        StringBuilder sb = new StringBuilder();

        switch (tipo) {
            case "1":
                for (Desktop d : desktops) {
                    sb.append(d.toString()).append("\n");
                }
                break;
            case "2":
                for (Laptop l : laptops) {
                    sb.append(l.toString()).append("\n");
                }
                break;
            case "3":
                for (Tablet t : tablets) {
                    sb.append(t.toString()).append("\n");
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Tipo inválido");
        }

        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(null, sb.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No hay registros aún.");
        }
    }

    private static String pedirDato(String campo) {
        String dato;
        do {
            dato = JOptionPane.showInputDialog("Ingrese " + campo + ":");
        } while (dato == null || dato.trim().isEmpty());
        return dato;
    }
}
