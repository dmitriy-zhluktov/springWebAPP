package com.arc;

import com.arc.config.DBConfig;
import com.arc.config.TestConfig;
import com.arc.model.dao.service.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DBConfig.class, TestConfig.class})
public class DaoTest {

    @Autowired
    UserDao userDao;

    @Test
    public void testUserExists() {
        Assert.notNull(userDao.findByUserName("admin2"));
    }
}
