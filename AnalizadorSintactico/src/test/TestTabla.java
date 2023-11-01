package test;

import parser.ElementosTabla;
import parser.Tabla;
import token.TipoToken;
import token.Token;

// Clase para probar la tabla de simbolos
public class TestTabla {
    public static void main(String[] args) {
        Tabla tabla = new Tabla();

        Token token = new Token(TipoToken.SELECT, "select");
        Token token1 = new Token(TipoToken.FROM, "from");
        Token token2 = new Token(TipoToken.DISTINCT, "distinct");
        Token token3 = new Token(TipoToken.ASTERISCO, "*");
        Token token4 = new Token(TipoToken.IDENTIFICADOR, "id");
        Token token5 = new Token(TipoToken.PUNTO, ".");
        Token token6 = new Token(TipoToken.COMA, ",");
        Token token7 = new Token(TipoToken.EOF, "EOF");

        ElementosTabla[] produccion = tabla.getValor("T1", token7);

        for(ElementosTabla elemento : produccion){
            System.out.println(elemento);
        }

        //tabla.imprimirTabla();

    }

}
