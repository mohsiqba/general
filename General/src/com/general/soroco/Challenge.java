package com.general.soroco;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Challenge { 
    /*
     * Complete the functions below. You may declare more variables for this class.
     * Please do NOT rename this class.
     */

	/**
	 * @author MohsinIqbal
	 * This is Block class which stores references of each duplicate chunks identified by @param blockNum
	 * i.e for each unique block it stores all further relative positions of its duplicates.
	 *
	 */
	static class Block{
		Integer blockNum;
		List<Integer> ref;
		
		public Block(Integer blobkNum) {
			this.blockNum=blobkNum;
			this.ref=new ArrayList<>();
		}

		public List<Integer> getRef() {
			return ref;
		}
	}
	
	/**
	 * this structure stores hash of each block with its Block references.
	 * Hash of block is used to identify whether it exists already or not.
	 * if yes -> it adds its references in the list.
	 * if not -> it creates a new entry with the block num.
	 */
	static Map<Integer, Block> blockMap=new HashMap<>();
	
	/**
	 * this stores the MD5 checksum of the generated file.
	 * this will be validated during redup() method in order to identify data corruption.
	 * Challenges i am facing is MD5 is getting different for the same file and because of which i am not able to validate for data corruptness.
	 */
	static String MD5_CHECKSUM=null;
	
	/**
	 * @param input_file_path
	 * @param deduped_file_path
	 * idea behind dedup() is to read chunk of bytes[1024] and calculate its Hash.
	 * If hash is already present in the data structure then update reference and continue reading next chunks.
	 * If Hash is not present then create an entry in the data structure and write this unique chunk into the file.
	 */
	static void dedup(String input_file_path, String deduped_file_path) {
		try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(input_file_path));
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(deduped_file_path))) {
			byte[] bbuf = new byte[1024];
			Integer blockNum=0;
			while (in.read(bbuf) != -1) {
				Integer hash=Arrays.hashCode(bbuf);
				if(blockMap.containsKey(hash)) {
					blockMap.get(hash).getRef().add(blockNum);
				}else {
					blockMap.put(hash, new Block(blockNum));
					out.write(bbuf);
				}
				blockNum++;
			}
			System.out.println("number of unique chunks:"+blockMap.size());
			System.out.println("input file size:"+(new File(input_file_path).length()));
			File f=new File(deduped_file_path);
			System.out.println("output file size:"+(f.length()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			//MD5_CHECKSUM=org.apache.commons.codec.digest.DigestUtils.md5Hex(new FileInputStream(f));
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

    /**
     * @param deduped_file_path
     * @param output_file_path
     * @return
     * idea behind redup is to first validate for data corruption and return false if found corrupted directly.
     * if data is not corrupted, then start reading unique chunks from deduped file and identify an entry in the data structure by calculating its Hash.
     * we get all the references and by using RandomAccessFile, all duplicates chunk can be written by moving to its offsets.
     * In this way,file can be regenerated.
     */
	static boolean redup(String deduped_file_path, String output_file_path) {
    	Boolean flag=true;
    	try {
    		File f=new File(deduped_file_path);
    		//if(!MD5_CHECKSUM.equals(org.apache.commons.codec.digest.DigestUtils.md5Hex(new FileInputStream(f)))){
    		//	return false;
    		//}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(deduped_file_path));
    			RandomAccessFile fileStore = new RandomAccessFile(output_file_path, "rw")) {
    	    byte[] bbuf = new byte[1024];
    	    while (in.read(bbuf) != -1) {
    	    	Integer hash=Arrays.hashCode(bbuf);
    	    	if(blockMap.containsKey(hash)) {
    	    		List<Integer> blockList=blockMap.get(hash).getRef();
    	    		fileStore.write(bbuf);
    	    		Long origPos = fileStore.getFilePointer(); // store the original position
    	    		for(Integer block:blockList) {
    	    			fileStore.seek(block*1024);
    	    			fileStore.write(bbuf);
    	    		}
    	    		fileStore.seek(origPos);
    	    	}else {
    	    		System.out.println("couldn't find for block:"+Arrays.toString(bbuf)+" with hash:"+hash);
    	    	}
    	    }
    	} catch (FileNotFoundException e) {
			e.printStackTrace();
			flag=false;
		} catch (IOException e) {
			e.printStackTrace();
			flag=false;
		}finally {
	    	System.out.println("deduped_file_path file size:"+(new File(deduped_file_path).length()));
	    	
	    	System.out.println("output_file_path file size:"+(new File(output_file_path).length()));
	    	
			return flag;
		}
    }
    
}
