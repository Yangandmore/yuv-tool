package com.example.libyuvdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import com.yuv.tool.YuvTool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private int yuvWidth = 256;
    private int yuvHeight = 256;

    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        path = Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public void nv21Toi420Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_nv21.yuv");
        byte[] nv21 = new byte[is.available()];
        is.read(nv21);
        is.close();

        // 开始转码
        byte[] i420 = YuvTool.NV21ToI420(nv21, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i420.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i420);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void nv21ToARGB8888Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_nv21.yuv");
        byte[] nv21 = new byte[is.available()];
        is.read(nv21);
        is.close();

        // 开始转码
        byte[] argb = YuvTool.NV21ToARGB(nv21, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_argb8888.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void nv21ToRG565Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_nv21.yuv");
        byte[] nv21 = new byte[is.available()];
        is.read(nv21);
        is.close();

        // 开始转码
        byte[] argb = YuvTool.NV21ToRGB565(nv21, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_rgb565.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void nv12Toi420Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_nv12.yuv");
        byte[] nv12 = new byte[is.available()];
        is.read(nv12);
        is.close();

        // 开始转码
        byte[] i420 = YuvTool.NV12ToI420(nv12, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i420.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i420);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void nv12Toi420RotateClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_nv12.yuv");
        byte[] nv12 = new byte[is.available()];
        is.read(nv12);
        is.close();

        // 开始转码
        byte[] i420 = YuvTool.NV12ToI420Rotate(nv12, yuvWidth, yuvHeight, 90);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i420_rotate.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i420);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void nv12ToARGB8888Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_nv12.yuv");
        byte[] nv12 = new byte[is.available()];
        is.read(nv12);
        is.close();

        // 开始转码
        byte[] argb = YuvTool.NV12ToARGB(nv12, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_argb8888.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void nv12ToRG565Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_nv12.yuv");
        byte[] nv12 = new byte[is.available()];
        is.read(nv12);
        is.close();

        // 开始转码
        byte[] argb = YuvTool.NV12ToRGB565(nv12, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_rgb565.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i420Tonv21Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420 = new byte[is.available()];
        is.read(i420);
        is.close();

        // 开始转码
        byte[] nv21 = YuvTool.I420ToNV21(i420, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_nv21.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(nv21);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i420Tonv12Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420 = new byte[is.available()];
        is.read(i420);
        is.close();

        // 开始转码
        byte[] nv12 = YuvTool.I420ToNV12(i420, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_nv12.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(nv12);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i420ToARGB8888Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420 = new byte[is.available()];
        is.read(i420);
        is.close();

        // 开始转码
        byte[] argb = YuvTool.I420ToARGB(i420, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_argb8888.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i420ToRGB565Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420 = new byte[is.available()];
        is.read(i420);
        is.close();

        // 开始转码
        byte[] argb = YuvTool.I420ToRGB565(i420, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_rgb565.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }
}
