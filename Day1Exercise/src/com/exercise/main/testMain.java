package com.exercise.main;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.http.ParseException;

import com.exercise.main.DeviceCompliancePayload.DeviceComplianceStatus1;
import com.exercise.main.DevicePrincipalPayload.DevicePrincipal1;
import com.exercise.main.Payload.DeviceComplianceStatus2;
import com.exercise.main.Payload.DevicePrincipal2;
import com.exercise.main.ResponsePayload.FailedElement;
import com.exercise.main.ResponsePayload.Record;
import com.exercise.main.UserAttributes.UserGroup;
import com.google.gson.Gson;
import com.sun.scenario.effect.Merge;

     

public class testMain {
	enum Company {
		EBAY("ebay 1"), PAYPAL("paypal 2"), GOOGLE("google 3"), YAHOO("yahoo 4"), ATT("att 5");
		private String value;

		private Company(String value) {
			this.value = value;
		}
		String getAuditUser(){
			switch(this){
			case EBAY : return "1";
			case PAYPAL : return "2";
			case GOOGLE :return "3";
			case YAHOO : return "4";
			case ATT :return "5";
			default : return "6";
			}
			
		}
	}
	 public final static String tagStart=
	            "\\<\\w+((\\s+\\w+(\\s*\\=\\s*(?:\".*?\"|'.*?'|[^'\"\\>\\s]+))?)+\\s*|\\s*)\\>";
	    public final static String tagEnd=
	            "\\</\\w+\\>";
	    public final static String tagSelfClosing=
	            "\\<\\w+((\\s+\\w+(\\s*\\=\\s*(?:\".*?\"|'.*?'|[^'\"\\>\\s]+))?)+\\s*|\\s*)/\\>";
	    public final static String htmlEntity=
	            "&[a-zA-Z][a-zA-Z0-9]+;";
	    public final static Pattern htmlPattern=Pattern.compile(
	          "("+tagStart+".*"+tagEnd+")|("+tagSelfClosing+")|("+htmlEntity+")",
	          Pattern.DOTALL
	    );
	    
	    public static boolean isHtml(String s) {
	        boolean ret=false;
	        if (s != null) {
	            ret=htmlPattern.matcher(s).find();
	        }
	        return ret;
	    }
	    
	    static Gson gson = new Gson();
	    
