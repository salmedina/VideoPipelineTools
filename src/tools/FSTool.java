package tools;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

public class FSTool {

	public static int importToProject(String sourceDir, String projectDir) {
		
		return -1;
	}
	
	/*
	 * Creates all the folders required for the project
	 */
	public static boolean createPojectFS(String root, String projectID) {
		
		Path path = FileSystems.getDefault().getPath(root, "SOURCE");
		if (!(new File(path.toString())).mkdirs()) {
		    return false;
		}
		path = FileSystems.getDefault().getPath(root, "FEATS");
		if (!(new File(path.toString())).mkdirs()) {
		    return false;
		}
		path = FileSystems.getDefault().getPath(root, "DICTS");
		if (!(new File(path.toString())).mkdirs()) {
		    return false;
		}
		path = FileSystems.getDefault().getPath(root, "VISUALWORDS");
		if (!(new File(path.toString())).mkdirs()) {
		    return false;
		}
		
		return true;
	}
	
	public static boolean mkdir(String dir) {
		if( dirExists(dir) ) {
			System.err.printf("FSTool::mkdir (%s) : Directory already exists");
			return true;
		}
		return (new File(dir)).mkdirs();
	}
	
	public static boolean dirExists(String dir) {
		Path path = FileSystems.getDefault().getPath(dir);
		return Files.exists(path, LinkOption.NOFOLLOW_LINKS);
	}
	
	/*
	 * Creates all the folders required for the project
	 */
	public static int cloneTreeStruct(String sourceDir, String targetDir) {
		List<String> sourceList = getDirList(new File(sourceDir));
		List<String> targetList = new ArrayList<String>();
		for(String srcDir : sourceList) {
			targetList.add(srcDir.replace(sourceDir, targetDir));
		}
		for(String tgtDir : targetList) {
			if( mkdir(tgtDir) ) {
				System.out.printf("Created: %s\n", tgtDir);
			} else {
				System.out.printf("Error on: %s\n", tgtDir);
			}
		}
		return targetList.size();
	}
	
	public static List<String> getDirList(File node){
		List dirList = new ArrayList<String>();
 
		if(node.isDirectory()){
			dirList.add(node.getAbsolutePath());
			String[] subNote = node.list();
			for(String filename : subNote){
				getSubDirList(new File(node, filename), dirList);
			}
		}
		return dirList;
	}
	
	public static List<String> getSubDirList(File node, List<String> dirList){
		if(node.isDirectory()){
			dirList.add(node.getAbsolutePath());
			String[] subNote = node.list();
			for(String filename : subNote){
				getSubDirList(new File(node, filename), dirList);
			}
		}
		return dirList;
	}
	
	public static int printDirList(String dir) {
		List<String> dirList = getDirList(new File(dir));
		return printDirList(dirList);
	}
	
	public static int printDirList(List<String> dirList) {
		if( dirList == null)
			return 0;
		
		for(String tmpDir : dirList) {
			System.out.println(tmpDir);
		}
		
		return dirList.size();
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
			return null;
		}
		for (String file : list) {
			String temp = new StringBuffer(path).append(File.separator)
					.append(file).toString();
		}
		
		return list;
	}
}
