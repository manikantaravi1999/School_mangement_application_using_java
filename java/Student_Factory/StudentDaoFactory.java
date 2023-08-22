package Student_Factory;

import com.in.studentinformation_dao.Student_dao;
import com.in.studentinformation_dao.Student_dao_implementation;

public class StudentDaoFactory {
private static Student_dao_implementation studentdaoimpl=null;
static {
	studentdaoimpl=new Student_dao_implementation();
}
public static Student_dao getstudentdaoimpl() {
	return studentdaoimpl;
}
}
