//
// Created by 杨世衢 on 2020/7/9.
//

#include <jni.h>
#include <string.h>
#include "libyuv.h"


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
    jbyteArray i400 = env->NewByteArray(size_y);
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
    jbyteArray i411 = env->NewByteArray(size_y + size_uv);
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned char* i411_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i411, 0));

    int ret = libyuv::I420ToI411(
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            i411_data, width,
            i411_data + size_y, width_half >> 1,
            i411_data + size_y + size_uv, width_half >> 1,
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
    jbyteArray i422 = env->NewByteArray(size_y * 2);
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned char* i422_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i422, 0));

    int ret = libyuv::I420ToI422(
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            i422_data, width,
            i422_data + size_y, width_half,
            i422_data + size_y + size_uv * 2, width_half,
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
    jbyteArray i444 = env->NewByteArray(size_y * 3);
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned char* i444_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i444, 0));

    int ret = libyuv::I420ToI444(
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            i444_data, width,
            i444_data + size_y, width,
            i444_data + size_y + size_y, width,
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
Java_com_yuv_tool_YuvTool_I420ToARGB1555(JNIEnv *env, jclass clazz, jbyteArray i420, jint width,
                                         jint height) {
    jsize len = env->GetArrayLength(i420);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray abgr_2555 = env->NewByteArray(size_y * 2);
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned char* abgr_1555_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(abgr_2555, 0));

    int ret = libyuv::I420ToARGB1555(
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            abgr_1555_data, width * 2,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);
    env->ReleasePrimitiveArrayCritical(abgr_2555, abgr_1555_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return abgr_2555;
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

    int ret = libyuv::I420ToBGRA(
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

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_I420ToUYVY(JNIEnv *env, jclass clazz, jbyteArray i420, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(i420);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray uyvy = env->NewByteArray(size_y * 2);
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned char* uyvy_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(uyvy, 0));

    int ret = libyuv::I420ToUYVY(
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            uyvy_data, width * 2,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);
    env->ReleasePrimitiveArrayCritical(uyvy, uyvy_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return uyvy;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_I420ToYUY2(JNIEnv *env, jclass clazz, jbyteArray i420, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(i420);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray yuy2 = env->NewByteArray(size_y * 2);
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned char* yuy2_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(yuy2, 0));

    int ret = libyuv::I420ToYUY2(
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            yuy2_data, width * 2,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);
    env->ReleasePrimitiveArrayCritical(yuy2, yuy2_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return yuy2;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_I420ToRAW(JNIEnv *env, jclass clazz, jbyteArray i420, jint width,
                                    jint height) {
    jsize len = env->GetArrayLength(i420);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray raw = env->NewByteArray(size_y * 3);
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned char* raw_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(raw, 0));

    int ret = libyuv::I420ToRAW(
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            raw_data, width * 3,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);
    env->ReleasePrimitiveArrayCritical(raw, raw_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return raw;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_I420Copy(JNIEnv *env, jclass clazz, jbyteArray i420, jint width,
                                   jint height) {
    jsize len = env->GetArrayLength(i420);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray i420_cache = env->NewByteArray(len);
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned char* i420_cache_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420_cache, 0));

    int ret = libyuv::I420Copy(
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            i420_cache_data, width,
            i420_cache_data + size_y, width_half,
            i420_cache_data + size_y + size_uv, width_half,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);
    env->ReleasePrimitiveArrayCritical(i420_cache, i420_cache_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return i420_cache;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_I420Mirror(JNIEnv *env, jclass clazz, jbyteArray i420, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(i420);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray i420_mirror = env->NewByteArray(len);
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned char* i420_mirror_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420_mirror, 0));

    int ret = libyuv::I420Mirror(
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            i420_mirror_data, width,
            i420_mirror_data + size_y, width_half,
            i420_mirror_data + size_y + size_uv, width_half,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);
    env->ReleasePrimitiveArrayCritical(i420_mirror, i420_mirror_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return i420_mirror;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_I420Rotate(JNIEnv *env, jclass clazz, jbyteArray i420, jint width,
                                     jint height, jint rotate) {
    jsize len = env->GetArrayLength(i420);
    int width_rotate = width;
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    libyuv::RotationMode mode;
    switch (rotate) {
        case 0:
            mode = libyuv::kRotate0;
            break;
        case 90:
            mode = libyuv::kRotate90;
            width_rotate = height;
            break;
        case 180:
            mode = libyuv::kRotate180;
            break;
        case 270:
            mode = libyuv::kRotate270;
            width_rotate = height;
            break;
        default:
            mode = libyuv::kRotate0;
            break;
    }

    jbyteArray i420_rotate = env->NewByteArray(len);
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned char* i420_rotate_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420_rotate, 0));

    int ret = libyuv::I420Rotate(
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            i420_rotate_data, width_rotate,
            i420_rotate_data + size_y, width_rotate >> 1,
            i420_rotate_data + size_y + size_uv, width_rotate >> 1,
            width, height, mode
    );

    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);
    env->ReleasePrimitiveArrayCritical(i420_rotate, i420_rotate_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return i420_rotate;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_I420Scale(JNIEnv *env, jclass clazz, jbyteArray i420, jint src_width,
                                    jint src_height, jint dst_width, jint dst_height, jint scale_mode) {
    jsize len = env->GetArrayLength(i420);
    int src_width_half = src_width >> 1;
    int dst_width_half = dst_width >> 1;
    int src_size_y = src_width * src_height;
    int src_size_uv = src_width_half * (src_height >> 1);
    int dst_size_y = dst_width * dst_height;
    int dst_size_uv = dst_width_half * (dst_height >> 1);

    if (len <= 0) {
        return NULL;
    }
    libyuv::FilterMode mode;
    switch (scale_mode) {
        case 0:
            mode = libyuv::kFilterNone;
            break;
        case 1:
            mode = libyuv::kFilterLinear;
            break;
        case 2:
            mode = libyuv::kFilterBilinear;
            break;
        case 3:
            mode = libyuv::kFilterBox;
            break;
        default:
            mode = libyuv::kFilterNone;

    }
    jbyteArray i420_scale = env->NewByteArray(dst_size_y + dst_size_uv * 2);
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned char* i420_scale_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420_scale, 0));

    int ret = libyuv::I420Scale(
            i420_data, src_width,
            i420_data + src_size_y, src_width_half,
            i420_data + src_size_y + src_size_uv, src_width_half,
            src_width, src_height,
            i420_scale_data, dst_width,
            i420_scale_data + dst_size_y, dst_width_half,
            i420_scale_data + dst_size_y + dst_size_uv, dst_width_half,
            dst_width, dst_height, mode
    );

    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);
    env->ReleasePrimitiveArrayCritical(i420_scale, i420_scale_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return i420_scale;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_I420Scale_116(JNIEnv *env, jclass clazz, jbyteArray i420, jint src_width,
                                        jint src_height, jint dst_width, jint dst_height,
                                        jint scale_mode) {
    jsize len = env->GetArrayLength(i420);
    int src_width_half = src_width >> 1;
    int dst_width_half = dst_width >> 1;
    int src_size_y = src_width * src_height;
    int src_size_uv = src_width_half * (src_height >> 1);
    int dst_size_y = dst_width * dst_height;
    int dst_size_uv = dst_width_half * (dst_height >> 1);

    if (len <= 0) {
        return NULL;
    }
    libyuv::FilterMode mode;
    switch (scale_mode) {
        case 0:
            mode = libyuv::kFilterNone;
            break;
        case 1:
            mode = libyuv::kFilterLinear;
            break;
        case 2:
            mode = libyuv::kFilterBilinear;
            break;
        case 3:
            mode = libyuv::kFilterBox;
            break;
        default:
            mode = libyuv::kFilterNone;

    }
    jbyteArray i420_scale = env->NewByteArray(dst_size_y + dst_size_uv * 2);
    unsigned short* i420_data = static_cast<unsigned short *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned short* i420_scale_data = static_cast<unsigned short *>(env->GetPrimitiveArrayCritical(i420_scale, 0));

    int ret = libyuv::I420Scale_16(
            i420_data, src_width >> 1,
            i420_data + (src_size_y >> 1), src_width_half >> 1,
            i420_data + (src_size_y >> 1) + (src_size_uv >> 1), src_width_half >> 1,
            src_width, src_height,
            i420_scale_data, dst_width >> 1,
            i420_scale_data + (dst_size_y >> 1), dst_width_half >> 1,
            i420_scale_data + (dst_size_y >> 1) + (dst_size_uv >> 1), dst_width_half >> 1,
            dst_width, dst_height, mode
    );

    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);
    env->ReleasePrimitiveArrayCritical(i420_scale, i420_scale_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return i420_scale;
}

extern "C"
JNIEXPORT jdouble JNICALL
Java_com_yuv_tool_YuvTool_I420Psnr(JNIEnv *env, jclass clazz, jbyteArray i420_a, jbyteArray i420_b,
                                   jint width, jint height) {
    jsize len = env->GetArrayLength(i420_a);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return -1;
    }
    unsigned char* i420_a_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420_a, 0));
    unsigned char* i420_b_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420_b, 0));

    double ret = libyuv::I420Psnr(
            i420_a_data, width,
            i420_a_data + size_y, width_half,
            i420_a_data + size_y + size_uv, width_half,
            i420_b_data, width,
            i420_b_data + size_y, width_half,
            i420_b_data + size_y + size_uv, width_half,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(i420_a, i420_a_data, 0);
    env->ReleasePrimitiveArrayCritical(i420_b, i420_b_data, 0);

    return ret;
}

