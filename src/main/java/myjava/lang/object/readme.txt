简介：
Class 是类层次结构的根。// *每个类都有Object作为超类。所有的对象，包括数组，实现这个类的方法


java.lang.Object中一共有五个本地方法，

包括hashCode，wait，notify，notifyAll和clone，ObjectSynchronizer就是前4个本地方法的底层实现


Object类有12个成员方法，按照用途可以分为以下几种

1. 构造函数

2. hashCode和equals函数判断对象是否相同,

3. wait(),wait(long),wait(long,int),notify(),notifyAll()

4. toString()和getClass,

5. clone()克隆

6. finalize()用于在垃圾回收



热点问题：

在日常工作中会重写Object类哪些方法？

为什么重写equals一定要重写hashcode？

深clone和浅clone说下你的认识？

wait和notify为什么要定义在Object中，wait和notify是怎么使用的？

Object.wait()和Thread.sleep()的区别？


