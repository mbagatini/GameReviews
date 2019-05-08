package dictionarybin;

import java.util.ArrayList;

public abstract class DictionaryAbs {

  protected ArrayList<Item> array;  

  public DictionaryAbs() {
    this.array = new ArrayList<Item>();
  }

  protected static class Item {
    public int key;
    public String value;

    public Item(int k, String v) {
      this.key = k;
      this.value = v;
    }

    public String toString() {
      return "[" + this.key + 
             "," + this.value + "]";
    }
  }

  protected abstract Item search(int k);

  public abstract void put(int k, String v);

  public String get(int k) {
    Item item = this.search(k);
    return (item != null) ? item.value : null;
  }

  public String toString() {
    return this.array.toString();
  }
}









