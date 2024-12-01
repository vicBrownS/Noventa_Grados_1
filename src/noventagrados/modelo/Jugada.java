package noventagrados.modelo;

/**
 * Clase que representa una jugada en un juego, definida por una celda de origen y una de destino.
 *
 * @param origen  Celda inicial de la jugada.
 * @param destino Celda final de la jugada.
 */
public record Jugada(Celda origen, Celda destino) {

    /**
     * Convierte la jugada a una representación textual.
     *
     * @return Cadena con el formato "origen-destino", donde origen y destino
     *         son las coordenadas de las celdas involucradas.
     */
    public String aTexto() {
        return origen.consultarCoordenada().toString() + "-" + destino.consultarCoordenada().toString();
    }
}

