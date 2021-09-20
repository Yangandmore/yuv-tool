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
    public static native byte[] I420ToI400(byte[] i420, int width, int height);
    public static native byte[] I420ToI411(byte[] i420, int width, int height);
    public static native byte[] I420ToI422(byte[] i420, int width, int height);
    public static native byte[] I420ToI444(byte[] i420, int width, int height);
    public static native byte[] I420ToARGB(byte[] i420, int width, int height);
    public static native byte[] I420ToRGB565(byte[] i420, int width, int height);
    public static native byte[] I420ToARGB4444(byte[] i420, int width, int height);
    public static native byte[] I420ToABGR(byte[] i420, int width, int height);
    public static native byte[] I420ToARGB1555(byte[] i420, int width, int height);
    public static native byte[] I420ToRGB24(byte[] i420, int width, int height);
    public static native byte[] I420ToRGBA(byte[] i420, int width, int height);
    public static native byte[] I420ToBGRA(byte[] i420, int width, int height);
    public static native byte[] I420ToUYVY(byte[] i420, int width, int height);
    public static native byte[] I420ToYUY2(byte[] i420, int width, int height);
    public static native byte[] I420ToRAW(byte[] i420, int width, int height);
    public static native byte[] I420Copy(byte[] i420, int width, int height);    // 拷贝
    public static native byte[] I420Mirror(byte[] i420, int width, int height);  // 镜像
    public static native byte[] I420Rotate(byte[] i420, int width, int height, int rotate);  // 旋转
    public static native byte[] I420Scale(byte[] i420, int srcWidth, int srcHeight, int dstWidth, int dstHeight, int scaleMode);   // 缩放(mode:0->3,慢->快)
    public static native byte[] I420Scale_16(byte[] i420, int srcWidth, int srcHeight, int dstWidth, int dstHeight, int scaleMode); // short模式下进行缩放相对速度快，质量差
    public static native double I420Psnr(byte[] i420A, byte[] i420B, int width, int height); // 峰值信噪比(不能很好地反映人眼主观感受),值越大，视频质量越好
    public static native double I420Ssim(byte[] i420A, byte[] i420B, int width, int height); // 结构相似性(较好地反映人眼主观感受),值越大，视频质量越好(0-1)
    public static native int I420Rect(byte[] i420, int width, int height, int x, int y, int rectW, int rectH, int rectY, int rectU, int rectV);

    public static native byte[] RGB24ToI420(byte[] rgb24, int width, int height);
    public static native byte[] RGB24ToARGB(byte[] rgb24, int width, int height);

    public static native byte[] RGB565ToI420(byte[] rgb565, int width, int height);
    public static native byte[] RGB565ToARGB(byte[] rgb565, int width, int height);

    public static native byte[] ABGRToI420(byte[] abgr, int width, int height);
    public static native byte[] ABGRToARGB(byte[] abgr, int width, int height);

    public static native byte[] ARGBToNV21(byte[] argb, int width, int height);
    public static native byte[] ARGBToNV12(byte[] argb, int width, int height);
    public static native byte[] ARGBToYUY2(byte[] argb, int width, int height);
    public static native byte[] ARGBToUYVY(byte[] argb, int width, int height);
    public static native byte[] ARGBToI420(byte[] argb, int width, int height);
    public static native byte[] ARGBToI400(byte[] argb, int width, int height);
    public static native byte[] ARGBToI411(byte[] argb, int width, int height);
    public static native byte[] ARGBToI422(byte[] argb, int width, int height);
    public static native byte[] ARGBToI444(byte[] argb, int width, int height);
    public static native byte[] ARGBToABGR(byte[] argb, int width, int height);
    public static native byte[] ARGBToBGRA(byte[] argb, int width, int height);
    public static native byte[] ARGBToRGBA(byte[] argb, int width, int height);
    public static native byte[] ARGBToRGB24(byte[] argb, int width, int height);
    public static native byte[] ARGBToRGB565(byte[] argb, int width, int height);
    public static native byte[] ARGBToARGB1555(byte[] argb, int width, int height);
    public static native byte[] ARGBToARGB4444(byte[] argb, int width, int height);
    public static native byte[] ARGBCopy(byte[] argb, int width, int height);
    public static native byte[] ARGBMirror(byte[] argb, int width, int height);
    public static native byte[] ARGBRotate(byte[] argb, int width, int height, int rotate);
    public static native byte[] ARGBScale(byte[] argb, int srcWidth, int srcHeight, int dstWidth, int dstHeight, int scaleMode);

    public static native byte[] RGBAToI420(byte[] rgba, int width, int height);
    public static native byte[] RGBAToARGB(byte[] rgba, int width, int height);

    /**
     *
     * @param src yuv格式数据
     * @param srcWidth 图片宽度
     * @param srcHeight 图片高度
     * @param cropX 裁剪后旋转前起始x坐标
     * @param cropY 裁剪后旋转前起始y坐标
     * @param cropWidth 裁剪后旋转前图片宽度
     * @param cropHeight 裁剪后旋转前图片高度
     * @param rotate 旋转角度
     * @param srcType 原数据类型，参考video_common.h文件下FourCC类
     * @return
     */
    public static native byte[] convertToI420(byte[] src, int srcWidth, int srcHeight, int cropX, int cropY, int cropWidth, int cropHeight, int rotate, char[] srcType);

    /**
     *
     * @param src yuv格式数据
     * @param srcWidth 图片宽度
     * @param srcHeight 图片高度
     * @param cropX 裁剪后旋转前起始x坐标
     * @param cropY 裁剪后旋转前起始y坐标
     * @param cropWidth 裁剪后旋转前图片宽度
     * @param cropHeight 裁剪后旋转前图片高度
     * @param rotate 旋转角度
     * @param srcType 原数据类型，参考video_common.h文件下FourCC类
     * @return
     */
    public static native byte[] convertToARGB(byte[] src, int srcWidth, int srcHeight, int cropX, int cropY, int cropWidth, int cropHeight, int rotate, char[] srcType);

    /**
     *
     * @param i420 i420格式数据
     * @param i420Width i420图片宽度
     * @param i420Height i420图片高度
     * @param dstLen 转码后文件大小
     * @param dstType 转换后数据类型，参考video_common.h文件下FourCC类
     * @return
     */
    public static native byte[] convertFromI420(byte[] i420, int i420Width, int i420Height, long dstLen, char[] dstType);

}
