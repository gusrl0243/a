package kr.or.ddit.board.model;

public class BoardVo {

	private String board_num;
	private String board_name;
	private String Y_N;
	
	public String getBoard_num() {
		return board_num;
	}
	public void setBoard_num(String board_num) {
		this.board_num = board_num;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getY_N() {
		return Y_N;
	}
	public void setY_N(String y_N) {
		Y_N = y_N;
	}
	public BoardVo(){
	}
	
	public BoardVo(String board_num, String board_name, String Y_N){
		this.board_num = board_num;
		this.board_name = board_name;
		this.Y_N = Y_N;
	}
	
	@Override
	public String toString() {
		return "BoardVo [board_num=" + board_num + ", board_name=" + board_name
				+ ", Y_N=" + Y_N + "]";
	}
	
	
}
