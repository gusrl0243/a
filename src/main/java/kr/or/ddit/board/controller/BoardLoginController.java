package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;

@WebServlet("/login")
public class BoardLoginController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IUserService userService;
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
		boardService = new BoardServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<BoardVo> boardList = boardService.getBoardList();
		List<BoardVo> boardList_Y = boardService.boardList_Y();
		
		req.setAttribute("boardList", boardList);
		req.setAttribute("boardList_Y", boardList_Y);
		
		RequestDispatcher rd = req.getRequestDispatcher("/login/login.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<BoardVo> boardList = boardService.getBoardList();
		List<BoardVo> boardList_Y = boardService.boardList_Y();
		
		req.setAttribute("boardList", boardList);
		req.setAttribute("boardList_Y", boardList_Y);

		
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		
		UserVo userVo = userService.selectUser(userId);
		
		if(userVo.getUserId().equals(userId)&&
		   userVo.getPass().equals(password)){
			
			HttpSession session = req.getSession();
			session.setAttribute("userVo", userVo);
			
			RequestDispatcher rd = req.getRequestDispatcher("/main.jsp");
			rd.forward(req, resp);
		}else{
			RequestDispatcher rd = req.getRequestDispatcher("/login/login.jsp");
			rd.forward(req, resp);
		}
	}
}














