/**
 * 
 */
package Ejercicio_02;

/**
 * 
 */
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;


public class CajaSupermercado {

	/**
	 * 
	 */
	public CajaSupermercado() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Double> carrito = new ArrayList<>();

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                "Seleccione una opción:\n" +
                "1. Agregar producto al carrito\n" +
                "2. Mostrar resumen de compra\n" +
                "3. Salir"
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
                    JOptionPane.showMessageDialog(null, "¡Gracias por su compra!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
                    break;
            }
        } while (opcion != 3);
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



}
