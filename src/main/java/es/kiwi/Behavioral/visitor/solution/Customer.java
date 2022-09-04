package es.kiwi.Behavioral.visitor.solution;

public abstract class Customer {

    private String customerId;
    private String name;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 接受访问者的访问
     * @param visitor 访问者对象
     */
    public abstract void accept(Visitor visitor);
}
