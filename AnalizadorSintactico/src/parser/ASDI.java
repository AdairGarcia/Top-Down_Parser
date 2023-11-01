package parser;

import token.TipoToken;
import token.Token;

import java.util.List;
import java.util.Stack;


public class ASDI implements Parser{

    private int i = 0;
    private boolean hayErrores = false;
    private Token preanalisis;
    private Token entrada;
    private final List<Token> tokens;
    private final Stack<ElementosTabla> pila;
    private Tabla tabla;



    public ASDI(List<Token> tokens){
        this.tokens = tokens;
        this.preanalisis = this.tokens.get(this.i);
        this.entrada = this.tokens.get(this.i);
        this.tabla = new Tabla();

        this.pila = new Stack<>();

        // Se introducen los elementos por defecto de la pila
        this.pila.push(new ElementosTabla("$", TipoToken.EOF));
        this.pila.push(new ElementosTabla("Q", null));
    }

    @Override
    public boolean parse() {
        analizar();

        if(this.pila.empty()){
            System.out.println("Consulta correcta");
            return true;
        } else{
            System.out.println("Se encontraron errores");
        }
        return false;

    }

    private void analizar(){
        // Por cada elemento de la entrada
        while(!this.pila.empty()){

            // Se obtienen el elemento de la cima de la pila
            // y el tipo de token de la entrada
            ElementosTabla cimaPila = this.pila.peek();
            TipoToken tipoEntrada = this.entrada.getTipo();

            if(cimaPila.getNombre().equals("Epsilon")){
                this.pila.pop();
                continue;
            }

            // Si el elemento de la cima de la pila es un terminal
            if(cimaPila.getTipo() != null){
                // Comparamos si el tipo de token de la entrada
                // es igual al tipo de token de la cima de la pila
                if(cimaPila.getTipo().equals(tipoEntrada)){
                    // Si son iguales, se saca el elemento de la cima de la pila
                    this.pila.pop();
                    // Se obtiene el siguiente elemento de la entrada
                    this.i++;
                    // Verificamos que i no sea mayor al tamaño de lista de tokens
                    if(this.i < this.tokens.size()){
                        this.entrada = this.tokens.get(this.i);
                    }

                }
                else{
                    // Si no son iguales, se reporta un error
                    this.hayErrores = true;
                    System.out.println("Error encontrado, se esperaba otro token");
                    break;
                }
            }
            // Si el elemento de la cima de la pila es un no terminal
            else{
                // Obtenemos la produccion que se encuentra en la tabla
                ElementosTabla[] produccion = this.tabla.getValor(cimaPila.getNombre(), entrada);
                // Si la produccion es null, es decir, hay un hueco en la tabla, mandamos error
                if(produccion == null){
                    this.hayErrores = true;
                    System.out.println("Error encontrado: Indice vacio");
                    break;
                } else{
                    // Si la produccion no es null, se saca el elemento de la cima de la pila
                    this.pila.pop();
                    // Se introducen los elementos de la produccion a la pila
                    for(int i = produccion.length - 1; i >= 0; i--){
                        this.pila.push(produccion[i]);
                    }
                }


            }
        }


    }
}
