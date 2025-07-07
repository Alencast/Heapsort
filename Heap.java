import java.util.ArrayList;
import java.util.List;

public class Heap {
    private Object[] a;
    private int tamanho;
    private int capacidade;

    public Heap(Object o, int capacidade) {
        this.capacidade = capacidade;
        this.a = new Object[capacidade];
        this.tamanho = 0;
        insert(o);
    }

    public int size(){ 
        return tamanho;
    }

    public boolean isEmpty(){ 
        return tamanho == capacidade;
    }

    
    public void upheap() {
        int i = tamanho - 1;  
        
        //ou while(true)
        while (i > 0) {

            int pai = (i - 1) / 2;            
            
            if (a[i].compareTo(a[pai]) >= 0) {
                break; 
            }          
           
            Comparable temp = a[i];
            a[i] = a[pai];
            a[pai] = temp;         
            
            i = pai;
        }
    }

    public void insert(Object o) {
        if (tamanho == capacidade) {
            redimensionar();
        }
        a[tamanho++] = o;
        upheap();       
    }

    private void redimensionar() {
        capacidade *= 2;
        Object[] novoHeap = new Object[capacidade];
        for (int i = 0; i < tamanho; i++) {
            novoHeap[i] = a[i];
        }
        a = novoHeap;
    }

    
}
