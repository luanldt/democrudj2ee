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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nguyenminhluan
 */
public class ProcessData extends HttpServlet {

    Gson gson = new Gson();
    SystemuserHelper systemuserHelper = new SystemuserHelper();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        try(PrintWriter out = response.getWriter()) {            
            List<Systemuser> systemusers = systemuserHelper.findAll();
            for(Systemuser systemuser : systemusers) {
                systemuser.setUserdiplomas(null);
            }
            String data = gson.toJson(systemusers);
            StringBuilder builder = new StringBuilder();
            builder.append("{\"aaData\":").append(data).append("}");
            out.write(builder.toString());
        } catch(Exception e) {
            
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
}
