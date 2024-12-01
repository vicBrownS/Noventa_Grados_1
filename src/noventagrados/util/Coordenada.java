package noventagrados.util;

/**
 * Clase que representa una coordenada con fila y columna.
 *
 * @param fila    Número de la fila.
 * @param columna Número de la columna.
 */
public record Coordenada(int fila, int columna) {

    /**
     * Convierte la coordenada a una representación textual.
     *
     * @return Cadena con el formato "fila,columna".
     */
    public String aTexto() {
        return fila + "" + columna;
    }
}

