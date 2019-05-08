/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionarybin;

/**
 *
 * @author morganabagatini
 */
public class TestDictonaryBin {

    public static void main(String[] args) {

        DictionaryAbs d = new DictionaryBin();

        d.put(2, "abc");
        d.put(9, "poe");
        d.put(3, "def");
        d.put(7, "fof");
        d.put(30, "zig");
        d.put(1, "are");
        d.put(10, "ami");
        
        System.out.println(d);
        
        System.out.println(d.search(3));
        System.out.println(d.search(1));
        System.out.println(d.search(25));

    }

}
