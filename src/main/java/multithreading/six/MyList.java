package multithreading.six;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Huang Guojun
 * @Date 2019/8/13
 * @Discription
 */
public class MyList {
    private static List<String> list = new ArrayList<>();

    public static void add(){
        list.add("anyString");
    }
    public static int size(){
        return list.size();
    }
}
