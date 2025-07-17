import java.util.Arrays;

public class Heap{ 
    
    private int[] a;
    private int tamanho;
    private int capacidade;
    private int teste;

    public Heap(int capacidade){ 
        this.capacidade = capacidade;
        this.tamanho = 0;
        this.a = new int[capacidade + 1]; // pq a raiz tá começando do 1 n do zero
    }

    public boolean isEmpty(){ 
        return tamanho == 0;
    }

    public int size(){ 
        return tamanho;
    }

    public int min(){ 
        if(isEmpty()){ 
            throw new IllegalStateException("vazio");
        }

        return a[1]; //lembrar que a raiz tá no index 1, pra evitar divisão por 0
    }

    public void upheap(int index){ 

        while(index > 1) { //pra percorrer o array até a raiz
            int pai = index / 2;

            if(a[index] >= a[pai]){ 
                break;
            }

            int temp = a[index];
            a[index] = a[pai];
            a[pai] = temp;
            
            index= pai; //att o index
        }
    }

    public void downheap(int index){ 

        while(2 * index <= tamanho) { 


            int filho = 2 * index;

            if(filho < tamanho && a[filho + 1] < a[filho]){ 
                filho++;
            }

            if(a[index] <= a[filho]){ 
                break;
            }

            int temp = a[index];
            a[index] = a[filho];

            a[filho] = temp;
            index = filho;

        }
    }

    public void insert(int valor){ 
        
        if(isFull()){ 
            redimensionar();
        }

        tamanho++;

        a[tamanho] = valor;

        upheap(tamanho);

        
    }

    public void removeMin(){ 

        if(iEmpty()){ 

            throw new IllegalStateException("vazio");

        }

        int min = a[1];

        a[1] = a[tamanho--];
        downheap(1);


        return min;
    }

     private void redimensionar() {

       if(isFull()){ 

        int novaCapacidade = capacidade * 2;
        Object[] b = new Object[capacidade];
        for (int i = 0; i < tamanho; i++) {            
            b[i] = a[i];
        }
        a = b;
        capacidade = novaCapacidade;
       }

       
    }


}
