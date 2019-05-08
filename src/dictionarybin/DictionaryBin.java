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
public class DictionaryBin extends DictionaryAbs {

    @Override
    protected Item search(int k) {
        Item i = null;

        // binary_search
        int begin = 0, end = array.size() - 1;

        while (begin <= end) {
            int middle = (begin + end) / 2;
            if (k == array.get(middle).key) {
                // já encontrou, pode sair
                i = array.get(middle);
                break;
            }

            if (k < array.get(middle).key) {
                // se 'v' está do lado esquerdo -> atualiza 'end'
                end = middle - 1;
            } else {
                // caso contrário -> atualiza 'begin'
                begin = middle + 1;
            }
        }
        return i;
    }

    private int binary_search_position(int k) {
        int c = 0;
        int begin = 0, end = array.size() - 1;

        while (begin <= end) {
            int middle = (begin + end) / 2;
            c = middle;
            if (k == array.get(middle).key) {
                // já encontrou, pode sair
                break;
            }
            if (k < array.get(middle).key) {
                // se 'v' está do lado esquerdo -> atualiza 'end'
                end = middle - 1;
            } else {
                // caso contrário -> atualiza 'begin'
                begin = middle + 1;
            }
        }
        return c;
    }

    @Override
    public void put(int k, String v) {

        // First
        if (array.isEmpty()) {
            array.add(0, new Item(k, v));
            return;
        }

        int pos = binary_search_position(k);

        // Last
        if (pos == array.size()) {
            array.add(array.size() + 1, new Item(k, v));
        } else {
            // Middle
            if (array.get(pos).key < k) {
                array.add(pos + 1, new Item(k, v));
            } else {
                array.add(pos, new Item(k, v));
            }
        }

    }

}
