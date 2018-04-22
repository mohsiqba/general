package com.exercise;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Node {

	public static void main(String[] args) {
		boolean descSort=true;
		String sortColumn="EVAL_MODE_PARAM";
		System.out.println(new Timestamp(System.currentTimeMillis()));
		System.out.println(new Timestamp(System.currentTimeMillis()+100));
		//List<SavedSearch> values = Node.test1();
		List<SavedSearch> values = Node.test3();
		List<SavedSearch> result = new Node().sortSavedSearch(values, descSort, sortColumn);
		System.out.println(result);
		System.out.println(result.size());
	}
//	/*
//	 * sortColumn:SEARCH_TYPE
//	 */
//	public static List<SavedSearch> test1(){
//		List<SavedSearch> values = new LinkedList<SavedSearch>();
//		values.add(new SavedSearch("dfhgdssadjg"));
//		values.add(new SavedSearch("aaaab"));
//		values.add(new SavedSearch("abab"));
//		values.add(new SavedSearch("rtregbfdsj"));
//		values.add(new SavedSearch("dfhgdssadjg"));
//		values.add(new SavedSearch("abab"));
//		values.add(new SavedSearch("1234gh098"));
//		values.add(new SavedSearch("aaab"));
//		values.add(new SavedSearch("uyuyundf"));
//		values.add(new SavedSearch("plosisdudsh"));
//		values.add(new SavedSearch("qaaeufdhewf"));
//		values.add(new SavedSearch("policyyyyy"));
//		values.add(new SavedSearch("qwsxahdsad"));
//		values.add(new SavedSearch("null"));
//		values.add(new SavedSearch("12343"));
//		values.add(new SavedSearch("213sdsf"));
//		values.add(new SavedSearch("sdsadsa123"));
//		values.add(new SavedSearch("dwfjhfdh"));
//		values.add(new SavedSearch("aqdwdde"));
//		values.add(new SavedSearch("aaab"));
//		values.add(new SavedSearch("dfhgdssadjg"));
//		values.add(new SavedSearch("dfhgdssadjg"));
//		values.add(new SavedSearch("1234"));
//		values.add(new SavedSearch("4321"));
//		values.add(new SavedSearch("!djf$%"));
//		values.add(new SavedSearch("@#qas"));
//		values.add(new SavedSearch("&dsjfdshf"));
//		values.add(new SavedSearch("asd abd abd"));
//		values.add(new SavedSearch("plin ajshj"));
//		values.add(new SavedSearch("123 q2 123"));
//		values.add(new SavedSearch("qaqdy 1233"));
//		values.add(new SavedSearch("rghiuredihjc 121"));
//		values.add(new SavedSearch("jwfehkj 213243"));
//		values.add(new SavedSearch("sdsadsa123"));
//		values.add(new SavedSearch("!djf$%"));
//		values.add(new SavedSearch("dfhgdssadjg"));
//		
//		return values;
//	}
	
	/*
	 * sortColumn:SEARCH_UPDATE_DATE
	 */
//	public static List<SavedSearch> test2(){
//		List<SavedSearch> values = new LinkedList<SavedSearch>();
//		for(int i=1000;i<1500;i++)
//			values.add(new SavedSearch(new Timestamp(new Date().getTime()+i)));
//		values.add(new SavedSearch(new Timestamp(System.currentTimeMillis())));
//		values.add(new SavedSearch(null));
//		values.add(new SavedSearch(new Timestamp(System.currentTimeMillis())));
//		values.add(new SavedSearch(null));
//		values.add(new SavedSearch(null));
//		values.add(new SavedSearch(new Timestamp(System.currentTimeMillis())));
//		values.add(new SavedSearch(new Timestamp(System.currentTimeMillis())));
//		values.add(new SavedSearch(new Timestamp(System.currentTimeMillis())));
//		values.add(new SavedSearch(null));
//		values.add(new SavedSearch(new Timestamp(System.currentTimeMillis())));
//		values.add(new SavedSearch(new Timestamp(System.currentTimeMillis())));
//		values.add(new SavedSearch(null));
//		values.add(new SavedSearch(null));
//		values.add(new SavedSearch(new Timestamp(System.currentTimeMillis())));
//		values.add(new SavedSearch(new Timestamp(System.currentTimeMillis())));
//		values.add(new SavedSearch(new Timestamp(System.currentTimeMillis())));
//		values.add(new SavedSearch(new Timestamp(System.currentTimeMillis())));
//		values.add(new SavedSearch(new Timestamp(System.currentTimeMillis())));
//		values.add(new SavedSearch(new Timestamp(System.currentTimeMillis())));
//		values.add(new SavedSearch(new Timestamp(System.currentTimeMillis())));
//		values.add(new SavedSearch(null));
//		values.add(new SavedSearch(null));
//		values.add(new SavedSearch(null));
//		values.add(new SavedSearch(null));
//		values.add(new SavedSearch(new Timestamp(System.currentTimeMillis())));
//		values.add(new SavedSearch(new Timestamp(System.currentTimeMillis())));
//		values.add(new SavedSearch(new Timestamp(System.currentTimeMillis())));
//		values.add(new SavedSearch(new Timestamp(System.currentTimeMillis())));
//		values.add(new SavedSearch(new Timestamp(System.currentTimeMillis())));
//		values.add(new SavedSearch(null));
//		values.add(new SavedSearch(null));
//		values.add(new SavedSearch(new Timestamp(System.currentTimeMillis())));
//		values.add(new SavedSearch(new Timestamp(System.currentTimeMillis())));
//		values.add(new SavedSearch(new Timestamp(System.currentTimeMillis())));
//		values.add(new SavedSearch(null));
//		System.out.println(values);
//		return values;
//	}
	
	/*
	 * sortColumn:EVAL_MODE_PARAM
	 */
	public static List<SavedSearch> test3(){
		List<SavedSearch> values = new LinkedList<SavedSearch>();
		values.add(new SavedSearch("true"));
		values.add(new SavedSearch("false"));
		values.add(new SavedSearch("false"));
		values.add(new SavedSearch("true"));
		values.add(new SavedSearch("true"));
		values.add(new SavedSearch("true"));
		values.add(new SavedSearch("false"));
		values.add(new SavedSearch("true"));
		values.add(new SavedSearch("false"));
		values.add(new SavedSearch("false"));
		values.add(new SavedSearch("true"));
		values.add(new SavedSearch("true"));
		values.add(new SavedSearch("true"));
		values.add(new SavedSearch("true"));
		values.add(new SavedSearch("false"));
		values.add(new SavedSearch("false"));
		values.add(new SavedSearch("true"));
		values.add(new SavedSearch("false"));
		values.add(new SavedSearch("true"));
		values.add(new SavedSearch("true"));
		values.add(new SavedSearch("false"));
		values.add(new SavedSearch("true"));
		values.add(new SavedSearch("false"));
		values.add(new SavedSearch("true"));
		values.add(new SavedSearch("false"));
		values.add(new SavedSearch("true"));
		values.add(new SavedSearch("false"));
		values.add(new SavedSearch("true"));
		values.add(new SavedSearch("false"));
		values.add(new SavedSearch("false"));
		values.add(new SavedSearch("false"));
		values.add(new SavedSearch("false"));
		values.add(new SavedSearch("true"));
		values.add(new SavedSearch("true"));
		values.add(new SavedSearch("true"));
		values.add(new SavedSearch("true"));
		values.add(new SavedSearch("true"));
		values.add(new SavedSearch("false"));
		values.add(new SavedSearch("false"));
		values.add(new SavedSearch("true"));
		System.out.println(values);
		return values;
	}
	private List<SavedSearch> sortSavedSearch(Collection<SavedSearch> savedSearches,final boolean descSort, final String sortColumn) {
        List<SavedSearch> values = new LinkedList<SavedSearch>();
        values.addAll(savedSearches);
        Collections.sort(values, new Comparator<SavedSearch>() {
            @Override
            public int compare(SavedSearch o1, SavedSearch o2) {
                if (sortColumn.equalsIgnoreCase("SEARCH_TYPE")) {
                    return (descSort ? 1 : -1) * o2.getSearchType().toLowerCase().compareTo(o1.getSearchType().toLowerCase());
                } else if (sortColumn.equalsIgnoreCase("SEARCH_UPDATE_DATE")) {
                    if(o1.getLastEvaluatedDate() == null && o2.getLastEvaluatedDate() == null){
                    	//System.out.println("1");
                    	return 0;
                    }
                    else if(o1.getLastEvaluatedDate() == null && o2.getLastEvaluatedDate() != null) {
//                    	System.out.println("2");
                    	return  1*(descSort ? 1 : -1);
                    }
                    else if(o1.getLastEvaluatedDate() != null && o2.getLastEvaluatedDate() == null){
//                    	System.out.println("3");
                    	return  -1*(descSort ? 1 : -1);
                    }
                    else {
//                    	System.out.println("4");
                        return (descSort ? 1 : -1) * (o1.getLastEvaluatedDate().after(o2.getLastEvaluatedDate()) ? -1 : 1);
                    }
                } else if (sortColumn.equalsIgnoreCase("LAST_EVALUATED_DATE")) {
                    if(o1.getLastGrpEvaluatedDate() == null && o2.getLastGrpEvaluatedDate() == null) return 0;
                    else if(o1.getLastGrpEvaluatedDate() == null && o2.getLastGrpEvaluatedDate() != null) return  1*(descSort ? 1 : -1);
                    else if(o1.getLastGrpEvaluatedDate() != null && o2.getLastGrpEvaluatedDate() == null) return  -1*(descSort ? 1 : -1);
                    else {
                        return (descSort ? 1 : -1) * (o1.getLastGrpEvaluatedDate().after(o2.getLastGrpEvaluatedDate()) ? -1 : 1);
                    }
				}
				else if (sortColumn.equalsIgnoreCase("EVAL_MODE_PARAM"))
				{
					// descSort here means if o1 > o2 return -1
					// evalMode can only be true=Real-Time, or false=Batch
					// [vrao:DNA-63709] Realtime first = descending order i.e Reaaltime > Batch => true > false
					if(o1.getEvalMode().equalsIgnoreCase(o2.getEvalMode()))
					{
						return 0;
					}
					else if(o1.getEvalMode().equalsIgnoreCase("true"))
					{
						return (descSort ? 1 : -1) * -1;
					}
					else
					{
						return (descSort ? 1 : -1) * 1;
					}
				}
				else
				{
                    return 0;
                }
            }
        });

        return values;
    }
}
