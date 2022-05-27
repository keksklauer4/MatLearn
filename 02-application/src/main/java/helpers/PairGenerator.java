package main.java.helpers;

import java.util.List;

public class PairGenerator<T> {
    private final List<T> listA;
    private final List<T> listB;

    public PairGenerator(List<T> listA, List<T> listB) {
        this.listA = listA;
        this.listB = listB;
    }

    public void generate(PairFunction<T> functor){
        for (final T a : listA){
            for (final T b : listB){
                if (a == null || b == null){
                    functor.execute(a, b);
                }
            }
        }
    }
}
