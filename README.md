Yuv-tool
--------

## 支持
用于android中的libyuv所有功能，在yuv、rgb之间的转换工具。

- [ ] Android实时转换查看

- [x] 支持架构: armeabi-v7a, arm64-v8a, x86, x86_64

- [ ] 加速SIMD指令

- [x] 当前支持以下格式转换方式：

    |  原始格式  |  转码格式  |
    | --------- | --------- |
    |NV21       | I420      |
    |NV21       | ARGB      |
    |NV21       | RGB565      |
    |NV12       | I420      |
    |NV12       | I420(旋转)      |
    |NV12       | ARGB      |
    |NV12       | RGB565      |
    |I420       | I420      |
    |I420       | NV21      |
    |I420       | NV12      |
    |I420       | ARGB      |
    |I420       | RGB565      |


## 代码

直接使用即可
```java
        YuvTool.xxx();
```