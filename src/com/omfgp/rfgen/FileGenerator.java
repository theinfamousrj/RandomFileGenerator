package com.omfgp.rfgen;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import org.apache.commons.io.FileUtils;

/**
 * Generates a file of a random size.
 * @author Raymond John Hill
 *
 */
public class FileGenerator {

	int fileSize;
	FileUtils utils;
	String fileName;
	StringBuilder sb;
	ArrayList<String> charList;
	
	/**
	 * Class instantiation.
	 */
	public FileGenerator() {
		//build a StringBuilder and ArrayList<String>.
		sb = new StringBuilder();
		charList = new ArrayList<String>();
	}
	
	/**
	 * This initiates the building of the file.
	 * @param fileSize The size of the file in bytes.
	 */
	public void buildTheFile(int fileSize) {
		//this should be obvious.
		this.fileSize = fileSize;
		//creates a fileName using the fileSize.
		this.fileName = fileSize + "bytes.txt";
		//calls the makeFileFromRandomStuff method.
		this.makeFileFromRandomStuff(fileSize);		
	}
	
	/**
	 * Helper function that fills the file with random characters converted from random bytes.
	 * @param bytes number of bytes the file should contain
	 */
	private void makeFileFromRandomStuff(int bytes) {
		//byte array with half the number of bytes since we're turning them into chars later.
		byte[] ba = new byte[bytes/2]; 
		//new random.
		Random rand = new Random();
		//nextBytes fills a byte array with random bytes.
		rand.nextBytes(ba);
		//iterates through every byte in the byte array converting it to a character.
		for (int i=0; i<ba.length; i++) {
			//appends the string value of the current random byte in the byte array.
	        sb.append(Integer.toString((ba[i] & 0xff) + 0x100, 16).substring(1));
	    }
		//passes the final string to the createFile method.
		this.createFile(this.sb.toString());
	}
	
	/**
	 * Writes the data to the file and names the file.
	 * @param fileData data to write to the file.
	 */
	private void createFile(String fileData) {
		try {
			//writes the data to the file.
			utils.writeStringToFile(new File(this.fileName), fileData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
