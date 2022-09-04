package es.kiwi.Creational.factory_method;

import com.google.common.base.Defaults;
import lombok.*;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class TestListStream {

    public static void main(String[] args) {
        /*Student aaa = new Student(null, "AAA");
        Student bbb = new Student(null, "BBB");
        Student ccc = new Student(null, "CCC");
        List<Student> students = new ArrayList<>();
        students.add(aaa);
        students.add(bbb);
        students.add(ccc);
        System.out.println(students);
       *//* for (Student student : students) {
            setNullToDefaultValue(student);
        }*//*

        students.forEach(TestListStream::setNullToDefaultValue);

        System.out.println(students);*/

       /* String s = new BigDecimal("-1234567.897").setScale(2, RoundingMode.HALF_UP).toPlainString().replaceAll("[^\\d]", "");
        String s1 = "hello007".replaceAll("[^\\d]", "");
        System.out.println(s);
        System.out.println(s1);*/

        String s = new StringBuilder().append("123", 0, 1).append("4").toString();
        System.out.println(s);
    }

    private static void setNullToDefaultValue(Object obj) {
        for (Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                if (f.get(obj) == null) {
                    if (f.getType().getName().contains("String"))
                        f.set(obj, "");
                    else if (f.getType().getName().contains("BigDecimal"))
                        f.set(obj, BigDecimal.ZERO);
                    else if (f.getType().getName().contains("Long"))
                        f.set(obj, 0L);
                    else if (f.getType().getName().contains("Integer"))
                        f.set(obj, 0);
                    else
                        f.set(obj, Defaults.defaultValue(f.getType()));
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Student {
    private Integer age;
    private String name;
}
