package lotto.spring.project.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnaServiceImpl implements QnaService {
	@Autowired
	QnaDao qnaDao;
	
	@Override
	public List<QnaVO> qnaSelectList() {
		List<QnaVO> qnalist = this.qnaDao.qnaSelectList();
		return qnalist;
	}
}
