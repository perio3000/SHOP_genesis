package edu.global.ex.command;

import edu.global.ex.dao.SDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SUpdateCommand implements SCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        int custno = Integer.parseInt(request.getParameter("custno"));
        String custname = request.getParameter("custname");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String joindate = request.getParameter("joindate");
        String grade = request.getParameter("grade");
        String city = request.getParameter("city");

        SDao dao =new SDao();
        dao.update(custno, custname, phone, address, joindate, grade, city);
    }
}
