package com.alidaodao.app;

public class FindGirlServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.write("get my love girl ...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.write("post my love girl ...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
