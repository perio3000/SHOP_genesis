package edu.global.ex.command;

import edu.global.ex.dao.SDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SJoinCommand implements SCommand {
	//인터페이스므로 메소드선언만 가능하다. 구현은 자손이 한다.
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joindate = request.getParameter("joindate");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");

		SDao dao =new SDao();
		dao.join(custname, phone, address, joindate, grade, city);
	};
}
