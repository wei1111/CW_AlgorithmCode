package designPattern;

public class Singleton2 {
    //饿汉式

    private static final Singleton2 INSTANCE2;
    private Singleton2(){

    }

    //通过静态内部类使用时在加载的原理
    static  {
        INSTANCE2 = new Singleton2();
    }

    public static final Singleton2 getInstance (){
        return INSTANCE2;
    }
}
