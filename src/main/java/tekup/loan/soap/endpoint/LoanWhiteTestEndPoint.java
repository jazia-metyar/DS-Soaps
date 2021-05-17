package tekup.loan.soap.endpoint;

import de.tekup.soap.models.whitetest.Exam;
import de.tekup.soap.models.whitetest.Student;
import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import tekup.loan.soap.Service.LoanWhiteTestService;

@Endpoint
public class LoanWhiteTestEndPoint {

    public static final String nameSpace="http://www.tekup.de/soap/models/whitetest";
    @Autowired
    LoanWhiteTestService service;
    @PayloadRoot(namespace = nameSpace, localPart ="WhiteTestResponse")
    @ResponsePayload
    public WhiteTestResponse PostWhitTest(@RequestPayload StudentRequest studentRequest) {
        return service.createWhitTest(studentRequest);
    }
 /* @PayloadRoot(namespace = nameSpace, localPart ="Exam")
    @ResponsePayload
    public Exam PostExam(@RequestPayload Exam exam) {
        return service.createExam(exam);
    }*/

}

