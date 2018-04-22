package com.exercise.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.StringJoiner;

import org.reflections.Reflections;

import com.mohsin.handler.IExample;

public class TestCondition {

	public static void main(String[] args) {
		boolean a=true;
		boolean b=true;
		boolean c=false;
		
		boolean res= a||b&&c;
		System.out.println("1:"+res);
		
		res=(a||b)&&c;
		System.out.println("2:"+res);
		
		res=a||(b&&c);
		System.out.println("3:"+res);
		
		
		
/*        if((m!=null && m.equalsIgnoreCase("Yes")) && (m1.equals("AUTO_APPROVE_SECURE") ||m1.equals("AUTO_APPROVE_NATIVE"))){
        	logger.debug("Got failed_settings:"+m+"| in hh_device_info for " + deviceId + " orgId : " + orgId + "so not executing XMPP action:" + action);
        	return 1;
        }
*/
		String m="Yes";
		String m1="AUTO_APPROVE_SECURE";
		
	        if((m!=null && m.equalsIgnoreCase("Yes")) && (m1.equals("AUTO_APPROVE_SECURE") ||m1.equals("AUTO_APPROVE_NATIVE"))){
    	System.out.println("Got failed_settings:"+m);
    }
	        
	        EnumBulkDataSources bulkDataSource = EnumBulkDataSources
	                .valueOf("EXCHANGE");
	        System.out.println(bulkDataSource);
		StringJoiner joiner = new StringJoiner(",");
		joiner.add("01").add("02").add("03");
		String joinedString = joiner.toString();
		System.out.println("joinedString :"+joinedString);
		
		List<String> strings = null;
//		String message = String.join(" ", strings);
//		System.out.println("message:"+message);
		strings = new ArrayList<>();
		String message = String.join(" ", strings);
		System.out.println("message:"+message);
		strings.add("Java");strings.add("is");
		strings.add("cool");
		message = String.join(",", strings);
		System.out.println("message:"+message);
		
		String[] arr=null;
		if(arr!=null){
		for(String str:arr){
			System.out.println(str);
		}
		}
		
		System.out.println(day.MONDAY.name());
		System.out.println(day.MONDAY);
		
		String s1="mohsin";
		String s2="iqbal";
		String s3="%1$s-%2$s";
		System.out.println(String.format(s3, s1,s2));
		Object str[]={"com.mohsin.handler.impl","com.mohsin.handler.impl1"};
		Reflections reflections=new Reflections(str);
		Set<Class<? extends IExample>> classes = reflections.getSubTypesOf(IExample.class);
		//System.out.println(classes);
		Iterator<Class<? extends IExample>> it=classes.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		String str11="mohsin,iqbal";
		String str12="";
		System.out.println(str11.split(",").length);
		System.out.println(str12.split(",").length);
		
		List<Group> list=new ArrayList<Group>();
		Group g1=new Group("root1", null);
		Group g2=new Group("grp1", "root1,grp2");
		Group g3=new Group("grp2", "root1");
		Group g4=new Group("grp3", "root1,grp2");

		Group g5=new Group("grp4", "grp3");
		Group g6=new Group("leaf1", "grp1");
		Group g7=new Group("leaf2", "grp1");
		Group g8=new Group("leaf3", null);
		list.add(g1);
		list.add(g2);
		list.add(g3);
		list.add(g4);
		list.add(g5);
		list.add(g6);
		list.add(g7);
		list.add(g8);
		System.out.println("prev list:"+list.size());
		
		List<Group> list2=process(list);
		System.out.println("now list:"+list2.size());
		for(Group g:list2)
			System.out.println(g);
	}
	
	private static List<Group> process(List<Group> list) {
		List<Group> list2=new ArrayList<Group>();
		ListIterator<Group> it=list.listIterator();
		while(it.hasNext()){
			Group g=it.next();
			System.out.println(g);
			if(g.getParentGrp()!=null && !g.getParentGrp().isEmpty() && g.getParentGrp().split(",").length>1){
				for(String s:g.getParentGrp().split(",")){
					list2.add(new Group(g.getChildGrp(), s));
				}
				continue;
			}
			list2.add(g);
		}
		return list2;
	}

	public enum day{
		MONDAY,
		TUESDAY,
		WEDNESDAY,
		THURSDAY,
		FRIDAY,
		SATURDAY
	}
}
