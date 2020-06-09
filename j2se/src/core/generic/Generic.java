package core.generic;

import java.util.ArrayList;
import java.util.List;

public class Generic {
    public static void main(String[] args) {
        ObjectTool<String> stringObjectTool = new ObjectTool<>();
        stringObjectTool.setObj("baba");
        System.out.println(stringObjectTool.getObj());

        ObjectTool<Long> integerObjectTool = new ObjectTool<>();
        integerObjectTool.setObj(100000l);
        System.out.println(integerObjectTool.getObj());

        ObjectTool objectTool = new ObjectTool();
        System.out.println(objectTool.show(2345).toString());

        ArrayList<Integer> integers = new ArrayList<>(5);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        test(integers);

    }

    private static void test(List<? extends Number> list) {
        for (int i = 0;i < list.size(); i ++) {
            System.out.println(list.get(i));
        }
    }

}

/**
 * 泛型类
 * @param <T>
 */
class ObjectTool<T> {
    @Override
    public String toString() {
        return "ObjectTool{" +
                "obj=" + obj +
                '}';
    }

    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public <T> ObjectTool<T> show(T t) {
        System.out.println(t);
        return new ObjectTool<>();
    }

}

interface Inter<T> {
    T get();
}

class InterImpl implements Inter<String> {

    @Override
    public String get() {
        return null;
    }
}
