package lotto.spring.project.lottoPercentage;

public class PercentageVO {
	private int history_key;
	private int history_idx;
	private String history_date;
	private String ballList;
	private int ball_number;
	private int ballCount;
	
	//21.08.31 검색 조건
	private String startYear;
	private String endYear;
	private String orderBy;
	private String searchNumber;
	private String bonusYN;
	
	
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
