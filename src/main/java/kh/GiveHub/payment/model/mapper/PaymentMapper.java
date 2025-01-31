package kh.GiveHub.payment.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import kh.GiveHub.payment.model.vo.PaymentRequest;

@Mapper
public interface PaymentMapper {

	int savePayment(PaymentRequest request);

}
