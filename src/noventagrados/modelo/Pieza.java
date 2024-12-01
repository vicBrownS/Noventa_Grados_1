package noventagrados.modelo;

import noventagrados.util.Color;
import noventagrados.util.TipoPieza;

import java.util.Objects;

import java.util.Objects;

/**
 * Clase que representa una pieza de un juego, con un tipo y un color específicos.
 */
public class Pieza {

    private TipoPieza tipoPieza; // Tipo de la pieza (e.g., PEON, REINA).
    private Color color;         // Color de la pieza (e.g., BLANCO, NEGRO).

    /**
     * Constructor de la clase Pieza.
     *
     * @param tipoPieza Tipo de la pieza.
     * @param color     Color de la pieza.
     */
    Pieza(TipoPieza tipoPieza, Color color) {
        this.tipoPieza = tipoPieza;
        this.color = color;
    }

    /**
     * Devuelve una representación textual de la pieza como concatenación de tipo y color.
     *
     * @return Cadena que representa el tipo y color de la pieza.
     */
    public String aTexto() {
        return tipoPieza.toString() + color.toString();
    }

    /**
     * Crea una copia de la pieza actual.
     *
     * @return Nueva instancia de la misma pieza.
     */
    public Pieza clonar() {
        return new Pieza(this.tipoPieza, this.color);
    }

    /**
     * Devuelve el color de la pieza.
     *
     * @return Color de la pieza.
     */
    public Color consultarColor() {
        return color;
    }

    /**
     * Devuelve el tipo de la pieza.
     *
     * @return Tipo de la pieza.
     */
    public TipoPieza consultarTipoPieza() {
        return tipoPieza;
    }

    /**
     * Devuelve una representación en texto de la pieza para depuración.
     *
     * @return Cadena con los detalles de la pieza.
     */
    @Override
    public String toString() {
        return "Pieza{" +
                "tipoPieza=" + tipoPieza +
                ", color=" + color +
                '}';
    }

    /**
     * Comprueba si dos piezas son iguales basándose en su tipo y color.
     *
     * @param o Objeto a comparar.
     * @return true si las piezas son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pieza pieza = (Pieza) o;
        return tipoPieza == pieza.tipoPieza && color == pieza.color;
    }

    /**
     * Calcula el código hash de la pieza basado en su tipo y color.
     *
     * @return Código hash de la pieza.
     */
    @Override
    public int hashCode() {
        return Objects.hash(tipoPieza, color);
    }
}


