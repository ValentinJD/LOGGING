package ru.project;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.inject.Inject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Inject
    ReportingPeriodDaoImpl reportingPeriodDao;

    Logger logger = LoggerFactory.getLogger(getClass());

    public HelloServlet() {
        super();
    }


    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
/*        writer.println("<h1>Hello World Servlet on WildFly</h1>");

        for (int i=0; i < 5; i++){
            logger.error("************** exclusions logger library 555555 Hello world SLF4j on WildFly  ******************");
//            logger.warn("55555555555555555 Request 55555555555555555555555555555555555");
        }*/
        writer.println(HibernateUtil.getEm().createQuery("SELECT period FROM ReportingPeriod period")
                .getResultList());
        writer.close();

    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
