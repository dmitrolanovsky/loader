package com.jelastic;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Loader extends HttpServlet {
    public Loader() {
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CPU</title>");
            out.println("</head>");
            out.println("<body>");
            int count = 1;
            if(request.getParameter("count") != null) {
                count = Integer.parseInt(request.getParameter("count"));
            }

            int context;
            if(request.getParameter("cpu") != null) {
                out.println("<h1>---- loading cpu...</h1>");
                out.flush();
                context = count * 5;
                double url = 100.0D;
                System.out.println("Factorial of " + context + ":");
                String in = null;

                for(int buff = 1; buff <= context; ++buff) {
                    in = Math.pow(url, Math.random() * url) + "";
                    if(buff % 100000 == 0) {
                        out.println("<br/>count = " + buff);
                        out.flush();
                    }
                }

                System.out.println("Lat text  " + in);
            }

            if(request.getParameter("mem") != null) {
                out.println("<h1>---- loading mem...</h1>");
                LinkedList var15 = new LinkedList();

                for(int var17 = 0; var17 < count; ++var17) {
                    var15.add(var15);
                    if(var17 % 1000000 == 0) {
                        out.println("<br/>count = " + var17);
                        out.flush();
                    }
                }

                out.println("<br/>starting GC..... ");
                out.flush();
                if(request.getParameter("gc") != null) {
                    System.gc();
                }
            }

            if(request.getParameter("net") != null) {
                if(request.getParameter("count") == null) {
                    count = 1;
                }

                out.println("<h1>---- loading net...</h1>");
                out.flush();

                for(context = 0; context < count; ++context) {
                    URL var18 = new URL("http://mirror.yandex.ru/gentoo-distfiles/distfiles/2002a.tar.gz");
                    HttpURLConnection coonnection = (HttpURLConnection)var18.openConnection();
                    coonnection.setRequestMethod("GET");
                    InputStream var19 = coonnection.getInputStream();
                    byte[] var20 = new byte[30720];
                    out.print("bytes read: ");
                    out.flush();
                    int j = 0;

                    int n;
                    while((n = var19.read(var20)) > -1) {
                        ++j;
                        if(j % 25 == 0) {
                            out.print("<br>");
                        }

                        out.print(n + ".....");
                        out.flush();
                    }

                    var19.close();
                }
            }

            out.println("</body>");
            out.println("</html>");
            String var16 = request.getContextPath();
            if(var16.isEmpty()) {
                var16 = "/";
            }

            out.println("<script>location.href=\'" + var16 + "\';</script>");
        } finally {
            out.close();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processRequest(request, response);
    }

    public String getServletInfo() {
        return "Short description";
    }
}