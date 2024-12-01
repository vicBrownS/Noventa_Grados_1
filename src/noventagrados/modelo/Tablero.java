package noventagrados.modelo;

import noventagrados.util.Coordenada;

import java.util.Arrays;
import java.util.Objects;

import java.util.Arrays;
import java.util.Objects;

/**
 * Clase que representa un tablero con celdas para un juego de mesa.
 * El tablero es una matriz de 7x7 celdas, donde cada celda puede contener una pieza o estar vacía.
 */
public class Tablero {

    private Celda[][] tablero;         // Matriz que representa las celdas del tablero.
    private final int NUMEROFILAS = 7; // Número total de filas en el tablero.
    private final int NUMEROCOLUMNAS = 7; // Número total de columnas en el tablero.

    /**
     * Constructor por defecto. Inicializa un tablero vacío de dimensiones 7x7.
     */
    Tablero() {
        tablero = new Celda[7][7];
    }

    /**
     * Devuelve una representación textual del tablero.
     * Las celdas vacías se representan como "--".
     *
     * @return Cadena con la representación textual del tablero.
     */
    public String aTexto() {
        String[][] textoString = new String[][]{
                {"0", "--", "--", "--", "--", "--", "--", "--"},
                {"1", "--", "--", "--", "--", "--", "--", "--"},
                {"2", "--", "--", "--", "--", "--", "--", "--"},
                {"3", "--", "--", "--", "--", "--", "--", "--"},
                {"4", "--", "--", "--", "--", "--", "--", "--"},
                {"5", "--", "--", "--", "--", "--", "--", "--"},
                {"6", "--", "--", "--", "--", "--", "--", "--"},
                {" ", " 0", " 1", " 2", " 3", " 4", " 5", " 6"}
        };

        // Reemplaza las celdas vacías por las piezas correspondientes si existen.
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (!tablero[i][j].estaVacia()) {
                    textoString[i][j] = tablero[i][j].consultarPieza().aTexto();
                }
            }
        }

        // Genera una cadena que representa todo el tablero.
        String stringTablero = "";

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                stringTablero = stringTablero + textoString[i][j];
                stringTablero = stringTablero + " ";
            }
            stringTablero = stringTablero + "\n";
        }

        return stringTablero;
    }

    /**
     * Crea una copia exacta del tablero actual.
     *
     * @return Nuevo tablero que es una clonación del actual.
     */
    public Tablero clonar() {
        Tablero clonTablero = new Tablero();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                clonTablero.tablero[i][j] = this.tablero[i][j].clonar();
            }
        }
        return clonTablero;
    }

    /**
     * Coloca una pieza en una celda específica del tablero.
     *
     * @param pieza      Pieza a colocar.
     * @param coordenada Coordenada de la celda donde se colocará la pieza.
     */
    public void colocar(Pieza pieza, Coordenada coordenada) {
        if (coordenada != null && estaEnTablero(coordenada)) {
            tablero[coordenada.fila()][coordenada.columna()].colocar(pieza);
        }
    }

    /**
     * Consulta una celda específica del tablero.
     *
     * @param coordenada Coordenada de la celda a consultar.
     * @return Celda clonada correspondiente a la coordenada, o null si no está en el tablero.
     */
    public Celda consultarCelda(Coordenada coordenada) {
        if (coordenada != null && estaEnTablero(coordenada)) {
            Celda celdaAClonar = tablero[coordenada.fila()][coordenada.columna()];
            return celdaAClonar.clonar();
        }
        return null;
    }

    /**
     * Consulta todas las celdas del tablero en un arreglo unidimensional.
     *
     * @return Arreglo de celdas clonadas del tablero.
     */
    public Celda[] consultarCeldas() {
        Celda[] celdas = new Celda[49];
        int contadorCeldasClonadas = 0;

        // Recorre todas las filas y columnas para clonar las celdas.
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                celdas[contadorCeldasClonadas] = tablero[i][j].clonar();
                contadorCeldasClonadas++;
            }
        }
        return celdas;
    }

    /**
     * Devuelve el número total de filas del tablero.
     *
     * @return Número de filas del tablero.
     */
    public int consultarNumeroFilas() {
        return NUMEROFILAS;
    }

    /**
     * Devuelve el número total de columnas del tablero.
     *
     * @return Número de columnas del tablero.
     */
    public int consultarNumeroColumnas() {
        return NUMEROCOLUMNAS;
    }

    /**
     * Elimina la pieza de una celda específica.
     *
     * @param coordenada Coordenada de la celda de la cual eliminar la pieza.
     */
    public void eliminarPieza(Coordenada coordenada) {
        if (coordenada != null && estaEnTablero(coordenada)) {
            tablero[coordenada.fila()][coordenada.columna()].eliminarPieza();
        }
    }

    /**
     * Verifica si una coordenada está dentro de los límites del tablero.
     *
     * @param coordenada Coordenada a verificar.
     * @return true si la coordenada está dentro del tablero, false en caso contrario.
     */
    public boolean estaEnTablero(Coordenada coordenada) {
        boolean filaValida = coordenada.fila() >= 0 && coordenada.fila() < NUMEROFILAS;
        boolean columnaValida = coordenada.columna() >= 0 && coordenada.columna() < NUMEROCOLUMNAS;
        return filaValida && columnaValida;
    }

    /**
     * Obtiene la celda correspondiente a una coordenada específica.
     *
     * @param coordenada Coordenada de la celda a obtener.
     * @return Celda correspondiente a la coordenada.
     */
    public Celda obtenerCelda(Coordenada coordenada) {
        return tablero[coordenada.fila()][coordenada.columna()];
    }

    /**
     * Comprueba si dos tableros son iguales.
     *
     * @param o Objeto a comparar.
     * @return true si ambos tableros son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tablero tablero1 = (Tablero) o;
        return Objects.deepEquals(tablero, tablero1.tablero);
    }

    /**
     * Calcula el código hash del tablero.
     *
     * @return Código hash basado en las celdas y dimensiones del tablero.
     */
    @Override
    public int hashCode() {
        return Objects.hash(Arrays.deepHashCode(tablero), NUMEROFILAS, NUMEROCOLUMNAS);
    }

    /**
     * Devuelve una representación textual del objeto tablero.
     *
     * @return Cadena con los detalles del tablero.
     */
    @Override
    public String toString() {
        return "Tablero{" +
                "tablero=" + Arrays.toString(tablero) +
                '}';
    }
}


