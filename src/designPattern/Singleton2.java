package designPattern;

public class Singleton2 {
    //饿汉式
    private static final Singleton2 INSTANCE2;
    private Singleton2(){

    }

    static  {
        INSTANCE2 = new Singleton2();
    }

    public static final Singleton2 getInstance (){
        return INSTANCE2;
    }
}
