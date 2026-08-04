public class Nodo {

    private int clave;

    //Constructor
    public Nodo(int clave) {
        this.clave = clave;
    }

    //Getter
    public int getClave(){
        return clave;}

    //Setter

    public void setClave(int clave){
        this.clave = clave;}


    public String toString(){
        return String.valueOf(clave);
    }

}
