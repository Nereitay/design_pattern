package es.kiwi.Behavioral.chain_of_responsibility.solution;

public class GeneralManager extends Handler {
    @Override
    public String handleStaffBanquetRequest(String user, double fee) {
        String str = "";
        //总经理权限很大，只要请求到了这里，他都可以处理
        if (fee >= 1000) {
            //为了测试，简单点，只同意Uva的
            if ("Uva".equals(user)) {
                str = "总经理同意" + user + "聚餐费用" + fee + "元的请求";
            } else {
                //其他人一律不同意
                str = "总经理不同意" + user + "聚餐费用" + fee + "元的请求";
            }

            return str;
        } else {
            //如果还有后继的处理对象， 继续传递
            if (this.successor != null) {
                return successor.handleStaffBanquetRequest(user, fee);
            }
        }

        return str;
    }

    @Override
    public boolean handlePrepaidTravelExpensesRequest(String user, double expenses) {
        if (expenses >= 10000) {
            //工作需要嘛，统统同意
            System.out.println("总经理同意" + user + "预支差旅费用" + expenses + "元的请求");
            return true;
        } else {
            //继续传递给级别更高的人处理
            if (this.successor != null) {
                return successor.handlePrepaidTravelExpensesRequest(user, expenses);
            }
        }

        return false;
    }
}
