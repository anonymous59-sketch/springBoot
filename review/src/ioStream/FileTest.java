package ioStream;

import java.io.File; // vs nio(최신)
import java.util.Calendar;

public class FileTest {
	public static void main(String[] args) {
//		printDirList();
//		deleteFile();
		
		printFileAttr();
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(1996, 5, 9);
		
		Long today = System.currentTimeMillis() - calendar.getTimeInMillis();
		
		System.out.println(today/365/1000/24/60/60 + "년");
		System.out.println(today/1000/24/60/60 + "일");
	}

	private static void printFileAttr() {
		File file = new File("d:/upload", "tree.png");
		System.out.println("파일이름: " + file.getName());
		System.out.printf("파일크기: %.2fkb\n", (double)file.length()/1024);
		System.out.println("파일수정일자: " + file.lastModified());
	}

	// 파일 삭제
	private static void deleteFile() {
		File file = new File("d:/upload", "Postman (x64).exe");
		file.delete();
	}

	// 파일목록 조회
	private static void printDirList() {
		File dir = new File("d:/upload");
		
		if(dir.isDirectory()) {
			File[] list = dir.listFiles();
			for(File file : list) {
				System.out.println(file.getName());
			}
		}
	}
	
}
