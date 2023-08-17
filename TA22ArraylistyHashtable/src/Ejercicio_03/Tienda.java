/**
 * 
 */
package Ejercicio_03;

/**
 * 
 */

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Tienda {

	/**
	 * 
	 */
	public Tienda() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Articulo> inventario = new ArrayList<>();

        inventario.add(new Articulo("Producto1", 10.0));
        inventario.add(new Articulo("Producto2", 20.0));
        inventario.add(new Articulo("Producto3", 30.0));
        inventario.add(new Articulo("Producto4", 40.0));
        inventario.add(new Articulo("Producto5", 50.0));
        inventario.add(new Articulo("Producto6", 60.0));
        inventario.add(new Articulo("Producto7", 70.0));
        inventario.add(new Articulo("Producto8", 80.0));
        inventario.add(new Articulo("Producto9", 90.0));
        inventario.add(new Articulo("Producto10", 100.0));

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                "Seleccione una opción:\n" +
                "1. Añadir nuevo artículo\n" +
                "2. Consultar artículo\n" +
                "3. Listar artículos\n" +
                "4. Salir"
            ));

            switch (opcion) {
                case 1:
                    String nombreArticulo = JOptionPane.showInputDialog("Introduce el nombre del nuevo artículo:");
                    double precioArticulo = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio del artículo:"));
                    inventario.add(new Articulo(nombreArticulo, precioArticulo));
                    JOptionPane.showMessageDialog(null, "Artículo añadido correctamente.");
                    break;
                case 2:
                    String articuloConsultar = JOptionPane.showInputDialog("Introduce el nombre del artículo a consultar:");
                    boolean encontrado = false;
                    for (Articulo articulo : inventario) {
                        if (articulo.getNombre().equalsIgnoreCase(articuloConsultar)) {
                            JOptionPane.showMessageDialog(null, "Precio de " + articulo.getNombre() + ": " + articulo.getPrecio() + " €");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        JOptionPane.showMessageDialog(null, "Artículo no encontrado.");
                    }
                    break;
                case 3:
                    mostrarArticulos(inventario);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "¡Gracias por usar nuestra tienda!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
                    break;
            }
        } while (opcion != 4);
    }

    public static void mostrarArticulos(ArrayList<Articulo> inventario) {
        StringBuilder mensaje = new StringBuilder("Listado de artículos:\n");
        for (Articulo articulo : inventario) {
            mensaje.append("Artículo: ").append(articulo.getNombre()).append(", Precio: ").append(articulo.getPrecio()).append(" €\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
}

class Articulo {
    private String nombre;
    private double precio;

    public Articulo(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

}
