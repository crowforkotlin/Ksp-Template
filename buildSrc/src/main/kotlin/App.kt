@file:Suppress("ConstPropertyName", "MemberVisibilityCanBePrivate")

/*************************
 * @Machine: RedmiBook Pro 15
 * @RelativePath: Configuration.kt
 * @Path: D:\Barry\B_study\Android\Android_Project\JetpackApp\buildSrc\src\main\kotlin\Configuration.kt
 * @Author: CrowForKotlin
 * @Time: 2022/5/6 9:18 周五 上午
 * @Description: 项目配置 应用配置
 * @formatter:on
 *************************/
object App {

    // 包名前缀
    private const val packageGroup = "com.crow"
    private const val packageName = "ksp"

    // 应用ID
    const val applicationId = "${packageGroup}.${packageName}.template"

    // 命名空间
    const val namespaceApp = applicationId
    const val namespaceApi = "${packageGroup}.${packageName}.api"

    // 编译SDK版本 Android 13 T
    const val compileSdkVersion = 34

    // 编译工具版本
    const val buildToolsVersion = "34.0.0"

    // 最小支持版本 Android 6
    const val minSdkVersion = 23

    // 目标支持版本 Android 13 T
    const val targetSdkVersion = 33

    const val versionCode = 1
    const val versionName = "1.0"
    const val jvmTarget = "1.8"
    const val ndkVersion = "23.2.8568313"

    // Android 提供的默认测试工具
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    // 一个默认的 ProGuard 规则文件，该文件包含了 Android 平台的优化规则
    const val proguardAndroidOptimizeTxt = "proguard-android-optimize.txt"

    // 自定义的 ProGuard 规则文件
    const val proguardRulesPro = "proguard-rules.pro"
    const val consumerRulesPro = "consumer-rules.pro"

    // 指定名为version 的维度 （一个抽象的概念）表示应用程序的不同版本
    const val flavor_dimension = "version"

    // 指定编译器的命令行参数 启用额外功能 (ContextReceiver)
    val free_compile_args = listOf("-Xcontext-receivers")
}