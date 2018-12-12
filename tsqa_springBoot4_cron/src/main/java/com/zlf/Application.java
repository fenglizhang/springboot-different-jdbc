package com.zlf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 一定要在启动类上添加@EnableScheduling来启动定时任务，否则定时任务不会起作用！！！
 * @author Administrator
 *
 */

@SpringBootApplication
@EnableScheduling
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

}