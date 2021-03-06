package lv.javaguru.cms.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CompanyDTO extends BaseDTO {

    private String title;
    private String registrationNumber;
    private String legalAddress;
    private String bankName;
    private String bankBicSwift;
    private String bankAccount;
    private String memberOfTheBoard;
    private Boolean pvnPayer;

}
