package com.problems;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class StringMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Character, Character> char_map = new HashMap<Character, Character>();
		char_map.put( ')','(');
		char_map.put( '}','{');
		char_map.put( ']','[');
		System.out.println(complete_string("(sfdsfdsf{}[][{}]){}", char_map));
	}
	public static Boolean complete_string(String sample, HashMap<Character, Character> char_map) {
		if(sample == "") return false;
		Stack<Character> char_stack = new Stack<Character>();
		for(int i=0 ; i < sample.length() ; i++) {
			char temp = sample.charAt(i);
			if(sample.charAt(i)=='(' || sample.charAt(i)=='[' || sample.charAt(i)=='{') {
				char_stack.push(temp);
			}
			else { 
				if(char_stack.isEmpty()) return false;	
				if(temp=='}' || temp == ']' || temp == ')') {
					if(char_map.get(temp) == char_stack.peek()) {
						char_stack.pop();
					}else return false;
				}
			}
		} 
		if(char_stack.isEmpty()) {
			return true;
		}else return false;
	}

}
