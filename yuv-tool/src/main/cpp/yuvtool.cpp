//
// Created by 杨世衢 on 2020/7/9.
//

#include <jni.h>
#include <string.h>
#include "libyuv.h"

#define NV21 1
#define NV12 2
#define I420 3
#define RGB_565 4
#define ARGB_8888 5

bool isEmpty(JNIEnv *env, jbyteArray src, int width, int height);

bool isEmpty(JNIEnv *env, jbyteArray src, int width, int height) {
    return !(src && env->GetArrayLength(src) && width && height);
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_NV21ToI420(JNIEnv *env, jclass clazz, jbyteArray nv21, jint width, jint height) {
    jsize len = env->GetArrayLength(nv21);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray i420 = env->NewByteArray(len);
    unsigned char* nv21_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(nv21, 0));
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));

    int ret = libyuv::NV21ToI420(
            nv21_data, width,
            nv21_data + size_y, width,
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(nv21, nv21_data, 0);
    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);

    if (ret != 0) {
        return NULL;
    }

    return i420;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_NV21ToARGB(JNIEnv *env, jclass clazz, jbyteArray nv21, jint width, jint height) {
    jsize len = env->GetArrayLength(nv21);
    int size_y = width * height;
    if (len <= 0) {
        return NULL;
    }
    jbyteArray argb = env->NewByteArray(size_y * 4);
    unsigned char* nv21_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(nv21, 0));
    unsigned char* agbr_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));

    int ret = libyuv::NV21ToARGB(
            nv21_data, width,
            nv21_data + size_y, width,
            agbr_data, width * 4,
            width, height);

    env->ReleasePrimitiveArrayCritical(nv21, nv21_data, 0);
    env->ReleasePrimitiveArrayCritical(argb, agbr_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return argb;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_NV21ToRGB565(JNIEnv *env, jclass clazz, jbyteArray nv21, jint width, jint height) {
    jsize len = env->GetArrayLength(nv21);
    int size_y = width * height;
    if (len <= 0) {
        return NULL;
    }
    jbyteArray rgb565 = env->NewByteArray(size_y * 2);
    unsigned char* nv21_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(nv21, 0));
    unsigned char* gbr565_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(rgb565, 0));

    int ret = libyuv::NV21ToRGB565(
            nv21_data, width,
            nv21_data + size_y, width,
            gbr565_data, width * 2,
            width, height);

    env->ReleasePrimitiveArrayCritical(nv21, nv21_data, 0);
    env->ReleasePrimitiveArrayCritical(rgb565, gbr565_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return rgb565;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_NV12ToI420(JNIEnv *env, jclass clazz, jbyteArray nv12, jint width, jint height) {
    jsize len = env->GetArrayLength(nv12);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray i420 = env->NewByteArray(len);
    unsigned char* nv12_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(nv12, 0));
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));

    int ret = libyuv::NV12ToI420(
            nv12_data, width,
            nv12_data + size_y, width,
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(nv12, nv12_data, 0);
    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);

    if (ret != 0) {
        return NULL;
    }

    return i420;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_NV12ToI420Rotate(JNIEnv *env, jclass clazz, jbyteArray nv12, jint width,
                                           jint height, jint rotation_mode) {
    jsize len = env->GetArrayLength(nv12);
    int width_rotate = width;
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray i420 = env->NewByteArray(len);
    unsigned char* nv12_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(nv12, 0));
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));

    libyuv::RotationMode rm;
    switch (rotation_mode) {
        case 0:
            rm = libyuv::kRotate0;
            break;
        case 90:
            rm = libyuv::kRotate90;
            width_rotate = height;
            break;
        case 180:
            rm = libyuv::kRotate180;
            break;
        case 270:
            rm = libyuv::kRotate270;
            width_rotate = height;
            break;
    }

    int ret = libyuv::NV12ToI420Rotate(
            nv12_data, width,
            nv12_data + size_y, width,
            i420_data, width_rotate,
            i420_data + size_y, width_rotate >> 1,
            i420_data + size_y + size_uv, width_rotate >> 1,
            width, height, rm
            );

    env->ReleasePrimitiveArrayCritical(nv12, nv12_data, 0);
    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);

    if (ret != 0) {
        return NULL;
    }

    return i420;
}
extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_NV12ToARGB(JNIEnv *env, jclass clazz, jbyteArray nv12, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(nv12);
    int size_y = width * height;
    if (len <= 0) {
        return NULL;
    }
    jbyteArray argb = env->NewByteArray(size_y * 4);
    unsigned char* nv12_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(nv12, 0));
    unsigned char* agbr_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));

    int ret = libyuv::NV12ToARGB(
            nv12_data, width,
            nv12_data + size_y, width,
            agbr_data, width * 4,
            width, height);

    env->ReleasePrimitiveArrayCritical(nv12, nv12_data, 0);
    env->ReleasePrimitiveArrayCritical(argb, agbr_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return argb;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_NV12ToRGB565(JNIEnv *env, jclass clazz, jbyteArray nv12, jint width,
                                       jint height) {
    jsize len = env->GetArrayLength(nv12);
    int size_y = width * height;
    if (len <= 0) {
        return NULL;
    }
    jbyteArray rgb565 = env->NewByteArray(size_y * 2);
    unsigned char* nv12_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(nv12, 0));
    unsigned char* gbr565_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(rgb565, 0));

    int ret = libyuv::NV12ToRGB565(
            nv12_data, width,
            nv12_data + size_y, width,
            gbr565_data, width * 2,
            width, height);

    env->ReleasePrimitiveArrayCritical(nv12, nv12_data, 0);
    env->ReleasePrimitiveArrayCritical(rgb565, gbr565_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return rgb565;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_I420ToNV21(JNIEnv *env, jclass clazz, jbyteArray i420, jint width, jint height) {
    jsize len = env->GetArrayLength(i420);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray nv21 = env->NewByteArray(len);
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned char* nv21_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(nv21, 0));

    int ret = libyuv::I420ToNV21(
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            nv21_data, width,
            nv21_data + size_y, width,
            width, height
            );

    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);
    env->ReleasePrimitiveArrayCritical(nv21, nv21_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return nv21;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_I420ToNV12(JNIEnv *env, jclass clazz, jbyteArray i420, jint width, jint height) {
    jsize len = env->GetArrayLength(i420);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray nv12 = env->NewByteArray(len);
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned char* nv12_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(nv12, 0));

    int ret = libyuv::I420ToNV12(
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            nv12_data, width,
            nv12_data + size_y, width,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);
    env->ReleasePrimitiveArrayCritical(nv12, nv12_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return nv12;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_I420ToI400(JNIEnv *env, jclass clazz, jbyteArray i420, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(i420);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray i400 = env->NewByteArray(len);
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned char* i400_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i400, 0));

    int ret = libyuv::I420ToI400(
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            i400_data, width,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);
    env->ReleasePrimitiveArrayCritical(i400, i400_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return i400;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_I420ToI411(JNIEnv *env, jclass clazz, jbyteArray i420, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(i420);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray i411 = env->NewByteArray(len);
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned char* i411_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i411, 0));

    int ret = libyuv::I420ToI411(
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            i411_data, width,
            i411_data + size_y, width_half,
            i411_data + size_y + size_uv, width_half,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);
    env->ReleasePrimitiveArrayCritical(i411, i411_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return i411;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_I420ToI422(JNIEnv *env, jclass clazz, jbyteArray i420, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(i420);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray i422 = env->NewByteArray(len);
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned char* i422_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i422, 0));

    int ret = libyuv::I420ToI422(
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            i422_data, width,
            i422_data + size_y, width_half,
            i422_data + size_y + size_uv, width_half,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);
    env->ReleasePrimitiveArrayCritical(i422, i422_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return i422;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_I420ToI444(JNIEnv *env, jclass clazz, jbyteArray i420, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(i420);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray i444 = env->NewByteArray(len);
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned char* i444_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i444, 0));

    int ret = libyuv::I420ToI444(
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            i444_data, width,
            i444_data + size_y, width_half,
            i444_data + size_y + size_uv, width_half,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);
    env->ReleasePrimitiveArrayCritical(i444, i444_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return i444;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_I420ToARGB(JNIEnv *env, jclass clazz, jbyteArray i420, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(i420);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray argb = env->NewByteArray(size_y * 4);
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned char* argb_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));

    int ret = libyuv::I420ToARGB(
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            argb_data, width * 4,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);
    env->ReleasePrimitiveArrayCritical(argb, argb_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return argb;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_I420ToRGB565(JNIEnv *env, jclass clazz, jbyteArray i420, jint width,
                                       jint height) {
    jsize len = env->GetArrayLength(i420);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray rgb_565 = env->NewByteArray(size_y * 2);
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned char* rgb_565_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(rgb_565, 0));

    int ret = libyuv::I420ToRGB565(
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            rgb_565_data, width * 2,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);
    env->ReleasePrimitiveArrayCritical(rgb_565, rgb_565_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return rgb_565;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_I420ToARGB4444(JNIEnv *env, jclass clazz, jbyteArray i420, jint width,
                                         jint height) {
    jsize len = env->GetArrayLength(i420);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray argb4444 = env->NewByteArray(size_y * 2);
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned char* argb4444_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb4444, 0));

    int ret = libyuv::I420ToARGB4444(
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            argb4444_data, width * 2,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);
    env->ReleasePrimitiveArrayCritical(argb4444, argb4444_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return argb4444;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_I420ToABGR(JNIEnv *env, jclass clazz, jbyteArray i420, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(i420);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray abgr = env->NewByteArray(size_y * 4);
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned char* abgr_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(abgr, 0));

    int ret = libyuv::I420ToABGR(
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            abgr_data, width * 4,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);
    env->ReleasePrimitiveArrayCritical(abgr, abgr_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return abgr;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_I420ToRGB24(JNIEnv *env, jclass clazz, jbyteArray i420, jint width,
                                      jint height) {
    jsize len = env->GetArrayLength(i420);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray rgb24 = env->NewByteArray(size_y * 3);
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned char* rgb24_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(rgb24, 0));

    int ret = libyuv::I420ToRGB24(
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            rgb24_data, width * 3,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);
    env->ReleasePrimitiveArrayCritical(rgb24, rgb24_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return rgb24;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_I420ToRGBA(JNIEnv *env, jclass clazz, jbyteArray i420, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(i420);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray rgba = env->NewByteArray(size_y * 4);
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned char* rgba_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(rgba, 0));

    int ret = libyuv::I420ToRGBA(
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            rgba_data, width * 4,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);
    env->ReleasePrimitiveArrayCritical(rgba, rgba_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return rgba;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_I420ToBGRA(JNIEnv *env, jclass clazz, jbyteArray i420, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(i420);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray bgra = env->NewByteArray(size_y * 4);
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned char* bgra_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(bgra, 0));

    int ret = libyuv::I420ToRGBA(
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            bgra_data, width * 4,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);
    env->ReleasePrimitiveArrayCritical(bgra, bgra_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return bgra;
}