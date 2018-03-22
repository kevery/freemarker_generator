package com.fb.controller;

import com.fb.bir.dao.businessdao.PageEntity;
import com.fb.bir.dao.businessdao.PagingResult;

import com.fb.vo.ViewData;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * ${comment}Controller
 *
 *
 */
@Controller
@RequestMapping("/${mapper_name}")
public class ${classname} {

    private Logger logger = LoggerFactory.getLogger(${classname}.class);

    @Autowired
    private ${domain}Service ${domain_low}Service;

    /**
     * ${comment}界面
     * @param response
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView supplierList(HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("order/order-list");

        return mv;
    }

    /**
     * 数据异步请求
     * @return
     */
    @ResponseBody
    @RequestMapping("/data")
    public ViewData<${domain}> list(
    HttpServletRequest req, HttpServletResponse rep,
    @RequestParam(required = true, defaultValue = "1") Integer page, // 第几页
    @RequestParam(required = true, defaultValue = "10") Integer limit,
    String username
    ) {
    ViewData<${domain}> v = new ViewData<>();
        PagingResult<${domain}> pr;
            try {
            Map<Object, Object> params = new HashMap<>();

            if (StringUtils.isNotBlank(username)) {
            params.put("username", username);
            }

            PageEntity p = new PageEntity();
            p.setPage(page);
            p.setSize(limit);
            p.setParams(params);
            pr = ${domain_low}Service.selectPagination(p);
            v.setCount(pr.getTotalSize());
            v.setData(pr.getResultList());
            } catch (Exception e) {
            logger.error("查询出错", e);
            }
            return v;
            }
}
