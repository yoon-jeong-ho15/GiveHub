package kh.GiveHub.payment;

import kh.GiveHub.payment.model.service.PaymentService;
import kh.GiveHub.payment.model.vo.PaymentRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import kh.GiveHub.member.model.exception.MemberException;
<<<<<<< HEAD
import kh.GiveHub.payment.model.service.PaymentService;
//import kh.GiveHub.payment.model.service.PaymentService;
=======
>>>>>>> branch 'main' of https://github.com/shpark47/GiveHub.git
import kh.GiveHub.payment.model.vo.Payment;
<<<<<<< HEAD
import kh.GiveHub.payment.model.vo.PaymentRequest;
//import kh.GiveHub.payment.model.vo.PaymentRequest;
=======
>>>>>>> branch 'main' of https://github.com/shpark47/GiveHub.git
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PaymentController {
	
	private final PaymentService pService;
	
    @PostMapping("/payment/complete")
    public ResponseEntity<String> paymentComplete(@RequestBody PaymentRequest request) {
        // 결제 완료 후 처리
    	Payment payment = new Payment();
    	
//    	System.out.println(request.getAmount());
//    	System.out.println(request.getName());
//    	System.out.println(request.getDoNo());
//    	System.out.println("멤버 번호는 ? = = = " + request.getMemNo());
    	
    	payment.setAmount(request.getAmount());
    	payment.setDonorName(request.getName());
    	payment.setDonationNo(request.getDoNo());
    	payment.setMemNo(request.getMemNo());
    	payment.setSuccess(true);
    	
    	int result = pService.savePayment(request);
    	
    	System.out.println(result);
    	
    	if(result>0) {
    		return ResponseEntity.ok("결제 완료");
    		
    	}else {
    		throw new MemberException("결제 실패");
    	}
    }
}
