package com.alidaodao.app;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class HttpServletResponse {

    private OutputStream outputStream;

    public HttpServletResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String content) throws IOException {
        StringBuffer response = new StringBuffer();
        response.append("HTTP/1.1 200 OK\n")
                .append("Content-Type: text/html\n")
                .append("\r\n")
                .append("<html><body>")
                .append(content)
                .append("</body></html>");
        outputStream.write(response.toString().getBytes(StandardCharsets.UTF_8));
        outputStream.close();
    }

}