extern "C"
JNIEXPORT jdouble JNICALL
Java_com_yuv_tool_YuvTool_I420Ssim(JNIEnv *env, jclass clazz, jbyteArray i420_a, jbyteArray i420_b,
                                   jint width, jint height) {
    jsize len = env->GetArrayLength(i420_a);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return -1;
    }
    unsigned char* i420_a_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420_a, 0));
    unsigned char* i420_b_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420_b, 0));

    double ret = libyuv::I420Ssim(
            i420_a_data, width,
            i420_a_data + size_y, width_half,
            i420_a_data + size_y + size_uv, width_half,
            i420_b_data, width,
            i420_b_data + size_y, width_half,
            i420_b_data + size_y + size_uv, width_half,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(i420_a, i420_a_data, 0);
    env->ReleasePrimitiveArrayCritical(i420_b, i420_b_data, 0);

    return ret;
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_yuv_tool_YuvTool_I420Rect(JNIEnv *env, jclass clazz, jbyteArray i420, jint width,
                                   jint height, jint x, jint y, jint rect_w, jint rect_h,
                                   jint rect_y, jint rect_u, jint rect_v) {
    jsize len = env->GetArrayLength(i420);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return -1;
    }
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));

    int ret = libyuv::I420Rect(
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            x, y, rect_w, rect_h,
            rect_y, rect_u, rect_v
            );

    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);

    return ret;
}


extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_RGB24ToI420(JNIEnv *env, jclass clazz, jbyteArray rgb24, jint width,
                                      jint height) {
    jsize len = env->GetArrayLength(rgb24);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray i420 = env->NewByteArray(size_y + size_uv * 2);
    unsigned char* rgb24_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(rgb24, 0));
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));

    int ret = libyuv::RGB24ToI420(
            rgb24_data, width * 3,
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(rgb24, rgb24_data, 0);
    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return i420;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_RGB24ToARGB(JNIEnv *env, jclass clazz, jbyteArray rgb24, jint width,
                                      jint height) {
    jsize len = env->GetArrayLength(rgb24);
    int size_y = width * height;
    if (len <= 0) {
        return NULL;
    }
    jbyteArray argb = env->NewByteArray(size_y * 4);
    unsigned char* rgb24_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(rgb24, 0));
    unsigned char* argb_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));

    int ret = libyuv::RGB24ToARGB(
            rgb24_data, width * 3,
            argb_data, width * 4,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(rgb24, rgb24_data, 0);
    env->ReleasePrimitiveArrayCritical(argb, argb_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return argb;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_RGB565ToI420(JNIEnv *env, jclass clazz, jbyteArray rgb565, jint width,
                                       jint height) {
    jsize len = env->GetArrayLength(rgb565);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray i420 = env->NewByteArray(size_y + size_uv * 2);
    unsigned char* rgb565_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(rgb565, 0));
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));

    int ret = libyuv::RGB565ToI420(
            rgb565_data, width * 2,
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(rgb565, rgb565_data, 0);
    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return i420;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_RGB565ToARGB(JNIEnv *env, jclass clazz, jbyteArray rgb565, jint width,
                                       jint height) {
    jsize len = env->GetArrayLength(rgb565);
    int size_y = width * height;
    if (len <= 0) {
        return NULL;
    }
    jbyteArray argb = env->NewByteArray(size_y * 4);
    unsigned char* rgb565_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(rgb565, 0));
    unsigned char* argb_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));

    int ret = libyuv::RGB565ToARGB(
            rgb565_data, width * 2,
            argb_data, width * 4,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(rgb565, rgb565_data, 0);
    env->ReleasePrimitiveArrayCritical(argb, argb_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return argb;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_ABGRToI420(JNIEnv *env, jclass clazz, jbyteArray abgr, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(abgr);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray i420 = env->NewByteArray(size_y + size_uv * 2);
    unsigned char* abgr_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(abgr, 0));
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));

    int ret = libyuv::ABGRToI420(
            abgr_data, width * 4,
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(abgr, abgr_data, 0);
    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return i420;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_ABGRToARGB(JNIEnv *env, jclass clazz, jbyteArray abgr, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(abgr);
    int size_y = width * height;
    if (len <= 0) {
        return NULL;
    }
    jbyteArray argb = env->NewByteArray(size_y *4);
    unsigned char* abgr_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(abgr, 0));
    unsigned char* argb_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));

    int ret = libyuv::ABGRToARGB(
            abgr_data, width * 4,
            argb_data, width * 4,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(abgr, abgr_data, 0);
    env->ReleasePrimitiveArrayCritical(argb, argb_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return argb;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_ARGBToNV21(JNIEnv *env, jclass clazz, jbyteArray argb, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(argb);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray nv21 = env->NewByteArray(size_y + size_uv * 2);
    unsigned char* argb_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));
    unsigned char* nv21_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(nv21, 0));

    int ret = libyuv::ARGBToNV21(
            argb_data, width * 4,
            nv21_data, width,
            nv21_data + size_y, width,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(argb, argb_data, 0);
    env->ReleasePrimitiveArrayCritical(nv21, nv21_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return nv21;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_ARGBToNV12(JNIEnv *env, jclass clazz, jbyteArray argb, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(argb);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray nv12 = env->NewByteArray(size_y + size_uv * 2);
    unsigned char* argb_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));
    unsigned char* nv12_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(nv12, 0));

    int ret = libyuv::ARGBToNV12(
            argb_data, width * 4,
            nv12_data, width,
            nv12_data + size_y, width,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(argb, argb_data, 0);
    env->ReleasePrimitiveArrayCritical(nv12, nv12_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return nv12;
}
extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_ARGBToYUY2(JNIEnv *env, jclass clazz, jbyteArray argb, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(argb);
    int size_y = width * height;
    if (len <= 0) {
        return NULL;
    }
    jbyteArray yuy2 = env->NewByteArray(size_y * 2);
    unsigned char* argb_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));
    unsigned char* yuy2_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(yuy2, 0));

    int ret = libyuv::ARGBToYUY2(
            argb_data, width * 4,
            yuy2_data, width * 2,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(argb, argb_data, 0);
    env->ReleasePrimitiveArrayCritical(yuy2, yuy2_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return yuy2;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_ARGBToUYVY(JNIEnv *env, jclass clazz, jbyteArray argb, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(argb);
    int size_y = width * height;
    if (len <= 0) {
        return NULL;
    }
    jbyteArray uyvy = env->NewByteArray(size_y * 2);
    unsigned char* argb_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));
    unsigned char* uyvy_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(uyvy, 0));

    int ret = libyuv::ARGBToUYVY(
            argb_data, width * 4,
            uyvy_data, width * 2,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(argb, argb_data, 0);
    env->ReleasePrimitiveArrayCritical(uyvy, uyvy_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return uyvy;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_ARGBToI420(JNIEnv *env, jclass clazz, jbyteArray argb, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(argb);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray i420 = env->NewByteArray(size_y + size_uv * 2);
    unsigned char* argb_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));

    int ret = libyuv::ARGBToI420(
            argb_data, width * 4,
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(argb, argb_data, 0);
    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return i420;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_ARGBToI400(JNIEnv *env, jclass clazz, jbyteArray argb, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(argb);
    int size_y = width * height;
    if (len <= 0) {
        return NULL;
    }
    jbyteArray i400 = env->NewByteArray(size_y);
    unsigned char* argb_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));
    unsigned char* i400_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i400, 0));

    int ret = libyuv::ARGBToI400(
            argb_data, width * 4,
            i400_data, width,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(argb, argb_data, 0);
    env->ReleasePrimitiveArrayCritical(i400, i400_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return i400;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_ARGBToI411(JNIEnv *env, jclass clazz, jbyteArray argb, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(argb);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray i411 = env->NewByteArray(size_y + size_uv);
    unsigned char* argb_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));
    unsigned char* i411_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i411, 0));

    int ret = libyuv::ARGBToI411(
            argb_data, width * 4,
            i411_data, width,
            i411_data + size_y, width_half >> 1,
            i411_data + size_y + size_uv, width_half >> 1,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(argb, argb_data, 0);
    env->ReleasePrimitiveArrayCritical(i411, i411_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return i411;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_ARGBToI422(JNIEnv *env, jclass clazz, jbyteArray argb, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(argb);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray i422 = env->NewByteArray(size_y * 2);
    unsigned char* argb_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));
    unsigned char* i422_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i422, 0));

    int ret = libyuv::ARGBToI422(
            argb_data, width * 4,
            i422_data, width,
            i422_data + size_y, width_half,
            i422_data + size_y + size_uv * 2, width_half,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(argb, argb_data, 0);
    env->ReleasePrimitiveArrayCritical(i422, i422_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return i422;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_ARGBToI444(JNIEnv *env, jclass clazz, jbyteArray argb, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(argb);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray i444 = env->NewByteArray(size_y * 3);
    unsigned char* argb_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));
    unsigned char* i444_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i444, 0));

    int ret = libyuv::ARGBToI444(
            argb_data, width * 4,
            i444_data, width,
            i444_data + size_y, width,
            i444_data + size_y + size_y, width,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(argb, argb_data, 0);
    env->ReleasePrimitiveArrayCritical(i444, i444_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return i444;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_ARGBToABGR(JNIEnv *env, jclass clazz, jbyteArray argb, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(argb);
    int size_y = width * height;
    if (len <= 0) {
        return NULL;
    }
    jbyteArray abgr = env->NewByteArray(size_y * 4);
    unsigned char* argb_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));
    unsigned char* abrg_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(abgr, 0));

    int ret = libyuv::ARGBToABGR(
            argb_data, width * 4,
            abrg_data, width * 4,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(argb, argb_data, 0);
    env->ReleasePrimitiveArrayCritical(abgr, abrg_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return abgr;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_ARGBToBGRA(JNIEnv *env, jclass clazz, jbyteArray argb, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(argb);
    int size_y = width * height;
    if (len <= 0) {
        return NULL;
    }
    jbyteArray bgra = env->NewByteArray(size_y * 4);
    unsigned char* argb_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));
    unsigned char* bgra_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(bgra, 0));

    int ret = libyuv::ARGBToBGRA(
            argb_data, width * 4,
            bgra_data, width * 4,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(argb, argb_data, 0);
    env->ReleasePrimitiveArrayCritical(bgra, bgra_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return bgra;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_ARGBToRGBA(JNIEnv *env, jclass clazz, jbyteArray argb, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(argb);
    int size_y = width * height;
    if (len <= 0) {
        return NULL;
    }
    jbyteArray rgba = env->NewByteArray(size_y * 4);
    unsigned char* argb_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));
    unsigned char* rgba_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(rgba, 0));

    int ret = libyuv::ARGBToRGBA(
            argb_data, width * 4,
            rgba_data, width * 4,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(argb, argb_data, 0);
    env->ReleasePrimitiveArrayCritical(rgba, rgba_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return rgba;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_ARGBToRGB24(JNIEnv *env, jclass clazz, jbyteArray argb, jint width,
                                      jint height) {
    jsize len = env->GetArrayLength(argb);
    int size_y = width * height;
    if (len <= 0) {
        return NULL;
    }
    jbyteArray rgb24 = env->NewByteArray(size_y * 3);
    unsigned char* argb_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));
    unsigned char* rgb24_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(rgb24, 0));

    int ret = libyuv::ARGBToRGB24(
            argb_data, width * 4,
            rgb24_data, width * 3,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(argb, argb_data, 0);
    env->ReleasePrimitiveArrayCritical(rgb24, rgb24_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return rgb24;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_ARGBToRGB565(JNIEnv *env, jclass clazz, jbyteArray argb, jint width,
                                       jint height) {
    jsize len = env->GetArrayLength(argb);
    int size_y = width * height;
    if (len <= 0) {
        return NULL;
    }
    jbyteArray rgb565 = env->NewByteArray(size_y * 2);
    unsigned char* argb_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));
    unsigned char* rgb565_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(rgb565, 0));

    int ret = libyuv::ARGBToRGB565(
            argb_data, width * 4,
            rgb565_data, width * 2,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(argb, argb_data, 0);
    env->ReleasePrimitiveArrayCritical(rgb565, rgb565_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return rgb565;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_ARGBToARGB1555(JNIEnv *env, jclass clazz, jbyteArray argb, jint width,
                                         jint height) {
    jsize len = env->GetArrayLength(argb);
    int size_y = width * height;
    if (len <= 0) {
        return NULL;
    }
    jbyteArray argb_1555 = env->NewByteArray(size_y * 2);
    unsigned char* argb_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));
    unsigned char* argb_1555_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb_1555, 0));

    int ret = libyuv::ARGBToARGB1555(
            argb_data, width * 4,
            argb_1555_data, width * 2,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(argb, argb_data, 0);
    env->ReleasePrimitiveArrayCritical(argb_1555, argb_1555_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return argb_1555;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_ARGBToARGB4444(JNIEnv *env, jclass clazz, jbyteArray argb, jint width,
                                         jint height) {
    jsize len = env->GetArrayLength(argb);
    int size_y = width * height;
    if (len <= 0) {
        return NULL;
    }
    jbyteArray argb_4444 = env->NewByteArray(size_y * 4);
    unsigned char* argb_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));
    unsigned char* argb_4444_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb_4444, 0));

    int ret = libyuv::ARGBToARGB4444(
            argb_data, width * 4,
            argb_4444_data, width * 4,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(argb, argb_data, 0);
    env->ReleasePrimitiveArrayCritical(argb_4444, argb_4444_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return argb_4444;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_ARGBCopy(JNIEnv *env, jclass clazz, jbyteArray argb, jint width,
                                   jint height) {
    jsize len = env->GetArrayLength(argb);
    int size_y = width * height;
    if (len <= 0) {
        return NULL;
    }
    jbyteArray argb_cache = env->NewByteArray(size_y * 4);
    unsigned char* argb_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));
    unsigned char* argb_cache_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb_cache, 0));

    int ret = libyuv::ARGBCopy(
            argb_data, width * 4,
            argb_cache_data, width * 4,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(argb, argb_data, 0);
    env->ReleasePrimitiveArrayCritical(argb_cache, argb_cache_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return argb_cache;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_ARGBMirror(JNIEnv *env, jclass clazz, jbyteArray argb, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(argb);
    int size_y = width * height;
    if (len <= 0) {
        return NULL;
    }
    jbyteArray argb_mirror = env->NewByteArray(size_y * 4);
    unsigned char* argb_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));
    unsigned char* argb_mirror_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb_mirror, 0));

    int ret = libyuv::ARGBMirror(
            argb_data, width * 4,
            argb_mirror_data, width * 4,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(argb, argb_data, 0);
    env->ReleasePrimitiveArrayCritical(argb_mirror, argb_mirror_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return argb_mirror;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_ARGBRotate(JNIEnv *env, jclass clazz, jbyteArray argb, jint width,
                                     jint height, jint rotate) {
    jsize len = env->GetArrayLength(argb);
    int size_y = width * height;
    int width_rotate = width;
    if (len <= 0) {
        return NULL;
    }
    jbyteArray argb_rotate = env->NewByteArray(size_y * 4);
    unsigned char* argb_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));
    unsigned char* argb_rotate_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb_rotate, 0));

    libyuv::RotationMode mode;
    switch (rotate) {
        case 0:
            mode = libyuv::kRotate0;
            break;
        case 90:
            mode = libyuv::kRotate90;
            width_rotate = height;
            break;
        case 180:
            mode = libyuv::kRotate180;
            break;
        case 270:
            mode = libyuv::kRotate270;
            width_rotate = height;
            break;
        default:
            mode = libyuv::kRotate0;
            break;
    }

    int ret = libyuv::ARGBRotate(
            argb_data, width * 4,
            argb_rotate_data, width_rotate * 4,
            width, height, mode
    );

    env->ReleasePrimitiveArrayCritical(argb, argb_data, 0);
    env->ReleasePrimitiveArrayCritical(argb_rotate, argb_rotate_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return argb_rotate;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_ARGBScale(JNIEnv *env, jclass clazz, jbyteArray argb, jint src_width,
                                    jint src_height, jint dst_width, jint dst_height,
                                    jint scale_mode) {
    jsize len = env->GetArrayLength(argb);
    int dst_size_y = dst_width * dst_height;

    if (len <= 0) {
        return NULL;
    }
    libyuv::FilterMode mode;
    switch (scale_mode) {
        case 0:
            mode = libyuv::kFilterNone;
            break;
        case 1:
            mode = libyuv::kFilterLinear;
            break;
        case 2:
            mode = libyuv::kFilterBilinear;
            break;
        case 3:
            mode = libyuv::kFilterBox;
            break;
        default:
            mode = libyuv::kFilterNone;

    }
    jbyteArray argb_scale = env->NewByteArray(dst_size_y * 4);
    unsigned char* argb_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));
    unsigned char* argb_scale_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb_scale, 0));

    int ret = libyuv::ARGBScale(
            argb_data, src_width * 4,
            src_width, src_height,
            argb_scale_data, dst_width * 4,
            dst_width, dst_height, mode
    );

    env->ReleasePrimitiveArrayCritical(argb, argb_data, 0);
    env->ReleasePrimitiveArrayCritical(argb_scale, argb_scale_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return argb_scale;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_RGBAToI420(JNIEnv *env, jclass clazz, jbyteArray rgba, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(rgba);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);
    if (len <= 0) {
        return NULL;
    }
    jbyteArray i420 = env->NewByteArray(size_y * 4 + size_uv * 2);
    unsigned char* rgba_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(rgba, 0));
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));

    int ret = libyuv::RGBAToI420(
            rgba_data, width * 4,
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(rgba, rgba_data, 0);
    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return i420;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_RGBAToARGB(JNIEnv *env, jclass clazz, jbyteArray rgba, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(rgba);
    int size_y = width * height;
    if (len <= 0) {
        return NULL;
    }
    jbyteArray agbr = env->NewByteArray(size_y * 4);
    unsigned char* rgba_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(rgba, 0));
    unsigned char* agbr_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(agbr, 0));

    int ret = libyuv::RGBAToARGB(
            rgba_data, width * 4,
            agbr_data, width * 4,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(rgba, rgba_data, 0);
    env->ReleasePrimitiveArrayCritical(agbr, agbr_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return agbr;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_RAWToI420(JNIEnv *env, jclass clazz, jbyteArray raw, jint width,
                                    jint height) {
    jsize len = env->GetArrayLength(raw);
    int width_half = width >> 1;
    int size_y = width * height;
    int size_uv = width_half * (height >> 1);

    if (len <= 0) {
        return NULL;
    }
    jbyteArray i420 = env->NewByteArray(size_y * 3 / 2);
    unsigned char* raw_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(raw, 0));
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));

    int ret = libyuv::RAWToI420(
            raw_data, width * 3,
            i420_data, width,
            i420_data + size_y, width_half,
            i420_data + size_y + size_uv, width_half,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(raw, raw_data, 0);
    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return i420;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_RAWToARGB(JNIEnv *env, jclass clazz, jbyteArray raw, jint width,
                                    jint height) {
    jsize len = env->GetArrayLength(raw);
    int size_y = width * height;

    if (len <= 0) {
        return NULL;
    }
    jbyteArray argb = env->NewByteArray(size_y * 4);
    unsigned char* raw_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(raw, 0));
    unsigned char* argb_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));

    int ret = libyuv::RAWToARGB(
            raw_data, width * 3,
            argb_data, width * 4,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(raw, raw_data, 0);
    env->ReleasePrimitiveArrayCritical(argb, argb_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return argb;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_RAWToRGB24(JNIEnv *env, jclass clazz, jbyteArray raw, jint width,
                                     jint height) {
    jsize len = env->GetArrayLength(raw);
    int size_y = width * height;

    if (len <= 0) {
        return NULL;
    }
    jbyteArray rgb24 = env->NewByteArray(size_y * 3);
    unsigned char* raw_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(raw, 0));
    unsigned char* rgb24_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(rgb24, 0));

    int ret = libyuv::RAWToRGB24(
            raw_data, width * 3,
            rgb24_data, width * 3,
            width, height
    );

    env->ReleasePrimitiveArrayCritical(raw, raw_data, 0);
    env->ReleasePrimitiveArrayCritical(rgb24, rgb24_data, 0);

    if (ret != 0) {
        return NULL;
    }
    return rgb24;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_convertToI420(JNIEnv *env, jclass clazz, jbyteArray src, jint src_width,
                                        jint src_height, jint crop_x, jint crop_y, jint crop_width, jint crop_height,
                                        jint rotate, jcharArray src_type) {
    jsize len = env->GetArrayLength(src);
    // 旋转用
    int width_rotate = src_width;
    int height_rotate = src_height;
    if (len <= 0) {
        return NULL;
    }
    // 必须为偶数，否则会有锯齿
    if (crop_x % 2 != 0 || crop_y % 2 != 0) {
        return NULL;
    }
    // 宽高异常
    if (crop_width + crop_x > src_width || crop_height + crop_y > src_height) {
        return NULL;
    }

    // 裁剪操作
    int width_crop = crop_width;
    int height_crop = crop_height;

    // 旋转操作
    libyuv::RotationMode rm;
    switch (rotate) {
        case 0:
            rm = libyuv::kRotate0;
            width_rotate = width_crop;
            height_rotate = height_crop;
            break;
        case 90:
            rm = libyuv::kRotate90;
            width_rotate = height_crop;
            height_rotate = width_crop;
            break;
        case 180:
            rm = libyuv::kRotate180;
            width_rotate = width_crop;
            height_rotate = height_crop;
            break;
        case 270:
            rm = libyuv::kRotate270;
            width_rotate = height_crop;
            height_rotate = width_crop;
            break;
    }
    // 计算旋转后的宽高，及需要的yuv计算
    int width_half = width_rotate >> 1;
    int size_y = width_rotate * height_rotate;
    int size_uv = size_y >> 2;

    int new_len = 3 * (size_y >> 1);
    jbyteArray i420 = env->NewByteArray(new_len);
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned char* src_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(src, 0));
    unsigned char* type_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(src_type, 0));

    int ret = libyuv::ConvertToI420(src_data, len,
                                    i420_data, width_rotate,
                                    i420_data + size_y, width_half,
                                    i420_data + size_y + size_uv, width_half,
                                    crop_x, crop_y,
                                    src_width, src_height,
                                    width_crop, height_crop, rm, FOURCC(type_data[0], type_data[2], type_data[4], type_data[6])
    );

    env->ReleasePrimitiveArrayCritical(src, src_data, 0);
    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);
    env->ReleasePrimitiveArrayCritical(src_type, type_data, 0);

    if (ret != 0) {
        return NULL;
    }

    return i420;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_convertToARGB(JNIEnv *env, jclass clazz, jbyteArray src, jint src_width,
                                        jint src_height, jint crop_x, jint crop_y, jint crop_width,
                                        jint crop_height, jint rotate, jcharArray src_type) {
    jsize len = env->GetArrayLength(src);
    // 旋转用
    int width_rotate = src_width;
    int height_rotate = src_height;
    if (len <= 0) {
        return NULL;
    }
    // 必须为偶数，否则会有锯齿
    if (crop_x % 2 != 0 || crop_y % 2 != 0) {
        return NULL;
    }
    // 宽高异常
    if (crop_width + crop_x > src_width || crop_height + crop_y > src_height) {
        return NULL;
    }

    // 裁剪操作
    int width_crop = crop_width;
    int height_crop = crop_height;

    // 旋转操作
    libyuv::RotationMode rm;
    switch (rotate) {
        case 0:
            rm = libyuv::kRotate0;
            width_rotate = width_crop;
            height_rotate = height_crop;
            break;
        case 90:
            rm = libyuv::kRotate90;
            width_rotate = height_crop;
            height_rotate = width_crop;
            break;
        case 180:
            rm = libyuv::kRotate180;
            width_rotate = width_crop;
            height_rotate = height_crop;
            break;
        case 270:
            rm = libyuv::kRotate270;
            width_rotate = height_crop;
            height_rotate = width_crop;
            break;
    }
    // 计算旋转后的宽高，及需要的yuv计算
    int size_y = width_rotate * height_rotate;

    int new_len = 4 * size_y;
    jbyteArray argb = env->NewByteArray(new_len);
    unsigned char* argb_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(argb, 0));
    unsigned char* src_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(src, 0));
    unsigned char* type_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(src_type, 0));

    int ret = libyuv::ConvertToARGB(src_data, len,
                                argb_data, width_rotate * 4,
                                crop_x, crop_y,
                                src_width, src_height,
                                width_crop, height_crop,
                                rm, FOURCC(type_data[0], type_data[2], type_data[4], type_data[6])
    );

    env->ReleasePrimitiveArrayCritical(src, src_data, 0);
    env->ReleasePrimitiveArrayCritical(argb, argb_data, 0);
    env->ReleasePrimitiveArrayCritical(src_type, type_data, 0);

    if (ret != 0) {
        return NULL;
    }

    return argb;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_yuv_tool_YuvTool_convertFromI420(JNIEnv *env, jclass clazz, jbyteArray i420,
                                          jint i420_width, jint i420_height, jlong dst_len,
                                          jint dst_stride_width,
                                          jcharArray dst_type) {
    jsize len = env->GetArrayLength(i420);
    int width_half = i420_width >> 1;
    int size_y = i420_width * i420_height;
    int size_uv = size_y >> 2;

    if (len <= 0) {
        return NULL;
    }

    jbyteArray dst = env->NewByteArray(dst_len);
    unsigned char* i420_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(i420, 0));
    unsigned char* dst_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(dst, 0));
    unsigned char* type_data = static_cast<unsigned char *>(env->GetPrimitiveArrayCritical(dst_type, 0));

    int ret = libyuv::ConvertFromI420(i420_data, i420_width,
                            i420_data + size_y, width_half,
                            i420_data + size_y + size_uv, width_half,
                            dst_data, dst_stride_width, i420_width, i420_height,
                            FOURCC(type_data[0], type_data[2], type_data[4], type_data[6])
    );

    env->ReleasePrimitiveArrayCritical(i420, i420_data, 0);
    env->ReleasePrimitiveArrayCritical(dst, dst_data, 0);
    env->ReleasePrimitiveArrayCritical(dst_type, type_data, 0);

    if (ret != 0) {
        return NULL;
    }

    return dst;
}