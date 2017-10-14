package cn.cntl.springmvc.controller;

import cn.cntl.springmvc.pojo.User;
import cn.cntl.springmvc.pojo.UserVO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("hello")
@Controller
public class Hello2Controller {

    @RequestMapping("show01")
    public ModelAndView test01(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("msg","test01");
        return modelAndView;
    }

    @RequestMapping("/sss?/show02")
    public ModelAndView test02(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("msg","/sss?/show02");
        return modelAndView;
    }

    @RequestMapping("/aa*/show03")
    public ModelAndView test03(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("msg","/aa*/show03");
        return modelAndView;
    }

    @RequestMapping("/**/show04")
    public ModelAndView test04(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("msg","/**/show04");
        return modelAndView;
    }

    @RequestMapping("/user/{userId}/{name}")
    public ModelAndView test05(@PathVariable("name") String name,@PathVariable("userId") Long userId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("msg","springmvc请求路径之占位符name"+name+",id="+userId);
        return modelAndView;
    }

    @RequestMapping(value = "show06",method = {RequestMethod.POST , RequestMethod.PUT})
    public ModelAndView test06(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("msg","RequestMethod.POST");
        return modelAndView;
    }

    public ModelAndView test07(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("msg","test01");
        return modelAndView;
    }

    @RequestMapping("show13")
    public ModelAndView test13(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        StringBuffer sb = new StringBuffer();
        sb.append("request+"+request.toString()+"<br />");
        sb.append("request+"+response.toString()+"<br />");
        sb.append("request+"+session.toString()+"<br />");
        modelAndView.setViewName("hello");
        modelAndView.addObject("msg",sb.toString());
        return modelAndView;
    }

    @RequestMapping("show14")
    public String test14(Model model){
        model.addAttribute("msg","springmv特有的内置对象");
        return "hello";
    }

    @RequestMapping("show15/{name}/{id}")
    public String test15(Model model, @PathVariable("id") Long id, @PathVariable("name") String name){
        model.addAttribute("msg","获取springmvc占位符参数：id="+id+";name="+name);
        return "hello";
    }

    @RequestMapping("show16")
    public String test16(Model model, @RequestParam(value = "id",required = false)Long id,@RequestParam(value = "name",required = false,defaultValue = "aaa") String name){
        model.addAttribute("msg","获取springmvc占位符参数：id="+id+";name="+name);
        return "hello";
    }

    @RequestMapping("show17")
    public String test17(HttpServletRequest request,Model model){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if("JSESSIONID".equals(cookie.getName())){
                    model.addAttribute("msg","jsession:"+cookie.getValue());
                }
            }
        }
        return "hello";
    }

    @RequestMapping("show18")
    public String test18(Model model, @CookieValue("JSESSIONID") String jsessionid){
        model.addAttribute("msg","jsessionid="+jsessionid);
        return "hello";
    }

    @RequestMapping("show19")
    @ResponseStatus(HttpStatus.OK)
    public void test19(
            @RequestParam("name")String name,
            @RequestParam("age")Integer age,
            @RequestParam("isMarry")String isMarry,
            @RequestParam("income")Float income,
            @RequestParam("interests")String[] interests
            ){
        StringBuffer sb = new StringBuffer();
        sb.append("name:"+name);
        sb.append(",age:"+age);
        sb.append(",isMarry:"+isMarry);
        sb.append(",income:"+income);
        sb.append(",interests:[");
        for(String sd : interests){
            sb.append(sd+" ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    @RequestMapping("show20")
    public String test20(Model model,User user){
        model.addAttribute("msg",user.toString());
        return "hello";
    }

    @RequestMapping("show21")
    public String test21(Model model, UserVO users){
        model.addAttribute("msg",users.toString());
        return "hello";
    }

    @RequestMapping("show22")
    public String test22(Model model, @RequestParam("ids") List<Integer> ids){
        model.addAttribute("msg",ids);
        return "hello";
    }

    @RequestMapping("show23")
    public String test23(Model model){
        List<User> userList = new ArrayList<User>();
        for(int i=0;i<=10;i++){
            User user = new User();
            user.setId("12121");
            user.setAge(35);
            user.setName("狗蛋儿");
            user.setUserName("XXOO");
            userList.add(user);
        }
        model.addAttribute("userList",userList);
        return "users";
    }

    @RequestMapping("show24")
    @ResponseBody
    public List<User> test24(){
        List<User> userList = new ArrayList<User>();
        for(int i=0;i<=10;i++){
            User user = new User();
            user.setId("12121");
            user.setAge(35);
            user.setName("狗蛋儿");
            user.setUserName("XXOO");
            userList.add(user);
        }
        return userList;
    }

}