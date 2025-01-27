package kh.GiveHub.payment.model.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment {
	private int payNo;
    private String donorName; // 기부자 이름
    private int donationNo; // 게시글 번호
    private int amount; // 결제 금액
    private boolean success; // 결제 성공 여부
}

