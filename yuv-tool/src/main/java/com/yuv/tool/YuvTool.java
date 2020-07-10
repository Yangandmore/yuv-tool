package com.yuv.tool;

public class YuvTool {
    static {
        System.loadLibrary("yuvtool");
    }

    public static native byte[] NV21ToI420(byte[] nv21, int width, int height);
    public static native byte[] NV21ToARGB(byte[] nv21, int width, int height);
    public static native byte[] NV21ToRGB565(byte[] nv21, int width, int height);

    public static native byte[] NV12ToI420(byte[] nv12, int width, int height);
    public static native byte[] NV12ToI420Rotate(byte[] nv12, int width, int height, int RotationMode);
    public static native byte[] NV12ToARGB(byte[] nv12, int width, int height);
    public static native byte[] NV12ToRGB565(byte[] nv12, int width, int height);

    public static native byte[] I420ToNV21(byte[] i420, int width, int height);
    public static native byte[] I420ToNV12(byte[] i420, int width, int height);
    public static native byte[] I420ToARGB(byte[] i420, int width, int height);
    public static native byte[] I420ToRGB565(byte[] i420, int width, int height);

    public static final class PicType {
        public static final int NV21 = 1;
        public static final int NV12 = 2;
        public static final int I420 = 3;
        public static final int RGB_565 = 4;
        public static final int ARGB_8888 = 5;

    }

}
