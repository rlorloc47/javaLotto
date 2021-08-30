package lotto.spring.project.lottoPercentage;

import java.util.List;

public class PercentageVO {
	private int history_key;
	private int history_idx;
	private String history_date;
	private String ballList;
	
	
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
	
	
	
}
