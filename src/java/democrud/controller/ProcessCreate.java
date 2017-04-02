/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democrud.controller;

import com.google.gson.Gson;
import democrud.helper.SystemuserHelper;
import democrud.model.Systemuser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nguyenminhluan
 */
@WebServlet(name = "ProcessCreate", urlPatterns = {"/ProcessCreate"})
public class ProcessCreate extends HttpServlet {

    
    Gson gson = new Gson();
    SystemuserHelper systemuserHelper = new SystemuserHelper();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String data = request.getParameter("data");
        Systemuser s = gson.fromJson(data, Systemuser.class);
        if(systemuserHelper.create(s)) {
            response.getWriter().write("{\"message\":\"success\"}");
        } else {
            response.getWriter().write("fail");
        }
    }

   
}
