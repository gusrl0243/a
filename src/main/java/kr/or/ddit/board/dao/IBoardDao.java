package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVo;

public interface IBoardDao {

	int insertboard(SqlSession sqlSession,BoardVo boardVo);

	List<BoardVo> getBoardList(SqlSession sqlSession);

	List<BoardVo> boardList_Y(SqlSession sqlSession); 
}
