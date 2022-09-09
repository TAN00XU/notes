package controller;

import model.Account;
import utils.ReadWriteUtils;

import java.util.ArrayList;

/**
 * 帐户控制器类
 *
 * @author TAN00XU
 * @date 2022/09/08
 */
public class AccountController {

//    private ArrayList<Account> accounts = new ArrayList<>();

    /**
     * 添加账户
     *
     * @param account 账户
     * @return boolean
     */
    public static boolean addAccount(Account account) {
        ArrayList<Account> accounts = listAccounts();
        if(accounts!=null) {

            for (Account thisAccount : accounts) {
                if (thisAccount.getUsername().equals(account.getUsername())) {
                    return false;
                }
            }
        }else {
            accounts = new ArrayList<>();
        }
        accounts.add(account);
        ReadWriteUtils.writeObject(accounts, "accounts.txt");
        return true;
    }

    /**
     * 登录
     *
     * @param account 账户
     * @return {@link Account}
     */
    public static Account login(Account account) {
        ArrayList<Account> accounts = listAccounts();
        if (accounts != null) {
            for (Account thisAccount : accounts) {
                if (thisAccount.getUsername().equals(account.getUsername()) && thisAccount.getPassword().equals(account.getPassword())) {
                    return thisAccount;
                }
            }
        }
        return null;
    }

    /**
     * 查询账户列表
     *
     * @return {@link ArrayList}<{@link Account}>
     */
    public static ArrayList<Account> listAccounts() {
        return (ArrayList<Account>) ReadWriteUtils.readObject("accounts.txt");
    }

    public static int getId() {
        int id = 0;
        ArrayList<Account> accounts = listAccounts();
        if (accounts != null) {
            for (Account account : accounts) {
                if (account.getId() > id) {
                    id = account.getId();
                }
            }

        }
        return ++id;
    }
}
