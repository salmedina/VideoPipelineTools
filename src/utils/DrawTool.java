package utils;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;

public class DrawTool {
	public static void drawRectToMat(Mat img, Rect rect) {
		drawRectToMat(img, rect, new Scalar(0,0,255), 3);
	}
	
	public static void drawRectToMat(Mat img, Rect rect, Scalar color, int thickness) {
		Core.rectangle(img, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), color, thickness);
	}
}
