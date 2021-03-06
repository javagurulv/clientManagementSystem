package lv.javaguru.cms.rest.controllers.company.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lv.javaguru.cms.rest.BaseResponse;
import lv.javaguru.cms.rest.dto.CompanyDTO;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UpdateCompanyResponse extends BaseResponse {

    private CompanyDTO company;

}
