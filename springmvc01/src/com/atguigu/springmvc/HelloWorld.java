package com.atguigu.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorld {
    @RequestMapping(value = {"/helloworld","/dontStopMeNow/{id}"})
    public String helloWorld(@PathVariable(value = "a",required = false) Integer id){
        System.out.println(id);
        System.out.println("Hello SpringMVC!");
        return "success";
    }
    @RequestMapping(value = "/doGet",method = RequestMethod.GET)
    public String doGet(){

        System.out.println("doGet");
        return "success";
    }
    @RequestMapping(value = "/doPost",method = RequestMethod.POST)
    public String doPost(){

        System.out.println("doPost");
        return "success";
    }
    @RequestMapping(value = "/doPut",method = RequestMethod.PUT)
    public String doPut(){

        System.out.println("doPut");
        return "success";
    }
    @RequestMapping(value = "/doDelete",method = RequestMethod.DELETE)
    public String doDelete(String username,String password){
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("doDelete");
        return "success";
    }
}
