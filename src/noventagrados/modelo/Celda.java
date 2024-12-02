package noventagrados.modelo;

import noventagrados.util.Color;
import noventagrados.util.Coordenada;

import java.util.Objects;

/**
 * Clase que representa una celda en un tablero, la cual puede contener una pieza.
 */
public class Celda {

    private Coordenada coordenada; // Coordenada que identifica la ubicación de la celda.
    private Pieza pieza;           // Pieza que ocupa la celda, puede ser null si está vacía.

    /**
     * Constructor de la clase Celda.
     *
     * @param coordenada Coordenada asociada a la celda.
     */
    public Celda(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    /**
     * Crea una copia de la celda actual.
     *
     * @return Nueva instancia de la celda con la misma coordenada y pieza.
     */
    public Celda clonar() {

        Celda clon = new Celda(this.coordenada);
        if (!this.estaVacia()) {
            clon.pieza = this.pieza;
        }

        return clon;
    }

    /**
     * Coloca una pieza en la celda.
     *
     * @param pieza Pieza a colocar en la celda.
     */
    public void colocar(Pieza pieza) {
        this.pieza = pieza;
    }

    /**
     * Consulta el color de la pieza en la celda.
     *
     * @return Color de la pieza en la celda.
     */
    public Color consultarColorDePieza() {
        return this.pieza.consultarColor();
    }

    /**
     * Consulta la coordenada de la celda.
     *
     * @return Coordenada de la celda.
     */
    public Coordenada consultarCoordenada() {
        return this.coordenada;
    }

    /**
     * Consulta la pieza que ocupa la celda.
     *
     * @return Pieza que ocupa la celda, o null si está vacía.
     */
    public Pieza consultarPieza() {
        return this.pieza;
    }

    /**
     * Elimina la pieza de la celda, dejándola vacía.
     */
    public void eliminarPieza() {
        this.pieza = null;
    }

    /**
     * Verifica si la celda está vacía.
     *
     * @return true si la celda está vacía, false en caso contrario.
     */
    public boolean estaVacia() {
        return this.pieza == null;
    }

    /**
     * Devuelve una representación textual de la celda.
     *
     * @return Cadena con los detalles de la celda.
     */
    @Override
    public String toString() {
        return "Celda{" +
                "coordenada=" + coordenada +
                ", pieza=" + pieza +
                '}';
    }

    /**
     * Comprueba si dos celdas son iguales basándose en su coordenada y pieza.
     *
     * @param o Objeto a comparar.
     * @return true si las celdas son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Celda celda = (Celda) o;
        return Objects.equals(coordenada, celda.coordenada) && Objects.equals(pieza, celda.pieza);
    }

    /**
     * Calcula el código hash de la celda basado en su coordenada y pieza.
     *
     * @return Código hash de la celda.
     */
    @Override
    public int hashCode() {
        return Objects.hash(coordenada, pieza);
    }
}

