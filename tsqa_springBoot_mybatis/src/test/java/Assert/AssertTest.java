package Assert;

import org.springframework.util.Assert;

public class AssertTest {
	/**
	 * 对入参进行非空判断，如果为空，则回报异常 notNull(Object object, String message) 方法允许您通过
	 * message 定制异常信息 。
	 * @param object  不为空值，程序正常往下，不然异常。
	 */
	public void notNull(Object object) {
		Assert.notNull(object, "你这个是空值！");
		System.out.println("------断言执行后。。。-------");
	}

	/**
	 * 入参为空，程序正常往下走，不为空时异常。
	 * @param object
	 */
	public void isNull(Object object) {
		Assert.isNull(object, "你这个是空值！");
		System.out.println("------断言执行后。。。-------");
	}
	public void isTrue(boolean expression){
		Assert.isTrue(expression);
		System.out.println("为true程序正常往下走！否则异常");
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		AssertTest at = new AssertTest();
		Object ob = "";
		at.isNull(ob);
	}
}
