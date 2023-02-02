import com.lxx.oa.utils.MybatisUtils;
import org.junit.Test;

/**
 * @author 林修贤
 * @date 2023/2/2
 * @description
 */
public class MybatisUtilsTestor {
    @Test
    public void testCase1(){
        String result = (String)MybatisUtils.executeQuery(sqlSession -> {
            String out = (String)sqlSession.selectOne("test.sample");
            return out;
        });
        System.out.println(result);
    }

    @Test
    public void testCase2(){
         String result = (String)MybatisUtils.executeQuery(sqlSession -> sqlSession.selectOne("test.sample"));
        System.out.println(result);
    }


}
