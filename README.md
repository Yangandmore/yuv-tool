Complete Yuv-tool
-----------------

[中文文档]<https://github.com/Yangandmore/yuv-tool/blob/master/README-CN.md>

## Support
It is used for all functions of libyuv in Android, and the conversion tool between YUV and RGB.

- [ ] Android Online conversion

- [x] Support architecture: armeabi-v7a, arm64-v8a, x86, x86_64

- [ ] SIMD

- [x] Currently supported formats：

    |  src format  |  dst format  |  test  |
    | --------- | --------- | ----- |
    |NV21       | I420      |  success  |
    |NV21       | ARGB      |  success  |
    |NV21       | RGB565    |  success  |
    |NV12       | I420      |  success  |
    |NV12       | I420 |  success  |
    |NV12       | ARGB      |  success  |
    |NV12       | RGB565    |  success  |
    |I420       | I420      |  success  |
    |I420       | NV21      |  success  |
    |I420       | NV12      |  success  |
    |I420       | ARGB      |  success  |
    |I420       | ARGB4444  |  success  |
    |I420       | RGB565    |  success  |
    |I420       | I400      |  success  |
    |I420       | I411      |  success  |
    |I420       | I422      | fail  |
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



## coding


```java
YuvTool.xxx();
```