package com.whq.mvc.base.designpattern.singleton;

/**
 * @Description: 单例模式 双重检验锁
 * 这里的volatile不是为了保证可见性，是为了防止指令重拍，instance = new SingletonTest2()非原子操作 包含
 *  给 instance 分配内存
 * 调用 SingletonTest2 的构造函数来初始化成员变量
 * 将instance对象指向分配的内存空间（执行完这步 instance 就为非 null 了）
 * 但是在 JVM 的即时编译器中存在指令重排序的优化。也就是说上面的第二步和第三步的顺序是不能保证的，
 * 最终的执行顺序可能是 1-2-3 也可能是 1-3-2。如果是后者，则在 3 执行完毕、2 未执行之前，被线程二抢占了，
 * 这时 instance 已经是非 null 了（但却没有初始化），所以线程二会直接返回 instance，然后使用，然后顺理成章地报错。
 *  注意，j Java 5 以前的版本使用了 volatile 的双检锁还是有问题的。其原因是 Java 5 以前的 JMM （Java 内存模型）是存在缺陷的，
 * 即时将变量声明成 volatile 也不能完全避免重排序，主要是 volatile 变量前后的代码仍然存在重排序问题。
 * 这个 volatile 屏蔽重排序的问题在 Java 5 中才得以修复，所以在这之后才可以放心使用 volatile。
 * @Author: whq
 * @Date: 2021/9/8 9:36
 */
public class SingletonTest2 {

    private volatile static SingletonTest2 instance;

    private SingletonTest2(){}

    public static SingletonTest2 getInstance(){
        if (null == instance){
            synchronized (SingletonTest2.class){
                if (null == instance){
                    instance = new SingletonTest2();
                }
            }
        }
        return instance;
    }
}
