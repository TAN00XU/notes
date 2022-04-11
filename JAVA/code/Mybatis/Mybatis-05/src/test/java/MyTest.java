import com.tan00xu.dao.StudentMapper;
import com.tan00xu.dao.TeacherMapper;
import com.tan00xu.pojo.Student;
import com.tan00xu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        mapper.listStudents().forEach(System.out::println);

        sqlSession.close();
    }

}
