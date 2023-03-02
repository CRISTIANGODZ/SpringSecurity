import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @auther DyingZhang
 * @Create 2023-02-25 上午 11:07
 * @Discriptioon
 */

public class TestBcyptPasswordEncoder {

    @Test

    public void test1() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode("12345");
        System.out.println(password);
    }
}
