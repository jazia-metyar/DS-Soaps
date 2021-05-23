package tekup.loan.soap.Service;

import de.tekup.soap.models.whitetest.*;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.*;

@Service
public class whittestservice {

	 XMLGregorianCalendar dateExam;




	public  WhiteTestResponse CreateWhiteTest(StudentRequest studentRequest) {
		WhiteTestResponse response = new ObjectFactory().createWhiteTestResponse();



		// Creation  list  Steudent
					Student student1=new Student();
					student1.setId(1);
					student1.setName("John");
					student1.setAddress("London");
					Student student2=new Student();
					student2.setId(2);
					student2.setName("Alex");
					student2.setAddress("Paris");

					List<Student> studentList=new ArrayList<Student>();
					studentList.add(student1);
					studentList.add(student2);

		//creation MAp Exam
					Exam exam1=new Exam();
					exam1.setCode("123");
					exam1.setName("JavaOca");
					Exam exam2=new Exam();
					exam2.setCode("456");
					exam2.setName("Java11-OCP");

					Map<String,Exam> examMAp=new HashMap<>();
					examMAp.put(exam1.getCode(),exam1);
					examMAp.put(exam2.getCode(),exam2);
            System.err.println(studentList);


     // initialise studentResponse && examResponse
				Student studentResponse;
				Exam examResponse;

			   if(studentRequest.getStudentId()>studentList.size())
			   {
				  studentResponse=null;

			   }
				else {
					studentResponse = studentList.get(studentRequest.getStudentId()-1);
				}
				if(examMAp.containsKey(studentRequest.getExamCode())) {
					 examResponse = examMAp.get(studentRequest.getExamCode());
				}
				else {
					examResponse=null;

				}

		if(studentResponse != null && examResponse != null ) {

			XMLGregorianCalendar dateexam = null;
			try {

				dateexam = DatatypeFactory                           
				.newInstance()                          
				.newXMLGregorianCalendar(                
				    GregorianCalendar.from(             
				        LocalDate  
				        .now()
				        .plusDays(5)           
				        .atStartOfDay( ZoneOffset.UTC )   
				    )

				);

			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	// set 	studentResponse
	// set	examResponse
	// set 	dateExam

			response.setStudent(studentResponse);
			response.setExam(examResponse);
		    response.setDate(dateExam);

		}
		return response;
	}
	
	

}
