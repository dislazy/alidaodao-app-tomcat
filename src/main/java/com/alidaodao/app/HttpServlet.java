package com.alidaodao.app;

import java.io.IOException;
import java.io.InputStream;

public abstract class HttpServlet {


    public abstract void doGet(HttpServletRequest request,HttpServletResponse response);

    public abstract  void doPost(HttpServletRequest request,HttpServletResponse response);

    public void service(HttpServletRequest request,HttpServletResponse response){
        
    }
}