	    public static String toJsonString(Object obj){
	    	return gson.toJson(obj);
	    }
	    public static <T> T toJsonObject(String str,Class<T> cls){
	    	return gson.fromJson(str, cls);
	    }
	public static void main(String[] args) throws ParseException, IOException {
		System.out.println("1:"+Subject.HINDI_PART1.name());
		System.out.println("2:"+Subject.HINDI_PART2.name());
		System.out.println("3:"+Subject.ENGLISH.name());
		
		System.out.println("4:"+Company.EBAY.getAuditUser());
		System.out.println("5:"+Company.PAYPAL.getAuditUser());
		System.out.println("6:"+Company.GOOGLE.getAuditUser());
		System.out.println("7:"+Company.ATT.getAuditUser());
		System.out.println("8:"+Company.YAHOO.getAuditUser());
		
		
		Map<String, String> map1=new HashMap<>();
		System.out.println("map1:"+map1.size());
		Map<String,String> map2=null;
		map2=map1;
		System.out.println("map2:"+map2.size());
		List<String> listcheck = new ArrayList<String>();
		listcheck.add("1");
		listcheck.add("2");
		listcheck.add("3");

		for(String str: listcheck) {
			int i=0;
			try {
				do{
					i++;
					System.out.println("i:"+i+"|"+str);
					throw new Exception("Exception for string " + str);

				}while(i<=3);
			} catch(Exception ex) {
				System.out.println("Caught exception");
			}
			System.out.println("mohsin");
		}
		//EntityUtils.toString(null);
		/*
		 * 
		//1000TOTAL_APPS00025000TOTAL_DEVICES0005000TOTAL_DOCS0000000TOTAL_USERS000500
		//1000TOTAL_APPS00025000TOTAL_DEVICES0005000TOTAL_DOCS0000000TOTAL_USERS000500
		//110TOTAL_APPS00000022713TOTAL_DEVICES00000028510TOTAL_DOCS00000021911TOTAL_USERS0000004905500//{TOTAL_USERS=9055, TOTAL_APPS=27, TOTAL_DEVICES=85, TOTAL_DOCS=19}
		String str1="110TOTAL_APPS0000001113TOTAL_DEVICES00000021410TOTAL_DOCS0000001011TOTAL_USERS00000021400";
		//{TOTAL_USERS=14, TOTAL_APPS=1, TOTAL_DEVICES=14, TOTAL_DOCS=0}
		
		
		String str="1000TOTAL_APPS00054000TOTAL_DEVICES00051000TOTAL_DOCS00053000TOTAL_USERS0005200";
		//   110TOTAL_APPS00000022513TOTAL_DEVICES0000001510TOTAL_DOCS0000001011TOTAL_USERS0000001500
		//	 110TOTAL_APPS22513TOTAL_DEVICES1510TOTAL_DOCS1011TOTAL_USERS1500
		//100000010TOTAL_APPS00000022500000013TOTAL_DEVICES0000001500000010TOTAL_DOCS0000001000000011TOTAL_USERS0000001500
		//110TOTAL_APPS00000022513TOTAL_DEVICES0000001510TOTAL_DOCS0000001011TOTAL_USERS0000001500
		testMain.parseFormattedString("110TOTAL_APPS00000022513TOTAL_DEVICES0000001510TOTAL_DOCS0000001011TOTAL_USERS0000001500", 2, 7);
		//110TOTAL_APPS00000022513TOTAL_DEVICES0000001510TOTAL_DOCS0000001011TOTAL_USERS0000001500
	*/
		
		String mohsin="a,b,c";
//		List<String> mi=Arrays.asList(mohsin.split(","));
//		System.out.println("mi:"+mi);
		int size=1;
		int p=50;
		int nn=size/p+size%p;
		List<Integer> ll=new ArrayList<Integer>();
		for (int i=0;i<size;i++){
			ll.add(i);
		}
		System.out.println("List:"+ll);
		for(int i=0;i<size;i+=50){
			System.out.println("LIST:"+ll.subList(i, size>i+p?i+p:size));
		}
		
//		DevicePrincipal dp1=new DevicePrincipal(100L,"mohsin:iqbal:1",null);
//		DevicePrincipal dp2=new DevicePrincipal(200L,"mohsin:iqbal:2",null);
//		DevicePrincipal dp3=new DevicePrincipal(300L,"mohsin:iqbal:3",true);
//		DevicePrincipal dp4=new DevicePrincipal(400L,"mohsin:iqbal:4",null);
//		DevicePrincipal dp5=new DevicePrincipal(500L,"mohsin:iqbal:5",true);
//		DevicePrincipal dp6=new DevicePrincipal(600L,"mohsin:iqbal:6",null);
//		
//		List<DevicePrincipal>list12=new ArrayList<DevicePrincipal>();
//		list12.add(dp1);
//		list12.add(dp2);
//		list12.add(dp3);
//		list12.add(dp4);
//		list12.add(dp5);
//		list12.add(dp6);
		
		DevicePrincipal1 dp1=new DevicePrincipal1(100L,"mohsin:iqbal:1",null);
		DevicePrincipal1 dp2=new DevicePrincipal1(200L,"mohsin:iqbal:2",null);
		DevicePrincipal1 dp3=new DevicePrincipal1(300L,"mohsin:iqbal:3",true);
		DevicePrincipal1 dp4=new DevicePrincipal1(400L,"mohsin:iqbal:4",null);
		DevicePrincipal1 dp5=new DevicePrincipal1(500L,"mohsin:iqbal:5",true);
		DevicePrincipal1 dp6=new DevicePrincipal1(600L,"mohsin:iqbal:6",null);
		
		List<DevicePrincipal1>list12=new ArrayList<DevicePrincipal1>();
		list12.add(dp1);
		list12.add(dp2);
		list12.add(dp3);
		list12.add(dp4);
		list12.add(dp5);
		list12.add(dp6);
		DevicePrincipalPayload dp=new DevicePrincipalPayload("m-1",6,new Timestamp(System.currentTimeMillis()),list12);
		System.out.println("DevicePrincipalPayload:"+dp);
		//1. Convert object to JSON string
        //Gson gson = new Gson();
       
		
		
		
		String json = toJsonString(dp);
        System.out.println("json:\n"+json);

		List<String> oocReasons=new ArrayList<String>();
		oocReasons.add("reason-1");
		oocReasons.add("reason-2");
		oocReasons.add("reason-3");
        DeviceComplianceStatus1 dc1=new DeviceComplianceStatus1(123456L, "csn-123456", "OOC", mohsin!=null?Arrays.asList(mohsin.split(",")):new ArrayList<String>());
        DeviceComplianceStatus1 dc2=new DeviceComplianceStatus1(98765L, "csn-98765", "In-Compliance", new ArrayList<String>());
        List<DeviceComplianceStatus1> list23=new ArrayList<DeviceComplianceStatus1>();
        list23.add(dc1);
        list23.add(dc2);
        DeviceCompliancePayload dcp=new DeviceCompliancePayload("payload-1", 2, new Timestamp(System.currentTimeMillis()), list23);
        json = toJsonString(dcp);
        System.out.println("json:\n"+json);
		
        
        DeviceComplianceStatus2 dc21=new DeviceComplianceStatus2(123456L, "csn-123456", true,"false", mohsin!=null?Arrays.asList(mohsin.split(",")):new ArrayList<String>(),null);
        DeviceComplianceStatus2 dc22=new DeviceComplianceStatus2(98765L, "csn-98765", true,"true", new ArrayList<String>(),null);
        DeviceComplianceStatus2 dc23=new DeviceComplianceStatus2(98765L, "csn-98765", false,"na", new ArrayList<String>(),null);
        DeviceComplianceStatus2 dc24=new DeviceComplianceStatus2(98765L, "csn-98765", null,null,null,true);
        List<DeviceComplianceStatus2> list223=new ArrayList<DeviceComplianceStatus2>();
        list223.add(dc21);
        list223.add(dc22);
        list223.add(dc23);
        list223.add(dc24);
        
		DevicePrincipal2 dp21=new DevicePrincipal2(100L,"mohsin:iqbal:1",null);
		DevicePrincipal2 dp22=new DevicePrincipal2(200L,"mohsin:iqbal:2",null);
		DevicePrincipal2 dp23=new DevicePrincipal2(300L,"mohsin:iqbal:3",true);
		DevicePrincipal2 dp24=new DevicePrincipal2(400L,"mohsin:iqbal:4",null);
		DevicePrincipal2 dp25=new DevicePrincipal2(500L,"mohsin:iqbal:5",true);
		DevicePrincipal2 dp26=new DevicePrincipal2(600L,"mohsin:iqbal:6",null);
		
		List<DevicePrincipal2>list212=new ArrayList<DevicePrincipal2>();
		list212.add(dp21);
		list212.add(dp22);
		list212.add(dp23);
		list212.add(dp24);
		list212.add(dp25);
		list212.add(dp26);
		Payload pd1=new Payload(1L, 6, new Timestamp(System.currentTimeMillis()), null,list212);
        Payload pd2=new Payload(2L, 3, new Timestamp(System.currentTimeMillis()), list223, null);
        System.out.println("latest json:\n"+toJsonString(pd1));
        System.out.println("latest json:\n"+toJsonString(pd2));
        
String ua="{"
+"  \"id\":16,"
+"  \"records\":2,"
+"  \"timestamp\":\"Feb 8, 2017 7:50:06 PM\","
+"  \"users\":["
+"    {"
+"      \"billingId\":\"30053389\","
+"      \"osUserName\":\"somasekhar44\","
+"      \"userFullName\":\"Soma Sekhar\","
+"      \"userEmail\":\"somasekhar44@in.ibm.com\","
+"      \"domain\":\"fiberlink.com\","
+"      \"phoneNumber\":\"9632415627\","
+"      \"userIdentifier\":\"DDF6B09FBFA3532C5BFBB7FFF3FDC7F3\""
+"    },"
+"    {"
+"      \"billingId\":\"30053389\","
+"      \"osUserName\":\"somasekhar\","
+"      \"userFullName\":\"Soma Sekhar\","
+"      \"userEmail\":\"somasekhar44@in.ibm.com\","
+"      \"domain\":\"fiberlink\","
+"      \"phoneNumber\":\"9632415627\","
+"      \"userIdentifier\":\"CDDEE8B19E849E8F9CE45A9B1A1EFDB0\""
+"    }"
+"  ]"
+"}";


UserAttributesPayload uap=toJsonObject(ua, UserAttributesPayload.class);
        String[] arrs={"a","b","c"};
        String strg="mohsin";
        System.out.println("1:"+Arrays.asList(arrs));
        System.out.println("2:"+Arrays.asList(strg));
        
        System.out.println(Boolean.valueOf(null));
        String user="user@realm";
        System.out.println("user:"+user.substring(0, user.indexOf("@")));
        String json1="{"
        		+"  \"id\":\"payload-2\","
        		+"  \"records\":3,"
        		+"  \"timestamp\":\"Jan 24, 2017 11:52:16 AM\","
        		+"  \"deviceComplStats\":["
        		+"    {"
        		+"      \"billingId\":123456,"
        		+"      \"csn\":\"csn-123456\","
        		+"      \"complianceStatus\":\"OOC\","
        		+"      \"oocReasons\":["
        		+"        \"a\","
        		+"        \"b\","
        		+"        \"c\""
        		+"      ]"
        		+"    },"
        		+"    {"
        		+"      \"billingId\":98765,"
        		+"      \"csn\":\"csn-98765\","
        		+"      \"complianceStatus\":\"In-Compliance\","
        		+"      \"oocReasons\":["
        		+""
        		+"      ]"
        		+"    },"
        		+"    {"
        		+"      \"billingId\":98765,"
        		+"      \"csn\":\"csn-98765\","
        		+"      \"_deleted\":true"
        		+"    }"
        		+"  ]"
        		+"}";
        String json2="{"
        		+"  \"id\":\"payload-1\","
        		+"  \"records\":6,"
        		+"  \"timestamp\":\"Jan 24, 2017 11:52:16 AM\","
        		+"  \"devicePrincipals\":["
        		+"    {"
        		+"      \"billingId\":100,"
        		+"      \"principal\":\"mohsin:iqbal:1\""
        		+"    },"
        		+"    {"
        		+"      \"billingId\":200,"
        		+"      \"principal\":\"mohsin:iqbal:2\""
        		+"    },"
        		+"    {"
        		+"      \"billingId\":300,"
        		+"      \"principal\":\"mohsin:iqbal:3\","
        		+"      \"_deleted\":true"
        		+"    }"
        		+"  ]"
        		+"}";
//        System.out.println("from str to obj :"+toJsonObject(json1,Payload.class));
//        System.out.println("from str to obj :"+pd2);
//        System.out.println("from str to obj :"+toJsonObject(json2,Payload.class));
//        System.out.println("from str to obj :"+pd1);
        
        List<FailedElement> lf1=new ArrayList<ResponsePayload.FailedElement>();
        ResponsePayload rep1=new ResponsePayload(pd1.getId(),lf1);
        for(DevicePrincipal2 d2: pd1.getDevicePrincipals()){
        	lf1.add(new FailedElement(new Record(d2.getBillingId()	, d2.getPrincipal(), null, null), "App aborted due to max tries"));
        }

        System.out.println("res from pd1:"+rep1);
        System.out.println("res from pd1:"+toJsonString(rep1));
        
        List<FailedElement> lf2=new ArrayList<ResponsePayload.FailedElement>();
        ResponsePayload rep2=new ResponsePayload(pd2.getId(),lf2);
        for(DeviceComplianceStatus2 d2: pd2.getDeviceComplStats()){
        	lf2.add(new FailedElement(new Record(d2.getBillingId()	, null, d2.getCsn(), null), "App aborted due to max tries"));
        }

        System.out.println("res from pd2:"+rep2);
        System.out.println("res from pd2:"+toJsonString(rep2));
        
        Record rec1=new Record("1234", "mohsin1", null,null);
        Record rec2=new Record("1234", "mohsin2", null,null);

        Record rec3=new Record("1234L", null, "csn-1",null);
        Record rec4=new Record("1234L", null, "csn-2",null);
        
        Record rec5=new Record("1234L", null, null,"uid-1");
        Record rec6=new Record("1234L", null, null,"uid-2");
        FailedElement fe1=new FailedElement(rec1, "conflict-1");
        FailedElement fe2=new FailedElement(rec2, "conflict-2");
        FailedElement fe3=new FailedElement(rec3, "conflict-3");
        FailedElement fe4=new FailedElement(rec4, "conflict-4");
        FailedElement fe5=new FailedElement(rec5, "conflict-5");
        FailedElement fe6=new FailedElement(rec6, "conflict-6");
        
        List<FailedElement>ll1=new ArrayList<ResponsePayload.FailedElement>();
        List<FailedElement>ll2=new ArrayList<ResponsePayload.FailedElement>();
        List<FailedElement>ll3=new ArrayList<ResponsePayload.FailedElement>();
        
        ll1.add(fe1);
        ll1.add(fe2);
        ll2.add(fe3);
        ll2.add(fe4);
        ll3.add(fe5);
        ll3.add(fe6);
        ResponsePayload rpp1=new ResponsePayload(1L,ll1 );
        ResponsePayload rpp2=new ResponsePayload(2L,ll2 );
        ResponsePayload rpp3=new ResponsePayload(3L,ll3 );
        
        System.out.println("Response Payload 1:"+rpp1);
        System.out.println("Response Payload 2:"+rpp2);
        System.out.println("Response Payload 3:"+rpp3);
        
        String res1="{"
        		+"    \"id\": \"1234\","
        		+"    \"failedElements\": [{"
        		+"        \"record\": {"
        		+"            \"billingId\": 1234,"
        		+"            \"principal\": \"billing4:csn4:user4\""
        		+"        },"
        		+"        \"errorMessage\": \"conflict\""
        		+"    }, {"
        		+"        \"record\": {"
        		+"            \"billingId\": 1234,"
        		+"            \"principal\": \"billing3:csn3:user3\""
        		+"        },"
        		+"        \"errorMessage\": \"conflict\""
        		+"    }]"
        		+"}";
        String res2="{"
        		+"    \"id\": \"1234\","
        		+"    \"failedElements\": [{"
        		+"        \"record\": {"
        		+"            \"billingId\": 1234,"
        		+"            \"csn\": \"csn-3\""
        		+"        },"
        		+"        \"errorMessage\": \"conflict\""
        		+"    }, {"
        		+"        \"record\": {"
        		+"            \"billingId\": 1234,"
        		+"            \"csn\": \"csn-2\""
        		+"        },"
        		+"        \"errorMessage\": \"conflict\""
        		+"    }]"
        		+"}";
        String res3="{"
        		+"    \"id\": \"1234\","
        		+"    \"failedElements\": []"
        		+"}";
        
        ResponsePayload rp1=toJsonObject(res1,ResponsePayload.class);
        System.out.println("res1:"+rp1);
        System.out.println("res2:"+toJsonObject(res2,ResponsePayload.class));
        System.out.println("res3:"+toJsonObject(res3,ResponsePayload.class));
        System.out.println(rp1.getId());
        System.out.println(rp1.getFailedElements().get(0).getRecord().getBillingId());
		Group g1=new Group("cg1", "pg1");
		Group g2=new Group("cg2", "pg2");
		Group g3=new Group("cg3", "pg3");
		Group g4=new Group("cg4", "pg4");
	List<Group> list=new ArrayList<Group>();
	list.add(g1);
	list.add(g2);
	list.add(g3);
	list.add(g4);
	System.out.println("list1 :"+list);
	
	Object[] obj=list.toArray();
	for(int i=0;i<obj.length;i++)
		System.out.println("list2 :"+obj[i]);
	
	Object[] obj1=new Object[]{list.toArray()};
	for(int i=0;i<obj1.length;i++)
		System.out.println("list3 :"+obj[i]);
	
	
	String eNm="google 3";
		for (Company cName : Company.values()) {
			System.out.println("Company Value: " + cName.value + " - Comapny Name: " + cName);
		}
		System.out.println(isHtml("In Compliance"));
	String str="<script>alert(1)</script>";
	String str1="mohsin iqbal";
	
	String str2=StringEscapeUtils.escapeHtml4(str);
	String str3=StringEscapeUtils.unescapeHtml4(str2);
	String str4=StringEscapeUtils.unescapeHtml4(str);
	System.out.println(str2);
	System.out.println(str3);
	System.out.println(str4);
	System.out.println(StringEscapeUtils.escapeHtml4(str1));
	System.out.println(StringEscapeUtils.escapeHtml4(str2));
	System.out.println(StringEscapeUtils.unescapeHtml4(str));
	System.out.println(StringEscapeUtils.unescapeHtml4(str1));
	
	
	List<String> cl1=new ArrayList<String>();
	List<String> cl2=new ArrayList<String>();
	cl1.add("M");
	cl1.add("O");
	cl1.add("H");
	cl1.add("S");
	cl1.add("I");
	cl1.add("N");
	
	cl2.add("M");
	cl2.add("O");
	cl2.add("H");
	cl2.add("S");
	cl2.add("I");
	cl2.add("N");
	cl2.add("A");
	
	List<String> cl3=(List<String>) CollectionUtils.subtract(cl1, cl2);
	System.out.println("cl1-cl2 :"+cl3);
	System.out.println("cl2-cl1 :"+CollectionUtils.subtract(cl2, cl1));
	
	
	UserGroup ug1=new UserGroup("g1", "g1-display", "g1-adid");
	UserGroup ug2=new UserGroup("g2", "g2-display", "g2-adid");
	UserGroup ug3=new UserGroup("g3", "g3-display", "g3-adid");
	UserGroup ug4=new UserGroup("g4", "g4-display", "g4-adid");
	
	UserAttributes ua1=new UserAttributes();
	ua1.setBillingId("1");
	ua1.setOsUserName("os");
	ua1.setUserFirstName("mohsin");
	ua1.setUserLastName("iqbal");
	ua1.setUserFullName("mohsin iqbal");
	ua1.setUserEmail("mohsiqba@in.icm.com");
	ua1.setDept("ieee");
	ua1.setJob("SE");
	ua1.setDomain("security");
	ua1.setLocation("bangalore");
	ua1.setMobileNumber("89045820022");
	ua1.setPhoneNumber("1234567890");
	ua1.setEmpId("06522s");
	ua1.setAddress("address");
	ua1.setUpn("upn");
	ua1.setUserIdentifier("userIdentifier");
	ua1.set_deleted(null);
//	ua1.setUserGroupList(Arrays.asList(ug1,ug2));
	
	UserAttributes ua2=new UserAttributes();
	ua2.setBillingId("2");
	ua2.setOsUserName("os");
	ua2.setUserFirstName("mohsin");
	ua2.setUserLastName("iqbal");
	ua2.setUserFullName("mohsin iqbal");
	ua2.setUserEmail("mohsiqba@in.icm.com");
	ua2.setDept("ieee");
	ua2.setJob("SE");
	ua2.setDomain("security");
	ua2.setLocation("bangalore");
	ua2.setMobileNumber("89045820022");
	ua2.setPhoneNumber("1234567890");
	ua2.setEmpId("06522s");
	ua2.setAddress("address");
	ua2.setUpn("upn");
	ua2.setUserIdentifier("userIdentifier");
	ua2.set_deleted(null);
//	ua2.setUserGroupList(Arrays.asList(ug3));
	
	UserAttributes ua3=new UserAttributes();
	ua3.setBillingId("3");
	ua3.setOsUserName("os");
	ua3.setUserFirstName("mohsin");
	ua3.setUserLastName("iqbal");
	ua3.setUserFullName("mohsin iqbal");
	ua3.setUserEmail("mohsiqba@in.icm.com");
	ua3.setDept("ieee");
	ua3.setJob("SE");
	ua3.setDomain("security");
	ua3.setLocation("bangalore");
	ua3.setMobileNumber("89045820022");
	ua3.setPhoneNumber("1234567890");
	ua3.setEmpId("06522s");
	ua3.setAddress("address");
	ua3.setUpn("upn");
	ua3.setUserIdentifier("userIdentifier");
	ua3.set_deleted(null);
	//ua3.setUserGroupList(null);
	
	UserAttributesPayload uap1=new UserAttributesPayload(1L, 3, new Timestamp(System.currentTimeMillis()), Arrays.asList(ua1,ua2,ua3));
	System.out.println("user payload:"+toJsonString(uap1));
	
	
	
	String newuapayload="{"
			+"  \"id\":1,"
			+"  \"records\":3,"
			+"  \"timestamp\":\"May 17, 2017 4:14:51 PM\","
			+"  \"users\":["
			+"    {"
			+"      \"billingId\":\"1\","
			+"      \"osUserName\":\"os\","
			+"      \"userFirstName\":\"mohsin\","
			+"      \"userLastName\":\"iqbal\","
			+"      \"userFullName\":\"mohsin iqbal\","
			+"      \"userEmail\":\"mohsiqba@in.icm.com\","
			+"      \"domain\":\"security\","
			+"      \"dept\":\"ieee\","
			+"      \"job\":\"SE\","
			+"      \"location\":\"bangalore\","
			+"      \"mobileNumber\":\"89045820022\","
			+"      \"phoneNumber\":\"1234567890\","
			+"      \"empId\":\"06522s\","
			+"      \"address\":\"address\","
			+"      \"userIdentifier\":\"userIdentifier\","
			+"      \"upn\":\"upn\","
			+"      \"userGroupList\":["
			+"        {"
			+"          \"userGroupName\":\"g1\","
			+"          \"userGroupDisplayName\":\"g1-display\","
			+"          \"completeADID\":\"g1-adid\""
			+"        },"
			+"        {"
			+"          \"userGroupName\":\"g2\","
			+"          \"userGroupDisplayName\":\"g2-display\","
			+"          \"completeADID\":\"g2-adid\""
			+"        }"
			+"      ]"
			+"    },"
			+"    {"
			+"      \"billingId\":\"2\","
			+"      \"osUserName\":\"os\","
			+"      \"userFirstName\":\"mohsin\","
			+"      \"userLastName\":\"iqbal\","
			+"      \"userFullName\":\"mohsin iqbal\","
			+"      \"userEmail\":\"mohsiqba@in.icm.com\","
			+"      \"domain\":\"security\","
			+"      \"dept\":\"ieee\","
			+"      \"job\":\"SE\","
			+"      \"location\":\"bangalore\","
			+"      \"mobileNumber\":\"89045820022\","
			+"      \"phoneNumber\":\"1234567890\","
			+"      \"empId\":\"06522s\","
			+"      \"address\":\"address\","
			+"      \"userIdentifier\":\"userIdentifier\","
			+"      \"upn\":\"upn\","
			+"      \"userGroupList\":["
			+"        {"
			+"          \"userGroupName\":\"g3\","
			+"          \"userGroupDisplayName\":\"g3-display\","
			+"          \"completeADID\":\"g3-adid\""
			+"        }"
			+"      ]"
			+"    },"
			+"    {"
			+"      \"billingId\":\"3\","
			+"      \"osUserName\":\"os\","
			+"      \"userFirstName\":\"mohsin\","
			+"      \"userLastName\":\"iqbal\","
			+"      \"userFullName\":\"mohsin iqbal\","
			+"      \"userEmail\":\"mohsiqba@in.icm.com\","
			+"      \"domain\":\"security\","
			+"      \"dept\":\"ieee\","
			+"      \"job\":\"SE\","
			+"      \"location\":\"bangalore\","
			+"      \"mobileNumber\":\"89045820022\","
			+"      \"phoneNumber\":\"1234567890\","
			+"      \"empId\":\"06522s\","
			+"      \"address\":\"address\","
			+"      \"userIdentifier\":\"userIdentifier\","
			+"      \"upn\":\"upn\""
			+"    }"
			+"  ]"
			+"}";
		System.out.println("deserialize p :"+toJsonObject(newuapayload, UserAttributesPayload.class));
		
		
		if("mohsin".equalsIgnoreCase(null))
			System.out.println("mohsin iqbal-2");
		
		Map<String,List<Integer>> map=null;
		map=new HashMap<>();
		map.put("1", new ArrayList<>(Arrays.asList(1,5)));
		map.put("2", new ArrayList<>(Arrays.asList(2,6)));
		map.put("3", new ArrayList<>(Arrays.asList(7,8)));
		
		Map<String,List<Integer>>map11=null; 
//		map11=new HashMap<>();
//		map11.put("1", new ArrayList<>(Arrays.asList(3)));
//		map11.put("2", new ArrayList<>(Arrays.asList(4)));
//		map11.put("4", new ArrayList<>(Arrays.asList(9)));
		
mergeMap(map, map11);
		System.out.println("MAP1:"+map);

	}
	
