package com.diquest.ta.util;

import com.diquest.ta.util.task.step1.TermExtractorTasklet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class TaUtilApplication {


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TaUtilApplication.class);

        //웹 어플리케이션 비활성화
        app.setWebApplicationType(WebApplicationType.NONE);

        ConfigurableApplicationContext ctx = app.run(args);

        ApplicationContext context = new AnnotationConfigApplicationContext("com.diquest.ta.util.config");
        TermExtractorTasklet termExtractorTasklet = context.getBean("termExtractorTasklet", TermExtractorTasklet.class);

        termExtractorTasklet.init();
        System.out.println(termExtractorTasklet.getJianaResultStr("오늘의 회식은 니와스시 참치"));
    }
}
