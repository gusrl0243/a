package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVo;

public class BoardDaoImpl implements IBoardDao{

	/**
	 * 게시판 등록
	 */
	@Override
	public int insertboard(SqlSession sqlSession, BoardVo boardVo) {
		return sqlSession.insert("board.insertboard", boardVo);
	}

	/**
	 * 게시판 목록 조회
	 */
	@Override
	public List<BoardVo> getBoardList(SqlSession sqlSession) {
		return sqlSession.selectList("board.getBoardList");
	}

	/**
	 * 활성화된 게시판 목록 조회
	 */
	@Override
	public List<BoardVo> boardList_Y(SqlSession sqlSession) {
		return sqlSession.selectList("board.boardList_Y");
	}




}
