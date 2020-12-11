package com.alidaodao.app;

public class HelloWorldServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.write("I have this world ...");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.write("hello world ...");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
