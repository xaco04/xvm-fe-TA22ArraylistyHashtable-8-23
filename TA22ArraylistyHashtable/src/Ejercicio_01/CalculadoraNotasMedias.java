/**
 * 
 */
package Ejercicio_01;

/**
 * 
 */
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;


public class CalculadoraNotasMedias {

	/**
	 * 
	 */
	public CalculadoraNotasMedias() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Alumno> alumnos = new ArrayList<>();
        
        int numAlumnos = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número de alumnos:"));
        
        for (int i = 0; i < numAlumnos; i++) {
            String nombreAlumno = JOptionPane.showInputDialog("Nombre del alumno " + (i + 1) + ":");
            Alumno alumno = new Alumno(nombreAlumno);
            obtenerNotasAlumno(alumno);
            alumnos.add(alumno);
        }
        
        mostrarNotasMedias(alumnos);
    }

    public static void obtenerNotasAlumno(Alumno alumno) {
        int numNotas = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número de notas para " + alumno.getNombre() + ":"));
        for (int i = 0; i < numNotas; i++) {
            double nota = Double.parseDouble(JOptionPane.showInputDialog("Introduce la nota " + (i + 1) + " para " + alumno.getNombre() + ":"));
            alumno.agregarNota(nota);
        }
    }

    public static void mostrarNotasMedias(ArrayList<Alumno> alumnos) {
        StringBuilder mensaje = new StringBuilder("Notas medias de los alumnos:\n");
        Iterator<Alumno> iterator = alumnos.iterator();
        while (iterator.hasNext()) {
            Alumno alumno = iterator.next();
            mensaje.append("Alumno: ").append(alumno.getNombre()).append(", Nota Media: ").append(alumno.calcularNotaMedia()).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
}

class Alumno {
    private String nombre;
    private ArrayList<Double> notas;

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.notas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarNota(double nota) {
        notas.add(nota);
    }

    public double calcularNotaMedia() {
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.size();
    }

}


