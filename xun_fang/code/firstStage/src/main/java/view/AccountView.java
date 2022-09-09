package view;

import controller.AccountController;
import model.Account;
import utils.CmdOutputInformationUtils;
import utils.InputUtils;

import java.util.ArrayList;

/**
 * @author TAN00XU
 * @date 2022/09/08 15:38
 */
public class AccountView {
    public static void main(String[] args) {
        CmdOutputInformationUtils.info("欢迎进入cmd学生管理系统");
        boolean flag = true;
        while (flag) {
            int i = InputUtils.getInt("请选择操作：\n\t1.学生注册\n\t2.学生登录\n\t其它退出系统");
            switch (i) {
                //注册
                case 1:
                    String username = InputUtils.getString("请输入用户名：");
                    String password = InputUtils.getString("请输入密码：");
                    Account account = new Account(AccountController.getId(), username, password);
                    if (AccountController.addAccount(account)) {
                        CmdOutputInformationUtils.debug("注册成功");
                    } else {
                        CmdOutputInformationUtils.error("注册失败");
                    }
                    break;
                //登录
                case 2:
                    username = InputUtils.getString("请输入用户名：");
                    password = InputUtils.getString("请输入密码：");
                    account = new Account(username, password);
                    Account login = AccountController.login(account);
                    if (login != null) {
                        CmdOutputInformationUtils.debug("登录成功\n用户：" + login.getUsername() + "\tid: " + login.getId());

                        boolean flag1 = true;
                        while (flag1) {
                            i = InputUtils.getInt("请选择操作：\n\t1.查看所有学生\n\t2.待开发\n\t其它退出系统");
                            switch (i) {
                                case 1:
                                    ArrayList<Account> accounts = AccountController.listAccounts();
                                    CmdOutputInformationUtils.warn("ID\t用户名");
                                    for (Account viewAccount : accounts) {
                                        CmdOutputInformationUtils.debug(viewAccount.getId() + "\t" + viewAccount.getUsername());
                                    }
                                    break;
                                case 2:
                                    System.out.println("待开发");
                                    break;
                                default:
                                    CmdOutputInformationUtils.error("已退出系统！");
                                    flag1 = false;
                            }
                        }


                    } else {
                        CmdOutputInformationUtils.error("登录失败");
                    }

                    break;
                default:
                    CmdOutputInformationUtils.error("已退出系统");
                    flag = false;
            }
        }
    }
}
