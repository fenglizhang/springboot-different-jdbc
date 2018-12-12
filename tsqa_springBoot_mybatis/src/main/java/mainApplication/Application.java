package mainApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Spring Boot建议将我们main方法所在的这个主要的配置类配置在根包名下。
 * 
 * @author Administrator
 * 
 * 
 * @SpringBootApplication是Spring Boot提供的注解，他相当于加上如下注解：
 * @Configuration，表明Application是一个Spring的配置对象，用于配置Spring应用上下文。
 * @EnableAutoConfiguration，Spring   Boot会根据类路径（classpath）以及一些属性值来自动完成一些配置行为，例如：开发基于Spring
 *      MVC的Web应用，需要在配置中加上
 * @EnableWebMvc直接来激活一些默认的Web配置， 一旦Spring Boot发现运行时类路径上包含了 spring-webmvc
 *                               依赖，它会自动的完成一个Web应用的基本配置
 *                               ——例如配置DispatcherServlet等等。
 * @ComponenScan告知Spring应用从什么位置去发现Spring构件（@Component, @Service,
 *                                                     @Configuration）等等
 */
@SpringBootApplication
@Controller
// @RestController因为我们例子是写一个web应用，因此写的这个注解，这个注解相当于同时添加@Controller和@ResponseBody注解
// @EnableAutoConfiguration// Spring Boot会自动根据你jar包的依赖来自动配置项目的数据源依赖
@ComponentScan(basePackages = { "controller", "service", "dao" })
// @ComponentScan路径被默认设置为SampleController的同名package，也就是该package下的所有@Controller
// ，@Service , @Component, @Repository都会被实例化后并加入Spring Context中。这也是为什么要把这个类最好放到与其他包同级目录 的原因了。
public class Application {

	@RequestMapping("")
	public String home() {
		// return "xiaozhang ,Hello World!";
		return "/index";
	}

	public static void main(String[] args) {
		// 启动Spring Boot项目最简单的方法就是执行下面的方法
		SpringApplication.run(Application.class);
	}

}