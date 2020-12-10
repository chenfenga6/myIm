package cf.owm.myim.tools;

import java.util.UUID;

/**
 * @ClassName UUIDUtil
 * @Description TODO
 * @Author gaor
 * @Date 2020/6/11 16:50
 */
public class UUIDTool {
    public static String getUUIDRandom(){

        String uuid= UUID.randomUUID().toString();

        return uuid.replace("-", "");
    }
}
