package tekup.loan.soap.Service;


import de.tekup.soap.models.whitetest.*;
import org.springframework.stereotype.Service;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class LoanWhiteTestService {

    public WhiteTestResponse createWhitTest(StudentRequest studentRequest) {

    Exam exam1=new Exam();
        exam1.setCode("123");
        exam1.setName("JavaOca");
    Exam exam2=new Exam();
        exam2.setCode("456");
        exam2.setName("Java11-OCP");
    Student student1=new Student();
        student1.setId(1);
        student1.setName("John");
        student1.setAddress("London");
    Student student2=new Student();
        student2.setId(2);
        student2.setName("Alex");
        student2.setAddress("Paris");
    List<Student> studentList=new ArrayList<Student>();
    List<Exam> examList=new ArrayList<Exam>();
        studentList.add(student1);
        studentList.add(student2);
        examList.add(exam1);
        examList.add(exam2);
// date


        WhiteTestResponse whiteTestResponse=new ObjectFactory().createWhiteTestResponse();
        whiteTestResponse.setStudent(studentList.get(studentRequest.getStudentId()-1));
        whiteTestResponse.setExam(examList.get(studentRequest.getStudentId()-1));

        return whiteTestResponse;
    }



 public Student createStudent(Student student) {
        return student;

    }
    public Exam createExam(Exam exam) {
        return exam;

    }
}

