/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 *
 * @author harxl
 */
public class TablaDeSimbolos<Key, Value> {
    private Node first;
    
    
    private class Node {
        Key key;
        Value val;
        Node next;
        
        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    
    public Value get(Key key) { 
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val; 
            }
        }
        return null; 
    }
    
    public void put(Key key, Value val) { 
        for (Node x = first; x != null; x = x.next){
            if (key.equals(x.key)){
                x.val = val; 
                return;  
            }
        first = new Node(key, val, first); 
        }
    }
    
    public List<Key> getKeys(){
        List<Key> keys = new List<>(5);
        for (Node x = first; x != null; x = x.next){
            keys.add(x.key, 0);
        }
        return keys;
    }
}
