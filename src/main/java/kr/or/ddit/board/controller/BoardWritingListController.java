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

@WebServlet("/boardWritingList")
public class BoardWritingListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IUserService userService;
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
		boardService = new BoardServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		List<BoardVo> boardList = boardService.getBoardList();
		List<BoardVo> boardList_Y = boardService.boardList_Y();
		
		req.setAttribute("boardList", boardList);
		req.setAttribute("boardList_Y", boardList_Y);
		
		System.out.println("boardList_Y : " + boardList_Y.size());
		System.out.println("boardList : " + boardList.size());
		
		String board_name = req.getParameter("board_name");
		System.out.println(board_name);
		req.setAttribute("board_name", board_name);
		
		RequestDispatcher rd = req.getRequestDispatcher("/board/boardWritingList.jsp");
		rd.forward(req, resp); 
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
	
	}
}
