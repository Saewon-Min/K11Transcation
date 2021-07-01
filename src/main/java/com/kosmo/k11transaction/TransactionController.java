package com.kosmo.k11transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import transaction.TicketDTO;
import transaction.TicketTplDAO;

/*
트랜잭션 매니저와 템플릿은 동시에 사용할 수 없으므로
2단계에서는 1단계의 모든 부분을 주석으로 처리한 후 진행한다.
TransactionController_back.java로 만들어 놓음
*/

@Controller
public class TransactionController {

	/*
	2.트랜잭션 템플릿을 활용한 처리
	 */
	// 자동주입시 setter를 사용하지 않아도 됨. 멤버변수에 직접 적용할 수 있음
	@Autowired
	private TicketTplDAO daoTpl;
	
	// 구매페이지
	@RequestMapping("/transaction/buyTicketTpl.do")
	public String buyTicketTpl() {
		
		return "08Transaction/buyTicketTpl";
	}
	
	// 구매 처리
	@RequestMapping("/transaction/buyTicketTplAction.do")
	public String buyTicketTplAction(TicketDTO ticketDTO,
			Model model) {
		
		// 폼값을 저장한 커맨드 객체를 매개변수로 구매 메소드 호출
		boolean isBool = daoTpl.buyTicket(ticketDTO);
		if(isBool==true) {
			// 정상 처리된 경우 모든 작업은 commit된다
			model.addAttribute("successOrFail","티켓구매가 정상처리 되었습니다.");
		}else {
			// 오류가 발생한 경우에는 모든 작업이 rollback된다.
			model.addAttribute("successOrFail","티켓구매가 취소되었습니다. 다시 시도해 주세요.");
		}
		
		model.addAttribute("ticketInfo",ticketDTO);
		
		return "08Transaction/buyTicketTplAction";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
