package kh.GiveHub.member.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private int mem_no;
    private String mem_name;
    private String mem_id;
    private String mem_pwd;
    private String mem_address;
    private String mem_type;
    private String mem_grade;
    private String mem_status;
    private String mem_confirm;
}
