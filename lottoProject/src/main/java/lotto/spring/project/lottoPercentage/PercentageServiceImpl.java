package lotto.spring.project.lottoPercentage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PercentageServiceImpl implements PercentageService {
	@Autowired
	PercentageDao PercentageDao;
	
	@Override
	public List<PercentageVO> percentageSelectList(PercentageVO percentageVO) {
		List<PercentageVO> percentageList = this.PercentageDao.percentageSelectList(percentageVO);
		return percentageList;
	}
}