	public static void mergeMap(Map<String,List<Integer>> map1,Map<String,List<Integer>> map2){
		if(map1!=null && map2!=null){
			for (Map.Entry<String, List<Integer>> en : map2.entrySet()) {
				if(map1.containsKey(en.getKey()))
					map1.get(en.getKey()).addAll(en.getValue());
				else
					map1.put(en.getKey(), en.getValue());
			}
		}else if(map2!=null){
			map1= map2;
		}
	}
	public  static void parseFormattedString(String input ,int KEY_INDEX_LENGTH, int VAL_INDEX_LENGTH)
	{
/*		if(org.springframework.util.StringUtils.hasText(input))
		{*/
			int startIndex = 1;
			int endIndex = startIndex + KEY_INDEX_LENGTH;
			StringBuilder builder = new StringBuilder(input);
			int requireProcessing  = builder.charAt(0) - '0';
			
			if(requireProcessing > 0)
			{
				Map<String, String> params = new HashMap<String, String>();
				System.out.println("startIndex 1:"+startIndex+"|endIndex :"+endIndex);
				int keyLength = Integer.parseInt(builder.substring(startIndex, endIndex));
				System.out.println("keyLength 1:"+keyLength);
				while(keyLength != 0)
				{
					startIndex = endIndex;
					endIndex += keyLength;
					String key = builder.substring(startIndex, endIndex);
					System.out.println("2.startIndex :"+startIndex+"|endIndex :"+endIndex+" |key :"+key);
					System.out.println("2.keyLength :"+keyLength);
					
					startIndex = endIndex;
					endIndex += VAL_INDEX_LENGTH;
					int valLength = Integer.parseInt(builder.substring(startIndex, endIndex));
					System.out.println("3.startIndex :"+startIndex+"|endIndex :"+endIndex+" |valLength :"+valLength);
					
					startIndex = endIndex;
					endIndex += valLength;
					String value = builder.substring(startIndex, endIndex);
					System.out.println("4.startIndex :"+startIndex+"|endIndex :"+endIndex+" |value :"+value);
					
					//populate result map
					params.put(key, value);
					System.out.println("params :"+params);
	 
					//Reset the index
					startIndex = endIndex;
					endIndex += KEY_INDEX_LENGTH;
					keyLength = Integer.parseInt(builder.substring(startIndex, endIndex));
					System.out.println("5.startIndex :"+startIndex+"|endIndex :"+endIndex+" |keyLength :"+keyLength);
				}
				System.out.println(params);
			} 
	 
//		}
		//System.out.println(Collections.emptyMap());
	}
}
