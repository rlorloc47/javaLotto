package lotto.spring.project.lottoSearch;

import java.util.List;

public interface LottoSearchService {
	List<LottoSearchVO> percentageSelectList(LottoSearchVO lottoSearchVO);
	List<LottoSearchVO> lottoSearchList(LottoSearchVO lottoSearchVO);	//21.09.03 복권조회리스트
	int lottoSearchCount(LottoSearchVO lottoSearchVO);	//21.09.03 복권조회전체카운트
}
