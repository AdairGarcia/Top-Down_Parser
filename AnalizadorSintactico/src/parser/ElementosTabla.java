package parser;

import token.TipoToken;

// Esta clase es la combinacion de los Noterminales y terminales
// esto para que las producciones que se introduzcan a la pila
// sean de un unico objeto, y no meter Strings y Tokens a la misma pila
public class ElementosTabla {
    // Sabremos que es un Noterminal si, el atributo tipo es null
    // y sabremos si es un Terminal, si el atributo tipo no es null
    private String nombre;
    private TipoToken tipo;

    public ElementosTabla(String nombre, TipoToken tipo){
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public TipoToken getTipo(){
        return this.tipo;
    }

    public String getNombre(){
        return this.nombre;
    }

    @Override
    public String toString() {
        return "{Nombre: " + this.nombre + ", Tipo: " + this.tipo + "}";
    }
}
