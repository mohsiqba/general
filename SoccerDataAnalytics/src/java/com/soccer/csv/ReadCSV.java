package com.soccer.csv;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.soccer.beans.PlayerInfo;
import com.soccer.beans.PlayerStats;

public class ReadCSV 
{
    public static List<PlayerStats> getPlayerStatsList() throws ParseException 
    {
        String csvFile = "./input/Player_Stats.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        List<PlayerStats> playerStatList=null;
        try 
        {
            br = new BufferedReader(new FileReader(csvFile));
            boolean firstLine=true;
            Calendar c = Calendar.getInstance();
            DateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            while ((line = br.readLine()) != null) 
            {
            	if (firstLine) {
					playerStatList=new ArrayList<PlayerStats>();
					firstLine=false;
					continue;
				}
                // use comma as separator
                String[] player_stat = line.split(cvsSplitBy);
                if(player_stat.length<8)
                	continue;
                c.setTime(dateFormater.parse(player_stat[3].replace("\"", "")));
                playerStatList.add(new PlayerStats(Integer.valueOf(player_stat[1]), Integer.valueOf(player_stat[2]), c.get(Calendar.YEAR), Integer.valueOf(player_stat[4]), Integer.valueOf(player_stat[5]), player_stat[6], player_stat[7],player_stat[8]));
            }
        }
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            if (br != null) 
            {
                try 
                {
                    br.close();
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
        }
        return playerStatList;
    }
    
    public static Map<Integer,PlayerInfo> getPlayerInfoMap() throws ParseException 
    {
        String csvFile = "./input/Player.csv";
        Reader in = null;
        Map<Integer,PlayerInfo> playerInfoMap=null;
        try 
        {
        	in=new FileReader(csvFile);
        	Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
            boolean firstLine=true;
            for (CSVRecord record : records) 
            {
            	if (firstLine) {
					playerInfoMap=new HashMap<Integer, PlayerInfo>();
					firstLine=false;
					continue;
				}
                playerInfoMap.put(Integer.valueOf(record.get(1)),new PlayerInfo(Integer.valueOf(record.get(1)),record.get(2), Integer.valueOf(record.get(3))));
            }
        }
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            if (in != null) 
            {
                try 
                {
                    in.close();
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
        }
        return playerInfoMap;
    }
}
