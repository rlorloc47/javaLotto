package lotto.spring.project.qna;

public class QnaVO {
	private int qna_seq;
	private String content;	//21.09.05 내용
	private int sort_order;	//21.09.05 순서
	private String writer;	//21.09.05 작성자
	private int group_seq;	//21.09.05 그룹순서
	private String write_time;	//21.09.05 작성시간
	private String modify_time;	//21.09.05 수정시간
	private String passwd;	//21.09.08 비밀번호
	
	private String board_type;	//21.09.05 원글(Q-question),답글(A-answer) 여부
	
	//21.09.08 페이지 처리
	private int limitStartPage;
	private int limitEndPage;
	private int pageNo;
	private String PagingStr;
	
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public int getLimitStartPage() {
		return limitStartPage;
	}
	public void setLimitStartPage(int limitStartPage) {
		this.limitStartPage = limitStartPage;
	}
	public int getLimitEndPage() {
		return limitEndPage;
	}
	public void setLimitEndPage(int limitEndPage) {
		this.limitEndPage = limitEndPage;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public String getPagingStr() {
		return PagingStr;
	}
	public void setPagingStr(String pagingStr) {
		PagingStr = pagingStr;
	}
	public String getBoard_type() {
		return board_type;
	}
	public void setBoard_type(String board_type) {
		this.board_type = board_type;
	}
	public int getQna_seq() {
		return qna_seq;
	}
	public void setQna_seq(int qna_seq) {
		this.qna_seq = qna_seq;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getSort_order() {
		return sort_order;
	}
	public void setSort_order(int sort_order) {
		this.sort_order = sort_order;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getGroup_seq() {
		return group_seq;
	}
	public void setGroup_seq(int group_seq) {
		this.group_seq = group_seq;
	}
	public String getWrite_time() {
		return write_time;
	}
	public void setWrite_time(String write_time) {
		this.write_time = write_time;
	}
	public String getModify_time() {
		return modify_time;
	}
	public void setModify_time(String modify_time) {
		this.modify_time = modify_time;
	}
	
	
	
}
