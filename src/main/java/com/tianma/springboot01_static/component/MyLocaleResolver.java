package com.tianma.springboot01_static.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import sun.util.locale.provider.LocaleResources;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author lgc
 * @createDate 2020/4/28 - 16:09
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        Locale locale = Locale.getDefault() ;
        if (!StringUtils.isEmpty(l)){
            String[] split = l.split("_");
            locale =  new Locale(split[0],split[1]);
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
