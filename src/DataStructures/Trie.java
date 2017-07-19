package DataStructures;


public class Trie {
    Nod root = new Nod(' ');

    public static void main(String[] args){
        Trie t = new Trie();
        t.insert("sanjeev");
        t.insert("vishal");
        t.insert("nikhil");
        System.out.println(t.search("sanjiv"));
    }

    public void insert(String word){
       Nod ws = root;
       for(int i =0; i<word.length(); i++){
           char ch = word.charAt(i);
           if(ws.children[ch-'a']==null)
               ws.children[ch-'a']=new Nod(ch);
           ws = ws.children[ch-'a'];
       }
       ws.leaf=true;
    }

    public boolean search(String word){
        Nod ws = root;
        for(int i =0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(ws.children[ch-'a']==null)
                    return false;
            ws = ws.children[ch-'a'];
        }
        return ws.leaf;
    }
}


class Nod{
    char ch;
    Nod[] children = new Nod[26];
    boolean leaf;

    public Nod(char ch){
        this.ch = ch;
        this.leaf = false;
    }
  }
