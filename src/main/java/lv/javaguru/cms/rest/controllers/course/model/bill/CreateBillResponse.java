package lv.javaguru.cms.rest.controllers.course.model.bill;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lv.javaguru.cms.rest.BaseResponse;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreateBillResponse extends BaseResponse {

    private Long billId;

}
