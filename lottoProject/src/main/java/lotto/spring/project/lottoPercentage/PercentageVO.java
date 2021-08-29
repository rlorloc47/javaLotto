package lotto.spring.project.lottoPercentage;

import java.util.List;

public class PercentageVO {
	private int history_key;
	private int history_idx;
	private String history_date;
	private int ball_number;
	private String bonus_yn;
	private List<String> ballList;
	
	
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
	public int getBall_number() {
		return ball_number;
	}
	public void setBall_number(int ball_number) {
		this.ball_number = ball_number;
	}
	public String getBonus_yn() {
		return bonus_yn;
	}
	public void setBonus_yn(String bonus_yn) {
		this.bonus_yn = bonus_yn;
	}
	public List<String> getBallList() {
		return ballList;
	}
	public void setBallList(List<String> ballList) {
		this.ballList = ballList;
	}
	
	
	
}
