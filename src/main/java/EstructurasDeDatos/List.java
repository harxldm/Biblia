/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

import java.util.Iterator;

/**
 *
 * @author harxl
 */
public class List<Item> implements Iterable<Item> {
    private Item[] lista;
    private int count;

    /**
     * Crea una lista con capacidad inicial.
     * @param maxCap Capacidad inicial de la lista.
     */
    public List(int maxCap) {
        lista = (Item[]) new Object[maxCap];
        count = 0;
    }

    /**
     * Redimensiona la lista.
     * @param newCapacity Nueva capacidad.
     */
    private void resize(int newCapacity) {
        
        if (newCapacity < 1) {
        newCapacity = 1;
        }
        
        Item[] aux = (Item[]) new Object[newCapacity];
        for (int i = 0; i < count; i++) {
            aux[i] = lista[i];
        }
        lista = aux;
    }

    /**
     * Retorna la longitud total del arreglo interno.
     * @return Tamaño total del arreglo.
     */
    public int lenght() {
        return lista.length;
    }

    /**
     * Retorna la cantidad de elementos insertados.
     * @return Número de elementos.
     */
    public int size() {
        return count;
    }

    /**
     * Verifica si la lista está vacía.
     * @return true si está vacía, false si no.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Desplaza elementos a la derecha desde una posición.
     * @param posicion Índice desde donde mover.
     */
    private void moveRight(int posicion) {
        if (posicion < 0 || posicion > count) {
            return;
        }
        for (int i = count; i > posicion; i--) {
            lista[i] = lista[i - 1];
        }
    }

    /**
     * Desplaza elementos a la izquierda desde una posición.
     * @param posicion Índice desde donde mover.
     */
    private void moveLeft(int posicion) {
        for (int i = posicion; i < count - 1; i++) {
            lista[i] = lista[i + 1];
        }
        lista[count - 1] = null;
    }

    /**
     * Agrega un elemento en una posición específica.
     * @param item Elemento a agregar.
     * @param posicion Posición deseada.
     */
    public void add(Item item, int posicion) {
        if (count == lista.length) {
            resize(lista.length * 2);
        }

        for (int i = 0; i < posicion; i++) {
            if (lista[i] == null) {
                return;
            }
        }

        if (posicion == count) {
            lista[count] = item;
            count++;
            return;
        }

        moveRight(posicion);
        lista[posicion] = item;
        count++;
    }

    /**
     * Reemplaza un elemento existente.
     * @param pos Índice.
     * @param unItem Nuevo elemento.
     * @return true si tuvo éxito, false si no.
     */
    public boolean set(int pos, Item unItem) {
        if (!isEmpty()) {
            if (pos < count && pos >= 0) {
                lista[pos] = unItem;
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina el primer elemento que coincide.
     * @param elemento Elemento a eliminar.
     * @return Elemento eliminado, o null.
     */
    public Item removeByElement(Item elemento) {
        for (int i = 0; i < count; i++) {
            if (lista[i].equals(elemento)) {
                moveLeft(i);
                count--;
                if (count == lista.length / 4) {
                    resize(lista.length / 2);
                }
                return elemento;
            }
        }
        return null;
    }

    /**
     * Elimina el elemento en una posición específica.
     * @param posicion Posición del elemento.
     * @return Elemento eliminado, o null.
     */
    public Item remove(int posicion) {
        for (int i = 0; i < count; i++) {
            if (i == posicion) {
                Item item = lista[i];
                moveLeft(posicion);
                count--;
                if (count == lista.length / 4) {
                    resize(lista.length / 2);
                }
                return item;
            }
        }
        return null;
    }
    
    public Item get(int i) {
        if (i < 0 || i > count) {
            return null;
        }
        return lista[i];
    }

    /**
     * Retorna un iterador para recorrer la lista.
     * @return Iterador.
     */
    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    /**
     * Iterador para recorrer los elementos de la lista.
     */
    private class ArrayIterator implements Iterator<Item> {
        int i = 0;

        @Override
        public boolean hasNext() {
            return i < count;
        }

        @Override
        public Item next() {
            return lista[i++];
        }
    }
}
