package com.alidaodao.app;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MyTomcat {

    private int port = 9080;

    private Map<String, String> urlServletMap = new HashMap<>();

    public MyTomcat(int port) {
        this.port = port;
    }

    private void initServletMapping() {
        for (ServletMapping servletMapping : ServletMappingConfig.servletMappings) {
            urlServletMap.put(servletMapping.getUrl(), servletMapping.getClazz());
        }
    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response) {
        String clazz = urlServletMap.get(request.getUrl());
        if (clazz == null){
            return;
        }
        try {
            Class<HttpServlet> myServletClass = (Class<HttpServlet>) Class.forName(clazz);
            HttpServlet myServlet = myServletClass.newInstance();
            myServlet.service(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        initServletMapping();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("my tomcat is start ...");
            while (true) {
                Socket socket = serverSocket.accept();

                InputStream inputStream = socket.getInputStream();

                OutputStream outputStream = socket.getOutputStream();

                HttpServletRequest request = new HttpServletRequest(inputStream);
                HttpServletResponse response = new HttpServletResponse(outputStream);

                dispatch(request, response);
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyTomcat(8080).start();
    }
}
