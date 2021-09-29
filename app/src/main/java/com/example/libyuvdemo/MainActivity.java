package com.example.libyuvdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
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
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
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
        InputStream is = getResources().getAssets().open("yuv/cuc_ieschool_640x360_yuv_nv21.yuv");
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
        InputStream is = getResources().getAssets().open("yuv/test_1920x1080_i420.yuv");
        byte[] nv21 = new byte[is.available()];
        is.read(nv21);
        is.close();

        // 开始转码
        byte[] argb = YuvTool.NV21ToRGB565(nv21, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_1920x1080_rgb565.rgb");
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
        File file = new File(path, "lena_256x256_raw.rgb");
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
        byte[] i420_scale = YuvTool.I420Scale(i420, yuvWidth, yuvHeight, yuvWidth >> 1, yuvHeight >> 1, 0);

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
        byte[] i420_scale = YuvTool.I420Scale_16(i420, yuvWidth, yuvHeight, yuvWidth >> 1, yuvHeight >> 1, 0);

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

    public void i444ToI420Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv444p.yuv");
        byte[] i444 = new byte[is.available()];
        is.read(i444);
        is.close();

        // 开始转码
        byte[] i420 = YuvTool.I444ToI420(i444, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i420.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i420);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i444ToARGBClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv444p.yuv");
        byte[] i444 = new byte[is.available()];
        is.read(i444);
        is.close();

        // 开始转码
        byte[] argb = YuvTool.I444ToARGB(i444, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_argb.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i444ToABGRClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv444p.yuv");
        byte[] i444 = new byte[is.available()];
        is.read(i444);
        is.close();

        // 开始转码
        byte[] abgr = YuvTool.I444ToAGBR(i444, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_abgr.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(abgr);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i422ToI420Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv422p.yuv");
        byte[] i422 = new byte[is.available()];
        is.read(i422);
        is.close();

        // 开始转码
        byte[] i420 = YuvTool.I422ToI420(i422, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i420.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i420);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i422ToABGRClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv422p.yuv");
        byte[] i422 = new byte[is.available()];
        is.read(i422);
        is.close();

        // 开始转码
        byte[] abgr = YuvTool.I422ToABGR(i422, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_abgr.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(abgr);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i422ToBGRAClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv422p.yuv");
        byte[] i422 = new byte[is.available()];
        is.read(i422);
        is.close();

        // 开始转码
        byte[] bgra = YuvTool.I422ToBGRA(i422, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_bgra.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(bgra);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i422ToRGBAClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv422p.yuv");
        byte[] i422 = new byte[is.available()];
        is.read(i422);
        is.close();

        // 开始转码
        byte[] rgba = YuvTool.I422ToRGBA(i422, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_rgba.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(rgba);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i422ToARGBClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv422p.yuv");
        byte[] i422 = new byte[is.available()];
        is.read(i422);
        is.close();

        // 开始转码
        byte[] argb = YuvTool.I422ToARGB(i422, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_argb.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i422ToUYVYClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv422p.yuv");
        byte[] i422 = new byte[is.available()];
        is.read(i422);
        is.close();

        // 开始转码
        byte[] uyvy = YuvTool.I422ToUYVY(i422, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_uyvy.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(uyvy);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i422ToYUY2Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv422p.yuv");
        byte[] i422 = new byte[is.available()];
        is.read(i422);
        is.close();

        // 开始转码
        byte[] yuy2 = YuvTool.I422ToYUY2(i422, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_yuy2.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(yuy2);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i400ToI420Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_i400.yuv");
        byte[] i400 = new byte[is.available()];
        is.read(i400);
        is.close();

        // 开始转码
        byte[] i420 = YuvTool.I400ToI420(i400, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i420.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i420);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i400ToARGBClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_i400.yuv");
        byte[] i400 = new byte[is.available()];
        is.read(i400);
        is.close();

        // 开始转码
        byte[] argb = YuvTool.I400ToARGB(i400, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_argb.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void i400ToMirrorClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_i400.yuv");
        byte[] i400 = new byte[is.available()];
        is.read(i400);
        is.close();

        // 开始转码
        byte[] i400Mirror = YuvTool.I400ToMirror(i400, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i400_mirror.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i400Mirror);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }


    public void yuy2ToI420Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuy2.yuv");
        byte[] yuy2 = new byte[is.available()];
        is.read(yuy2);
        is.close();

        // 开始转码
        byte[] i420 = YuvTool.YUY2ToI420(yuy2, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i420.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i420);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void yuy2ToI422Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuy2.yuv");
        byte[] yuy2 = new byte[is.available()];
        is.read(yuy2);
        is.close();

        // 开始转码
        byte[] I422 = YuvTool.YUY2ToI422(yuy2, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i422.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(I422);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void yuy2ToNV12Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuy2.yuv");
        byte[] yuy2 = new byte[is.available()];
        is.read(yuy2);
        is.close();

        // 开始转码
        byte[] nv12 = YuvTool.YUY2ToNV12(yuy2, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_nv12.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(nv12);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void yuy2ToYClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuy2.yuv");
        byte[] yuy2 = new byte[is.available()];
        is.read(yuy2);
        is.close();

        // 开始转码
        byte[] y = YuvTool.YUY2ToY(yuy2, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_y.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(y);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void yuy2ToARGBClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuy2.yuv");
        byte[] yuy2 = new byte[is.available()];
        is.read(yuy2);
        is.close();

        // 开始转码
        byte[] argb = YuvTool.YUY2ToARGB(yuy2, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_argb.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void uyvyToI420Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_uyvy.yuv");
        byte[] uyvy = new byte[is.available()];
        is.read(uyvy);
        is.close();

        // 开始转码
        byte[] i420 = YuvTool.UYVYToI420(uyvy, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i420.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i420);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void uyvyToI422Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_uyvy.yuv");
        byte[] uyvy = new byte[is.available()];
        is.read(uyvy);
        is.close();

        // 开始转码
        byte[] i422 = YuvTool.UYVYToI422(uyvy, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i422.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i422);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void uyvyToNV12Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_uyvy.yuv");
        byte[] uyvy = new byte[is.available()];
        is.read(uyvy);
        is.close();

        // 开始转码
        byte[] nv12 = YuvTool.UYVYToNV12(uyvy, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_nv12.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(nv12);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void uyvyToARGBClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_uyvy.yuv");
        byte[] uyvy = new byte[is.available()];
        is.read(uyvy);
        is.close();

        // 开始转码
        byte[] argb = YuvTool.UYVYToARGB(uyvy, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_argb.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb);
        fos.flush();
        fos.close();

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

    public void argbToNV21Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb.rgb");
        byte[] argb = new byte[is.available()];
        is.read(argb);
        is.close();

        // 开始转码
        byte[] nv21 = YuvTool.ARGBToNV21(argb, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_nv21.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(nv21);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void argbToNV12Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb.rgb");
        byte[] argb = new byte[is.available()];
        is.read(argb);
        is.close();

        // 开始转码
        byte[] nv12 = YuvTool.ARGBToNV12(argb, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_nv12.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(nv12);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void argbToYUY2Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb.rgb");
        byte[] argb = new byte[is.available()];
        is.read(argb);
        is.close();

        // 开始转码
        byte[] yuy2 = YuvTool.ARGBToYUY2(argb, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_yuy2.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(yuy2);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void argbToUYVYClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb.rgb");
        byte[] argb = new byte[is.available()];
        is.read(argb);
        is.close();

        // 开始转码
        byte[] uyvy = YuvTool.ARGBToUYVY(argb, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_uyvy.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(uyvy);
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

    public void argbToBGRAClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb.rgb");
        byte[] argb = new byte[is.available()];
        is.read(argb);
        is.close();

        // 开始转码
        byte[] bgra = YuvTool.ARGBToBGRA(argb, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_bgra.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(bgra);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void argbToRGBAClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb.rgb");
        byte[] argb = new byte[is.available()];
        is.read(argb);
        is.close();

        // 开始转码
        byte[] rgba = YuvTool.ARGBToRGBA(argb, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_rgba.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(rgba);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void argbToRGB24Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb.rgb");
        byte[] argb = new byte[is.available()];
        is.read(argb);
        is.close();

        // 开始转码
        byte[] rgb24 = YuvTool.ARGBToRGB24(argb, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_rgb24.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(rgb24);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void argbToRGB565Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb.rgb");
        byte[] argb = new byte[is.available()];
        is.read(argb);
        is.close();

        // 开始转码
        byte[] rgb565 = YuvTool.ARGBToRGB565(argb, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_rgb565.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(rgb565);
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

    public void argbToJ400Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb.rgb");
        byte[] argb = new byte[is.available()];
        is.read(argb);
        is.close();

        // 开始转码
        byte[] j400 = YuvTool.ARGBToJ400(argb, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_j400.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(j400);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void argbToJ420Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb.rgb");
        byte[] argb = new byte[is.available()];
        is.read(argb);
        is.close();

        // 开始转码
        byte[] j420 = YuvTool.ARGBToJ420(argb, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_j420.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(j420);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void argbToJ422Click(View view) throws IOException {
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb.rgb");
        byte[] argb = new byte[is.available()];
        is.read(argb);
        is.close();

        // 开始转码
        byte[] j422 = YuvTool.ARGBToJ422(argb, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_j422.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(j422);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void argbToCopyClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb.rgb");
        byte[] argb = new byte[is.available()];
        is.read(argb);
        is.close();

        // 开始转码
        byte[] argb_copy = YuvTool.ARGBCopy(argb, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_argb_copy.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb_copy);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void argbToMirrorClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb.rgb");
        byte[] argb = new byte[is.available()];
        is.read(argb);
        is.close();

        // 开始转码
        byte[] argb_mirror = YuvTool.ARGBMirror(argb, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_argb_mirror.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb_mirror);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void argbToRotateClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb.rgb");
        byte[] argb = new byte[is.available()];
        is.read(argb);
        is.close();

        // 开始转码
        byte[] argb_rotate = YuvTool.ARGBRotate(argb, yuvWidth, yuvHeight, 90);

        // 成功失败提示
        File file = new File(path, "lena_256x256_argb_rotate.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb_rotate);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void argbToScaleClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb.rgb");
        byte[] argb = new byte[is.available()];
        is.read(argb);
        is.close();

        // 开始转码
        byte[] argb_scale = YuvTool.ARGBScale(argb, yuvWidth, yuvHeight, yuvWidth >> 1, yuvHeight >> 1, 0);

        // 成功失败提示
        File file = new File(path, "lena_256x256_argb_scale.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb_scale);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void bgraToI420Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_bgra.rgb");
        byte[] bgra = new byte[is.available()];
        is.read(bgra);
        is.close();

        // 开始转码
        byte[] i420 = YuvTool.BGRAToI420(bgra, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i420.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i420);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void bgraToARGBClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_bgra.rgb");
        byte[] bgra = new byte[is.available()];
        is.read(bgra);
        is.close();

        // 开始转码
        byte[] argb = YuvTool.BGRAToARGB(bgra, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_argb.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void argb4444ToI420Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb4444.rgb");
        byte[] argb4444 = new byte[is.available()];
        is.read(argb4444);
        is.close();

        // 开始转码
        byte[] i420 = YuvTool.ARGB4444ToI420(argb4444, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i420.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i420);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void argb4444ToARGBClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb4444.rgb");
        byte[] argb4444 = new byte[is.available()];
        is.read(argb4444);
        is.close();

        // 开始转码
        byte[] argb8888 = YuvTool.ARGB4444ToARGB8888(argb4444, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_argb8888.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb8888);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void rgbaToI420Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_rgba.rgb");
        byte[] rgba = new byte[is.available()];
        is.read(rgba);
        is.close();

        // 开始转码
        byte[] i420 = YuvTool.RGBAToI420(rgba, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i420.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i420);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void rgbaToAGBRClick(View view) throws IOException {

        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_rgba.rgb");
        byte[] rgba = new byte[is.available()];
        is.read(rgba);
        is.close();

        // 开始转码
        byte[] argb = YuvTool.RGBAToARGB(rgba, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_argb.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void argb1555ToI420Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb1555.rgb");
        byte[] argb1555 = new byte[is.available()];
        is.read(argb1555);
        is.close();

        // 开始转码
        byte[] i420 = YuvTool.ARGB1555ToI420(argb1555, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i420.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i420);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void argb1555ToARGBClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("rgb/lena_256x256_argb1555.rgb");
        byte[] argb1555 = new byte[is.available()];
        is.read(argb1555);
        is.close();

        // 开始转码
        byte[] argb = YuvTool.ARGB1555ToARGB(argb1555, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_argb.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void rawToI420Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("raw/lena_256x256_raw.rgb");
        byte[] raw = new byte[is.available()];
        is.read(raw);
        is.close();

        // 开始转码
        byte[] i420 = YuvTool.RAWToI420(raw, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_i420.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i420);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void rawToARGBClick(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("raw/lena_256x256_raw.rgb");
        byte[] raw = new byte[is.available()];
        is.read(raw);
        is.close();

        // 开始转码
        byte[] argb = YuvTool.RAWToARGB(raw, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_argb.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void rawToRGB24Click(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("raw/lena_256x256_raw.rgb");
        byte[] raw = new byte[is.available()];
        is.read(raw);
        is.close();

        // 开始转码
        byte[] rgb24 = YuvTool.RAWToRGB24(raw, yuvWidth, yuvHeight);

        // 成功失败提示
        File file = new File(path, "lena_256x256_rgb24.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(rgb24);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void toI420(View view) throws IOException {
        InputStream is = getResources().getAssets().open("yuv/cuc_ieschool_640x360_yuv_nv21.yuv");
        byte[] nv21 = new byte[is.available()];
        is.read(nv21);
        is.close();

        // 开始转码
        byte[] i420 = YuvTool.convertToI420(nv21, yuvWidth, yuvHeight, 512, 8, 120, 40, 0, new char[]{'N', 'V', '2', '1'});

        // 成功失败提示Ll
        File file = new File(path, "cuc_ieschool_640x360_yuv_I420.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(i420);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();

    }

    public void toARGB(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/cuc_ieschool_640x360_yuv420p.yuv");
        byte[] nv21 = new byte[is.available()];
        is.read(nv21);
        is.close();

        // 开始转码
        byte[] argb = YuvTool.convertToARGB(nv21, yuvWidth, yuvHeight, 540, 10, 100, 100, 90, new char[]{'I', '4', '2', '0'});

        // 成功失败提示Ll
        File file = new File(path, "cuc_ieschool_640x360_argb.rgb");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(argb);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void fromI420(View view) throws IOException {
        // 获取文件数据
        InputStream is = getResources().getAssets().open("yuv/lena_256x256_yuv420p.yuv");
        byte[] i420 = new byte[is.available()];
        is.read(i420);
        is.close();

        // 开始转码
        byte[] dst = YuvTool.convertFromI420(i420, yuvWidth, yuvHeight, yuvWidth * yuvHeight * 3 / 2, yuvWidth, new char[]{'N', 'V', '2', '1'});

        // 成功失败提示
        File file = new File(path, "cuc_ieschool_640x360_yuv_nv21.yuv");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(dst);
        fos.flush();
        fos.close();

        Toast.makeText(this, "转码成功", Toast.LENGTH_SHORT).show();
    }

    public void j420ToARGBClick(View view) {

    }
}
