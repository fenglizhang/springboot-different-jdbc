package com.zlf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 虽然为H2,但是还是用引入jpa这个jar包。
 * @author Administrator 右击，run as Java
 *         Application运行之后在浏览器中访问localhost:8080/h2-console即可进入h2配置页面，可以选择语言为中文
 */

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

}