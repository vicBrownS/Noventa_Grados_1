/**
 * @Author Victor Brown Sogorb
 */
package noventagrados.util;

/**
 * Enumeración que representa los colores disponibles en una partida.
 */
public enum Color {
    BLANCO('B'), // Representa el color blanco.
    NEGRO('N');  // Representa el color negro.

    private char letra; // Carácter que identifica al color.

    /**
     * Constructor de la enumeración.
     *
     * @param letra Carácter que representa el color.
     */
    Color(char letra) {
        this.letra = letra;
    }

    /**
     * Obtiene el color opuesto al actual.
     *
     * @return El color contrario.
     */
    public Color consultarContrario() {
        return this == Color.NEGRO ? Color.BLANCO : Color.NEGRO;
    }

    /**
     * Devuelve el carácter que representa al color.
     *
     * @return Carácter asociado al color.
     */
    public char toChar() {
        return letra;
    }
}

