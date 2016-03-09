
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data_Access.AccountDBConnect;
import java.sql.SQLException;

/**
 *
 * @author Flory
 */
public class Account {
    private String oldPassword;
    private String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(char[] oldPassword) {
        
        this.oldPassword = charArrayToString(oldPassword);
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(char[] newPassword) {
        this.newPassword = charArrayToString(newPassword);
    }
    public void updateAccount(char[] newPassword, char[] oldPassword) throws ClassNotFoundException, SQLException{
        AccountDBConnect ac = new AccountDBConnect();
        this.setNewPassword(newPassword);
        ac.updatePassword(this);
    }
    
    public String charArrayToString(char[] array){
        String str = "";
        for(int i = 0; i < array.length; i++){
            str = str + array[i];
        }
        return str;
    }
    
    
}
