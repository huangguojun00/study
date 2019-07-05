package designmodde.responsebility;

/**
 * @Author Huang Guojun
 * @Date 2019/7/5
 * @Discription
 */
public class Clinet {
    public static void main(String[] args) {
        // 组装责任链
        GeneralManager generalManager = new GeneralManager();
        DeptManager deptManager = new DeptManager();
        ProjectManager projectManager = new ProjectManager();
        projectManager.setSuccessor(deptManager);
        deptManager.setSuccessor(generalManager);


        // 开始测试
        String test1 = projectManager.handleFeeRequest("张三", 300);
        System.out.println("test1 = " + test1);
        String test2 = projectManager.handleFeeRequest("李四", 300);
        System.out.println("test2 = " + test2);
        System.out.println("----------------------------------------------------");

        String test3 = projectManager.handleFeeRequest("张三", 700);
        System.out.println("test3 = " + test3);
        String test4 = projectManager.handleFeeRequest("李四", 700);
        System.out.println("test4 = " + test4);
        System.out.println("----------------------------------------------------");

        String test5 = projectManager.handleFeeRequest("张三", 1500);
        System.out.println("test5 = " + test5);
        String test6 = projectManager.handleFeeRequest("李四", 1500);
        System.out.println("test6 = " + test6);

    }
}
