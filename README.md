Complete Yuv-tool
-----------------
[![](https://jitpack.io/v/Yangandmore/yuv-tool.svg)](https://jitpack.io/#Yangandmore/yuv-tool)


[中文文档]<https://github.com/Yangandmore/yuv-tool/blob/master/README-CN.md>

## Support
It is used for all functions of libyuv in Android, and the conversion tool between YUV and RGB.
***Note: the libyuv library that this library depends on is not a public version library. The dependent library connections are as follows：***

- [ ] Android Online conversion

- [x] Support architecture: armeabi-v7a, arm64-v8a, x86, x86_64

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
    |I420       | ARGB4444  |  fail  |
    |I420       | RGB565    |  success  |
    |I420       | I400      |  success  |
    |I420       | I411      |  false  |
    |I420       | I422      | success  |
    |I420       | I444      |  success  |
    |I420       | UYVY      |  success  |
    |I420       | RGBA      |  success  |
    |I420       | BGRA      |  success  |
    |I420       | RGB24     |  success  |
    |I420       | ABGR      |  success  |
    |I420       | ABGR1555  | fail  |
    |I420       | YUY2(YUYV)|  success  |
    |I420       |    raw    | fail  |
    |I420       | copy | success  |
    |I420       | mirror | success  |
    |I420       | rotate | success  |
    |I420       | scale | success  |
    |I420       | scale_16(short) | success  |
    |I420       |    Psnr    | success  |
    |I420       |    Ssim    | success  |
    |I420       |    Rect    | fail  |

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
    |ARGB       |    I411    | false  |
    |ARGB       |    I422    | success  |
    |ARGB       |    I444    | success  |
    |ARGB       |    ABGR    | success  |
    |ARGB       |    BGRA    | success  |
    |ARGB       |    RGBA    | success  |
    |ARGB       |    RGB24    | success  |
    |ARGB       |    RGB565    | success  |
    |ARGB       |    ARGB1555    | fail  |
    |ARGB       |    ARGB4444    |  fail  |
    |ARGB       |    copy    | success  |
    |ARGB       |    mirror    | success  |
    |ARGB       |    rotate    | success  |
    |ARGB       |    scale    | success  |

    |  src format  |  dst format  |  test  |
    | --------- | --------- | ----- |
    |RGBA       | I420      | success|
    |RGBA       | ARGB      | success|

    |  src format  |  dst format | function  |  test  |
    | --------- | ---------  | ----- | ----- |
    |XXXX       | I420      | crop、scale | success|
    |XXXX       | ARGB      | crop、scale | success|


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