package com.wisely.hightlight_spring4.ch2.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("com.wisely.hightlight_spring4.ch2.el")
@PropertySource("classpath:/com/wisely/hightlight_spring4/ch2/el/test" +
        ".properties")
//指定属性文件的全路径
//classpath:其实就是打包之后的classes下
public class ElConfig {
    @Value("zju")//(1)注入普通字符串
    private String normal;

    @Value("#{systemProperties['os.name']}") //(2)注入操作系统属性，注意格式
    private String osName;

    @Value("#{T(java.lang.Math).random()*100.0}")//(3)注入表达式结果
    private double randomNumber;

    @Value("#{demoService.another}")//(4)注入其他bean的属性
    private String fromAnother;

    @Value("classpath:/com/wisely/hightlight_spring4/ch2/el/test.txt")//(5)
    // 注入文件资源
    private Resource testFile;

    @Value("http://www.baidu.com")//(6)注入网站资源
    private Resource testUrl;

    @Value("${book.name}")//(7)注入配置文件，注意使用的是$而不是#
    private String bookName;

    /**
     * 关于@Autowired和@Bean
     * @Autowired:可注解在set方法和属性上，用来注入bean，习惯上注解在属性上，它是属于注解配置
     * @Bean：注解在方法上，声明当前方法的返回值为一个Bean，它是属于java配置
     */
    @Autowired
    private Environment environment;//注入Properties还可以从Environment中获得

    //注入配置配件需要使用@PropertySoure指定文件地址，若使用@Value注入，则要配置一个
    //PropertySourcesPlaceholderConfigurer的bean

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource(){
        try{
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAnother);

            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));

            System.out.println(bookName);
            System.out.println(environment.getProperty("book.author"));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}