package kh.GiveHub.payment.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    int payNo;
    int payAmount;
    Date payCreatedate;
    String payStatus;
    int memNo;
    int doNo;
    String memName;
    String doTitle;
}
