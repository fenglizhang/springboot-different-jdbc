package com.zlf.controller;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.zlf.bo.StaffBo;
/**
 * 
 * @author Administrator
 *
 *单元测试注意点：
 *@1.测试的类目录要和你要测试那个方法对应类的目录一样。这样才能在@before前置加载项正常加载。
 *@2.post方法传值问题。单个字符参数：post().param("参数名","参数值")，接收参数用在方法的入口@RequestParam(value="参数名") String 参数名
 *实体类post().requestAttr("实体名",实体)，接收参数也是在方法入口用@RequestAttribute(value="实体参数名") 实体类  实现对像
 */
@RunWith(SpringRunner.class)//SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest// 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class SpringJUnitTestApplicationTests {
	@Autowired  
    private WebApplicationContext context;  
      
    private MockMvc mockMvc;   
    
    @Before   
    public void setupMockMvc() throws Exception {   
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();   
    }
    /*** 
     * 测试添加用户接口 
     * @throws Exception 
     */  
    @Test  
    public void testAddUser() throws Exception  
    {  
        //构造添加的用户信息  
        StaffBo sta = new StaffBo();  
        sta.setName("梨花");  
        sta.setAge(29);  
        sta.setId("4"); 
          
        //调用接口，传入添加的用户参数  
        ResultActions resultActions = mockMvc.perform(post("/staff/adduser").requestAttr("staff", sta)) ; 
        //判断返回值，是否达到预期，测试示例中的返回值的结构如下{"errcode":0,"errmsg":"OK","p2pdata":null}  
        resultActions .andExpect(status().isOk()) ; 
        resultActions .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))  ;
        //使用jsonPath解析返回值，判断具体的内容  
        resultActions.andExpect(jsonPath("id", is("4")))  ;
        resultActions.andExpect(jsonPath("name", is("梨花"))) ; 
    }
    
}
