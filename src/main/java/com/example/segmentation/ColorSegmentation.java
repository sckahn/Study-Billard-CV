package com.example.segmentation;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class ColorSegmentation {

    public static Mat segmentByColor(Mat inputImage, Scalar lowerBound, Scalar upperBound) {
        Mat hsvImage = new Mat();
        Mat mask = new Mat();
        Mat segmented = new Mat();

        // Convert the image from BGR to HSV color space
        Imgproc.cvtColor(inputImage, hsvImage, Imgproc.COLOR_BGR2HSV);

        // Create a mask based on the defined color range
        Core.inRange(hsvImage, lowerBound, upperBound, mask);

        // Apply the mask to the original image
        Core.bitwise_and(inputImage, inputImage, segmented, mask);

        return segmented;
    }
}
