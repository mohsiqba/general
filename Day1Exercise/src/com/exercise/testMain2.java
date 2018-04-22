package com.exercise;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;
import com.thoughtworks.xstream.XStream;


public class testMain2 {
	private static Integer A=1;
	private static Integer B=2;
	private static Integer C=4;
	private static Integer D=8;
	private static Integer E=16;
	private static Integer F=32;
	
	private static Integer ALL_CONF=63;
	private static Integer A_CONF=1;
	private static Integer AB_CONF=3;
	private static Integer ABC_CONF=7;
	private static Integer ABCD_CONF=15;
	private static Integer ABCDE_CONF=31;
	private static Integer NONE_CONF=0;
	public static void main(String[] args) {
		System.out.println("mohsin");
		Map<String,Integer> actionMap=new HashMap<>();
		actionMap.put("A", 1);
		actionMap.put("B", 2);
		actionMap.put("C", 4);
		actionMap.put("D", 8);
		actionMap.put("E", 16);
		actionMap.put("F", 32);
		
		Boolean b= (A & ALL_CONF)==A;
		System.out.println(b);
		
		b= (A & AB_CONF)==A;
		System.out.println(b);
		
		b= (A & ABC_CONF)==A;
		System.out.println(b);
		
		b= (A & ABCD_CONF)==A;
		System.out.println(b);
		
		b= (A & ABCDE_CONF)==A;
		System.out.println(b);
		
		b= (A & NONE_CONF)==A;
		System.out.println(b);
		
		b= (A & ALL_CONF)==A;
		System.out.println(b);
		
		
		System.out.println(RevokeActionEnum.SELECTIVE_WIPE_BIT_VALUE.toString());
		System.out.println(RevokeActionEnum.SELECTIVE_WIPE_BIT_VALUE.value);
		
		if(4>3)
			System.out.println("mohsin");
		Integer m1=new Integer(10);
		if(m1.equals(10))
			System.out.println("Iqbal");
		
		List<String> l=new ArrayList();
		List<String> l1=new ArrayList();
		List<String> l2=new ArrayList();
		List<String> l3=new ArrayList();
		
		l1.add("a1");
		l1.add("b1");
		l1.add("c1");
		
		l2.add("a2");
		l2.add("b2");
		l2.add("c2");
		
		l3.add("a3");
		l3.add("b3");
		l3.add("c3");
		
		l.addAll(l1);
		System.out.println("l after l1 :"+l);
		l.addAll(l2);
		System.out.println("l after l2 :"+l);
		l.addAll(l3);
		System.out.println("l after l3 :"+l);
		
		List<String> strList=new ArrayList<>();
		List<String> strList1=new ArrayList<>();
//		for(int i=0;i<2550;i++)
//			strList.add("A"+i);
		System.out.println("0:strList:"+strList+"\n0:strList.size:"+strList.size());
		
		int strt=0,numIdx=1000;
		do {
			System.out.println(strt+"|"+numIdx+"|"+strList.subList(strt, strList.size()<numIdx?strList.size():numIdx).size());
			strList1.addAll(strList.subList(strt, strList.size()<numIdx?strList.size():numIdx));
			strt=numIdx;
			numIdx+=1000;
		}while(strt<strList.size());
		System.out.println("1:strList1:"+strList1+"\n1:strList1.size:"+strList1.size());
		String commas="08tv,09g6,1668562484,230w,24240eaf45c6,29gt,2lyc,3412982ae8fd,4by6,4ckh,4kbg,4kht,4khv,4m45,4ymr,508p,5b7x,5kpp,5mjt,5qjx,5ydm,5zmm,61yw,6554,6557,6cc7,7php,7rjf,7sx7,7z8d,7z8q,80006e45ee94,868c,868d,8bx3,8c7h,8hhr,8jg7,8kdt,98fe94adfd9b,Android0250F20000050000,Android1052d53ac0ee356a,Android125efe53a084981f,Android129dc8626ba38b16,Android139bb6ab06307499,Android1456bfdb6fad6b72,Android14ea63167f1aa59,Android151ffba3c3a45e7f,Android16224c36cd82589e,Android1950b677b8c8e048,Android1a85a54723d086f6,Android1ae457dcc8e67446,Android1b0f126b0f0e3e25,Android1c8ee6bbbea0782,Android1ca8271afc06b3b6,Android1d115ecad6d15cf,Android1d1263f431ca50ad,Android1e103b0a4330df70,Android1eee1215db25e63e,Android1f3b4617223f442a,Android1fe66299677b4655,Android214bfddba01120ac,Android21a7844851cf1ad6,Android22950cf390d36218,Android22e88f68bc976e6,Android24d9c669d618448e,Android24f9a3a8bf79d92b,Android25a051c217de7a4f,Android261c31ad64003eb2,Android27039868,Android27e4d0aeafe99236,Android28bda110896a5fe5,Android29882046b4ab1916,Android2af902e14d665d58,Android2c4de2801ff1ea6,Android2e96725e45826c9e,Android2ea89cd57e91decc,Android2ec8a0c541a2b674,Android30c120f5bdc60efb,Android30e29415dcd2ccf4,Android314fd7a186a46ec7,Android33a222c861f8fec6,Android354043047664273,Android356525042836045,Android357232046478168,Android35a63121e9d22e52,Android394cb893e97b6ba2,Android39a9bc06105815a4,Android3C970EAC2AF50000,Android3a5305cecca1404d,Android3aab372df83dffd4,Android3b420c671733c835,Android3b8480b05884690e,Android3bb20b24f6157e59,Android3bbb9c680cba9128,Android3bfdb975349c307f,Android3ea0d52d231d5e5d,Android3f3bb46e0b34aa26,Android3f9fb169d0f9afd0,Android40250F2000005000,Android40490018f2bf17b1,Android414e62c5e85bcb33,Android419bd9d813f9b9ac,Android422d2cf938d15ed8,Android4240fe75c40227f5,Android4429c79ed94562a9,Android443359ec4d661e95,Android44986bae0de30501,Android449ae5e99326cd3a,Android44f3e1ebc46b9082,Android4563f88fc46ad875,Android45c68aa4c8333df,Android488f543a454b3e02,Android49d39b5fd5076a0a,Android4ad27d5add5d7cd9,Android4ae3031cf78175c8,Android4b2604f60b45b748,Android4b39af7d3749600b,Android4cef00dc0750e75e,Android4d2089a54056d7c5,Android4e201c05eb267610,Android4f83d15e7c48b04b,Android50aebc9bd4a73ee1,Android5268c6a750732c37,Android53d49b94844465e9,Android5443d644a5da0e7a,Android552f6eab4dc32a0b,Android556d9164d232a214,Android55c0b2c56214b759,Android55e03cd8115f24da,Android55efdada3490ded,Android5617c8dabf0fb9fa,Android56666b69afe6b3ef,Android574a5ad10506ea5,Android5878cbb6c4d70881,Android590669b3104ee93d,Android59273407ab67ab6d,Android597f385be63a2dbc,Android5b2280ee33d3e3e8,Android5c3a24aa70b3b078,Android5cf800479985e8c6,Android5d27eb7bec15fd32,Android5d2b61b127a6399,Android60ad330a61ee6f13,Android61a82fa49bf1f5f0,Android6273a6884d6cf605,Android63624583d1cb9d48,Android65370458f80f26,Android670114a48e1b7671,Android672b0c450deb2fdc,Android6ac0ddfc7c03536c,Android6c222030c7168347,Android6c275c4d70be8485,Android6e76be155167e4a6,Android6f0ebc366fea84f1,Android732c73bff6dcf7fd,Android73d19e5316d9485b,Android743b7ae37e128b8d,Android76eda10c60d7026f,Android77cbefadff105dee,Android783b5f73a2446430,Android7adc024acf4d0dda,Android7c20c3077a86a05,Android7c66ef2b097116d0,Android7cf1fd3309c6e912,Android7db822f2111f6e68,Android7dbde891416919cc,Android7dc7f22fa984be91,Android7eb6870c23b4bde3,Android81670595195f0e74,Android81ae221552f502e2,Android83e1e7ff55b47880,Android845a0fef31d90857,Android84fff58f26ca288f,Android851f816772f0ff77,Android86c81ffe1660ef5b,Android87572d5977f2bddc,Android883259c3c7ccb1d3,Android88655bbe802c3f4,Android8b8ce735bf98485f,Android8faa0ce4f5a6d40e,Android8fb50fbbbdd8bcd7,Android9030f45e2eda96ca,Android9141923d55b3814b,Android932724d2712a7f5c,Android93f8661402661275,Android940c0cc85401cbd1,Android954bf8be48839c8d,Android95cedae8a434b6cc,Android95e6436613c79af7,Android968cee6dab0118ae,Android9708b2156293caa9,Android97c276b7d75f3616,Android9922879d6a48173,Android9a596007ecb88af6,Android9af8472cf00d4a13,Android9bff1c4e02868031,Android9c382d10867daa3d,Android9ce1bb1a6968785b,Android9fbc0ca4f2d2a5a4,Android9fc16520a974665d,Androida02a1b8be5cae24d,Androida1fc49b20251e5e9,Androida240629e8f0bee61,Androida2f6ad1a8d5e8849,Androida35f4bf1d40ba5b3,Androida467e214225c8876,Androida5e922dcf695b3f1,Androida636afbb1d18eac1,Androida66eb597adae5cdb,Androida6a462c7ba7427cf,Androida6a697f6be952915,Androida704ade0fa41b4b0,Androida7e7d1e96a19ad4,Androida7ee20a9d36c8774,Androida886d9a19d1ee802,Androida9b7b4af8f138f97,Androidab3d377fa4edeb59,Androidac9fb22a3284168c,Androidacb48f7006315cb6,Androidad99797b793017a3,Androidadaa876e6f6269a8,Androidadab7f56f43b4a14,Androidadc5275576699154,Androidae5ae1e502a980b3,Androidaf66ee7bde3f7f73,Androidb0f1b0d49ffdf723,Androidb10dd207e8989b2e,Androidb397d2a65fd6a1d6,Androidb46c27114ad11d89,Androidb57f44905f699c86,Androidb6a134bffad3403e,Androidb6d83c2e4840ce3a,Androidb782bdb9475dd6e8,Androidb7e892e203254032,Androidb9707b6e121a038b,Androidba15d9b1f7e5e72,Androidbc706b400e675bac,Androidbd30abb1775a9cfe,Androidbe1104cecfd22955,Androidbe348cef57833769,Androidbedc22bdeeb95228,Androidbeea2fd07a3f2281,Androidc0ecb44e3687df4c,Androidc19fa493d5d4dba2,Androidc56848b34ef35856,Androidc5743444408487f3,Androidc5df7b4485c84ff3,Androidc7d70b6be488d5ae,Androidc7e9bff2695d01ba,Androidc84e407882a15921,Androidc99e19358f3d31c0,Androidca7ddfd9aba1dcf3,Androidcb1a3cc5ded10eb2,Androidcbe4efea6308f8b9,Androidcc9caae45599fc76,Androidcd0886c46964332d,Androidcd0a1a1defd6fc8,Androidcd3cf666f1b17486,Androidcdad5fb42634256e,Androidcdbfc35d844b4793,Androidce789575a229801e,Androidcfdea1473d43a3e4,Androidcfdf44e035c03fdf,Androidcfe817161b6d8aff,Androidd02490e6d1bad58b,Androidd13c1483c26376b2,Androidd1e1b5732cc1bc5d,Androidd34e9fd53767033b,Androidd4ee0065790ea9df,Androidd5400138c8fe33f4,Androidd551610a4831a3df,Androidd583615802e8b043,Androidd5cfa5b2b54c659d,Androiddb8e1eb06040e97c,Androiddbb19cb1fde2cd2b,Androiddc90a82149e91e59,Androiddd344ebe302c4bfb,Androiddd9bc86755e17ece,Androidddd4d80518030841,Androidde004b8f884e451e,Androide164ec5f46716cf,Androide198eecc6f5457fa,Androide1bc33a72abc1d1,Androide48eb6d45507e657,Androide5842f03682fa6ae,Androide7b69604b2236276,Androide7c062a04c4a5eef,Androide9158d81e38b32ba,Androide9ad3ea172858411,Androidea347200b24ddc7f,Androideb6c6f59041dd71e,Androided565092a5a4ce76,Androidee6df15079356ab7,Androidefb9abef8bf3df7f,Androidf0242da881a5030e,Androidf04e1d3eefd5d8aa,Androidf07d7401bb6e7286,Androidf1a0a88e7c6fefee,Androidf1ff145b56f31356,Androidf21bf62c66affe5a,Androidf24d7e8b8df5fff4,Androidf2f7669f1ba28c57,Androidf3b5a26c6d0bf803,Androidf4d976f4a720a01d,Androidf659e7f6c1b0c2aa,Androidf78f832d6d9d4350,Androidf7ced92f19abe408,Androidf87ac1485fae07c2,Androidf8e4a0f2460c989b,Androidf9c4881b2e324f6c,Androidf9f3a62aec8605d6,Androidf9f521394a8a5ee1,Androidfaf27462987d64cd,Androidfbb576c0c404a6a1,Androidfc65895414ddf1ca,Androidfcbf5c5b5873fb92,Androidfd4dc526b55ec9d8,Androidfd6914ebd082c72e,Androidfea7820c027ef11e,Androidfeb3b2df39be0a8f,Androidfec69d8901819d7f,Androidfed12164defbe67e,Androidnull,Appl5K4030B8A4S,Appl65105TVQA4S,Appl7Q110SB1A4S,Appl7W0420B6A4S,Appl80017PY93NP,Appl84943PBC3NP,Appl851387N8DZZ,Appl859454SP3NR,Appl861286SJA4T,Appl86921182Y7H,Appl87851QLCY7H,Appl881337JWA4S,Appl9C022P4F6K2,ApplC02FN0TQDH2M,ApplC02LMB01FD57,ApplC02LP02HFLCF,ApplC02LT16ZFH05,ApplC17Q35QBG940,ApplC28HF3WKDT9Y,ApplC28HW4ADDTC1,ApplC31NGFRHG5MQ,ApplC34JR72UDTWD,ApplC35GPU23DTD2,ApplC35JKY8RDTWF,ApplC36JX46VDTWD,ApplC36LP1GXFRC6,ApplC38GMT3ADTD2,ApplC38P60R4G5MR,ApplC39GLQHNDTDM,ApplC39JPFDEDTWG,ApplC39KVE4MDTWD,ApplC39LLDVCFRC5,ApplC39LN6TKFRC7,ApplC39LNTXJFFG8,ApplC39LQSASFRC8,ApplC39LTG8HFRC6,ApplC39LV4LEFRCF,ApplC39M51XJFF9R,ApplC39NP116G5MN,ApplC39QM41RGRWT,ApplC3RGH7BXDT77,ApplC78JK47TDP0V,ApplC79P23QEG5MG,ApplC7GJV06TF8GL,ApplC7JNKDALG5N0,ApplC7JP4LE3G5MV,ApplC8VF9RA3DDP7,ApplCCQKN7AZF4JW,ApplDKVJC07UDKNY,ApplDKVL60FQF191,ApplDLXFL3YHDFJ3,ApplDLXFLLUXDFJ1,ApplDLXFN3B3DFHY,ApplDLXG7ARNDFHY,ApplDLXGG2Z3DFHY,ApplDLXGGGJVDFJ2,ApplDLXGHF4NDFJ2,ApplDLXGVAXVDFHY,ApplDLXGW1GZDKPH,ApplDLXJKM6ZF183,ApplDLXJL713F184,ApplDLXJRBPRF19P,ApplDLXJT1A2FLML,ApplDLXJV2WJF191,ApplDLXJV9N2F19K,ApplDLXKL7FKF185,ApplDLXKQ5EUF182,ApplDLXKW4ZBF182,ApplDLXLQ0MGFLMM,ApplDLXLQ217F4YG,ApplDLXLR2FVFLMK,ApplDLXLR7KDFLMQ,ApplDLXLX75YFCM5,ApplDLXM60L4FCM8,ApplDLXMC254FCM5,ApplDLXMC3FNFCM5,ApplDLXMF1M2F4YG,ApplDLXMK261FCM5,ApplDLXML0VGFCM5,ApplDLXML1QLFCM5,ApplDLXMT3VWFCM5,ApplDLXMV0M8FCM5,ApplDLXNL8NTG5V2,ApplDLXP5182G5YL,ApplDLXPF514G5YL,ApplDLXPG2S2G5YL,ApplDLXQ15Q7G5V5,ApplDLXQ407HG5V1,ApplDLXQT6TCGMLM,ApplDLXRM18CGMLD,ApplDMPGTZ6XDKPH,ApplDMPH104BDFJ2,ApplDMPHM7GDDVGJ,ApplDMPHM7MADVGJ,ApplDMPHM7THDVGJ,ApplDMPJ37VUDVGJ,ApplDMPJ387NDVGJ,ApplDMPJ409CDVGL,ApplDMPJ5FLNDJ8T,ApplDMPJ6BD1DJ8R,ApplDMPJ8967DJ8R,ApplDMPJ8ANVDJ8R,ApplDMPJP6SRF183,ApplDMPJPC4JF188,ApplDMPJTGJ9F183,ApplDMPJTGMCF183,ApplDMPKD63NF18P,ApplDMPKD86QF18P,ApplDMPL90AVFK10,ApplDMPLC1P2FK10,ApplDMPLV4TAF4YJ,ApplDMPM2DXVF4YD,ApplDMPM33QHF4YD,ApplDMPM6473F4YG,ApplDMPM8XM3FK10,ApplDMPMM98BF4YG,ApplDMPN2V8EFK11,ApplDMPN81RCF4YK,ApplDMPNK21DF4YG,ApplDMPNL2N4F4YF,ApplDMPNLNTQG5VJ,ApplDMPNLS7FFP84,ApplDMPNMAE3G5YL,ApplDMPNN8EHG5YL,ApplDMPP50EWG5YL,ApplDMPP713FG5YL,ApplDMPPF0DXG5YM,ApplDMPPF6RAG5YL,ApplDMPRC2G5GXQ0,ApplDMPT9A27H1MJ,ApplDMQGDUP2DFHW,ApplDMQGK6MHDFHW,ApplDMQGLT6NDFHW,ApplDMQHMH8KDJ8T,ApplDMQJT0Z3F183,ApplDMRGPHFMDFHW,ApplDMRH1XV8DFHW,ApplDMRK9D9DF182,ApplDMRLP582FK11,ApplDMRNR3L1G5W0,ApplDMTGVBB7DFHW,ApplDMTLRA3GFK10,ApplDN6FN9NLDKPH,ApplDN6FT68XDFJ3,ApplDN6FWPEJDFHY,ApplDN6G2DMNDFHY,ApplDN6G8V3JDFHY,ApplDN6GCR0TDFJ3,ApplDN6GH21QDKPJ,ApplDN6GHH5BDFHY,ApplDN6GQQ96DFJ1,ApplDN6GQTUJDFJ1,ApplDN6GWL5DDFJ2,ApplDN6GX0D3DFJ2,ApplDN6H2JUKDFJ3,ApplDN6H605DDVD2,ApplDN6HRDQADKPH,ApplDNPGNHFGDTDF,ApplDNPJ2JUHDTC1,ApplDNPK3HZCDTTQ,ApplDNPLKCVZFFFK,ApplDNPLWKM4FFDP,ApplDNPN9ET1G5MC,ApplDNPN9MG0G5MC,ApplDNPNGPC2G5MC,ApplDNPNT54YG5MK,ApplDNPNXXYDG5MG,ApplDNPQP2FNGRYC,ApplDNQGLFF5DTD2,ApplDNQJLWHKDTTQ,ApplDNQJTDNUDTTN,ApplDNQNQFVEG5MN,ApplDNQSKGKSHG75,ApplDNRHL91YDTD2,ApplDNTHFZ9CDTC0,ApplDNVJQ5YFDTTN,ApplDQGLPFG5DTWD,ApplDQGML59GDTWD,ApplDQTFK389DKNY,ApplDQTFMCCBDFHW,ApplDQTFMG2RDFHW,ApplDQTFMG2UDFHW,ApplDQTFMG44DFHW,ApplDQTFMHF4DFHW,ApplDQTG8PS1DKPH,ApplDQTGV4ZNDKPH,ApplDQTK2ZA9F196,ApplDQTL1BQKF196,ApplDQTLXBB7FCM5,ApplDQTM390WFCM5,ApplDQVFJ2QPDFHW,ApplDQVGCNX9DKPH,ApplDQVLR54TFK14,ApplDR5HDHTRDFJ1,ApplDR5JP5BEDJHF,ApplDV6N6035F4YF,ApplDX4S4JWPFFG8,ApplDX5L3BA6DP0N,ApplDX5NLDUEFRC6,ApplDYTJ49ACDJ8V,ApplDYTJ7UNDDVD1,ApplDYTJ82K5DJ8V,ApplDYTJJDU3DFHW,ApplDYTMD53MDKPH,ApplDYVHL0T5DVD2,ApplDYVHREU4DVD2,ApplDYVJ3JUZDJ8T,ApplDYVJJEW7DFHW,ApplDYVJJJVCDFHW,ApplDYVJJJVNDFHW,ApplF17JQG53DTWF,ApplF17JX825F8H5,ApplF17LD3CKFNJJ,ApplF17LKB0TFNNK,ApplF17LN2FNFFGK,ApplF17LX9DAFR9D,ApplF17LXEKEFR97,ApplF17SG3ETHG7K,ApplF18K8EC0F8H2,ApplF18L9MAKDTWD,ApplF18LRP1JFFG9,ApplF18R60V8H2XW,ApplF19PJVJXG5MQ,ApplF2LJD0HVF8H5,ApplF2LJQQN9DTWG,ApplF2LKQKYEDTWF,ApplF2LKWV6XDTWD,ApplF2LL4XY4DTWF,ApplF2LN9425G5R1,ApplF2LNMCT5G5QL,ApplF2LQLB2DGRWV,ApplF2MJWA92DTWF,ApplF2MM20EBFFDR,ApplF2NKPQ78DTWD,ApplF2NL3FD1DTWD,ApplF2NLQA07FFG8,ApplF4GJKJL6F194,ApplF4GQ9N66GRY9,ApplF4KJQ1YDF197,ApplF4KJR86QF195,ApplF4KKJHY0F193,ApplF4KKQ0PYF19M,ApplF4KLV10PFCMC,ApplF4KM4A3JFCM5,ApplF4KM4GETFCM5,ApplF4KM71V8FCM5,ApplF4KM72VBFCM5,ApplF4KM8209FCM5,ApplF4KM856MFCM5,ApplF4KM90AGFCM5,ApplF4KM90B2FCM5,ApplF4KM92AWFCM5,ApplF4KM92PAFCM5,ApplF4KM94LHFCM5,ApplF4KM94Y3FLMK,ApplF4KMFQ9XFCM5,ApplF4KMR1DSFLMR,ApplF4KMT13LFTVD,ApplF4KMTZBSFCM8,ApplF4KN12DJFCM6,ApplF4LK3CCBF197,ApplF4LMT15TFCM8,ApplF4MK61CTF193,ApplF4NL4MYZF193,ApplF5RKDAGYDKPH,ApplF5XKGDUHDFHW,ApplF78M764TFFHM,ApplF7NMKU50F196,ApplF7PLXFBGFP84,ApplF7PMH6G0F196,ApplF7PMJAVDF196,ApplF7QLXZWSFP84,ApplF7RM240GFP84,ApplF85L9YFZF196,ApplF86LF8MSF196,ApplF9GNGWNDFP84,ApplFFMNK0UPFYWC,ApplFFNS628RGRY9,ApplFK1NC2CLG5QQ,ApplFK1QGA0MGRY7,ApplFK2NNHVDG5QY,ApplFK3QRFXVGRY9,ApplFK4QH3ZAGRY5,ApplJF138TKMDZZ,ApplV5018NBBZ38,ApplV50260BAZ39,ApplV5035210ETV,ApplV5043E70ETV,ApplW893720J64C,WIFIMAC0008CA3871AE,WIFIMAC28EF01316682,WIFIMAC3085A9F80B5F,WIFIMAC6021C0293935,WIFIMACBC20A472283C,WIFIMACBC20A4722D7E,WIFIMACBC20A4723026,a85b78195de9,androidc1263901642,androidc162928075,e066787ead2b,zh2zj,zh5pd,zh6mc,zh90p,zhb8c,zhn1q,zhn7s,zhpxp,zhqsr,zhr6m,zhrdj,zhrhh,zhs3r,zhs7y,zhs91,zht2k,zht55,zht5h,zht5n,zhtcd,zhty5,zhtzx,zhv6b,zhv6c,zhv9z,zhvcj,zhvcl,zhwhs,zhwht,zhy29,zhy2d,zhy6j,zhz44,zj33k,zj4ps,zj8cp,zj8rg,zj8s2,zj9tx,zjb06,zjb2w,zjch9,zjcxq,zjd0b,zjfct,zjfnl,zjfr5,zjg92,zjgjy,zjgrg,zjjhc,zjjqm,zjm9c,zjr3z,zjw8t,zjzwx,zk7px,zk8g6,zk8y7,zk8yp,zkg2d,zl37m,zl6cd,zl6gf,zl7z0,zly4z,zlztx,zmrt5,zplmc,zq5f1,zq8nc,zq959,zq95n,zqgkx,zqjcb,zqm1k,zqmkp,zqmx0,zqpbt,zqpc0,zqqtg,zspsp,zsqj2,zsrx2,zsryf,zt4dn,ztf29,ztkmp,ztnvq,ztyyf,zv19d,zv2n7,zvgm4,zvk0l,zvlgd,zvwdy,zvxg9,zw139,zw3x2,zw6gd,zw7c8,zwk11,zxq0m";
		String commas1="08tv,09g6,1668562484,230w,24240eaf45c6,29gt,2lyc,3412982ae8fd,4by6,4ckh,4kbg,4kht,4khv,4m45,4ymr,508p,5b7x,5kpp,5mjt,5qjx,5ydm,5zmm,61yw,6554,6557,6cc7,7php,7rjf,7sx7,7z8d,7z8q,80006e45ee94,868c,868d,8bx3,8c7h,8hhr,8jg7,8kdt,98fe94adfd9b,Android0250F20000050000,Android1052d53ac0ee356a,Android125efe53a084981f,Android129dc8626ba38b16,Android139bb6ab06307499,Android1456bfdb6fad6b72,Android14ea63167f1aa59,Android151ffba3c3a45e7f,Android16224c36cd82589e,Android1950b677b8c8e048,Android1a85a54723d086f6,Android1ae457dcc8e67446,Android1b0f126b0f0e3e25,Android1c8ee6bbbea0782,Android1ca8271afc06b3b6,Android1d115ecad6d15cf,Android1d1263f431ca50ad,Android1e103b0a4330df70,Android1eee1215db25e63e,Android1f3b4617223f442a,Android1fe66299677b4655,Android214bfddba01120ac,Android21a7844851cf1ad6,Android22950cf390d36218,Android22e88f68bc976e6,Android24d9c669d618448e,Android24f9a3a8bf79d92b,Android25a051c217de7a4f,Android261c31ad64003eb2,Android27039868,Android27e4d0aeafe99236,Android28bda110896a5fe5,Android29882046b4ab1916,Android2af902e14d665d58,Android2c4de2801ff1ea6,Android2e96725e45826c9e,Android2ea89cd57e91decc,Android2ec8a0c541a2b674,Android30c120f5bdc60efb,Android30e29415dcd2ccf4,Android314fd7a186a46ec7,Android33a222c861f8fec6,Android354043047664273,Android356525042836045,Android357232046478168,Android35a63121e9d22e52,Android394cb893e97b6ba2,Android39a9bc06105815a4,Android3C970EAC2AF50000,Android3a5305cecca1404d,Android3aab372df83dffd4,Android3b420c671733c835,Android3b8480b05884690e,Android3bb20b24f6157e59,Android3bbb9c680cba9128,Android3bfdb975349c307f,Android3ea0d52d231d5e5d,Android3f3bb46e0b34aa26,Android3f9fb169d0f9afd0,Android40250F2000005000,Android40490018f2bf17b1,Android414e62c5e85bcb33,Android419bd9d813f9b9ac,Android422d2cf938d15ed8,Android4240fe75c40227f5,Android4429c79ed94562a9,Android443359ec4d661e95,Android44986bae0de30501,Android449ae5e99326cd3a,Android44f3e1ebc46b9082,Android4563f88fc46ad875,Android45c68aa4c8333df,Android488f543a454b3e02,Android49d39b5fd5076a0a,Android4ad27d5add5d7cd9,Android4ae3031cf78175c8,Android4b2604f60b45b748,Android4b39af7d3749600b,Android4cef00dc0750e75e,Android4d2089a54056d7c5,Android4e201c05eb267610,Android4f83d15e7c48b04b,Android50aebc9bd4a73ee1,Android5268c6a750732c37,Android53d49b94844465e9,Android5443d644a5da0e7a,Android552f6eab4dc32a0b,Android556d9164d232a214,Android55c0b2c56214b759,Android55e03cd8115f24da,Android55efdada3490ded,Android5617c8dabf0fb9fa,Android56666b69afe6b3ef,Android574a5ad10506ea5,Android5878cbb6c4d70881,Android590669b3104ee93d,Android59273407ab67ab6d,Android597f385be63a2dbc,Android5b2280ee33d3e3e8,Android5c3a24aa70b3b078,Android5cf800479985e8c6,Android5d27eb7bec15fd32,Android5d2b61b127a6399,Android60ad330a61ee6f13,Android61a82fa49bf1f5f0,Android6273a6884d6cf605,Android63624583d1cb9d48,Android65370458f80f26,Android670114a48e1b7671,Android672b0c450deb2fdc,Android6ac0ddfc7c03536c,Android6c222030c7168347,Android6c275c4d70be8485,Android6e76be155167e4a6,Android6f0ebc366fea84f1,Android732c73bff6dcf7fd,Android73d19e5316d9485b,Android743b7ae37e128b8d,Android76eda10c60d7026f,Android77cbefadff105dee,Android783b5f73a2446430,Android7adc024acf4d0dda,Android7c20c3077a86a05,Android7c66ef2b097116d0,Android7cf1fd3309c6e912,Android7db822f2111f6e68,Android7dbde891416919cc,Android7dc7f22fa984be91,Android7eb6870c23b4bde3,Android81670595195f0e74,Android81ae221552f502e2,Android83e1e7ff55b47880,Android845a0fef31d90857,Android84fff58f26ca288f,Android851f816772f0ff77,Android86c81ffe1660ef5b,Android87572d5977f2bddc,Android883259c3c7ccb1d3,Android88655bbe802c3f4,Android8b8ce735bf98485f,Android8faa0ce4f5a6d40e,Android8fb50fbbbdd8bcd7,Android9030f45e2eda96ca,Android9141923d55b3814b,Android932724d2712a7f5c,Android93f8661402661275,Android940c0cc85401cbd1,Android954bf8be48839c8d,Android95cedae8a434b6cc,Android95e6436613c79af7,Android968cee6dab0118ae,Android9708b2156293caa9,Android97c276b7d75f3616,Android9922879d6a48173,Android9a596007ecb88af6,Android9af8472cf00d4a13,Android9bff1c4e02868031,Android9c382d10867daa3d,Android9ce1bb1a6968785b,Android9fbc0ca4f2d2a5a4,Android9fc16520a974665d,Androida02a1b8be5cae24d,Androida1fc49b20251e5e9,Androida240629e8f0bee61,Androida2f6ad1a8d5e8849,Androida35f4bf1d40ba5b3,Androida467e214225c8876,Androida5e922dcf695b3f1,Androida636afbb1d18eac1,Androida66eb597adae5cdb,Androida6a462c7ba7427cf,Androida6a697f6be952915,Androida704ade0fa41b4b0,Androida7e7d1e96a19ad4,Androida7ee20a9d36c8774,Androida886d9a19d1ee802,Androida9b7b4af8f138f97,Androidab3d377fa4edeb59,Androidac9fb22a3284168c,Androidacb48f7006315cb6,Androidad99797b793017a3,Androidadaa876e6f6269a8,Androidadab7f56f43b4a14,Androidadc5275576699154,Androidae5ae1e502a980b3,Androidaf66ee7bde3f7f73,Androidb0f1b0d49ffdf723,Androidb10dd207e8989b2e,Androidb397d2a65fd6a1d6,Androidb46c27114ad11d89,Androidb57f44905f699c86,Androidb6a134bffad3403e,Androidb6d83c2e4840ce3a,Androidb782bdb9475dd6e8,Androidb7e892e203254032,Androidb9707b6e121a038b,Androidba15d9b1f7e5e72,Androidbc706b400e675bac,Androidbd30abb1775a9cfe,Androidbe1104cecfd22955,Androidbe348cef57833769,Androidbedc22bdeeb95228,Androidbeea2fd07a3f2281,Androidc0ecb44e3687df4c,Androidc19fa493d5d4dba2,Androidc56848b34ef35856,Androidc5743444408487f3,Androidc5df7b4485c84ff3,Androidc7d70b6be488d5ae,Androidc7e9bff2695d01ba,Androidc84e407882a15921,Androidc99e19358f3d31c0,Androidca7ddfd9aba1dcf3,Androidcb1a3cc5ded10eb2,Androidcbe4efea6308f8b9,Androidcc9caae45599fc76,Androidcd0886c46964332d,Androidcd0a1a1defd6fc8,Androidcd3cf666f1b17486,Androidcdad5fb42634256e,Androidcdbfc35d844b4793,Androidce789575a229801e,Androidcfdea1473d43a3e4,Androidcfdf44e035c03fdf,Androidcfe817161b6d8aff,Androidd02490e6d1bad58b,Androidd13c1483c26376b2,Androidd1e1b5732cc1bc5d,Androidd34e9fd53767033b,Androidd4ee0065790ea9df,Androidd5400138c8fe33f4,Androidd551610a4831a3df,Androidd583615802e8b043,Androidd5cfa5b2b54c659d,Androiddb8e1eb06040e97c,Androiddbb19cb1fde2cd2b,Androiddc90a82149e91e59,Androiddd344ebe302c4bfb,Androiddd9bc86755e17ece,Androidddd4d80518030841,Androidde004b8f884e451e,Androide164ec5f46716cf,Androide198eecc6f5457fa,Androide1bc33a72abc1d1,Androide48eb6d45507e657,Androide5842f03682fa6ae,Androide7b69604b2236276,Androide7c062a04c4a5eef,Androide9158d81e38b32ba,Androide9ad3ea172858411,Androidea347200b24ddc7f,Androideb6c6f59041dd71e,Androided565092a5a4ce76,Androidee6df15079356ab7,Androidefb9abef8bf3df7f,Androidf0242da881a5030e,Androidf04e1d3eefd5d8aa,Androidf07d7401bb6e7286,Androidf1a0a88e7c6fefee,Androidf1ff145b56f31356,Androidf21bf62c66affe5a,Androidf24d7e8b8df5fff4,Androidf2f7669f1ba28c57,Androidf3b5a26c6d0bf803,Androidf4d976f4a720a01d,Androidf659e7f6c1b0c2aa,Androidf78f832d6d9d4350,Androidf7ced92f19abe408,Androidf87ac1485fae07c2,Androidf8e4a0f2460c989b,Androidf9c4881b2e324f6c,Androidf9f3a62aec8605d6,Androidf9f521394a8a5ee1,Androidfaf27462987d64cd,Androidfbb576c0c404a6a1,Androidfc65895414ddf1ca,Androidfcbf5c5b5873fb92,Androidfd4dc526b55ec9d8,Androidfd6914ebd082c72e,Androidfea7820c027ef11e,Androidfeb3b2df39be0a8f,Androidfec69d8901819d7f,Androidfed12164defbe67e,Androidnull,Appl5K4030B8A4S,Appl65105TVQA4S,Appl7Q110SB1A4S,Appl7W0420B6A4S,Appl80017PY93NP,Appl84943PBC3NP,Appl851387N8DZZ,Appl859454SP3NR,Appl861286SJA4T,Appl86921182Y7H,Appl87851QLCY7H,Appl881337JWA4S,Appl9C022P4F6K2,ApplC02FN0TQDH2M,ApplC02LMB01FD57,ApplC02LP02HFLCF,ApplC02LT16ZFH05,ApplC17Q35QBG940,ApplC28HF3WKDT9Y,ApplC28HW4ADDTC1,ApplC31NGFRHG5MQ,ApplC34JR72UDTWD,ApplC35GPU23DTD2,ApplC35JKY8RDTWF,ApplC36JX46VDTWD,ApplC36LP1GXFRC6,ApplC38GMT3ADTD2,ApplC38P60R4G5MR,ApplC39GLQHNDTDM,ApplC39JPFDEDTWG,ApplC39KVE4MDTWD,ApplC39LLDVCFRC5,ApplC39LN6TKFRC7,ApplC39LNTXJFFG8,ApplC39LQSASFRC8,ApplC39LTG8HFRC6,ApplC39LV4LEFRCF,ApplC39M51XJFF9R,ApplC39NP116G5MN,ApplC39QM41RGRWT,ApplC3RGH7BXDT77,ApplC78JK47TDP0V,ApplC79P23QEG5MG,ApplC7GJV06TF8GL,ApplC7JNKDALG5N0,ApplC7JP4LE3G5MV,ApplC8VF9RA3DDP7,ApplCCQKN7AZF4JW,ApplDKVJC07UDKNY,ApplDKVL60FQF191,ApplDLXFL3YHDFJ3,ApplDLXFLLUXDFJ1,ApplDLXFN3B3DFHY,ApplDLXG7ARNDFHY,ApplDLXGG2Z3DFHY,ApplDLXGGGJVDFJ2,ApplDLXGHF4NDFJ2,ApplDLXGVAXVDFHY,ApplDLXGW1GZDKPH,ApplDLXJKM6ZF183,ApplDLXJL713F184,ApplDLXJRBPRF19P,ApplDLXJT1A2FLML,ApplDLXJV2WJF191,ApplDLXJV9N2F19K,ApplDLXKL7FKF185,ApplDLXKQ5EUF182,ApplDLXKW4ZBF182,ApplDLXLQ0MGFLMM,ApplDLXLQ217F4YG,ApplDLXLR2FVFLMK,ApplDLXLR7KDFLMQ,ApplDLXLX75YFCM5,ApplDLXM60L4FCM8,ApplDLXMC254FCM5,ApplDLXMC3FNFCM5,ApplDLXMF1M2F4YG,ApplDLXMK261FCM5,ApplDLXML0VGFCM5,ApplDLXML1QLFCM5,ApplDLXMT3VWFCM5,ApplDLXMV0M8FCM5,ApplDLXNL8NTG5V2,ApplDLXP5182G5YL,ApplDLXPF514G5YL,ApplDLXPG2S2G5YL,ApplDLXQ15Q7G5V5,ApplDLXQ407HG5V1,ApplDLXQT6TCGMLM,ApplDLXRM18CGMLD,ApplDMPGTZ6XDKPH,ApplDMPH104BDFJ2,ApplDMPHM7GDDVGJ,ApplDMPHM7MADVGJ,ApplDMPHM7THDVGJ,ApplDMPJ37VUDVGJ,ApplDMPJ387NDVGJ,ApplDMPJ409CDVGL,ApplDMPJ5FLNDJ8T,ApplDMPJ6BD1DJ8R,ApplDMPJ8967DJ8R,ApplDMPJ8ANVDJ8R,ApplDMPJP6SRF183,ApplDMPJPC4JF188,ApplDMPJTGJ9F183,ApplDMPJTGMCF183,ApplDMPKD63NF18P,ApplDMPKD86QF18P,ApplDMPL90AVFK10,ApplDMPLC1P2FK10,ApplDMPLV4TAF4YJ,ApplDMPM2DXVF4YD,ApplDMPM33QHF4YD,ApplDMPM6473F4YG,ApplDMPM8XM3FK10,ApplDMPMM98BF4YG,ApplDMPN2V8EFK11,ApplDMPN81RCF4YK,ApplDMPNK21DF4YG,ApplDMPNL2N4F4YF,ApplDMPNLNTQG5VJ,ApplDMPNLS7FFP84,ApplDMPNMAE3G5YL,ApplDMPNN8EHG5YL,ApplDMPP50EWG5YL,ApplDMPP713FG5YL,ApplDMPPF0DXG5YM,ApplDMPPF6RAG5YL,ApplDMPRC2G5GXQ0,ApplDMPT9A27H1MJ,ApplDMQGDUP2DFHW,ApplDMQGK6MHDFHW,ApplDMQGLT6NDFHW,ApplDMQHMH8KDJ8T,ApplDMQJT0Z3F183,ApplDMRGPHFMDFHW,ApplDMRH1XV8DFHW,ApplDMRK9D9DF182,ApplDMRLP582FK11,ApplDMRNR3L1G5W0,ApplDMTGVBB7DFHW,ApplDMTLRA3GFK10,ApplDN6FN9NLDKPH,ApplDN6FT68XDFJ3,ApplDN6FWPEJDFHY,ApplDN6G2DMNDFHY,ApplDN6G8V3JDFHY,ApplDN6GCR0TDFJ3,ApplDN6GH21QDKPJ,ApplDN6GHH5BDFHY,ApplDN6GQQ96DFJ1,ApplDN6GQTUJDFJ1,ApplDN6GWL5DDFJ2,ApplDN6GX0D3DFJ2,ApplDN6H2JUKDFJ3,ApplDN6H605DDVD2,ApplDN6HRDQADKPH,ApplDNPGNHFGDTDF,ApplDNPJ2JUHDTC1,ApplDNPK3HZCDTTQ,ApplDNPLKCVZFFFK,ApplDNPLWKM4FFDP,ApplDNPN9ET1G5MC,ApplDNPN9MG0G5MC,ApplDNPNGPC2G5MC,ApplDNPNT54YG5MK,ApplDNPNXXYDG5MG,ApplDNPQP2FNGRYC,ApplDNQGLFF5DTD2,ApplDNQJLWHKDTTQ,ApplDNQJTDNUDTTN,ApplDNQNQFVEG5MN,ApplDNQSKGKSHG75,ApplDNRHL91YDTD2,ApplDNTHFZ9CDTC0,ApplDNVJQ5YFDTTN,ApplDQGLPFG5DTWD,ApplDQGML59GDTWD,ApplDQTFK389DKNY,ApplDQTFMCCBDFHW,ApplDQTFMG2RDFHW,ApplDQTFMG2UDFHW,ApplDQTFMG44DFHW,ApplDQTFMHF4DFHW,ApplDQTG8PS1DKPH,ApplDQTGV4ZNDKPH,ApplDQTK2ZA9F196,ApplDQTL1BQKF196,ApplDQTLXBB7FCM5,ApplDQTM390WFCM5,ApplDQVFJ2QPDFHW,ApplDQVGCNX9DKPH,ApplDQVLR54TFK14,ApplDR5HDHTRDFJ1,ApplDR5JP5BEDJHF,ApplDV6N6035F4YF,ApplDX4S4JWPFFG8,ApplDX5L3BA6DP0N,ApplDX5NLDUEFRC6,ApplDYTJ49ACDJ8V,ApplDYTJ7UNDDVD1,ApplDYTJ82K5DJ8V,ApplDYTJJDU3DFHW,ApplDYTMD53MDKPH,ApplDYVHL0T5DVD2,ApplDYVHREU4DVD2,ApplDYVJ3JUZDJ8T,ApplDYVJJEW7DFHW,ApplDYVJJJVCDFHW,ApplDYVJJJVNDFHW,ApplF17JQG53DTWF,ApplF17JX825F8H5,ApplF17LD3CKFNJJ,ApplF17LKB0TFNNK,ApplF17LN2FNFFGK,ApplF17LX9DAFR9D,ApplF17LXEKEFR97,ApplF17SG3ETHG7K,ApplF18K8EC0F8H2,ApplF18L9MAKDTWD,ApplF18LRP1JFFG9,ApplF18R60V8H2XW,ApplF19PJVJXG5MQ,ApplF2LJD0HVF8H5,ApplF2LJQQN9DTWG,ApplF2LKQKYEDTWF,ApplF2LKWV6XDTWD,ApplF2LL4XY4DTWF,ApplF2LN9425G5R1,ApplF2LNMCT5G5QL,ApplF2LQLB2DGRWV,ApplF2MJWA92DTWF,ApplF2MM20EBFFDR,ApplF2NKPQ78DTWD,ApplF2NL3FD1DTWD,ApplF2NLQA07FFG8,ApplF4GJKJL6F194,ApplF4GQ9N66GRY9,ApplF4KJQ1YDF197,ApplF4KJR86QF195,ApplF4KKJHY0F193,ApplF4KKQ0PYF19M,ApplF4KLV10PFCMC,ApplF4KM4A3JFCM5,ApplF4KM4GETFCM5,ApplF4KM71V8FCM5,ApplF4KM72VBFCM5,ApplF4KM8209FCM5,ApplF4KM856MFCM5,ApplF4KM90AGFCM5,ApplF4KM90B2FCM5,ApplF4KM92AWFCM5,ApplF4KM92PAFCM5,ApplF4KM94LHFCM5,ApplF4KM94Y3FLMK,ApplF4KMFQ9XFCM5,ApplF4KMR1DSFLMR,ApplF4KMT13LFTVD,ApplF4KMTZBSFCM8,ApplF4KN12DJFCM6,ApplF4LK3CCBF197,ApplF4LMT15TFCM8,ApplF4MK61CTF193,ApplF4NL4MYZF193,ApplF5RKDAGYDKPH,ApplF5XKGDUHDFHW,ApplF78M764TFFHM,ApplF7NMKU50F196,ApplF7PLXFBGFP84,ApplF7PMH6G0F196,ApplF7PMJAVDF196,ApplF7QLXZWSFP84,ApplF7RM240GFP84,ApplF85L9YFZF196,ApplF86LF8MSF196,ApplF9GNGWNDFP84,ApplFFMNK0UPFYWC,ApplFFNS628RGRY9,ApplFK1NC2CLG5QQ,ApplFK1QGA0MGRY7,ApplFK2NNHVDG5QY,ApplFK3QRFXVGRY9,ApplFK4QH3ZAGRY5,ApplJF138TKMDZZ,ApplV5018NBBZ38,ApplV50260BAZ39,ApplV5035210ETV,ApplV5043E70ETV,ApplW893720J64C,WIFIMAC0008CA3871AE,WIFIMAC28EF01316682,WIFIMAC3085A9F80B5F,WIFIMAC6021C0293935,WIFIMACBC20A472283C,WIFIMACBC20A4722D7E,WIFIMACBC20A4723026,a85b78195de9,androidc1263901642,androidc162928075,e066787ead2b,zh2zj,zh5pd,zh6mc,zh90p,zhb8c,zhn1q,zhn7s,zhpxp,zhqsr,zhr6m,zhrdj,zhrhh,zhs3r,zhs7y,zhs91,zht2k,zht55,zht5h,zht5n,zhtcd,zhty5,zhtzx,zhv6b,zhv6c,zhv9z,zhvcj,zhvcl,zhwhs,zhwht,zhy29,zhy2d,zhy6j,zhz44,zj33k,zj4ps,zj8cp,zj8rg,zj8s2,zj9tx,zjb06,zjb2w,zjch9,zjcxq,zjd0b,zjfct,zjfnl,zjfr5,zjg92,zjgjy,zjgrg,zjjhc,zjjqm,zjm9c,zjr3z,zjw8t,zjzwx,zk7px,zk8g6,zk8y7,zk8yp,zkg2d,zl37m,zl6cd,zl6gf,zl7z0,zly4z,zlztx,zmrt5,zplmc,zq5f1,zq8nc,zq959,zq95n,zqgkx,zqjcb,zqm1k,zqmkp,zqmx0,zqpbt,zqpc0,zqqtg,zspsp,zsqj2,zsrx2,zsryf,zt4dn,ztf29,ztkmp,ztnvq,ztyyf,zv19d,zv2n7,zvgm4,zvk0l,zvlgd,zvwdy,zvxg9,zw139,zw3x2,zw6gd,zw7c8,zwk11,zxq0m";
		System.out.println(commas.split(",").length);
		System.out.println(commas1.split(",").length);
		
		SavedSearch ss= new SavedSearch("one");
		SavedSearch ss1= null;
		System.out.println(ss);
		System.out.println(ss.toString());
		System.out.println(ss1);
//		System.out.println(ss1.toString());
		
		
		for(int i=0;i<10;i++) {
			try {
				if(i==4)
					throw new Exception();
				if(i>4)
					continue;
				System.out.println("try :"+i);
			}catch (Exception e) {
				System.out.println("catch :"+i);
			}finally {
				System.out.println("finally :"+i);	
			}
		}
		
		List<String> ll=new ArrayList<>();
		ll.add("a");
		ll.add("b");
		ll.add("c");
		
		Iterator<String> itr=ll.listIterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		for(int i=0;i<5;i++) {
			try {
				if(i>2)
					break;
				System.out.println("i:"+i);
			}finally {
				System.out.println("finally i:"+i);
			}
		}
		
		
		Test test=new Test();
		test.setName("mohsin");
		test.setAddress("IBM");
		test.setBloodType("O+");
		
		ITest itest=test;
		System.out.println(test.getAddress()+"|"+test.getBloodType()+"|"+test.getName());
		//System.out.println(itest.getAddress()+"|"+itest.getBloodType()+"|"+itest.getName());
		String mStr="ABCD:MOHSIN";
		String sStr="ABCD";
		System.out.println(Arrays.toString(mStr.split(":")));
		System.out.println(Arrays.toString(sStr.split(":")));
		
		String validJsonString = "{\"mailboxId\":\"mohsin\",\"mailboxId1\":\"mohsin1\"}";

		// Invalid String with a missing parenthesis at the beginning.
		String invalidJsonString ="junk";
				//"\"developers\": [ \"firstName\":\"Linus\" , \"lastName\":\"Torvalds\" }, " +
		        //"{ \"firstName\":\"John\" , \"lastName\":\"von Neumann\" } ]}";

		System.out.println(isJSONValid(validJsonString)); //true);
		System.out.println(isJSONValid(invalidJsonString)); //false
		
		for(int k=0;k<20;k++) {
			System.out.println(((1+k)%5));
		}
		
		System.out.println(new Timestamp(0));
		
		XStream stream=new XStream();
		stream.processAnnotations(EmailNotificationSettings.class);
		stream.processAnnotations(MultipleEmailNotificationSettings.class);
		
		
		String unsub="<?xml version=\"1.0\" standalone=\"yes\"?>"+                                   
		"<EmailNotificationSettings>            "+                        
		"    <updateType>Full</updateType>"+ 
		 "   <mailBoxesInThisMessage>2</mailBoxesInThisMessage>"+ 
		  "  <EmailNotificationSetting>         "+ 
		   "     <mailboxId>mdmxxsece0667804058b2K1</mailboxId>"+          
		    "    <data>554e5355 42534352 494245</data>         "+ 
		     "   <dataSize>11</dataSize>         "+ 
		    "</EmailNotificationSetting>"+ 
		    "<EmailNotificationSetting>    "+      
		     "   <mailboxId>mdmxxe0667804058b</mailboxId>"+          
		        "<data>554e5355 42534352 494245</data>    "+      
		        "<dataSize>11</dataSize>         "+ 
		    "</EmailNotificationSetting>"+ 
		"</EmailNotificationSettings>";
		//System.out.println(Base64.getDecoder().decode("554e5355 42534352 494245"));
		//System.out.println(Base64.getDecoder().decode("<554e5355 42534352 494245>"));
		System.out.println(Base64.getEncoder().encodeToString("UNSUBSCRIBE".getBytes()));
		MultipleEmailNotificationSettings emailNotificationSettings=(MultipleEmailNotificationSettings) stream.fromXML(unsub);
		//List<EmailNotificationSettings> emailNotificationSettings=(List<EmailNotificationSettings>) stream.fromXML(unsub,EmailNotificationSettings.class);
		System.out.println(emailNotificationSettings);
		
		/*try {
			//System.out.println(Base64.getDecoder().decode(new String(emailNotificationSettings.getEmailSettingsList().get(0).getData(), "UTF-8")));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		List<String> emailList=new ArrayList<>();
		emailList.add(null);
		System.out.println(emailList);
		System.out.println(emailList);
		Map<String, Object> mailBoxDatap=new HashMap<>();
		Map<String, Object> mailBoxData=new HashMap<>();
		mailBoxData.put("A", "mohsin");
		mailBoxDatap.put("B", mailBoxData.get("A")+"B");
		String mohsin=mailBoxDatap.get("B")+"";
		System.out.println(mohsin);
		
		switch("") {
		case"A": System.out.println("A");break;
		default : System.out.println("default");
		}
		
		String message="UPPRCS-0005-abcdeUPPRCS-0003-abcUPPRCS-0004-abcd";
		parse(message);
		
		Map<RevokeActionEnum,String> enumMap=new HashMap<>();
		enumMap.put(RevokeActionEnum.ADMIN_REMOVE_CONTROL_BIT_VALUE, "Day");
		System.out.println(enumMap.get(RevokeActionEnum.ADMIN_REMOVE_CONTROL_BIT_VALUE));
		
		for(RevokeActionEnum vvv:RevokeActionEnum.values()) {
			System.out.println(vvv+"|"+vvv.value);
		}
	}
	public static void parse(String msg) {
		while(StringUtils.isNotEmpty(msg)) {
			Integer len=Integer.valueOf(msg.substring(7, 11))+12;
			String temp=msg.substring(0, len);
			System.out.println(temp);
			msg=msg.substring(len);
		}
	}
	public static Map<String,String> moduleMap=new HashMap<>();
	{
		moduleMap.put("1 0", "SELECTIVE_WIPE_BIT_VALUE");
	}
	public enum RevokeActionEnum {
	    SELECTIVE_WIPE_BIT_VALUE("1 0"),
	    WIPE_BIT_VALUE("1 1"),
	    ADMIN_REMOVE_CONTROL_BIT_VALUE("2 0"),
	    USER_REMOVE_CONTROL_BIT_VALUE("2 1"),
	    INACTIVE_DEVICES_BIT_VALUE("2 2");
		
		public String value;
		private RevokeActionEnum(String value){
			this.value=value;
		}
	}
	

	
	private static final Gson gson = new Gson();
	public static String isJSONValid(String jsonInString) {/*
	      try {
	          gson.fromJson(jsonInString, Object.class);
	          return true;
	      } catch(com.google.gson.JsonSyntaxException ex) { 
	          return false;
	      }
	  */

		try {
			JsonObject object  = gson.fromJson(jsonInString, JsonObject.class);
			return object.get("mailboxId").getAsString();
		}catch (ClassCastException e) {
			System.out.println("class:"+e);
			return null;
		}catch (Exception e) {
        	//logger.warn("Exception while parsing json String:{} for the key:{}",jsonString,key,e);
			System.out.println(e);
        	return null;
        }
	
	
	}
}
