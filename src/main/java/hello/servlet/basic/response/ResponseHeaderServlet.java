package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name ="responseHeaderServlet",urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_OK);

        resp.setHeader("Content-Type", "text/plain;charset=utf-8");
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("my-header", "hello");

        PrintWriter writer = resp.getWriter();
        writer.println("안녕하세요");

        redirect(resp);



    }



    private void cookie(HttpServletResponse response) {
//Set-Cookie: myCookie=good; Max-Age=600; //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
Cookie cookie = new Cookie("myCookie", "good");
cookie.setMaxAge(600); //600초
        response.addCookie(cookie);
    }

    private void content(HttpServletResponse response) {
//Content-Type: text/plain;charset=utf-8
//Content-Length: 2
response.setHeader("Content-Type", "text/plain;charset=utf-8");
response.setContentType("text/plain");
response.setCharacterEncoding("utf-8");
//response.setContentLength(2); //(생략시 자동 생성)
    }

    private void redirect(HttpServletResponse resp) throws IOException {
        //Status Code 302
        //Location: /basic/hello-form.html

//        resp.setStatus(HttpServletResponse.SC_FOUND); //302
//        resp.setHeader("Location", "/basic/hello-form.html");

        resp.sendRedirect("/basic/hello-form.html");
    }



}