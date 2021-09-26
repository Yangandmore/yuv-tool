完整的 Yuv-tool
------------
[![](https://jitpack.io/v/Yangandmore/yuv-tool.svg)](https://jitpack.io/#Yangandmore/yuv-tool)

## 支持
用于android中的libyuv所有功能，在yuv、rgb等之间的转换工具。尽量满足内部所有函数的清晰使用。
***注意：此库所依赖的libyuv库并非公版库，依赖库连接如下：***
[libyuv]<https://github.com/Yangandmore/libyuv_original>

- [ ] Android实时转换查看

- [x] 支持架构: armeabi-v7a, arm64-v8a, x86, x86_64

- [ ] compare.h
- [ ] convert.h
- [ ] convert_argb.h
- [ ] convert_from.h
- [ ] convert_from_argb.h
- [ ] planar_functions.h
- [ ] rotate.h
- [ ] rotate_argb.h
- [ ] scale.h
- [ ] scale_argb.h
- [ ] version.h

- [x] 当前支持以下格式转换方式：

    |  原始格式  |  转码格式  |  测试  |
    | --------- | --------- | ----- |
    |NV21       | I420      |  完成  |
    |NV21       | ARGB      |  完成  |
    |NV21       | RGB565    |  完成  |

    |  原始格式  |  转码格式  |  测试  |
    | --------- | --------- | ----- |
    |NV12       | I420      |  完成  |
    |NV12       | I420(旋转) |  完成  |
    |NV12       | ARGB      |  完成  |
    |NV12       | RGB565    |  完成  |

    |  原始格式  |  转码格式  |  测试  |
    | --------- | --------- | ----- |
    |I420       | I420      |  完成  |
    |I420       | NV21      |  完成  |
    |I420       | NV12      |  完成  |
    |I420       | ARGB      |  完成  |
    |I420       | ARGB4444  |  完成  |
    |I420       | RGB565    |  完成  |
    |I420       | I400      |  完成  |
    |I420       | I411      |  完成  |
    |I420       | I422      |  完成  |
    |I420       | I444      |  完成  |
    |I420       | UYVY      |  完成  |
    |I420       | RGBA      |  完成  |
    |I420       | BGRA      |  完成  |
    |I420       | RGB24     |  完成  |
    |I420       | ABGR      |  完成  |
    |I420       | ABGR1555  | 无法测试  |
    |I420       | YUY2(YUYV)|  完成  |
    |I420       |    raw    | 完成  |
    |I420       | copy(复制) | 完成  |
    |I420       | mirror(镜像) | 完成  |
    |I420       | rotate(旋转) | 完成  |
    |I420       | scale(缩放) | 完成  |
    |I420       | scale_16(缩放) | 完成  |
    |I420       |    Psnr计算    | 完成  |
    |I420       |    Ssim计算    | 完成  |
    |I420       |    Rect    | 无法测试  |
    
    |  原始格式  |  转码格式  |  测试  |
    | --------- | --------- | ----- |
    |I444       | I420      |  完成  |
    |I444       | ARGB      |  完成  |
    |I444       | ABGR      |  完成  |

    |  原始格式  |  转码格式  |  测试  |
    | --------- | --------- | ----- |
    |I422       | I420      |  完成  |
    |I422       | ABGR      |  完成  |
    |I422       | BGRA      |  完成  |
    |I422       | RGBA      |  完成  |
    |I422       | ARGB      |  完成  |
    |I422       | UYVY      |  完成  |
    |I422       | YUY2      |  完成  |

    |  原始格式  |  转码格式  |  测试  |
    | --------- | --------- | ----- |
    |I400       | I420      |  完成  |
    |I400       | ARGB      |  完成  |
    |I400       | mirror      |  完成  |

    |  原始格式  |  转码格式  |  测试  |
    | --------- | --------- | ----- |
    |YUY2       | I420      |  完成  |
    |YUY2       | I422      |  完成  |
    |YUY2       | NV12      |  完成  |
    |YUY2       | Y         |  完成  |
    |YUY2       | ARGB      |  完成  |
    
    |  原始格式  |  转码格式  |  测试  |
    | --------- | --------- | ----- |
    |UYVY       | I420      |  完成  |
    |UYVY       | I422      |  完成  |
    |UYVY       | NV12      |  完成  |
    |UYVY       | ARGB      |  完成  |

    |  原始格式  |  转码格式  |  测试  |
    | --------- | --------- | ----- |
    |RGB24       |    I420    | 完成  |
    |RGB24       |    ARGB    | 完成  |

    |  原始格式  |  转码格式  |  测试  |
    | --------- | --------- | ----- |
    |RGB565       |    I420    | 完成  |
    |RGB565       |    ARGB    | 完成  |

    |  原始格式  |  转码格式  |  测试  |
    | --------- | --------- | ----- |
    |ABGR       |    I420    | 完成  |
    |ABGR       |    ARGB    | 完成  |

    |  原始格式  |  转码格式  |  测试  |
    | --------- | --------- | ----- |
    |ARGB       |    NV21    | 完成  |
    |ARGB       |    NV12    | 完成  |
    |ARGB       |    YUY2    | 完成  |
    |ARGB       |    UYVY    | 完成  |
    |ARGB       |    I420    | 完成  |
    |ARGB       |    I400    | 完成  |
    |ARGB       |    I411    | 完成  |
    |ARGB       |    I422    | 完成  |
    |ARGB       |    I444    | 完成  |
    |ARGB       |    ABGR    | 完成  |
    |ARGB       |    BGRA    | 完成  |
    |ARGB       |    RGBA    | 完成  |
    |ARGB       |    RGB24    | 完成  |
    |ARGB       |    RGB565    | 完成  |
    |ARGB       |    ARGB1555    | 无法测试  |
    |ARGB       |    ARGB4444    | 完成  |
    |ARGB       |    copy(复制)    | 完成  |
    |ARGB       |    mirror(镜像)    | 完成  |
    |ARGB       |    rotate(旋转)    | 完成  |
    |ARGB       |    scale(缩放)    | 完成  |

    |  原始格式  |  转码格式  |  测试  |
    | --------- | --------- | ----- |
    |ARGB4444   | I420      | 完成|
    |ARGB4444   | ARGB      | 完成|

    |  原始格式  |  转码格式  |  测试  |
    | --------- | --------- | ----- |
    |RGBA       | I420      | 完成|
    |RGBA       | ARGB      | 完成|

    |  原始格式  |  转码格式  |  测试  |
    | --------- | --------- | ----- |
    |RAW       | I420      | 完成|
    |RAW       | ARGB      | 完成|
    |RAW       | RGB24      | 完成|

    |  原始格式  |  转码格式 |  功能  |  测试  |
    | --------- | -------- | ----- | ----- |
    |XXXX       | I420     | 裁剪、旋转  | 完成|
    |XXXX       | ARGB     | 裁剪、旋转  | 完成|

    |  原始格式  |  转码格式 |  功能  |  测试  |
    | --------- | ---------  | ----- |
    |I420       | xxxx      | 完成|

## 代码

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

...

dependencies {
        implementation 'com.github.Yangandmore:yuv-tool:1.0'
}
```

直接使用即可
```java
        YuvTool.xxx();
```