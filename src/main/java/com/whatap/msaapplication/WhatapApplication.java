package com.whatap.msaapplication;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@EnableJpaAuditing
@SpringBootApplication
public class WhatapApplication {

//    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
//    public TestLifeCycle initTest() {
//        return new TestLifeCycle();
//    }

    public static void main(String[] args) {
        SpringApplication.run(WhatapApplication.class, args);
    }

//    class TestLifeCycle implements InitializingBean, DisposableBean {
//
//        @Override
//        public void afterPropertiesSet() {
//            System.out.println("afterPropertiesSet");
//        }
//
//        public void initMethod() {
//            System.out.println("initMethod");
//        }
//
//        @PostConstruct
//        public void postConstruct() {
//            System.out.println("postConstruct");
//        }
//
//        @Override
//        public void destroy() {
//            System.out.println("destroy");
//        }
//
//        public void destroyMethod() {
//            System.out.println("destroyMethod");
//        }
//
//        @PreDestroy
//        public void preDestroy() {
//            System.out.println("preDestroy");
//        }
//    }

}
