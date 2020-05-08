package core.collection;
//default 关键字使用说明

//一.调用父接口的默认方法
//1.创建接口 interface1，并且在接口 Interface1 中定义默认方法 helloWorld()
interface Interface1
{
    default void helloWorld() {
        System.out.println("hello-world===print from interface1");
    }
}
//2.编写一个实现 Interface1 接口的类 Interface1Impl，并且调用接口中定义的默认方法 helloWorld()
class Interface1Impl implements Interface1
{
    public static void main(String[] args) {
        Interface1Impl i = new Interface1Impl();
        i.helloWorld();
    }
}

//二.同时实现两个接口
//1.创建接口 Interface2，接口 Interface2 中也定义了默认方法 helloWorld().
interface Interface2
{
    default void helloWorld() {
        System.out.println("hello-world===print from interface2");
    }
}
//创建一个同时实现 Interface1 和 Interface2 的类
class Interface12Impl implements Interface1, Interface2
{
    public static void main(String[] args) {
        Interface12Impl i = new Interface12Impl();
        i.helloWorld();
    }

    @Override
    public void helloWorld() {
        System.out.println("hello-world===print from class implements Interface1, Interface2");
    }
}

//三.类优先于接口
//1.创建一个继承了 Interface12Impl 并且实现了 Interface2 接口的类 ExtendsInterface12ImplImplementsInterface2
//并且调用 helloWorld 方法 ==》 调用继承类中的方法

class ExtendsInterface12ImplImplementsInterface2 extends Interface12Impl implements Interface2
{
    public static void main(String[] args) {
        ExtendsInterface12ImplImplementsInterface2 e = new ExtendsInterface12ImplImplementsInterface2();
        e.helloWorld();
    }
}

public class defaultDemo {
}
