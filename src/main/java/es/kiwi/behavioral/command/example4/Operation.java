package es.kiwi.behavioral.command.example4;

/**
 * 运算类，真正实现加减法运算
 */
public class Operation implements OperationApi {
    /**
     * 记录运算的结果
     */
    private int result;

    /**
     * 获取计算完成后的结果
     *
     * @return 计算完成后的结果
     */
    @Override
    public int getResult() {
        return result;
    }

    /**
     * 设置计算开始的初始值
     *
     * @param result 计算开始的初始值
     */
    @Override
    public void setResult(int result) {
        this.result = result;
    }

    /**
     * 执行加法
     *
     * @param num 需要加的数
     */
    @Override
    public void add(int num) {
        //实现加法功能
        result += num;
    }

    /**
     * 执行减法
     *
     * @param num 需要减的数
     */
    @Override
    public void substract(int num) {
        //实现减法功能
        result -= num;
    }
}
