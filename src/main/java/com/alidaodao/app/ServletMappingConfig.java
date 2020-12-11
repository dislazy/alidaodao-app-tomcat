package com.alidaodao.app;

import java.util.ArrayList;
import java.util.List;

public class ServletMappingConfig {

    public static List<ServletMapping> servletMappings = new ArrayList<>();

    static {
        servletMappings.add(new ServletMapping("findGirl","/girl","com.alidaodao.app.FindGirlServlet"));
        servletMappings.add(new ServletMapping("helloWorld","/hello","com.alidaodao.app.HelloWorldServlet"));
    }
}
