package lv.javaguru.cms.rest.controllers.course.model.participant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lv.javaguru.cms.model.entities.enums.CourseParticipantStatus;
import lv.javaguru.cms.rest.BaseRequest;

import javax.validation.constraints.NotNull;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UpdateCourseParticipantRequest extends BaseRequest {

    @NotNull
    private Long courseId;

    @NotNull
    private Long participantId;

    @NotNull
    private CourseParticipantStatus status;

}
