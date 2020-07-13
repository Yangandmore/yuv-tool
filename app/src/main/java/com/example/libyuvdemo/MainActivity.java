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

    public void i420ToI400Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420 = new byte[is.available()];
        is.read(i420);
        is.close();

        // 开始转码
        byte[] i400 = YuvTool.I420ToI400(i420, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i400.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i400);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i420ToI411Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420 = new byte[is.available()];
        is.read(i420);
        is.close();

        // 开始转码
        byte[] i411 = YuvTool.I420ToI411(i420, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i411.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i411);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i420ToI422Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420 = new byte[is.available()];
        is.read(i420);
        is.close();

        // 开始转码
        byte[] i422 = YuvTool.I420ToI422(i420, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i422.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i422);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i420ToI444Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420 = new byte[is.available()];
        is.read(i420);
        is.close();

        // 开始转码
        byte[] i444 = YuvTool.I420ToI444(i420, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i444.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i444);
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

    public void i420ToARGB4444Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420 = new byte[is.available()];
        is.read(i420);
        is.close();

        // 开始转码
        byte[] argb4444 = YuvTool.I420ToARGB4444(i420, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_argb4444.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb4444);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i420ToARGB1555Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420 = new byte[is.available()];
        is.read(i420);
        is.close();

        // 开始转码
        byte[] argb1555 = YuvTool.I420ToARGB1555(i420, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_argb1555.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb1555);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i420ToABGRClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420 = new byte[is.available()];
        is.read(i420);
        is.close();

        // 开始转码
        byte[] abgr = YuvTool.I420ToABGR(i420, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_abgr.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(abgr);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i420ToRGB24Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420 = new byte[is.available()];
        is.read(i420);
        is.close();

        // 开始转码
        byte[] rgb24 = YuvTool.I420ToRGB24(i420, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_rgb24.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(rgb24);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i420ToRGBAClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420 = new byte[is.available()];
        is.read(i420);
        is.close();

        // 开始转码
        byte[] rgba = YuvTool.I420ToRGBA(i420, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_rgba.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(rgba);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i420ToBGRAClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420 = new byte[is.available()];
        is.read(i420);
        is.close();

        // 开始转码
        byte[] rgba = YuvTool.I420ToBGRA(i420, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_bgra.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(rgba);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i420ToUYVYClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] uyvy = new byte[is.available()];
        is.read(uyvy);
        is.close();

        // 开始转码
        byte[] rgba = YuvTool.I420ToUYVY(uyvy, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_uyvy.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(rgba);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

}
