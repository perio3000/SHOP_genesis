package edu.global.ex.command;

import edu.global.ex.dao.SDao;
import edu.global.ex.dto.SDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SReadCommand implements SCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("수정될 회원의 번호를 골랐음 ");

        String custno = request.getParameter("custno");

        SDao dao = new SDao();
        SDto dto = dao.selectOne(custno);

        request.setAttribute("list", dto);
        System.out.println("멤버 정보 가져왔음");
    }
}
