package Student_Factory;

import com.in.studentservice.Student_service;
import com.in.studentservice.Student_service_implementation;

public class StudentServiceFactory {
private static Student_service studentservice=null;
static {
	studentservice=new Student_service_implementation();
}
public static Student_service  getstudentservice() {
	return studentservice;
	
}
}
