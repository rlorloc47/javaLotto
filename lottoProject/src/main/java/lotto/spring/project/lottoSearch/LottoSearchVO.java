package lotto.spring.project.lottoSearch;

public class LottoSearchVO {
	private int history_key;
	private int history_idx;
	private String history_date;
	private String ballList;
	private int ball_number;
	private int ballCount;
	private int bonus_number;
	
	//21.08.31 검색 조건
	private String startYear;
	private String endYear;
	private String orderBy;
	private String searchNumber;
	private String bonusYN;
	private String searchKeyword;
	private int searchNumberCount;
	
	//21.09.03 페이지 처리
	private int limitStartPage;
	private int limitEndPage;
	private int pageNo;
	private String PagingStr;
	
	//21.09.12 담청지역 리스트
	private String address_ori;
	private String auto_type;
	private int win_order;
	private String company_name;
	private String code_content;
	
	
	 
	public String getCode_content() {
		return code_content;
	}
	public void setCode_content(String code_content) {
		this.code_content = code_content;
	}
	public String getAddress_ori() {
		return address_ori;
	}
	public void setAddress_ori(String address_ori) {
		this.address_ori = address_ori;
	}
	public String getAuto_type() {
		return auto_type;
	}
	public void setAuto_type(String auto_type) {
		this.auto_type = auto_type;
	}
	public int getWin_order() {
		return win_order;
	}
	public void setWin_order(int win_order) {
		this.win_order = win_order;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public int getSearchNumberCount() {
		return searchNumberCount;
	}
	public void setSearchNumberCount(int searchNumberCount) {
		this.searchNumberCount = searchNumberCount;
	}
	public String getPagingStr() {
		return PagingStr;
	}
	public void setPagingStr(String pagingStr) {
		PagingStr = pagingStr;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
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
	public int getBonus_number() {
		return bonus_number;
	}
	public void setBonus_number(int bonus_number) {
		this.bonus_number = bonus_number;
	}
	public String getBonusYN() {
		return bonusYN;
	}
	public void setBonusYN(String bonusYN) {
		this.bonusYN = bonusYN;
	}
	public int getBallCount() {
		return ballCount;
	}
	public void setBallCount(int ballCount) {
		this.ballCount = ballCount;
	}
	public int getBall_number() {
		return ball_number;
	}
	public void setBall_number(int ball_number) {
		this.ball_number = ball_number;
	}
	public int getHistory_key() {
		return history_key;
	}
	public void setHistory_key(int history_key) {
		this.history_key = history_key;
	}
	public int getHistory_idx() {
		return history_idx;
	}
	public void setHistory_idx(int history_idx) {
		this.history_idx = history_idx;
	}
	public String getHistory_date() {
		return history_date;
	}
	public void setHistory_date(String history_date) {
		this.history_date = history_date;
	}
	public String getBallList() {
		return ballList;
	}
	public void setBallList(String ballList) {
		this.ballList = ballList;
	}
	public String getStartYear() {
		return startYear;
	}
	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}
	public String getEndYear() {
		return endYear;
	}
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getSearchNumber() {
		return searchNumber;
	}
	public void setSearchNumber(String searchNumber) {
		this.searchNumber = searchNumber;
	}
	
	
	
}
