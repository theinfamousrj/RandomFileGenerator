package com.omfgp.rfgen;

/**
 * @author Raymond John Hill
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//makes a new FileGenerator.
		FileGenerator fg = new FileGenerator();
		//starts the timer.
		long start = System.nanoTime();
		//builds a file with a specified number of bytes. 1000 bytes in this case.
		fg.buildTheFile(1000);
		//prints the end time - start time.
		System.out.println("Finished in " + (System.nanoTime()-start) + " ns.");
	}

}
