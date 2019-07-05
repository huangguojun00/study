package designmodde.responsebility;

/**
 * @Author Huang Guojun
 * @Date 2019/7/5
 * @Discription
 */
public class GeneralManager extends Handler {
    @Override
    public String handleFeeRequest(String user, double fee) {
        String str = "";
        if (fee >= 1000) {
            //为了测试，简单点，只同意张三的请求
            if ("张三".equals(user)) {
                str = "成功：总经理同意【" + user + "】的聚餐费用，金额为" + fee + "元";
            } else {
                //其他人一律不同意
                str = "失败：总经理不同意【" + user + "】的聚餐费用，金额为" + fee + "元";
            }
        } else {
            if (getSuccessor() != null) {
                return getSuccessor().handleFeeRequest(user, fee);
            }
        }
        return str;
    }
}
