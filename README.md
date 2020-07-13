Yuv-tool
--------

## 支持
用于android中的libyuv所有功能，在yuv、rgb之间的转换工具。

- [ ] Android实时转换查看

- [x] 支持架构: armeabi-v7a, arm64-v8a, x86, x86_64

- [ ] 加速SIMD指令

- [x] 当前支持以下格式转换方式：

    |  原始格式  |  转码格式  |  测试  |
    | --------- | --------- | ----- |
    |NV21       | I420      |  完成  |
    |NV21       | ARGB      |  完成  |
    |NV21       | RGB565    |  完成  |
    |NV12       | I420      |  完成  |
    |NV12       | I420(旋转) |  完成  |
    |NV12       | ARGB      |  完成  |
    |NV12       | RGB565    |  完成  |
    |I420       | I420      |  完成  |
    |I420       | NV21      |  完成  |
    |I420       | NV12      |  完成  |
    |I420       | ARGB      |  完成  |
    |I420       | ARGB4444  |  完成  |
    |I420       | RGB565    |  完成  |
    |I420       | I400      |  完成  |
    |I420       | I411      |  完成  |
    |I420       | I422      | 未完成  |
    |I420       | I444      |  完成  |
    |I420       | UYVY      |  完成  |
    |I420       | RGBA      |  完成  |
    |I420       | BGRA      |  完成  |
    |I420       | RGB24     |  完成  |
    |I420       | ABGR      |  完成  |
    |I420       | ABGR1555  | 未完成  |


## 代码

直接使用即可
```java
        YuvTool.xxx();
```