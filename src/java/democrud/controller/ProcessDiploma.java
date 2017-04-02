/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democrud.controller;

import com.google.gson.Gson;
import democrud.helper.UserdiplomaHelper;
import democrud.model.Userdiploma;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luan
 */
@WebServlet(name = "ProcessDiploma", urlPatterns = {"/ProcessDiploma"})
public class ProcessDiploma extends HttpServlet {

    Gson gson = new Gson();
    UserdiplomaHelper userdiplomaHelper = new UserdiplomaHelper();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (userId != null && !"".equals(userId)) {
                int iUserId = Integer.parseInt(userId);
                List<Userdiploma> userdiplomas = userdiplomaHelper.findAll(iUserId);
                for(Userdiploma userdiploma : userdiplomas) {
                    userdiploma.setSystemuser(null);
                }
                String data = gson.toJson(userdiplomas);
                StringBuilder builder = new StringBuilder();
                builder.append("{\"result\":").append(data).append("}");
                out.write(builder.toString());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
