package noventagrados.util;

/**
 * Enumeración que representa los tipos de piezas disponibles.
 */
public enum TipoPieza {
    PEON('P'),  // Representa la pieza Peón.
    REINA('R'); // Representa la pieza Reina.

    private char caracter; // Carácter que identifica al tipo de pieza.

    /**
     * Constructor de la enumeración.
     *
     * @param letra Carácter que representa el tipo de pieza.
     */
    TipoPieza(char letra) {
        this.caracter = letra;
    }

    /**
     * Devuelve el carácter asociado al tipo de pieza.
     *
     * @return Carácter que representa al tipo de pieza.
     */
    public char toChar() {
        return caracter;
    }
}

