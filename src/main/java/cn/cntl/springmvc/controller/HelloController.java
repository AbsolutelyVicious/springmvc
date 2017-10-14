package cn.cntl.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 在整体架构里，处理器称为Handler
 * 在具体实现里，处理器称为Controller
 * @author joedy
 *
 */
public class HelloController implements Controller {

	/* (non-Javadoc)
	 * 处理具体的业务逻辑
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("hello");
		mv.addObject("msg", "springmvc的第一个入门程序");
		return mv;
	}

	/* (non-Javadoc)
	 * 处理具体的业务逻辑
	 */
	public ModelAndView handleRequestX(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("hello");
		mv.addObject("msg", "springmvc的第一个入门程序");
		return mv;
	}

}
