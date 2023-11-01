package parser;

import token.TipoToken;
import token.Token;

// Tabla de analisis sintactico para la gramatica de SQL
public class Tabla {
    // Estos atributos y metodos
    // ayudan a al sistema a encontrar los indices de la tabla
    // que debe revisar el analizador sintactico


    // En este arreglo, los elementos de la PILA, buscaran
    // su nombre en este arreglo, para saber en que fila
    // deben buscar en la tabla
    private String Noterminales[] = {
            "Q",
            "D",
            "P",
            "A",
            "A1",
            "A2",
            "A3",
            "T",
            "T1",
            "T2",
            "T3"
    };

    // En este arreglo, los elementos de la ENTRADA, buscaran su tipoToken
    // para saber en que columna deben buscar en la tabla
    private TipoToken Terminales[] = {
            TipoToken.SELECT,
            TipoToken.FROM,
            TipoToken.DISTINCT,
            TipoToken.ASTERISCO,
            TipoToken.IDENTIFICADOR,
            TipoToken.PUNTO,
            TipoToken.COMA,
            TipoToken.EOF
    };

    // Esta es la tabla de analisis sintactico
    // las producciones se agregan en el constructor de la clase
    private ElementosTabla[] tabla[][] = {
        {null, null, null, null, null, null, null, null}, //0
        {null, null, null, null, null, null, null, null}, //1
        {null, null, null, null, null, null, null, null}, //2
        {null, null, null, null, null, null, null, null}, //3
        {null, null, null, null, null, null, null, null}, //4
        {null, null, null, null, null, null, null, null}, //5
        {null, null, null, null, null, null, null, null}, //6
        {null, null, null, null, null, null, null, null}, //7
        {null, null, null, null, null, null, null, null}, //8
        {null, null, null, null, null, null, null, null}, //9
        {null, null, null, null, null, null, null, null}  //10
    };

    public Tabla(){
        agregarProducciones();
    }


    // Este metodo recibira un token, y buscara en el arreglo
    // de terminales, el indice de la columna que le corresponde
    private int encontrarColumna(Token token){
        for(int i = 0; i < Terminales.length; i++){
            if(token.getTipo() == Terminales[i]){
                return i;
            }
        }
        // Retorno -1 si no se encontro el token
        // en el arreglo de terminales
        return -1;
    }

    // Este metodo recibira un no terminal, y buscara en el arreglo
    // el indice de la fila que le corresponde
    private int encontrarFila(String noTerminal){
        for(int i = 0; i < Noterminales.length; i++){
            if(noTerminal.equals(Noterminales[i])){
                return i;
            }
        }
        // Retorno -1 si no se encontro el no terminal
        // en el arreglo de no terminales
        return -1;
    }

