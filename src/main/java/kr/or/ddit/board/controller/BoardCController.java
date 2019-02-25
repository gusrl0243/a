package kr.or.ddit.board.controller;

import java.io.Console;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.mapping.ResultMap;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;
import kr.or.ddit.util.model.PageVo;

@WebServlet("/boardC")
public class BoardCController extends HttpServlet{
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

		List<BoardVo> boardList = boardService.getBoardList();
		List<BoardVo> boardList_Y = boardService.boardList_Y();
		
		req.setAttribute("boardList", boardList);
		req.setAttribute("boardList_Y", boardList_Y);
		System.out.println("boardList_Y : " + boardList_Y.size());
		System.out.println("boardList : " + boardList.size());
		
		RequestDispatcher rd = req.getRequestDispatcher("/board/boardC.jsp");
		rd.forward(req, resp); 
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String board_name = req.getParameter("new_board_name");
		String y_n = req.getParameter("Y_N");

		String num = "50";
		
		BoardVo boardVo = new BoardVo(num,y_n,y_n);
		boardVo.setBoard_name(board_name);
		boardVo.setBoard_num(num);
		boardVo.setY_N(y_n);
		System.out.println(boardVo);
		System.out.println(boardVo.getBoard_name() + boardVo.getBoard_num() + boardVo.getY_N());

		int insertCnt = boardService.insertboard(boardVo);
		
		
		//정상입력(성공)
		if(insertCnt == 1){
			req.getSession().setAttribute("msg", "정상 등록 되었습니다"); 
		}
		//정상입력(실패)
			doGet(req, resp);
	}
}
