package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;


public class LeftController extends HttpServlet{
	private static final long serivalversionUID = 1L;
	private IUserService userService;
	private IBoardService boardService;

	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
		boardService = new BoardServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<BoardVo> boardList_Y = boardService.boardList_Y();
		List<BoardVo> boardList = boardService.getBoardList();
		req.setAttribute("boardList", boardList);
		req.setAttribute("boardList_Y", boardList_Y);
		
		System.out.println(boardList_Y);
		System.out.println("asdgasfg");
		RequestDispatcher rd = req.getRequestDispatcher("/module/left.jsp");
		rd.forward(req, resp); 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {

	}

}
