public class main {
    public static void main(String[] args) {
        arbol arbol1 = new arbol();
        arbol1.insertar(3, "nodo1");
        arbol1.insertar(5, "nodo2");
        arbol1.insertar(1, "nodo3");
        arbol1.insertar(4, "nodo4");
        arbol1.insertar(2, "nodo5");
        arbol1.insertar(6, "nodo6");

        arbol1.Bst(arbol1.raiz);
    }
}
