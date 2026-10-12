package controlador;

import modelo.Competidor;
import vista.VistaMundial;

/**
 * Controlador: maneja los competidores y conecta el modelo con la vista.
 */
public class ControladorMundial {

    private Competidor[] competidores;
    private int cantidad;
    private VistaMundial vista;

    public ControladorMundial(VistaMundial vista) {
        this.vista = vista;
        this.competidores = new Competidor[20];
        this.cantidad = 0;
    }

    public void agregarCompetidor(Competidor c) {
        if (cantidad < competidores.length) {
            competidores[cantidad] = c;
            cantidad++;
            vista.mostrarMensaje("Registrado: " + c.getNombre());
        } else {
            vista.mostrarMensaje("No hay espacio para más competidores.");
        }
    }

    public Competidor buscarCompetidor(String nombre) {
        for (int i = 0; i < cantidad; i++) {
            if (competidores[i].getNombre().equals(nombre)) {
                return competidores[i];
            }
        }
        return null;
    }

     // Usa la sobrecarga 1 del modelo: actualizarRanking(int)
    public void actualizarRanking(String nombre, int puntos) {
        Competidor c = buscarCompetidor(nombre);
        if (c != null) {
            c.actualizarRanking(puntos);
            vista.mostrarMensaje(nombre + " suma " + puntos + " puntos. Nuevo ranking: "
                    + c.getRanking() + " | Posición global: " + calcularPosicion(c));
        } else {
            vista.mostrarMensaje("No se encontró a " + nombre);
        }
    }

    // Usa la sobrecarga 2 del modelo: actualizarRanking(int, boolean)
    public void actualizarRanking(String nombre, int puntos, boolean ganoMedalla) {
        Competidor c = buscarCompetidor(nombre);
        if (c != null) {
            c.actualizarRanking(puntos, ganoMedalla);
            vista.mostrarMensaje(nombre + " suma " + puntos + " puntos (medalla: " + ganoMedalla
                    + "). Nuevo ranking: " + c.getRanking() + " | Posición global: " + calcularPosicion(c));
        } else {
            vista.mostrarMensaje("No se encontró a " + nombre);
        }
    }

    // Recálculo de la posición global: 1 + cuántos competidores tienen más ranking
    public int calcularPosicion(Competidor c) {
        int posicion = 1;
        for (int i = 0; i < cantidad; i++) {
            if (competidores[i].getRanking() > c.getRanking()) {
                posicion++;
            }
        }
        return posicion;
    
    }
 public void mostrarCompetidores() {
        for (int i = 0; i < cantidad; i++) {
            vista.mostrarMensaje(competidores[i].toString());
        }
    }
    // Ejecuta el programa con datos de ejemplo
    public void iniciar() {
        vista.mostrarTitulo("MUNDIAL DE CICLISMO DE PISTA - CALI");

        vista.mostrarTitulo("Registro de competidores");
        agregarCompetidor(new Competidor("Egan Bernal", 27, "Colombia", 100, 1.75, 60.0));
        agregarCompetidor(new Competidor("Martha Bayona", 30, "Colombia", 150, 1.65, 70.0));
        agregarCompetidor(new Competidor("Harrie Lavreysen", 27, "Paises Bajos", 200, 1.84, 90.0));

        vista.mostrarTitulo("Competidores iniciales");
        mostrarCompetidores();

        vista.mostrarTitulo("Actualización de ranking");
        actualizarRanking("Egan Bernal", 20);                 // solo puntos
        actualizarRanking("Martha Bayona", 60, true);         // medalla y más de 50 puntos (+30)
        actualizarRanking("Harrie Lavreysen", 40, true);      // medalla y 50 o menos (+15)
        actualizarRanking("Egan Bernal", 10, false);          // sin medalla (+0)

        vista.mostrarTitulo("Competidores después de la competencia");
        mostrarCompetidores();
    }
}