    private void agregarProducciones(){
        // Producciones de Q
                // Agregando a tabla[0][0]
        ElementosTabla elemento1 = new ElementosTabla("select", TipoToken.SELECT);
        ElementosTabla elemento2 = new ElementosTabla("D", null);
        ElementosTabla elemento3 = new ElementosTabla("from", TipoToken.FROM);
        ElementosTabla elemento4 = new ElementosTabla("T", null);

        ElementosTabla[] produccion1 = {elemento1, elemento2, elemento3, elemento4};
        tabla[0][0] = produccion1;


        // Producciones de D
                // Agregando a tabla[1][2]
        ElementosTabla elemento5 = new ElementosTabla("distinct", TipoToken.DISTINCT);
        ElementosTabla elemento6 = new ElementosTabla("P", null);

        ElementosTabla[] produccion2 = {elemento5, elemento6};
        tabla[1][2] = produccion2;

                // Agregando a tabla[1][3]
        ElementosTabla elemento7 = new ElementosTabla("P", null);

        ElementosTabla[] produccion3 = {elemento7};
        tabla[1][3] = produccion3;

                //Agregando a tabla[1][4]
        ElementosTabla elemento8 = new ElementosTabla("P", null);

        ElementosTabla[] produccion4 = {elemento8};
        tabla[1][4] = produccion4;

        // Producciones de P
                // Agregando a tabla[2][3]
        ElementosTabla elemento9 = new ElementosTabla("*", TipoToken.ASTERISCO);

        ElementosTabla[] produccion5 = {elemento9};
        tabla[2][3] = produccion5;

                // Agregando a tabla[2][4]
        ElementosTabla elemento31 = new ElementosTabla("A", null);

        ElementosTabla[] produccion20 = {elemento31};
        tabla[2][4] = produccion20;


        // Producciones de A
                // Agregando a tabla[3][4]
        ElementosTabla elemento10 = new ElementosTabla("A2", null);
        ElementosTabla elemento11 = new ElementosTabla("A1", null);

        ElementosTabla[] produccion6 = {elemento10, elemento11};
        tabla[3][4] = produccion6;


        // Producciones de A1
            // Agregando a tabla[4][1]
        ElementosTabla elemento12 = new ElementosTabla("Epsilon", null);

        ElementosTabla[] produccion7 = {elemento12};
        tabla[4][1] = produccion7;

            // Agregando a tabla[4][6]
        ElementosTabla elemento13 = new ElementosTabla(",", TipoToken.COMA);
        ElementosTabla elemento14 = new ElementosTabla("A", null);

        ElementosTabla[] produccion8 = {elemento13, elemento14};
        tabla[4][6] = produccion8;

        // Producciones de A2
            // Agregando a tabla[5][4]
        ElementosTabla elemento15 = new ElementosTabla("id", TipoToken.IDENTIFICADOR);
        ElementosTabla elemento16 = new ElementosTabla("A3", null);

        ElementosTabla[] produccion9 = {elemento15, elemento16};
        tabla[5][4] = produccion9;

        // Producciones de A3
            // Agregando a tabla[6][1]
        ElementosTabla elemento17 = new ElementosTabla("Epsilon", null);

        ElementosTabla[] produccion10 = {elemento17};
        tabla[6][1] = produccion10;

            // Agregando a tabla[6][5]
        ElementosTabla elemento18 = new ElementosTabla(".", TipoToken.PUNTO);
        ElementosTabla elemento19 = new ElementosTabla("id", TipoToken.IDENTIFICADOR);

        ElementosTabla[] produccion11 = {elemento18, elemento19};
        tabla[6][5] = produccion11;

            // Agregando a tabla[6][6]
        ElementosTabla elemento20 = new ElementosTabla("Epsilon", null);

        ElementosTabla[] produccion12 = {elemento20};
        tabla[6][6] = produccion12;

        // Producciones de T
            // Agregando a tabla[7][4]
        ElementosTabla elemento21 = new ElementosTabla("T2", null);
        ElementosTabla elemento22 = new ElementosTabla("T1", null);

        ElementosTabla[] produccion13 = {elemento21, elemento22};
        tabla[7][4] = produccion13;


        // Producciones de T1
            // Agregando a tabla[8][6]
        ElementosTabla elemento23 = new ElementosTabla(",", TipoToken.COMA);
        ElementosTabla elemento24 = new ElementosTabla("T", null);

        ElementosTabla[] produccion14 = {elemento23, elemento24};
        tabla[8][6] = produccion14;

            // Agregando a tabla[8][7]
        ElementosTabla elemento25 = new ElementosTabla("Epsilon", null);

        ElementosTabla[] produccion15 = {elemento25};
        tabla[8][7] = produccion15;

        // Producciones de T2
            // Agregando a tabla[9][4]
        ElementosTabla elemento26 = new ElementosTabla("id", TipoToken.IDENTIFICADOR);
        ElementosTabla elemento27 = new ElementosTabla("T3", null);

        ElementosTabla[] produccion16 = {elemento26, elemento27};
        tabla[9][4] = produccion16;


        // Producciones de T3
            // Agregando a tabla[10][4]
        ElementosTabla elemento28 = new ElementosTabla("id", TipoToken.IDENTIFICADOR);

        ElementosTabla[] produccion17 = {elemento28};
        tabla[10][4] = produccion17;

            // Agregando a tabla[10][6]
        ElementosTabla elemento29 = new ElementosTabla("Epsilon", null);

        ElementosTabla[] produccion18 = {elemento29};
        tabla[10][6] = produccion18;

            // Agregando a tabla[10][7]
        ElementosTabla elemento30 = new ElementosTabla("Epsilon", null);

        ElementosTabla[] produccion19 = {elemento30};
        tabla[10][7] = produccion19;
    }


    // Este metodo retornara el valor de la tabla
    // en la posicion [fila][columna]
    public ElementosTabla[] getValor(String noTerminal, Token token){
        int fila = encontrarFila(noTerminal);
        int columna = encontrarColumna(token);
        return tabla[fila][columna];
    }

    public void imprimirTabla() {
        for(int i = 0; i < tabla.length; i++){
            for(int j = 0; j < tabla[i].length; j++){
                if(tabla[i][j] != null){
                    for(ElementosTabla elemento : tabla[i][j]){
                        System.out.print(elemento + " ");
                    }
                } else{
                    System.out.print("null ");
                }
            }
            System.out.println('\n');
        }
    }
}
