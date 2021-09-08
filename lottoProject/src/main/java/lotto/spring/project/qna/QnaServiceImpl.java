package lotto.spring.project.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnaServiceImpl implements QnaService {
	@Autowired
	QnaDao qnaDao;
	
	@Override
	public List<QnaVO> qnaSelectList(QnaVO qnaVO) {
		List<QnaVO> qnalist = this.qnaDao.qnaSelectList(qnaVO);
		return qnalist;
	}

	@Override
	public void qnaInsert(QnaVO qnaVO) {
		this.qnaDao.qnaInsert(qnaVO);
	}

	@Override
	public int qnaMaxSeq() {
		int maxQnaSeq = this.qnaDao.qnaMaxSeq();
		return maxQnaSeq;
	}

	@Override
	public int qnaMaxGroupSeq() {
		int maxGroupSeq = this.qnaDao.qnaMaxGroupSeq();
		return maxGroupSeq;
	}

	@Override
	public void qnaModify(QnaVO qnaVO) {
		this.qnaDao.qnaModify(qnaVO);
	}

	@Override
	public void qnaDel(QnaVO qnaVO) {
		this.qnaDao.qnaDel(qnaVO);
	}

	@Override
	public int qnaTotalCount(QnaVO qnaVO) {
		return this.qnaDao.qnaTotalCount(qnaVO);
	}

	@Override
	public QnaVO qnaSelect(QnaVO qnaVO) {
		return this.qnaDao.qnaSelect(qnaVO);
	}
}
