package cf.owm.myim.service;

import cf.owm.myim.tools.TLSSigAPIv2;
import cf.owm.myim.vo.tencent.TencentUserSigVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author chenf
 * @Date 2020/12/10 9:22
 */
@Service
public class TencentService {
    /**
     *腾讯云api url
     */
    @Value("${tengxun.im.baseurl}")
    private String BASE_URL;
    @Value("${tengxun.im.sdkappid}")
    private long sdkappid;
    /**
     *密钥
     */
    @Value("${tengxun.im.key}")
    private String key;
    /**
     *app管理账号
     */
    @Value("${tengxun.im.identifier}")
    private String identifier;
    /**
     * UserSig超时时间
     */
    private static final long EXPIRTIME = 60*60*24*7;


    /**
     * 获取 UserSign
     * @param userId 账号
     * @return
     */
    public TencentUserSigVo getUserSig(String userId){
        TencentUserSigVo vo = new TencentUserSigVo();
        vo.setSdkAppID(String.valueOf(sdkappid));
        TLSSigAPIv2 tlsSigAPIv2 = new TLSSigAPIv2(sdkappid,key);
        vo.setUserSig(tlsSigAPIv2.genUserSig(userId,EXPIRTIME));
        return vo;
    }


}
