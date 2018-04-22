package com.exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class NovelString{

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

	public static Map<String,Integer> readFile(String fileToReadFrom) throws IOException{
		BufferedReader br= null;
		Map<String,Integer> fileContentMap=null;
		String inpStr=null;
		try {
			fileContentMap=new LinkedHashMap<String,Integer>();
			br= new BufferedReader(new FileReader(fileToReadFrom));
			while(!(inpStr=br.readLine()).equals("$$")){
				fileContentMap.put(inpStr,0);
			}
		} finally{
			if(br!=null)
				br.close();
		}
		return fileContentMap;
	}

	public static void writeFile(String fileToWriteIn,Map<String,Integer> outputDataMap) throws IOException{
		BufferedWriter bw=null;
		try{
			bw=new BufferedWriter(new FileWriter(fileToWriteIn));
			for(Map.Entry<String, Integer> en:outputDataMap.entrySet()){
				switch(en.getValue()){
				case 0 :bw.write(en.getKey()+" is not a Novel string\n");
				break;
				case 1 :bw.write(en.getKey()+" is a Novel string\n");
				break;
				}
			}
		}finally{
			if(bw!=null)
				bw.close();
		}
	}
	public static Map<String,Integer> processFile(Map<String,Integer> fileContentToRead){
		int len=0,idx,i;
		boolean flag;
		String subStr;
		Iterator<Map.Entry<String,Integer>> it=fileContentToRead.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, Integer> en=it.next();
			len=en.getKey().length();
			idx=1;
			flag=false;
			if(len>2){
				while(len-1>0){
					i=0;
					Map<String,Object> inSet=new HashMap<String,Object>();
					while(i+idx<en.getKey().length()){
						subStr=String.valueOf(en.getKey().charAt(i));
						subStr.concat(String.valueOf(en.getKey().charAt(i+idx)));
						if(inSet.containsKey(subStr)){
							flag=true;
							break;
						}else{
							inSet.put(subStr,null);
						}
						i++;
					}
					if(flag)
						break;
					idx++;
					len--;
				}
			}
			if(!flag)
				fileContentToRead.put(en.getKey(), 1);
		}
		return fileContentToRead;
	}
	
	public static void isNovelString(String[] file) throws IOException{
		Map<String,Integer> readFileContent=readFile(file[0]);
		writeFile(file[1], processFile(readFileContent));
	}
}
