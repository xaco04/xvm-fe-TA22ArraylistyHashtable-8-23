/**
 * 
 */
package Ejercicio_04;

/**
 * 
 */
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;


public class Combinacion {

	/**
	 * 
	 */
	public Combinacion() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Articulo> inventario = new ArrayList<>();
        ArrayList<Double> carrito = new ArrayList<>();

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
                "1. Añadir producto al carrito\n" +
                "2. Mostrar resumen de compra\n" +
                "3. Añadir nuevo artículo\n" +
                "4. Consultar artículo\n" +
                "5. Listar artículos\n" +
                "6. Salir"
            ));

            switch (opcion) {
                case 1:
                    double precioProducto = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio del producto:"));
                    carrito.add(precioProducto);
                    break;
                case 2:
                    mostrarResumenCompra(carrito);
                    break;
                case 3:
                    String nombreArticulo = JOptionPane.showInputDialog("Introduce el nombre del nuevo artículo:");
                    double precioArticulo = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio del artículo:"));
                    inventario.add(new Articulo(nombreArticulo, precioArticulo));
                    JOptionPane.showMessageDialog(null, "Artículo añadido correctamente.");
                    break;
                case 4:
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
                case 5:
                    mostrarArticulos(inventario);
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "¡Gracias por usar nuestra tienda!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
                    break;
            }
        } while (opcion != 6);
    }

    public static void mostrarResumenCompra(ArrayList<Double> carrito) {
        double totalBruto = 0;
        int numArticulos = carrito.size();

        Iterator<Double> iterator = carrito.iterator();
        while (iterator.hasNext()) {
            totalBruto += iterator.next();
        }

        double iva = totalBruto * 0.21; // IVA del 21%
        double totalConIva = totalBruto + iva;

        double cantidadPagada = Double.parseDouble(JOptionPane.showInputDialog("Introduce la cantidad pagada:"));
        double cambio = cantidadPagada - totalConIva;

        String mensaje = "Resumen de compra:\n" +
                "IVA aplicado: 21%\n" +
                "Precio total bruto: " + totalBruto + " €\n" +
                "Precio total con IVA: " + totalConIva + " €\n" +
                "Número de artículos comprados: " + numArticulos + "\n" +
                "Cantidad pagada: " + cantidadPagada + " €\n" +
                "Cambio a devolver: " + cambio + " €";
        JOptionPane.showMessageDialog(null, mensaje);
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
