package edu.clayton.csit.antlab.person;
// :encoding=Native2ASCII:ff=dos:autoIndent=full:folding=java:indentSize=4:maxLineLen=80:mode=java:tabSize=4:wrap=soft:
/**
 *  A simple class for person 2
 *  returns their name and a
 *  modified string 
 *
 * @author Qu
 * @version 1.1
 */
public class Person2 {
    /** Holds the persons real name */
    private String name;
	 	/**
	 * The constructor, takes in the persons
	 * name
	 * @param pname the person's real name
	 */
	 public Person2(String pname) {
	   name = pname;
	 }
	/**
	 * This method should take the string
	 * input and return its characters in
	 * random order.
	 * given "gtg123b" it should return
	 * something like "g3tb1g2".
	 *
	 * @param input the string to be modified
	 * @return the modified string
	 */
	private String calc(String input) {
	  //Generate permutation
	  int[] permutation = new int[input.length()];
	  int rand = 0;
	  boolean insert = true;
	  for (int i = 0; i < permutation.length(); i++) {
	  	  insert = true;
	  	  do {
	  	  	  rand = (int)(Math.random()*permutation.length);
	  	  	  insert = !arrayContains(permutation,i,rand);
	  	  } while (!insert);
	  	  permutation[i] = rand
	  }
	  char[] inChars = input.toCharArray();
	  StringBuilder output = new StringBuilder();
	  //This loop would break if there were surrogates, because there's no
	  //guarantee that a pair of them would move as a unit
	  for (int i = 0; i < inChars.length; i++) {
	  	  output.append(inChars[permutation[i]]);
	  }
	  return output.toString();
	}
	/**
	 * Originally written for a personal project
	 * @author Dominique Jaramillo
	 */
	private static boolean arrayContains(byte[] arr, int maxIndx, byte search) {
		byte d = (byte)(0);
		for (int i = 0; i < maxIndx; i++) {
			d = arr[i];
			if (d==search) return true;
		}
		return false;
	}
	/**
	 * Return a string rep of this object
	 * that varies with an input string
	 *
	 * @param input the varying string
	 * @return the string representing the 
	 *         object
	 */
	public String toString(String input) {
	  return name + calc(input);
	}
}
