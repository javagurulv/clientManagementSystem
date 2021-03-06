package lv.javaguru.cms.rest.course.participant;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import lv.javaguru.cms.model.entities.enums.CourseType;
import lv.javaguru.cms.model.entities.enums.DayOfTheWeek;
import lv.javaguru.cms.model.entities.enums.Language;
import lv.javaguru.cms.rest.controllers.course.model.participant.GetCourseParticipantResponse;
import lv.javaguru.cms.rest.dto.CourseParticipantDTO;
import lv.javaguru.cms.rest.util.RestIntegrationTest;
import org.hamcrest.Matchers;
import org.junit.Test;

import static com.github.springtestdbunit.annotation.DatabaseOperation.DELETE_ALL;
import static com.github.springtestdbunit.assertion.DatabaseAssertionMode.NON_STRICT;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class GetCourseParticipantIntegrationTest extends RestIntegrationTest {

    @Test
    @DatabaseSetup(value = "classpath:dbunit/participant/get_course_participant/getCourseParticipant-ClientManager-setupDataset.xml")
    @ExpectedDatabase(value = "classpath:dbunit/participant/get_course_participant/getCourseParticipant-ClientManager-setupDataset.xml", assertionMode= NON_STRICT)
    @DatabaseTearDown(value = "classpath:dbunit/database-cleanup.xml", type = DELETE_ALL)
    public void shouldGetCourseParticipantsWithClientManagerRole() {
        GetCourseParticipantResponse response = sendRequest(CLIENT_MANAGER_LOGIN, CLIENT_MANAGER_PASSWORD, 1L, 1L);
        assertThat(response.isOk(), is(true));
        assertThat(response.getErrors(), is(nullValue()));
        CourseParticipantDTO participant = response.getParticipant();
        assertThat(participant.getStatus(), is("ACTIVE"));
        assertThat(participant.getBillCount(), is(1));
        assertThat(participant.getOneBillAmount(), is(100));
        assertThat(participant.getCourse().getId(), is(1L));
        assertThat(participant.getCourse().getTitle(), is("Java 1 - Introduction to Java"));
        assertThat(participant.getCourse().getLanguage(), is(Language.RU));
        assertThat(participant.getCourse().getStartDate(), is("10.01.2019"));
        assertThat(participant.getCourse().getEndDate(), is("10.01.2020"));
        assertThat(participant.getCourse().getCourseType(), is(CourseType.IN_CLASS));
        assertThat(participant.getCourse().getAddress(), is("Skolas 21, cabinet 508c"));
        assertThat(participant.getCourse().getLessonsTimeFrom(), is("18:00"));
        assertThat(participant.getCourse().getLessonsTimeTo(), is("21:00"));
        assertThat(participant.getCourse().getDayOfTheWeek(), is(DayOfTheWeek.MONDAY));
        assertThat(participant.getCourse().getFullPrice(), is(400));
        assertThat(participant.getCourse().getModifiedBy(), is("client_manager_login"));
        assertThat(participant.getCourse().getCreatedAt(), is(Matchers.notNullValue()));
        assertThat(participant.getCourse().getModifiedAt(), is(Matchers.nullValue()));

        assertThat(participant.getClient().getId(), is(1L));
        assertThat(participant.getClient().getFirstName(), is("Vasja"));
        assertThat(participant.getClient().getLastName(), is("Pupkin"));
        assertThat(participant.getClient().getPhoneNumber(), is("+371222"));
        assertThat(participant.getClient().getEmail(), is("email@emal.lv"));
        assertThat(participant.getClient().getPromoCode(), is("promoCode"));
        assertThat(participant.getClient().getPersonalCode(), is("xxxxx"));
        assertThat(participant.getClient().getComment(), is("comment"));
        assertThat(participant.getClient().getSchoolkid(), is(Boolean.FALSE));
        assertThat(participant.getClient().getStudent(), is(Boolean.FALSE));
        assertThat(participant.getClient().getModifiedBy(), is("client_manager_login"));
        assertThat(participant.getClient().getCreatedAt(), is(Matchers.notNullValue()));
        assertThat(participant.getClient().getModifiedAt(), is(Matchers.nullValue()));
    }

    private GetCourseParticipantResponse sendRequest(String userName,
                                                     String password,
                                                     Long courseId,
                                                     Long participantId) {
        return getRestTemplate(userName, password).getForObject(
                baseUrl() + "/course/" + courseId + "/participant/" + participantId, GetCourseParticipantResponse.class);
    }

}
