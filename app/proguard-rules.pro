# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-dontwarn com.xiaomi.mipush.sdk.**
-keep public class com.xiaomi.mipush.sdk.* {*; }
-keep public class com.google.firebase.* {*;}
#-keep public class com.tqxd.guard.support.entity.* {*;}
-keepclasseswithmembernames class * { # 保持 native 方法不被混淆
native <methods>;
}
-keep public class com.tencent.aai.*
-keep public class com.qq.wx.voice.*