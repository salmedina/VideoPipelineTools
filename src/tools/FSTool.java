package tools;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FSTool {
	/*
	 * Creates all the folders required for the project
	 */
	public static boolean createPojectFS(String root, String projectID) {
		String sourceDir 	= root+"SOURCE-"+projectID;
		String featsDir  	= root+"FEATS-"+projectID;
		String dictsDir  	= root+"DICTS-"+projectID;
		String vwDir		= root+"VISUALWORDS-"+projectID;
		
		if (!(new File(sourceDir)).mkdirs()) {
		    return false;
		}
		if (!(new File(featsDir)).mkdirs()) {
		    return false;
		}
		if (!(new File(dictsDir)).mkdirs()) {
		    return false;
		}
		if (!(new File(vwDir)).mkdirs()) {
		    return false;
		}
		
		return true;
	}
	
	public static boolean mkdir(String dir) {
		return (new File(dir)).mkdirs();
	}
	
	/*
	 * Creates all the folders required for the project
	 */
	public static boolean cloneTreeStruct(String sourceDir, String targetDir) {
		List<String> sourceList = getDirList(new File(sourceDir));
		List targetList = new ArrayList<String>();
		for(String srcDir : sourceList) {
			targetList.add(srcDir.replace(sourceDir, targetDir));
		}
		
		return true;
	}
	
	public static List<String> getDirList(File node){
		List dirList = new ArrayList<String>();
 
		if(node.isDirectory()){
			dirList.add(node.getAbsoluteFile());
			String[] subNote = node.list();
			for(String filename : subNote){
				getDirList(new File(node, filename));
			}
		}
		return dirList;
	}
	
	/*
	 * Gets the list of files with given extension
	 * searches for the subdirectories
	 */
	public static String[] getFilesByExt(String path, String ext) {
		GenericExtFilter filter = new GenericExtFilter(ext);
		 
		File dir = new File(path);
 
		if(dir.isDirectory()==false) {
			System.out.println("Directory does not exists : " + path);
			return null;
		}
		// list out all the file name and filter by the extension
		String[] list = dir.list(filter);
 
		if (list.length == 0) {
			System.out.println("no files end with : " + ext);
			return null;
		}
		for (String file : list) {
			String temp = new StringBuffer(path).append(File.separator)
					.append(file).toString();
			System.out.println("file : " + temp);
		}
		
		return list;
	}
}
