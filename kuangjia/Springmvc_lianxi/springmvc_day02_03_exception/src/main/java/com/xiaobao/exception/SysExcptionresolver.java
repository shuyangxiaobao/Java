package com.xiaobao.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class SysExcptionresolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(javax.servlet.http.HttpServletRequest httpServletRequest,
                                         javax.servlet.http.HttpServletResponse httpServletResponse, Object o, Exception e) {

        SysExcption excption = null;
        if (e instanceof SysExcption){
            excption = (SysExcption) e;
        } else {
            excption = new SysExcption ( "系统正在维护中....." );
        }

        ModelAndView modelAndView = new ModelAndView ();
        modelAndView.addObject ( "errormsg",excption.getMessage () );
        modelAndView.setViewName ( "error" );
        return modelAndView;
    }
}
