package lotto.spring.project.lottoSearch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LottoSearchServiceImpl implements LottoSearchService {
	@Autowired
	LottoSearchDao lottoSearchDao;
	
	@Override
	public List<LottoSearchVO> percentageSelectList(LottoSearchVO lottoSearchVO) {
		List<LottoSearchVO> percentageList = this.lottoSearchDao.percentageSelectList(lottoSearchVO);
		return percentageList;
	}

	@Override
	public List<LottoSearchVO> lottoSearchList(LottoSearchVO lottoSearchVO) {
		List<LottoSearchVO> lottoSearchList = this.lottoSearchDao.lottoSearchList(lottoSearchVO);
		return lottoSearchList;
	}

	@Override
	public int lottoSearchCount(LottoSearchVO lottoSearchVO) {
		int total_count = this.lottoSearchDao.lottoSearchCount(lottoSearchVO);
		return total_count;
	}
}
