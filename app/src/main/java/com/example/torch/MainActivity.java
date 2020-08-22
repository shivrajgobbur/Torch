package com.example.torch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private CameraManager cameraManager;
    private String cameraID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            cameraID = cameraManager.getCameraIdList()[0];
        }catch (CameraAccessException e){
            e.printStackTrace();
        }

    }

    public void TorchOnButtonClick(View view){
        try {
            cameraManager.setTorchMode(cameraID,true);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

    }


    public void TorchOffButtonClick(View view){
        try {
            cameraManager.setTorchMode(cameraID,false);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

    }

}
