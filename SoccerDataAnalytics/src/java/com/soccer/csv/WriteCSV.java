package com.soccer.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import com.soccer.beans.PlayerInfo;
import com.soccer.beans.PlayerStats;

public class WriteCSV {

	 public static void write1(String filename,Map<Integer,List<PlayerStats>> map,Map<Integer,PlayerInfo> playerInfoMap) throws FileNotFoundException{
		 File file = new File("./output");
		 if (!file.exists())
			 file.mkdir();
		 PrintWriter pw = new PrintWriter(new File(file.getAbsolutePath()+"/"+filename));
	     StringBuilder sb = new StringBuilder();
	     Iterator<Map.Entry<Integer, List<PlayerStats>>> it =map.entrySet().iterator();
	     sb.append("Year Wise Highest Player Ratings");
	     sb.append('\n').append('\n');
	     while(it.hasNext()){
	    	 Entry<Integer, List<PlayerStats>> en=it.next();
	    	 sb.append("For Year : ");
	    	 sb.append(en.getKey());
	    	 sb.append('\n');
	    	 sb.append("Player Name");
	    	 sb.append(',');
	    	 sb.append("Rating");
	    	 sb.append(',');
	    	 sb.append("Potential");
	    	 sb.append(',');
	    	 sb.append("Preferred foot");
	    	 sb.append('\n');
	    	 ListIterator<PlayerStats>li=en.getValue().listIterator();
	    	 while(li.hasNext()){
	    		 PlayerStats ps=li.next();
		    	 sb.append((playerInfoMap.get(ps.getPlayer_api_id())).getPlayer_name());
		    	 sb.append(',');
		    	 sb.append(ps.getOverall_rating());
		    	 sb.append(',');
		    	 sb.append(ps.getPotential());
		    	 sb.append(',');
		    	 sb.append(ps.getPreferred_foot());
		    	 sb.append('\n');	    		 
	    	 }
	    	 sb.append('\n');
	    	 sb.append('\n');
	     }
	     pw.write(sb.toString());
	        pw.close();
	 }
	 
	 public static void write3(String filename,List<PlayerStats> list,Map<Integer,PlayerInfo> playerInfoMap) throws IOException{
		//Delimiter used in CSV file
		String NEW_LINE_SEPARATOR = "\n";
		//CSV file header
		Object [] FILE_HEADER = {"Player Name","Rating","Potential","Preferred foot"};
		FileWriter fileWriter = null;
		
		CSVPrinter csvFilePrinter = null;
		
		//Create the CSVFormat object with "\n" as a record delimiter
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
      //initialize FileWriter object
		fileWriter = new FileWriter("./output/"+filename);
		
		//initialize CSVPrinter object 
        csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
        
        csvFilePrinter.printRecords("Player Wise Highest Ratings Achieved during all years");
        csvFilePrinter.println();
        //Create CSV file header
        csvFilePrinter.printRecord(FILE_HEADER);
		
		//Write a new student object list to the CSV file
        ListIterator<PlayerStats> it=list.listIterator();
        while(it.hasNext()){
	    	 PlayerStats ps=it.next();
	    	 List record=new ArrayList();
	    	 record.add((playerInfoMap.get(ps.getPlayer_api_id())).getPlayer_name());	
	    	 record.add(ps.getOverall_rating());
	    	 record.add(ps.getPotential());
	    	 record.add(ps.getPreferred_foot());
	    	 csvFilePrinter.printRecord(record);
	    }
	 }
	 
	 public static void write2(String filename,List<PlayerStats> list,Map<Integer,PlayerInfo> playerInfoMap) throws IOException{
		//Delimiter used in CSV file
		String NEW_LINE_SEPARATOR = "\n";
		//CSV file header
		Object [] FILE_HEADER = {"Player Name"};
		FileWriter fileWriter = null;
		
		CSVPrinter csvFilePrinter = null;
		
		//Create the CSVFormat object with "\n" as a record delimiter
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
      //initialize FileWriter object
		fileWriter = new FileWriter("./output/"+filename);
		
		//initialize CSVPrinter object 
        csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
        
        csvFilePrinter.printRecords("Players With Attacking Work Rate & DEfensive Work Rate As High/HIGH");
        csvFilePrinter.println();
        //Create CSV file header
        csvFilePrinter.printRecord(FILE_HEADER);
		
		//Write a new student object list to the CSV file
        ListIterator<PlayerStats> it=list.listIterator();
        while(it.hasNext()){
	    	 PlayerStats ps=it.next();
	    	 csvFilePrinter.printRecord((playerInfoMap.get(ps.getPlayer_api_id())).getPlayer_name());
	    }
	 }
}
