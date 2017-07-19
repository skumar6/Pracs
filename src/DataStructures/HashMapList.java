package DataStructures;

/**
 * Created by vineet on 7/6/17.
 */
public class HashMapList {
    Entry[] hm;

    public HashMapList(int capacity){
        hm = new Entry[capacity];
    }

    public void insert(int key, int val){
        int index = ((Integer)key).hashCode() % hm.length;
        if(hm[index]==null){
            hm[index]=new Entry(key, val);
            return;
        }
        Entry entry = hm[index];
        while(entry.next != null){
            if(entry.val == key){
                entry.val = val;
                return;
            }
            entry = entry.next;
        }
        entry.next= new Entry(key, val);
    }

    public int seach(int key){
        int index = ((Integer)key).hashCode() % hm.length;
        Entry entry = hm[index];

        while(entry == null){
            if(entry.key == key)
                return entry.val;
            entry = entry.next;
        }
        System.out.println("not found..");
        return -1;

    }


}

class Entry{
    int key;
    int val;
    Entry next;

    public Entry(int k, int v){
        this.key = k;
        this.val = val;
        next= null;
    }
}
