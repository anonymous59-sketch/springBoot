package ioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputStreamTest {
	public static void main(String[] args) throws Exception {
//		fileCopy();
		saveFile();
		
	}// end of main

	private static void saveFile() throws Exception{
		FileOutputStream copy = new FileOutputStream(new File("d:/upload", "in.txt"));
		int a;
		while( (a = System.in.read()) != -1) {
			copy.write(a);
		}
	}

	private static void fileCopy() throws IOException {
		FileInputStream origin = new FileInputStream(new File("d:/upload", "tree.png"));
		FileOutputStream copy = new FileOutputStream(new File("d:/upload", "tree(copy2).png"));
		
		byte[] b = new byte[1024];
		int s;
		while( (s = origin.read(b)) != -1) {
			copy.write(b, 0, s);
		}
	}
}
