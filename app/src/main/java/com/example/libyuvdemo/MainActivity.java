package com.example.libyuvdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
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
        byte[] rgb565 = YuvTool.I420ToRGB565(i420, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_rgb565.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(rgb565);
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
        byte[] i420 = new byte[is.available()];
        is.read(i420);
        is.close();

        // 开始转码
        byte[] uyvy = YuvTool.I420ToUYVY(i420, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_uyvy.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(uyvy);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    // YUYV
    public void i420ToYUY2Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420 = new byte[is.available()];
        is.read(i420);
        is.close();

        // 开始转码
        byte[] yuy2 = YuvTool.I420ToYUY2(i420, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_yuy2.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(yuy2);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i420ToRawClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420 = new byte[is.available()];
        is.read(i420);
        is.close();

        // 开始转码
        byte[] raw = YuvTool.I420ToRAW(i420, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_raw.raw");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(raw);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i420CopyClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420 = new byte[is.available()];
        is.read(i420);
        is.close();

        // 开始转码
        byte[] i420_cache = YuvTool.I420Copy(i420, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i420_copy.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i420_cache);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i420MirrorClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420 = new byte[is.available()];
        is.read(i420);
        is.close();

        // 开始转码
        byte[] i420_mirror = YuvTool.I420Mirror(i420, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i420_mirror.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i420_mirror);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i420RotateClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420 = new byte[is.available()];
        is.read(i420);
        is.close();

        // 开始转码
        byte[] i420_rotate = YuvTool.I420Rotate(i420, yuvWidth, yuvHeight, 90);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i420_rotate.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i420_rotate);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i420ScaleClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420 = new byte[is.available()];
        is.read(i420);
        is.close();

        // 开始转码
        long time = System.currentTimeMillis();
        byte[] i420_scale = YuvTool.I420Scale(i420, yuvWidth, yuvHeight, yuvWidth >> 1, yuvHeight >> 1, 0);
        Log.e("-----> scale:", (System.currentTimeMillis() - time)+"");

        // 成功失败提示
        File file = new File(path, "lena_256x256_i420_scale.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i420_scale);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i420Scale16Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420 = new byte[is.available()];
        is.read(i420);
        is.close();

        // 开始转码
        long time = System.currentTimeMillis();
        byte[] i420_scale = YuvTool.I420Scale_16(i420, yuvWidth, yuvHeight, yuvWidth >> 1, yuvHeight >> 1, 0);
        Log.e("-----> scale_16:", (System.currentTimeMillis() - time)+"");

        // 成功失败提示
        File file = new File(path, "lena_256x256_i420_scale_16.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i420_scale);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i420PsnrClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420_a = new byte[is.available()];
        is.read(i420_a);
        is.close();
        is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420_b = new byte[is.available()];
        is.read(i420_b);
        is.close();

        // 开始转码
        double data = YuvTool.I420Psnr(i420_a, i420_b, yuvWidth, yuvHeight);

        // 成功失败提示
        Log.e("-----> PsnrData : ", data+"");

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i420SsimClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420_a = new byte[is.available()];
        is.read(i420_a);
        is.close();
        is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420_b = new byte[is.available()];
        is.read(i420_b);
        is.close();

        // 开始转码
        double data = YuvTool.I420Ssim(i420_a, i420_b, yuvWidth, yuvHeight);

        // 成功失败提示
        Log.e("-----> SsimData : ", data+"");

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i420RectClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420 = new byte[is.available()];
        is.read(i420);
        is.close();

        // 开始转码
        int ret = YuvTool.I420Rect(i420, yuvWidth, yuvHeight, 0, 0, 50, 50, 1, 0, 0);

        Log.e("-----> ret:", ret+"");

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void rgb24ToI420Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_rgb24.rgb");
        byte[] rgb24 = new byte[is.available()];
        is.read(rgb24);
        is.close();

        // 开始转码
        byte[] i420 = YuvTool.RGB24ToI420(rgb24, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i420.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i420);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void rgb24ToARGBClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_rgb24.rgb");
        byte[] argb = new byte[is.available()];
        is.read(argb);
        is.close();

        // 开始转码
        byte[] i420 = YuvTool.RGB24ToARGB(argb, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_argb.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i420);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void rgb565ToI420Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_rgb565.rgb");
        byte[] rgb565 = new byte[is.available()];
        is.read(rgb565);
        is.close();

        // 开始转码
        byte[] i420 = YuvTool.RGB565ToI420(rgb565, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_I420.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i420);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void rgb565ToARGBClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_rgb565.rgb");
        byte[] rgb565 = new byte[is.available()];
        is.read(rgb565);
        is.close();

        // 开始转码
        byte[] argb = YuvTool.RGB565ToARGB(rgb565, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_argb.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void abgrToI420Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_abgr.rgb");
        byte[] abgr = new byte[is.available()];
        is.read(abgr);
        is.close();

        // 开始转码
        byte[] i420 = YuvTool.ABGRToI420(abgr, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i420.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i420);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void abgrToARGBClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_abgr.rgb");
        byte[] abgr = new byte[is.available()];
        is.read(abgr);
        is.close();

        // 开始转码
        byte[] argb = YuvTool.ABGRToARGB(abgr, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_argb.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void argbToI420Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb.rgb");
        byte[] argb = new byte[is.available()];
        is.read(argb);
        is.close();

        // 开始转码
        byte[] i420 = YuvTool.ARGBToI420(argb, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_argb.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i420);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void argbToI400Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb.rgb");
        byte[] argb = new byte[is.available()];
        is.read(argb);
        is.close();

        // 开始转码
        byte[] i400 = YuvTool.ARGBToI400(argb, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i400.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i400);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void argbToI411Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb.rgb");
        byte[] argb = new byte[is.available()];
        is.read(argb);
        is.close();

        // 开始转码
        byte[] i411 = YuvTool.ARGBToI411(argb, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i411.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i411);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void argbToI422Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb.rgb");
        byte[] argb = new byte[is.available()];
        is.read(argb);
        is.close();

        // 开始转码
        byte[] i422 = YuvTool.ARGBToI422(argb, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i422.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i422);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void argbToI444Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb.rgb");
        byte[] argb = new byte[is.available()];
        is.read(argb);
        is.close();

        // 开始转码
        byte[] i444 = YuvTool.ARGBToI444(argb, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i444.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i444);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void argbToABGRClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb.rgb");
        byte[] argb = new byte[is.available()];
        is.read(argb);
        is.close();

        // 开始转码
        byte[] abgr = YuvTool.ARGBToABGR(argb, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_abgr.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(abgr);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void argbToARGB1555Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb.rgb");
        byte[] argb = new byte[is.available()];
        is.read(argb);
        is.close();

        // 开始转码
        byte[] argb1555 = YuvTool.ARGBToARGB1555(argb, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_argb1555.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb1555);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void argbToARGB4444Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb.rgb");
        byte[] argb = new byte[is.available()];
        is.read(argb);
        is.close();

        // 开始转码
        byte[] argb4444 = YuvTool.ARGBToARGB4444(argb, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_argb4444.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb4444);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }
}
