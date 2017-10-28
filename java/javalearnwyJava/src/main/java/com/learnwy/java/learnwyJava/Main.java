package com.learnwy.java.learnwyJava;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

class TT<T> {
    boolean hasProto(T t, String protoName) {
        boolean ret = true;
        try {
            t.getClass().getDeclaredField(protoName);

        } catch (Exception e) {
            ret = false;
        }
        return ret;
    }

    void next(TT<? extends T> extend) {

    }

    void prev(TT<? super T> sup) {

    }
}


public class Main {
    public static void main(String... args) {
        TT<String> a = new TT<String>();
        TT<Object> obj = new TT<>();
        TT<List> list = new TT<List>();
        TT<ArrayList> arrayListTT = new TT();

        list.prev(obj);
        list.next(arrayListTT);

        System.out.println(a.hasProto(new String(), "value"));
    }
}
