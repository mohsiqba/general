package com.exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Parlor {

	public static int isValidArgs(String[] file) throws FileNotFoundException,IOException{
		File rFile=new File(file[0]);
		if(!rFile.exists())
			return 1;
		if(rFile.isDirectory())
			return 2;
		if(!rFile.canRead())
			return 3;

		File wFile=new File(file[1]);
		if(wFile.isDirectory())
			return 4;
		if(!wFile.exists())
			wFile.createNewFile();
		if(wFile.exists() && !wFile.canWrite())
			return 5;
		return 0;
	}

	public static List<String> readFile(String fileToReadFrom) throws IOException{
		BufferedReader br= null;
		List<String> fileContentList=null;
		String inpStr=null;
		try {
			fileContentList=new ArrayList<String>();
			br= new BufferedReader(new FileReader(fileToReadFrom));
			while(!(inpStr=br.readLine()).equals("0")){
				fileContentList.add(inpStr);
			}
		} finally{
			if(br!=null)
				br.close();
		}
		return fileContentList;
	}

	public static void writeFile(String fileToWriteIn,List<Integer> outputDataList) throws IOException{
		BufferedWriter bw=null;
		try{
			bw=new BufferedWriter(new FileWriter(fileToWriteIn));
			for(Integer in:outputDataList){
				switch(in){
				case 0 :bw.write("All customers serviced.\n");
				break;
				default:bw.write(in+" customer(s) walked away.\n");
				break;
				}
			}
		}finally{
			if(bw!=null)
				bw.close();
		}
	}

	public static List<Integer> processFile(List<String> fileContentToRead){
		Set<Character> serviceSet=null;
		Set<Character> delayedSet=null;
		String outStr="";
		int no_of_staff=0;
		int walked_away_customer=0;
		List<Integer> outputDataList=null;
		Iterator<String> it=fileContentToRead.iterator();
		if(it.hasNext()){
			outputDataList=new ArrayList<Integer>();
			do{
				outStr=it.next();
				walked_away_customer=0;
				serviceSet=new HashSet<Character>();
				delayedSet=new HashSet<Character>();
				no_of_staff=Integer.parseInt(outStr.substring(0, outStr.indexOf(' ')));
				outStr=outStr.substring(outStr.indexOf(' ')+1);
				for(int i=0;i<outStr.length();i++){
					if(delayedSet.contains(outStr.charAt(i))){
						walked_away_customer++;
						delayedSet.remove(outStr.charAt(i));
					}else if(serviceSet.contains(outStr.charAt(i))){
						serviceSet.remove(outStr.charAt(i));
					}else if(serviceSet.size()==no_of_staff){
						delayedSet.add(outStr.charAt(i));
					}else{
						serviceSet.add(outStr.charAt(i));
					}
				}
				outputDataList.add(walked_away_customer);
			}while(it.hasNext());
		}else{
			return null;
		}
		return outputDataList;
	}

	public static void parlorService(String[] file) throws IOException{

		List<String> readFileContent=readFile(file[0]);
		List<Integer> outputDataList=processFile(readFileContent);
		if(outputDataList!=null)
			writeFile(file[1], outputDataList);
	}	


}
