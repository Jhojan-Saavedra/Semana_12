import java.util.PriorityQueue;
import java.util.Comparator;

class Paciente {
    String nombre;
    int prioridad; // 1 = más urgente, 2, 3

    Paciente(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return nombre + " (Prioridad " + prioridad + ")";
    }
}

class SistemaTriage {

    // Cola de prioridad basada en triage
    private PriorityQueue<Paciente> cola;

    public SistemaTriage() {
        // Prioridad más baja en número = más urgente
        cola = new PriorityQueue<>(Comparator.comparingInt(p -> p.prioridad));
    }

    // 1. Registrar paciente
    public void registrar(String nombre, int prioridad) {
        cola.add(new Paciente(nombre, prioridad));
    }

    // 2. Ver siguiente (sin atender)
    public Paciente verSiguiente() {
        return cola.peek();
    }

    // 3. Atender siguiente
    public Paciente atender() {
        return cola.poll();
    }

    // 4. Mostrar contadores por prioridad
    public void mostrarContadores() {
        int rojo = 0, amarillo = 0, verde = 0;

        for (Paciente p : cola) {
            if (p.prioridad == 1) rojo++;
            else if (p.prioridad == 2) amarillo++;
            else verde++;
        }

        System.out.println("Rojo (1): " + rojo);
        System.out.println("Amarillo (2): " + amarillo);
        System.out.println("Verde (3): " + verde);
    }
}

public class Triage {
    public static void main(String[] args) {

        SistemaTriage sistema = new SistemaTriage();

        // Ejemplo mínimo
        sistema.registrar("Carlos", 1);
        sistema.registrar("Ana", 3);
        sistema.registrar("Luis", 2);

        System.out.println("Siguiente: " + sistema.verSiguiente());
        System.out.println("Atendiendo: " + sistema.atender());

        System.out.println("Contadores:");
        sistema.mostrarContadores();
    }
}
