package kr.or.ddit.board.service;
import java.util.List;
import java.util.Map;
import kr.or.ddit.board.model.BoardVo;

public interface IBoardService {

	/**
	 * 게시판 추가
	 * @param boardVo
	 * @return
	 */
	int insertboard(BoardVo boardVo); 
	
	/**
	 * 전체 게시판목록 조회
	 * @return
	 */
	List<BoardVo> getBoardList();

	/**
	 * 활성화된 게시판 리스트 조회
	 * @return
	 */
	List<BoardVo> boardList_Y();
	
	
}
