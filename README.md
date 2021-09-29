Complete Yuv-tool
-----------------
[![](https://jitpack.io/v/Yangandmore/yuv-tool.svg)](https://jitpack.io/#Yangandmore/yuv-tool)


[中文文档]<https://github.com/Yangandmore/yuv-tool/blob/master/README-CN.md>

## Support
It is used for all functions of libyuv in Android, and the conversion tool between YUV and RGB.
***Note: the libyuv library that this library depends on is not a public version library. The dependent library connections are as follows：***
[libyuv]<https://github.com/Yangandmore/libyuv_original>

- [ ] Android Online conversion

- [x] Support architecture: armeabi-v7a, arm64-v8a, x86, x86_64

- [ ] compare.h
- [x] convert.h
- [ ] convert_argb.h
- [ ] convert_from.h
- [ ] convert_from_argb.h
- [ ] planar_functions.h
- [ ] rotate.h
- [ ] rotate_argb.h
- [ ] scale.h
- [ ] scale_argb.h
- [ ] version.h

- [x] Currently supported formats：

    |  src format  |  dst format  |  test  |
    | --------- | --------- | ----- |
    |NV21       | I420      |  success  |
    |NV21       | ARGB      |  success  |
    |NV21       | RGB565    |  success  |

    |  src format  |  dst format  |  test  |
    | --------- | --------- | ----- |
    |NV12       | I420      |  success  |
    |NV12       | I420 |  success  |
    |NV12       | ARGB      |  success  |
    |NV12       | RGB565    |  success  |

    |  src format  |  dst format  |  test  |
    | --------- | --------- | ----- |
    |I420       | I420      |  success  |
    |I420       | NV21      |  success  |
    |I420       | NV12      |  success  |
    |I420       | ARGB      |  success  |
    |I420       | ARGB4444  |  success  |
    |I420       | RGB565    |  success  |
    |I420       | I400      |  success  |
    |I420       | I411      |  success  |
    |I420       | I422      | success  |
    |I420       | I444      |  success  |
    |I420       | UYVY      |  success  |
    |I420       | RGBA      |  success  |
    |I420       | BGRA      |  success  |
    |I420       | RGB24     |  success  |
    |I420       | ABGR      |  success  |
    |I420       | ABGR1555  | 完成  |
    |I420       | YUY2(YUYV)|  success  |
    |I420       |    raw    | success  |
    |I420       | copy | success  |
    |I420       | mirror | success  |
    |I420       | rotate | success  |
    |I420       | scale | success  |
    |I420       | scale_16(short) | success  |
    |I420       |    Psnr    | success  |
    |I420       |    Ssim    | success  |
    |I420       |    Rect    | NoTest  |

    |  src format  |  dst format  |  test  |
    | --------- | --------- | ----- |
    |I444       | I420      |  success  |
    |I444       | ARGB      |  success  |
    |I444       | ABGR      |  success  |

    |  src format  |  dst format  |  test  |
    | --------- | --------- | ----- |
    |I422       | I420      |  success  |
    |I422       | ABGR      |  success  |
    |I422       | BGRA      |  success  |
    |I422       | RGBA      |  success  |
    |I422       | ARGB      |  success  |
    |I422       | UYVY      |  success  |
    |I422       | YUY2      |  success  |

    |  src format  |  dst format  |  test  |
    | --------- | --------- | ----- |
    |I400       | I420      |  success  |
    |I400       | ARGB      |  success  |
    |I400       | mirror      |  success  |

    |  src format  |  dst format  |  test  |
    | --------- | --------- | ----- |
    |YUY2       | I420      |  success  |
    |YUY2       | I422      |  success  |
    |YUY2       | NV12      |  success  |
    |YUY2       | Y         |  success  |
    |YUY2       | ARGB      |  success  |

    |  src format  |  dst format  |  test  |
    | --------- | --------- | ----- |
    |UYVY       | I420      |  success  |
    |UYVY       | I422      |  success  |
    |UYVY       | NV12      |  success  |
    |UYVY       | ARGB      |  success  |

    |  src format  |  dst format  |  test  |
    | --------- | --------- | ----- |
    |RGB24       |    I420    | success  |
    |RGB24       |    ARGB    | success  |

    |  src format  |  dst format  |  test  |
    | --------- | --------- | ----- |
    |RGB565       |    I420    | success  |
    |RGB565       |    ARGB    | success  |

    |  src format  |  dst format  |  test  |
    | --------- | --------- | ----- |
    |ABGR       |    I420    | success  |
    |ABGR       |    ARGB    | success  |

    |  src format  |  dst format  |  test  |
    | --------- | --------- | ----- |
    |ARGB       |    NV21    | success  |
    |ARGB       |    NV12    | success  |
    |ARGB       |    YUY2    | success  |
    |ARGB       |    UYVY    | success  |
    |ARGB       |    I420    | success  |
    |ARGB       |    I400    | success  |
    |ARGB       |    I411    | success  |
    |ARGB       |    I422    | success  |
    |ARGB       |    I444    | success  |
    |ARGB       |    ABGR    | success  |
    |ARGB       |    BGRA    | success  |
    |ARGB       |    RGBA    | success  |
    |ARGB       |    RGB24    | success  |
    |ARGB       |    RGB565    | success  |
    |ARGB       |    ARGB1555    | success  |
    |ARGB       |    ARGB4444    |  success  |
    |ARGB       |    J400    | success  |
    |ARGB       |    J420    | success  |
    |ARGB       |    J422    | success  |
    |ARGB       |    copy    | success  |
    |ARGB       |    mirror    | success  |
    |ARGB       |    rotate    | success  |
    |ARGB       |    scale    | success  |

    |  src format  |  dst format  |  test  |
    | --------- | --------- | ----- |
    |BGRA       | I420      | success|
    |BGRA       | ARGB      | success|

    |  src format  |  dst format  |  test  |
    | --------- | --------- | ----- |
    |ARGB4444   | I420      | success|
    |ARGB4444   | ARGB      | success|

    |  src format  |  dst format  |  test  |
    | --------- | --------- | ----- |
    |RGBA       | I420      | success|
    |RGBA       | ARGB      | success|

    |  src format  |  dst format  |  test  |
    | --------- | --------- | ----- |
    |ARGB1555   | I420      | success|
    |ARGB1555   | ARGB      | success|

    |  src format  |  dst format |  test  |
    | --------- | ---------  | ----- |
    |RAW       | I420      | success|
    |RAW       | ARGB      | success|
    |RAW       | RGB24      | success|

    |  src format  |  dst format | function  |  test  |
    | --------- | ---------  | ----- | ----- |
    |XXXX       | I420      | crop、scale | success|
    |XXXX       | ARGB      | crop、scale | success|


    |  src format  |  dst format |  test  |
    | --------- | ---------  | ----- |
    |I420       | xxxx      | success|

## Coding

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

```java
YuvTool.xxx();
```