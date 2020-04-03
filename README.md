<div align="center">
   <img width="160" src="http://img.mamoe.net/2020/02/16/a759783b42f72.png" alt="logo"></br>

   <img width="95" src="http://img.mamoe.net/2020/02/16/c4aece361224d.png" alt="title">

----

[![Gitter](https://badges.gitter.im/mamoe/mirai.svg)](https://gitter.im/mamoe/mirai?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)
![Gradle CI](https://github.com/mamoe/mirai-console/workflows/Gradle%20CI/badge.svg?branch=master)
[![Download](https://api.bintray.com/packages/him188moe/mirai/mirai-console/images/download.svg)](https://bintray.com/him188moe/mirai/mirai-console/)  

Mirai 是一个在全平台下运行，提供 QQ Android 和 TIM PC 协议支持的高效率机器人框架

这个项目的名字来源于
     <p><a href = "http://www.kyotoanimation.co.jp/">京都动画</a>作品<a href = "https://zh.moegirl.org/zh-hans/%E5%A2%83%E7%95%8C%E7%9A%84%E5%BD%BC%E6%96%B9">《境界的彼方》</a>的<a href = "https://zh.moegirl.org/zh-hans/%E6%A0%97%E5%B1%B1%E6%9C%AA%E6%9D%A5">栗山未来(Kuriyama <b>Mirai</b>)</a></p>
     <p><a href = "https://www.crypton.co.jp/">CRYPTON</a>以<a href = "https://www.crypton.co.jp/miku_eng">初音未来</a>为代表的创作与活动<a href = "https://magicalmirai.com/2019/index_en.html">(Magical <b>Mirai</b>)</a></p>
图标以及形象由画师<a href = "">DazeCake</a>绘制
</div>

# mirai-console 
高效率插件支持机器人框架

### 插件开发与获取
[插件中心](https://github.com/mamoe/mirai-plugins) <br>
[mirai-console插件开发快速上手](PluginDocs/ToStart.MD) 

### 使用
**[下载(download)](https://github.com/mamoe/mirai-console/releases)**  
请下载最新的 `mirai-console-wrapper-x.x.x-all.jar`

#### 如何启动
如果是打包好的软件, 双击<br>
如果是命令行运行, 请注意运行目录, 推荐cd到jar的文件夹下运行, 运行目录与Console的全部配置文件储存位置有关
#### 如何添加插件
如果是打包好的软件, 请根据UI操作<br>
如果是命令行运行, 请将插件放入 **运行目录/plugins** 下
#### 如何更改插件配置
如果是打包好的软件, 请根据UI操作<br>
如果是命令行运行, 插件的所有配置文件将出现在 **运行目录/plugins/插件名** 下，推荐在mirai-console关闭时修改
#### 如何选择版本
Mirai Console 提供了6个版本以满足各种需要<br>
所有版本的 Mirai Console API 相同 插件系统相同<br>
|  名称    | 介绍 |
| --- | --- |
| Mirai-Console-Pure  |  最纯净版, CLI环境, 通过标准输入与标准输出 交互 |
| Mirai-Console-Terminal  |  (UNIX)Terminal环境 提供简洁的富文本控制台 |
| Mirai-Console-Android   |  安卓APP (TODO) |
| Mirai-Console-Graphical  |  JavaFX的图形化界面 (.jar/.exe/.dmg) |
| Mirai-Console-WebPanel  |   Web Panel操作(TODO) |
| Mirai-Console-Ios   |  IOS APP (TODO) |

1:  Mirai-Console-Pure 兼容性最高, 在其他都表现不佳的时候请使用</br>
2:  以系统区分
```kotlin
    return when(operatingSystem){
        WINDOWS -> listOf("Graphical","WebPanel","Pure")
        MAC_OS  -> listOf("Graphical","Terminal","WebPanel","Pure") 
        LINUX   -> listOf("Terminal","Pure")
        ANDROID -> listOf("Android","Pure","WebPanel") 
        IOS     -> listOf("Ios") 
        else    -> listOf("Pure") 
    }      
```
3: 以策略区分
```kotlin
    return when(task){
        体验         -> listOf("Graphical","Terminal","WebPanel","Android","Pure")
        测试插件      -> listOf("Pure") 
        调试插件      -> byOperatingSystem() 
        稳定挂机      -> listOf("Terminal","Pure") 
        else         -> listOf("Pure") 
    }      
``` 
----

