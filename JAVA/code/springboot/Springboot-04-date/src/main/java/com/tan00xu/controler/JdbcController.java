package com.tan00xu.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 查询数据库的所有信息
     *
     * @return {@link List}<{@link Map}<{@link String}, {@link Object}>>
     */
    @GetMapping("/listAll")
    public List<Map<String,Object>> ListALl(){
        String sql = "select * from user";
        return jdbcTemplate.queryForList(sql);

    }

    /**
     * 添加用户
     *
     * @return {@link String}
     */
    @GetMapping("/addUser")
    public String addUser() {
        String sql = "insert into test.user(id,username,password) value (2,'小羊','123123')";
        jdbcTemplate.update(sql);
        return "OK";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id) {
        String sql = "update test.user set username =?,password =? where id="+id;
        //封装
        Object[] objects = new Object[2];
        objects[0] ="小谭";
        objects[1] = "zzzzzz";

        jdbcTemplate.update(sql,objects);
        return "OK";
    }

    @GetMapping("/delete/{id}")
    public String deleteUse(@PathVariable("id") int id) {
        String sql = "delete from test.user where id=?";
        jdbcTemplate.update(sql,id);
        return "OK";
    }

}
