package noventagrados.util;

/**
 * Enumeración que representa diferentes sentidos de movimiento en un tablero.
 */
public enum Sentido {
    VERTICAL_N(-1, 0),  // Movimiento vertical hacia el norte.
    VERTICAL_S(1, 0),   // Movimiento vertical hacia el sur.
    HORIZONTAL_E(0, 1), // Movimiento horizontal hacia el este.
    HORIZONTAL_O(0, -1); // Movimiento horizontal hacia el oeste.

    private int desplazamientoEnFilas;   // Desplazamiento en filas.
    private int desplazamientoEnColumnas; // Desplazamiento en columnas.

    /**
     * Constructor de la enumeración.
     *
     * @param desplazamientoEnFilas    Desplazamiento asociado en las filas.
     * @param desplazamientoEnColumnas Desplazamiento asociado en las columnas.
     */
    Sentido(int desplazamientoEnFilas, int desplazamientoEnColumnas) {
        this.desplazamientoEnFilas = desplazamientoEnFilas;
        this.desplazamientoEnColumnas = desplazamientoEnColumnas;
    }

    /**
     * Devuelve el desplazamiento en filas asociado al sentido.
     *
     * @return Desplazamiento en filas.
     */
    public int consultarDesplazamientoEnFilas() {
        return desplazamientoEnFilas;
    }

    /**
     * Devuelve el desplazamiento en columnas asociado al sentido.
     *
     * @return Desplazamiento en columnas.
     */
    public int consultarDesplazamientoEnColumnas() {
        return desplazamientoEnColumnas;
    }
}

