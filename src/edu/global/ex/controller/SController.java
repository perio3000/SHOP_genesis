package edu.global.ex.controller;

import edu.global.ex.command.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Servlet implementation class EController
 */
@WebServlet("*.do")
public class SController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("doget...");
        actionDo(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("doPost......");
        actionDo(request, response);
    }

    public void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("actionDo...");

        request.setCharacterEncoding("UTF-8");

        String viewPage = null;
        SCommand command = null;

        String uri = request.getRequestURI();
        String conPath = request.getContextPath();
        String com = uri.substring(conPath.length());

        System.out.println("경로확인 : " + uri + ":" + conPath + ":" + com);


        if (com.equals("/front.do")) {
            viewPage = "front.jsp";
        }


        else if (com.equals("/memberList.do")) {
            System.out.println("list.Do....");
            command = new SListCommand();
            command.execute(request, response);
            viewPage = "memberList.jsp";

        } else if (com.equals("/join.do")) {
            System.out.println("/join.do ..");
            viewPage = "join.jsp";

        } else if (com.equals("/join_resist.do")) {
            System.out.println("join_resist.do ..");
            command = new SJoinCommand();
            command.execute(request, response);
            viewPage = "memberList.do";

        } else if (com.equals("/selectOne.do")) {
            System.out.println("/selectOne.do ..");
            command = new SReadCommand();
            command.execute(request, response);
            viewPage = "update.jsp";

        } else if (com.equals("/update_this.do")) {
            System.out.println("/update_this.do ..");
            command = new SUpdateCommand();
            command.execute(request, response);
            viewPage = "memberList.do";

        } else if (com.equals("/rankList.do")) {
            System.out.println("/rank.do................");
            command = new SRankCommand();
            command.execute(request, response);
            viewPage = "rankList.jsp";
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
        dispatcher.forward(request, response);


    }


}
