package designPattern;

public class Singleton1 {
    //懒汉式LazyHolder Singleton 调用static类型的getInstance方法后才得到对象实体
    private Singleton1(){

    }

    //通过静态内部类使用时在加载的原理
    public static class SingletonHolder {
        private static final Singleton1 INSTANCE = new Singleton1();
    }

    public static final Singleton1 getInstance (){
        return SingletonHolder.INSTANCE;
    }
}
