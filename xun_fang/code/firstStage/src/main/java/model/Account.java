package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 * 账户类
 *
 * @author TAN00XU
 * @date 2022/09/08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
public class Account implements Serializable {
    /**
     * id
     */
    private int id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }


}
