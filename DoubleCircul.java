public class DoubleCircul {
    private Nodo cabeza;

    // Inserción
    public void insertar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo cola = cabeza.anterior;
            cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = cola;
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
        }
    }

    // Eliminación
    public boolean eliminar(int dato) {
        if (cabeza == null) return false;
        Nodo actual = cabeza;
        do {
            if (actual.dato == dato) {
                if (actual == cabeza) {
                    cabeza = cabeza.siguiente;
                }
                actual.anterior.siguiente = actual.siguiente;
                actual.siguiente.anterior = actual.anterior;
                return true;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);
        return false;
    }

    // Búsqueda
    public boolean buscar(int dato) {
        if (cabeza == null) return false;
        Nodo actual = cabeza;
        do {
            if (actual.dato == dato) return true;
            actual = actual.siguiente;
        } while (actual != cabeza);
        return false;
    }

    // Ordenamiento
    public void ordenar(boolean ascendente) {
        if (cabeza == null) return;
        boolean intercambiado;
        do {
            Nodo actual = cabeza;
            intercambiado = false;
            do {
                if ((ascendente && actual.dato > actual.siguiente.dato) ||
                        (!ascendente && actual.dato < actual.siguiente.dato)) {
                    int temp = actual.dato;
                    actual.dato = actual.siguiente.dato;
                    actual.siguiente.dato = temp;
                    intercambiado = true;
                }
                actual = actual.siguiente;
            } while (actual.siguiente != cabeza);
        } while (intercambiado);
    }

    // Visualización
    public String mostrar() {
        if (cabeza == null) return "Lista vacía.";
        StringBuilder resultado = new StringBuilder();
        Nodo actual = cabeza;
        do {
            resultado.append(actual.dato).append(" ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        return resultado.toString();
    }
}
