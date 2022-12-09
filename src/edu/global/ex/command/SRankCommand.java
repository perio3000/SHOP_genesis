package edu.global.ex.command;

import edu.global.ex.dao.SDao;
import edu.global.ex.dto.SDto;
import edu.global.ex.dto.SDto_rank;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SRankCommand implements SCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("SRankCommand START");
        SDao dao = new SDao();
        List<SDto_rank> dtos = dao.rank();

        request.setAttribute("rank", dtos);
        System.out.println("SRankCommand END");
    }
}