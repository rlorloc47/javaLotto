package lotto.spring.project.raffle;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RaffleController {
	
	@RequestMapping(value = "/raffle", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		List<Integer> ranNumList = new ArrayList<Integer>();
		
		Random random = new Random();
		for(int i=0;i<6;i++) {
			int ranNum = random.nextInt(44)+1; //0~44까지 랜덤 +1 = 1~45까지 랜덤
			if(!ranNumList.contains(ranNum)) {
				ranNumList.add(ranNum);
			}else {
				i--;
			}
		}
		
		model.addAttribute("ranNumList", ranNumList);
		
		return ".tiles/raffle/raffleMain";
	}
}
