package com.alidaodao.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public abstract class HttpServlet {


    public abstract void doGet(HttpServletRequest request, HttpServletResponse response);

    public abstract void doPost(HttpServletRequest request, HttpServletResponse response);

    public void service(HttpServletRequest request, HttpServletResponse response) {
        if (Objects.isNull(request.getMethod())) {

        } else if ("post".equals(request.getMethod().toLowerCase())) {
            doPost(request, response);
        } else if ("get".equals(request.getMethod().toLowerCase())) {
            doGet(request, response);
        }
    }
}
