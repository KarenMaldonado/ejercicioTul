public class arbol {
    Nodo raiz;

    public arbol() {
        raiz = null;
    }

    public void insertar(int i, Object componente) {
        Nodo nd = new Nodo(i);
        nd.elementos = componente;
        if (raiz == null) {
            raiz = nd;
        } else {
            Nodo auxiliar = raiz;

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

    public void recorrer(Nodo nd) {
        if (nd != null) {
            recorrer(nd.izq);
            System.out.println("elemento" + nd.llave + "componente" + nd.elementos);
            recorrer(nd.der);
        }
    }

    public static boolean Bst(Nodo nod, int minLlave, int maxLlave) {
        if (nod == null) {
            return true;
        }
        if (nod.llave < minLlave || nod.llave > maxLlave) {
            return false;
        }
        boolean izqBst = Bst(nod.izq, minLlave, nod.llave - 1);
        boolean derBst = Bst(nod.der, nod.llave + 1, maxLlave);
        return izqBst && derBst;
    }

    public static void Bst(Nodo nodo) {
        System.out.println(Bst(nodo, Integer.MIN_VALUE, Integer.MAX_VALUE));
        if (Bst(nodo, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            System.out.println("Es arbol de busqueda binaria");
        } else {
            System.out.println("no es un arbol de busqueda binaria");
        }
    }

    private class Nodo {
        public Nodo padre;
        private Nodo izq;
        private Nodo der;
        public int llave;
        public Object elementos;

        public Nodo(int puntero) {
            llave = puntero;
            der = null;
            izq = null;
            padre = null;
            elementos = null;
        }
    }
}