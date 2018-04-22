package com.exercise.main;

import java.io.IOException;
import com.exercise.Parlor;

public class ParlorMain {
	public static void main(String[] args) {
		try {
			if(args.length!=2){
				System.out.println("Insufficient Arguments!!!");
				System.out.println("-----------------------help-----------------------------");
				System.out.println("usage: java ParlorMain readFilePath writeFilePath");
				System.out.println("--------------------------------------------------------");
				System.exit(0);
			}
			switch(Parlor.isValidArgs(args)){
				case 0 :Parlor.parlorService(args);
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
