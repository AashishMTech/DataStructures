package com.trie;

import com.node.TrieNode;

public class Trie {

	private TrieNode root;
	
	public Trie() {
		this.root = new TrieNode();
	}
	
	public void insert(String word) {
		TrieNode current = root;
		
		for(int i=0;i<word.length();i++) {
			char word_char = word.charAt(i);
			TrieNode child = current.getChildren().get(word_char);
			if(child == null) {
				child =  new TrieNode();
				current.getChildren().put(word_char, child);
			}
			current = child;			
		}
		current.setEndOfWord(true);
		System.out.println("word "+ word + " is sucessfully inserted in Trie!!");
	}
	
	public boolean search(String word) {
		TrieNode current =  root;
		
		for (int i  = 0 ;i <word.length(); i++) {
			char word_char = word.charAt(i);
			TrieNode child = current.getChildren().get(word_char);
			if (child == null) {
				System.out.println("word " + word+ " is not present");
				return false;
			}
			current  = child;
		}
		if(current.isEndOfWord()) {
			System.out.println("word "+ word+ " is present in Trie!!");
		}else {
			System.out.println("word " + word + " is not present but it is a prefix");
		}
		
		return current.isEndOfWord();
	}
	
	public void delete(String word) {
		if (this.search(word)) {
			delete(root, word, 0);
		}
	}
	
	private boolean delete(TrieNode parentNode, String word, int index) {
		
		char word_char = word.charAt(index);
		TrieNode currentNode = parentNode.getChildren().get(word_char);
		boolean canBeDeleted;
		if(currentNode.getChildren().size()>1) {
			System.out.println("entering case 1");
			delete(currentNode,word,index+1);
			return false;
		}
		
		if(index == word.length()-1) {
			System.out.println("enterign case 2");
			if(currentNode.getChildren().size()>=1) {
				currentNode.setEndOfWord(false);
				return false;
			}else {
				System.out.println("character "+ word_char+ " has no dependency so deleting it from last");
				parentNode.getChildren().remove(word_char);
				return true;
			}
		}
		
		if(currentNode.isEndOfWord()) {
			System.out.println("entering case 3");
			delete(currentNode, word, index+1);
			return false;
		}
				
		System.out.println("entering case 1");
		canBeDeleted = delete(currentNode, word, index+1);
		if (canBeDeleted==true) {
			System.out.println("character "+ word_char + " has on dependecy");
			parentNode.getChildren().remove(word_char);
			return true;
		}else {
			return false;
		}
	
	}
}
