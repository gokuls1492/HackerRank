import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    class TrieNode{
        HashMap<Character, TrieNode> contacts;
        int count;
        
        public TrieNode(){
            contacts = new HashMap<>();
            count =0;
        }
    }
    
    TrieNode root;
    
    public Solution(){
        root = new TrieNode();
    }
    
    public void add(String word){
        TrieNode cur = root;
        for(char ch : word.toCharArray()){
            if(cur.contacts.get(ch)== null)
                cur.contacts.put(ch, new TrieNode());
            cur = cur.contacts.get(ch);
            cur.count++;
        }
        
    }
    
    public int find(String word){
        TrieNode cur = root;
        for(char ch : word.toCharArray()){
            cur = cur.contacts.get(ch);
            if(cur == null)
                return 0;                
        }
        return cur.count;
    }
    
    public static void main(String[] args) {
        Solution obj = new Solution();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if(op.equals("add"))
                obj.add(contact);
            else if(op.equals("find"))
                System.out.println(obj.find(contact));
        }
    }
}
