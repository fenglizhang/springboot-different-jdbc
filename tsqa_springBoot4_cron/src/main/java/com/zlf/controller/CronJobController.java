package com.zlf.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zlf.bo.User;
import com.zlf.repository.UserRepository;

@Controller
@RequestMapping("/show")
public class CronJobController {

	@Autowired
	private UserRepository userRepository;

	public final static long ONE_Minute = 60 * 1000;

	@Scheduled(cron = "20 * * * * *")
	public void showJob() {
		System.out.println("定时器启动了");
		long count = this.userRepository.count();
		System.out.println(count);
		User findOne = this.userRepository.findOne(1);
		if(findOne !=null){
			
			System.out.println((findOne).toString());
		}
	}

	/**
	 * fixedDelay和fixedRate，单位是毫秒，所以1分钟就是60秒×1000
	 * 他们的区别在于，fixedRate就是每多少分钟一次，不论你业务执行花费了多少时间
	 * 。我都是1分钟执行1次，而fixedDelay是当任务执行完毕后1分钟在执行。所以根据实际业务不同，我们会选择不同的方式。
	 */
	@Scheduled(fixedDelay = ONE_Minute)
	public void fixedDelayJob() {
		System.out.println(">>fixedDelay执行....");
	}

	@Scheduled(fixedRate = ONE_Minute)
	public void fixedRateJob() {
		System.out.println(" >>fixedRate执行....");
	}

	/**
	 * Cron表达式： 第一位，表示秒，取值0-59 第二位，表示分，取值0-59 第三位，表示小时，取值0-23 第四位，日期天/日，取值1-31
	 * 第五位，日期月份，取值1-12 第六位，星期，取值1-7，星期一，星期二...，注：不是第1周，第二周的意思 另外：1表示星期天，2表示星期一。
	 * 第七位，年份，可以留空，取值1970-2099
	 */
	// 还有一类定时任务，比如是每天的3点15分执行，那么我们就需要用另外一种方式：cron表达式
	@Scheduled(cron = "0 15 3 * * ?")
	public void cronJob() {
		System.out.println(" >>cron执行....");
	}

	public static void main(String[] args) {
		Random ran=new Random();
		int nextInt = ran.nextInt(3);
		System.out.println(nextInt);
	}
}
