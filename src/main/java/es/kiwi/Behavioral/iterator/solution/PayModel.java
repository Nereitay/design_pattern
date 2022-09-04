package es.kiwi.Behavioral.iterator.solution;

/**
 * 工资描述模型对象
 */
public class PayModel {

    private String username;

    private double pay;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "PayModel{" +
                "username='" + username + '\'' +
                ", pay=" + pay +
                '}';
    }
}
