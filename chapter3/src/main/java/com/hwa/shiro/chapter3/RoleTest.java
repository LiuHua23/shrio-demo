package src.main.java.com.hwa.shiro.chapter3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by LiuHua on 2018/5/7
 */
public class RoleTest extends src.main.java.com.hwa.shiro.chapter3.BaseTest {

    @Test
    public void testHasRole() {
        login("classpath:shiro-role.ini", "wang", "123");
        //判断拥有的角色：role1
        Assert.assertTrue(subject().hasRole("role1"));
        //判断拥有角色：role1 and role2
//        Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role1", "role2")));
        //判断拥有角色：role1 and role2 and !role3
//        boolean[] result = subject().hasRoles(Arrays.asList("role1", "role2", "role3"));
//        Assert.assertEquals(true, result[0]);
//        Assert.assertEquals(true, result[1]);
//        Assert.assertEquals(true, result[2]);
    }
}
