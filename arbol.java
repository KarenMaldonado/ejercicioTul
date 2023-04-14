public class arbol {

    nodo raiz;

    public arbol() {
        raiz = null;
    }

    public void insertar(int i, Object componente) {
        nodo nd = new nodo(i);
        nd.elementos = componente;
        if (raiz == null) {
            raiz = nd;
        } else {
            nodo auxiliar = raiz;

            while (auxiliar != null) {
                nd.padre = auxiliar;
                if (nd.llave >= auxiliar.llave) {
                    auxiliar = auxiliar.der;
                } else {
                    auxiliar = auxiliar.izq;
                }

            }

            if (nd.llave < nd.padre.llave) {
                nd.padre.izq = nd;
            } else {
                nd.padre.der = nd;
            }

        }

    }

    public void recorrer(nodo nd) {
        if (nd != null) {
            recorrer(nd.izq);
            System.out.println("elemento" + nd.llave + "componente" + nd.elementos);
            recorrer(nd.der);
        }

    }

    public static boolean Bst(nodo nod, int Millave, int Mallave) {
        if (nod == null) {
            return true;
        }
        if (nod.llave < Millave || nod.llave > Mallave) {
            return false;
        }
        return Bst(nod.izq, Millave, nod.llave - 1) && Bst(nod.der, nod.llave + 1, Mallave);

    }

    public static void Bst(nodo nodo) {
        if (Bst(nodo, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            System.out.println("Es arbol de busqueda binaria");
        } else {
            System.out.println("no es un arbol de busqueda binaria");
        }
    }

    private class nodo {

        public nodo padre;
        private nodo izq;
        private nodo der;
        public int llave;
        public Object elementos;

        public nodo(int puntero) {
            llave = puntero;
            der = null;
            izq = null;
            padre = null;
            elementos = null;

        }

    }

}