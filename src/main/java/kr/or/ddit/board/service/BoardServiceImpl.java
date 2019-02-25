package kr.or.ddit.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;

public class BoardServiceImpl implements IBoardService{

	private IBoardDao boardDao;
	
	public BoardServiceImpl(){
		boardDao = new BoardDaoImpl();
	}
	@Override
	public int insertboard(BoardVo boardVo) {
		SqlSessionFactory sqlSessionFactory = 
				MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int insertCnt = boardDao.insertboard(sqlSession, boardVo);
		
		sqlSession.commit();
		sqlSession.close();
		
		return insertCnt;
	}
	@Override
	public List<BoardVo> getBoardList() {
		SqlSessionFactory sqlSessionFactory =
				MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<BoardVo> boardList = boardDao.getBoardList(sqlSession);
		sqlSession.close();
		return boardList;
	}
	@Override
	public List<BoardVo> boardList_Y() {
		SqlSessionFactory sqlSessionFactory =
				MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<BoardVo> boardList_Y = boardDao.boardList_Y(sqlSession);
		sqlSession.close();
		return boardList_Y;
	}

}
