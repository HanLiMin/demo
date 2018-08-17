import java.util.Arrays;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/8/17
 */
public class ReTest {
    public static void main(String[] args) {
        String string = "1093||1418$$11:00|11:30";
        System.err.println(Arrays.toString(string.split("\\$\\$")));
    }

    public void test(){

    }
}
