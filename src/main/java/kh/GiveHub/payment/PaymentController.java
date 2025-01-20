package kh.GiveHub.payment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/pay")
public class PaymentController {
	
    @PostMapping
    public ResponseEntity<Map<String, String>> handlePayment(@RequestParam("amount") String amount,
                                                              @RequestParam(value = "customAmount", required = false) String customAmount,
                                                              HttpServletRequest request) {
        // 사용자로부터 전달된 기부 금액 처리
        String selectedAmount = amount;
        if (customAmount != null && !customAmount.isEmpty()) {
            selectedAmount = customAmount;
        }

        // 결제 정보 확인
        Map<String, String> response = new HashMap<>();
        response.put("amount", selectedAmount);
        response.put("message", "기부 금액이 정상적으로 처리되었습니다.");

        // 여기서 아임포트 결제 API 호출 등을 처리할 수 있습니다.

        return ResponseEntity.ok(response);
    }

    @PostMapping("/payment/complete")
    public ResponseEntity<String> paymentComplete(@RequestBody Map<String, String> paymentData) {
        // 결제 완료 후 처리
        String impUid = paymentData.get("imp_uid");
        String merchantUid = paymentData.get("merchant_uid");

        // 여기에서 결제 정보를 서버에서 처리하고 저장할 수 있습니다.
        // 예를 들어 결제 완료 상태를 DB에 저장하거나, 알림을 보낼 수 있습니다.

        return ResponseEntity.ok("결제 완료");
    }
}
