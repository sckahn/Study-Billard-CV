package com.example;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import com.example.segmentation.ColorSegmentation;

public class MainActivity extends AppCompatActivity {

    static {
        if (!OpenCVLoader.initDebug()) {
            Log.e("OpenCV", "Initialization Failed");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example usage
        Mat inputImage = ... // Load your image here
        Scalar lowerBound = new Scalar(35, 100, 100); // Example lower bound for green
        Scalar upperBound = new Scalar(85, 255, 255); // Example upper bound for green

        Mat segmented = ColorSegmentation.segmentByColor(inputImage, lowerBound, upperBound);

        // Display or process the segmented image
    }
}
