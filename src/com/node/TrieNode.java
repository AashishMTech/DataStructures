package com.node;

import java.util.HashMap;

public class TrieNode {

		private HashMap<Character, TrieNode> children;
		private boolean endOfWord;
		
		public TrieNode() {
			this.endOfWord  = false;
			children = new HashMap<Character, TrieNode>();
		}
		
		public HashMap<Character, TrieNode> getChildren() {
			return children;
		}
		public void setChildren(HashMap<Character, TrieNode> neighbor) {
			this.children = neighbor;
		}
		public boolean isEndOfWord() {
			return endOfWord;
		}
		public void setEndOfWord(boolean endOfWord) {
			this.endOfWord = endOfWord;
		}
		
		
}
