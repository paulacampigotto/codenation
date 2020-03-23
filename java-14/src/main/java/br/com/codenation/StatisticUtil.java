package br.com.codenation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StatisticUtil {

	public static int average(int[] elements) {
            int soma = 0;
            for(int element : elements) soma+=element;
            return (int) soma/elements.length;
	}

	public static int mode(int[] elements) {
            int currentValue;
            Map<Integer, Integer> elementCount = new HashMap<>();
            for(int element : elements){
                if(elementCount.containsKey(element)) currentValue = elementCount.get(element);
                else currentValue = 0;
                elementCount.put(element, ++currentValue);
            }
            int maior = 0;
            int moda = 0;
            Set<Integer> keys = elementCount.keySet();
            
            for (Integer key : keys) {
                if(elementCount.get(key) > maior){
                    maior = elementCount.get(key);
                    moda = key;
                }
            }
            
            return moda;
        }

	public static int median(int[] elements) {
            Arrays.sort(elements);
            int middle = (int) Math.ceil(elements.length/2);
            if(elements.length % 2 != 0) return elements[middle];
            
            return (elements[elements.length/2] + elements[(elements.length/2) - 1])/2;
                    
               
	}

}