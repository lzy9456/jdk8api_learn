package myjava.lang.object;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author _lizy
 * @version 1.0
 * @description ObjectTest
 * @date 2020/10/12 16:39
 */
//@Slf4j
public class ObjectTest {
    public static void main(String[] args) {

        equals_MT();
        hashcode_MT();
    }



    /**
     * @Description
     *      1. 为什么重写equals？
     *      2. 为何重写equals方法就得重写hashCode方法？
     *      3. 怎样重写equals？
     *
     * 1. Object.equals() 默认实现是返回this == obj，比较的是引用地址是否相等，有时候我们想要的是比较对象的值是否相等
     * 2. 重写了equals()，说明有自己需要的比值需求，不重写hashcode有可能出现无法预料的错误；
     *  Object.hashcode()默认实现，每个对象返回都不相同，不能保证"相同对象必须有相同哈希值"这一约定，会造成使用这一约定设计的类（如hashmap集合等），出现预料之外的结果
     *  equals() java doc注释中的大致意思是：当我们将equals方法重写后有必要将hashCode方法也重写，这样做才能保证不违背hashCode方法中“相同对象必须有相同哈希值”的约定
     * 3. 自反性、对称性、传递性、一致性
     */
    private static void equals_MT() {
        TestBean t1 = new TestBean();
        t1.id = "1";
        TestBean t2 = new TestBean();
        t2.id = "1";
        System.out.println("已重写hashcode()对象比较:"+(t1.equals(t2)));

        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(t1, t1);
        hashMap.put(t2, t2);




        TestBean3 t3 = new TestBean3();
        t1.id = "1";
        TestBean3 t4 = new TestBean3();
        t2.id = "1";
        System.out.println("未重写hashcode()对象比较:"+(t3.equals(t4)));


        Map hashMap2 = new HashMap<>();
        hashMap2.put(t3, t1);
        hashMap2.put(t4, t2);


        hashMap.forEach((key, value) -> {
            System.out.println("已重写equals()，hashcode()对象:"+"Key = " + key + "  " + " Value = " + value);
        });

        hashMap2.forEach((key, value) -> {
            System.out.println("未重写equals()，hashcode()对象:"+"Key = " + key + "  " + " Value = " + value);
        });
    }

    /**
     * @Description
     *      1. 为什么重写equals？
     *      2. 为何重写equals方法就得重写hashCode方法？
     *      3. 怎样重写equals？
     *
     * 1. Object.equals() 默认实现是返回this == obj，比较的是引用地址是否相等，有时候我们想要的是比较对象的值是否相等
     * 2. 重写了equals()，说明有自己需要的比值需求，不重写hashcode有可能出现无法预料的错误；
     *  Object.hashcode()默认实现，每个对象返回都不相同，不能保证"相同对象必须有相同哈希值"这一约定，会造成使用这一约定设计的类（如hashmap集合等），出现预料之外的结果
     *  equals() java doc注释中的大致意思是：当我们将equals方法重写后有必要将hashCode方法也重写，这样做才能保证不违背hashCode方法中“相同对象必须有相同哈希值”的约定
     * 3. 自反性、对称性、传递性、一致性
     */
    private static void hashcode_MT() {
        TestBean1 t1 = new TestBean1();
        TestBean1 t2 = new TestBean1();
        System.out.println("未重写hashcode()对象比较:"+(t1.hashCode()==t2.hashCode()));

        TestBean t3 = new TestBean();
        TestBean t4 = new TestBean();
        System.out.println("已重写hashcode()对象比较:"+(t3.hashCode()==t4.hashCode()));

    }







    static class TestBean{
        String id;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            TestBean testBean = (TestBean) o;
            return Objects.equals(id, testBean.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
    static class TestBean1{
        String id;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            TestBean testBean = (TestBean) o;
            return Objects.equals(id, testBean.id);
        }

    }

    static class TestBean3{
        String id;
    }
}
