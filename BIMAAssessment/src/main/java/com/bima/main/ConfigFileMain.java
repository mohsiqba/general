package com.bima.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.bima.persistence.PropertiesPersistence;
import com.bima.utils.Utils;
/**
 * Execute app from here
 * @author MohsinIqbal
 *
 */
public class ConfigFileMain {

	public static void main(String[] args) {
		try {
			List<String> allLines = Files.readAllLines(Paths.get("config/bima.properties"));
			for (String line : allLines) {
				parseAndPersist(line);
			}
			String key1="Section-1.Sub-section-1.Sub-section-1_2.a"; 	//case 1: recursive search for a down the chain 
			String key2="Section-1.Sub-section-1.Sub-section-1_1.Sub-section-1_1_1.Sub-section-1_1_1_1.Sub-section-1_1_1_1_1.eee";	//case 2: recursive search for key
			String key3="Section-1.Sub-section-1.Sub-section-1_2.Var1";	// global key
			String key4="Section-1.Sub-section-1.Sub-section-1_1.Sub-section-1_1_1.Sub-section-1_1_1_1.Sub-section-1_1_1_1_1.f";	// multiple key existence
			String key5="Section-1.Sub-section-1.Sub-section-1_2.Blah";	// key doesn't exist in the chain
			String key6="Section-1.Sub-section-1.Sub-section-1_2.EEEE";	// case insensitive search
			String key7="Section-2.Sub-section-1.Sub-section-1_2.k";	// case 7:entire sub-section doesn't exist
			
			System.out.println(key1+" : "+PropertiesPersistence.getValue(key1));
			System.out.println(key2+" : "+PropertiesPersistence.getValue(key2));
			System.out.println(key3+" : "+PropertiesPersistence.getValue(key3));
			System.out.println(key4+" : "+PropertiesPersistence.getValue(key4));
			System.out.println(key5+" : "+PropertiesPersistence.getValue(key5));
			System.out.println(key6+" : "+PropertiesPersistence.getValue(key6));
			System.out.println(key7+" : "+PropertiesPersistence.getValue(key7));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param line
	 * 1. if line is comment -> ignore it
	 * 2. read all Global variables
	 * 3. read all Sectional variables
	 */
	private static void parseAndPersist(String line) {
		String tag="";
		if(!Utils.isComment(line)) {
			//1.read Global Variables
			String[] kv=Utils.getKeyValueFromLine(line);
			if(kv==null) {
				//its Sectional TAG
				tag=line.trim();
				PropertiesPersistence.checkWhetherPopOrPush(tag.toUpperCase());
			}else {
				//prefix sectional TAG with key if any(peek stack till root tag)
				tag=PropertiesPersistence.getKeyFromStack();
				kv[0]=Utils.constructKey(tag, kv[0]);
				PropertiesPersistence.addEntry(kv[0], kv[1]);
			}
			
		}
	}
}
