package com.exercise.main;

import java.io.IOException;
import com.exercise.NovelString;

public class NovelStringMain {
	public static void main(String[] args) {
		try {
			if(args.length!=2){
				System.out.println("Insufficient Arguments!!!");
				System.out.println("-----------------------help-----------------------------");
				System.out.println("usage: java NovelStringMain readFilePath writeFilePath");
				System.out.println("--------------------------------------------------------");
				System.exit(0);
			}
			switch(NovelString.isValidArgs(args)){
				case 0 :NovelString.isNovelString(args);
						break;
				case 1 :System.out.println("Directory or File do not exists.!!!!!");
						break;
				case 2 :System.out.println("is a Directory...... Expecting a File...!!!!!");
						break;
				case 3 :System.out.println("File does not have read permission....!!!!");
						break;
				case 4 :System.out.println("is a Directory...... Expecting a File...!!!!!");
						break;
				case 5 :System.out.println("File does not have write permission....!!!!");
						break;
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
