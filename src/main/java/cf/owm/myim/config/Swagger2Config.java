package cf.owm.myim.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenf
 * @Date 2020/6/2 16:07
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class Swagger2Config {
    /**
     * 扫描的包
     */
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "cf.owm.myim.controller";
    /**
     * 当前版本
     */
    public static final String VERSION = "1.0.0";

    @Bean
    public Docket createRestApi() {
//        ParameterBuilder ticketPar = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<Parameter>();
        //header中的ticket参数非必填，传空也可以
//        ticketPar.name("token").description("user token")
//                .modelRef(new ModelRef("string")).parameterType("header")
//                .required(false).build();
        //根据每个方法名也知道当前方法在设置什么参数
//        pars.add(ticketPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .paths(PathSelectors.any())
                .build();
//                .globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置文档的标题
                .title("CF_MYIM")
                // 设置文档的描述
                .description("MYIM-API-接口文档")
                // 设置文档的版本信息
                .version(VERSION)
                // 设置文档的License信息
                .termsOfServiceUrl("http://www.baidu.com")
                .build();
    }
}
