package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.objdetect.CascadeClassifier;
import org.yaml.snakeyaml.Yaml;

import utils.*;

public class Test {
  public static void main(String[] args) {

	  FSToolTest();
	  
	  //YAML example
	  //YAMLTest();
  }
  
  private static void OpenCVTest() {
	System.out.println("Hello, OpenCV");
	// This is required whenever using OpenCV
	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	SIFTTool imgTool = new SIFTTool();
	imgTool.extractFeatsToFile("E:\\Devel\\VideoPipelineTools\\Tux.jpg", "E:\\Devel\\VideoPipelineTools\\Tux.sift");
	
  }
  
  private static void FSToolTest() {
	  //FSTool.createPojectFS("F:\\Project-13", "13");
	  //FSTool.copyDir("F:\\Warez", "F:\\Test");
	  FSTool.printStrList(FSTool.getFilesByExt("F:\\VIDEOS\\", ".mp4")); 
  }
  
  private static void YAMLTest() {
	  Map<String, String> map = new HashMap<String, String>();
	  map.put("name", "Pushkin");
	  Yaml yaml = new Yaml();
	  String output = yaml.dumpAsMap(map);
	  System.out.println(output);
	  Yaml inYaml = new Yaml();
	  Map inMap = (HashMap<String, String>)inYaml.load(output);
	  
	  System.out.println("Break here");
  }
  
  
}
