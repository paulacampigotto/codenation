package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

    public static List<Integer> fibonacci() {

        final List sequencia = new ArrayList<>();
        int a = 0;
        int b = 1;
        int aux = 0;
        sequencia.add(a);
        sequencia.add(b);
        do {
            aux = a;
            a = b;
            b = aux + b;
            sequencia.add(b);
        }while(b<=350);
        return sequencia;
    }
    
    public static Boolean isFibonacci(final Integer a) {
        return fibonacci().contains(a);
    }
}
