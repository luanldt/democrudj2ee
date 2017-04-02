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
public class ProcessUpdate extends HttpServlet {

    Gson gson = new Gson();
    SystemuserHelper systemuserHelper = new SystemuserHelper();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String data = request.getParameter("data");
        Systemuser s = gson.fromJson(data, Systemuser.class);
        if (systemuserHelper.update(s)) {
            response.getWriter().write("{\"message\":\"success\"}");
        } else {
            response.getWriter().write("fail");
        }
    }

}
