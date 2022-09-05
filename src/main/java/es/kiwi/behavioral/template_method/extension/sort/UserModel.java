package es.kiwi.behavioral.template_method.extension.sort;

/**
 * 用户数据模型
 */
public class UserModel {
    private String userId, name;
    private int age;

    public UserModel(String userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
