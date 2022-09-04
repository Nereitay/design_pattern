package es.kiwi.Behavioral.chain_of_responsibility.solution;

public class DepManager extends Handler {
    @Override
    public String handleStaffBanquetRequest(String user, double fee) {
        String str = "";
        //部门经理的权限只能在1000以内
        if (fee < 1000) {
            //为了测试，简单点，只同意Uva的
            if ("Uva".equals(user)) {
                str = "部门经理同意" + user + "聚餐费用" + fee + "元的请求";
            } else {
                //其他人一律不同意
                str = "部门经理不同意" + user + "聚餐费用" + fee + "元的请求";
            }

            return str;
        } else {
            //超过1000， 继续传递给级别更高的人处理
            if (this.successor != null) {
                return successor.handleStaffBanquetRequest(user, fee);
            }
        }

        return str;
    }

    @Override
    public boolean handlePrepaidTravelExpensesRequest(String user, double expenses) {

        if (expenses < 10000) {
            //工作需要嘛，统统同意
            System.out.println("部门经理同意" + user + "预支差旅费用" + expenses + "元的请求");
            return true;
        } else {
            //超过10000， 继续传递给级别更高的人处理
            if (this.successor != null) {
                return successor.handlePrepaidTravelExpensesRequest(user, expenses);
            }
        }

        return false;
    }

}
