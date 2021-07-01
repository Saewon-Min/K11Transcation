/*
 * package com.kosmo.k11transaction;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.RequestMapping;
 * 
 * import transaction.TicketDAO; import transaction.TicketDTO;
 * 
 * @Controller public class TransactionController_back {
 * 
 * 
 * 1. 트랜잭션 매니저를 활용한 트랜잭션 처리 : servlet-context.xml 에서 미리 생성한 DAO를 자동주입 받아 사용한다.
 * 
 * private TicketDAO dao;
 * 
 * @Autowired public void setDao(TicketDAO dao) { this.dao = dao;
 * System.out.println("@Autowired => TicketDAO 주입성공"); }
 * 
 * // 티켓 구매 페이지
 * 
 * @RequestMapping("/transaction/buyTicketMain.do") public String
 * buyTicketMain() {
 * 
 * return "08Transaction/buyTicketMain"; }
 * 
 * @RequestMapping("/transaction/buyTicketAction.do") public String
 * buyTicketAction(TicketDTO ticketDTO, Model model) {
 * 
 * 
 * 클라이언트가 전송한 폼값을 커맨드 객체를 통해 한번에 받아 DAO로 전달한다.
 * 
 * dao.buyTicket(ticketDTO); model.addAttribute("ticketInfo",ticketDTO);
 * 
 * return "08Transaction/buyTicketAction";
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 */