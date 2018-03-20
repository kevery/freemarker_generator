package com.fb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * ${comment}Controller
 *
 * 2018/3/19
 */
@Controller
@RequestMapping("/${mapper_name}")
public class ${classname} {

    private Logger logger = LoggerFactory.getLogger(${classname}.class);


    /**
     * ${comment}界面
     * @param response
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView supplierList(HttpServletResponse response
    ) {
        ModelAndView mv = new ModelAndView("order/order-list");

        return mv;
    }
}
