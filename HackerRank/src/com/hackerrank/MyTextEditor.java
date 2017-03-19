package com.hackerrank;

import java.util.Scanner;

public class MyTextEditor {
	
	StringBuffer editor = new StringBuffer();
	String previousText;

	public static void main(String[] args) {
		MyTextEditor myTextEditor = new MyTextEditor();
		Scanner scanner=new Scanner(System.in);
		String s = scanner.nextLine();
		int count = Integer.parseInt(s);
		int i=0;
		while(i<count){
			String line = scanner.nextLine();
			String[] command = line.split(" ");
			if(command[0].equals("1"))
				myTextEditor.append(line.split(" ")[1]);
			else if (command[0].equals("2"))
				myTextEditor.delete(Integer.parseInt(line.split(" ")[1])-1);
			else if(command[0].equals("3"))
				myTextEditor.print(Integer.parseInt(line.split(" ")[1])-1);
			else if(command[0].equals("4"))
				myTextEditor.undo();
			i++;
		}
		scanner.close();
	}
	private void append(String s){
		previousText=editor.toString();
		editor.append(s);
	}
	private void delete(int i){
		previousText=editor.toString();
		editor.deleteCharAt(i);
	}
	private void print(int i){
		System.out.println(editor.charAt(i));
	}
	private void undo(){
		editor = new StringBuffer(previousText);
		previousText="";
	}
}
