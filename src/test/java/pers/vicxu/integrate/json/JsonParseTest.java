package pers.vicxu.integrate.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import pers.vicxu.integrate.pojo.User;
import pers.vicxu.integrate.util.JsonUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Create by JsonParseTest on 7/12/2018
 */
public class JsonParseTest {

    @Test
    public void testOutput() throws IOException {
        User user = new User(1, "Vic Xu", 10, true, new Date());
        ObjectMapper mapper = new ObjectMapper();
        mapper.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        mapper.writeValue(System.out, user);
    }

    @Test
    public void testInput() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        User u = mapper.readValue(new FileInputStream("user.data"),User.class);
        System.out.println(u.toString());
    }

    @Test
    public void testOutputArray() throws IOException {
        List<User> users = new ArrayList<>();
        for (int i =0; i< 10; i++)
            users.add(new User(1, "Vic Xu", 10, true, new Date()));
        ObjectMapper mapper = new ObjectMapper();
        mapper.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        mapper.writeValue(System.out, users);
    }

    @Test
    public void testInputputArray() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        List<User> users = mapper.readValue(new FileInputStream("user.data"),new TypeReference<List<User>>(){});
        users.forEach(user -> {
            System.out.println(user.toString());
        });
    }

    @Test
    public void testJson() throws Exception {
        User user = new User(1, "Vic Xu", 10, true, new Date());
        List<User> users = new ArrayList<>();
        for (int i =0; i< 10; i++)
            users.add(new User(1, "Vic Xu", 10, true, new Date()));
        String json = JsonUtil.parseObject2Json(users);
        System.out.println(json);

    }

}
