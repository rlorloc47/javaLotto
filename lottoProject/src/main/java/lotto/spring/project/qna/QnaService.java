package lotto.spring.project.qna;

import java.util.List;

public interface QnaService {
	List<QnaVO> qnaSelectList(QnaVO qnaVO);

	void qnaInsert(QnaVO qnaVO);

	int qnaMaxSeq();

	int qnaMaxGroupSeq();

	void qnaModify(QnaVO qnaVO);

	void qnaDel(QnaVO qnaVO);

	int qnaTotalCount(QnaVO qnaVO);

	QnaVO qnaSelect(QnaVO qnaVO);

}
