package edu.global.ex.command;

import edu.global.ex.dao.SDao;
import edu.global.ex.dto.SDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SListCommand implements SCommand {
    //인터페이스므로 메소드선언만 가능하다. 구현은 자손이 한다.
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("SListCommand START");
        SDao dao = new SDao();
        List<SDto> dtos = dao.list();

        request.setAttribute("list", dtos);
        System.out.println("SListCommand END");
    }
}
