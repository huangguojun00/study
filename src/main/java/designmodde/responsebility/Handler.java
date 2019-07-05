package designmodde.responsebility;

/**
 * @Author Huang Guojun
 * @Date 2019/7/5
 * @Discription  抽象处理角色类
 */
public abstract class Handler {
    /**
     * 持有下一个处理请求的对象
     */
    protected Handler successor = null;

    /**
     * 取值方法
     */
    public Handler getSuccessor() {
        return successor;
    }

    /**
     * 设置下一个处理对象
     *
     * @param successor
     */
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    /**
     * 处理聚餐费用的申请
     *
     * @param user
     * @param fee
     * @return
     */
    public abstract String handleFeeRequest(String user, double fee);
}
