/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 
 /*
package com.bis.util;
*/

import java.util.HashMap;

/**This structure is used to store all the patterns we are searching for
 *ie this structure will hold all the needles we will be looking for in our haystack
 *
 */

public class Tree {

    public int key; //hashcode of given string 
    public String value; //string you want to search for (string hashcode represents)
    //below, if string contains more than 1 word, it will hold a hashmap of all the trees that hold the value of the succeeding words where the keys will be each individual word's hashcode
    public HashMap <Integer,Tree> children = new HashMap(); 
    
    public Tree() {
        this.key = 0;
        this.value = "";
    }

    //creates a tree for a particular string
    public Tree(String str) {
        String[] words = str.split("\\s+");
        int hash_code = str.toLowerCase().hashCode();
        //if string contains only 1 word, just append 1 branch
        if (words.length == 1) {
            this.key = hash_code;
            this.value = str;
        } 
        //if string contains more than 1 word, adds a new level for each word in order of how the string appears
        else {
            int current_hash_code = words[0].toLowerCase().hashCode();
            this.key = current_hash_code;
            this.value = str;
            this.children.put (current_hash_code, (createBranch(words, 1, str)));
        }
    }

    //This function creates a new level for each word and recursively creates a new branch for each word in the entire string
    public static Tree createBranch(String[] words, int word_count, String final_word) {
        Tree t = new Tree();
        int final_index = words.length;
        if (word_count < final_index){
            int hash_code = words[word_count].trim().toLowerCase().hashCode();
            t.key = hash_code;
            t.value = final_word;
            t.children.put(hash_code,createBranch(words, word_count + 1, final_word));
        }
        return t;
    }
}
