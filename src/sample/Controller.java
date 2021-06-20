package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Controller {


@FXML
    private Button createForm;
@FXML
    private TextField nameForm;

@FXML
    private PasswordField passForm;

@FXML
    private PasswordField confirmPass;

@FXML
    private TextField idForm;

@FXML
    private TextField numberForm;

@FXML
    private TextField addressForm;

@FXML
    private ComboBox <String>dayForm;

@FXML
    private ComboBox<String> monthForm;

@FXML
    private TextField  yearForm;


@FXML
    private ComboBox<String> genderForm;

@FXML
    private Button checkIdForm;


List<UserAccount> userAccountList=new ArrayList<>();

public void createAccount(ActionEvent event){
    boolean checkInformation=true;
    UserAccount userAccount=new UserAccount();
    if(checkIdForm()){
        userAccount.setUserName(idForm.getText());
    } else {
        checkInformation=false;
    }


    userAccount.setAddress(addressForm.getText());
    userAccount.setGender(genderForm.getValue());
    userAccount.setPhoneNumber(numberForm.getText());
    try{
        userAccount.setAge(Year.now().getValue()-Integer.parseInt(yearForm.getText()));
    }catch (Exception e){
        checkInformation=false;
        e.printStackTrace();
    }
    userAccount.setFullname(nameForm.getText());
    if(passForm.getText().equals(confirmPass.getText())){
        userAccount.setPassword(passForm.getText());

    }else{
        checkInformation=false;
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Xác nhận mật khẩu không đúng!");
        alert.show();
    }
    if(checkInformation){
        userAccountList.add(userAccount);
    }
    display();

}
public boolean checkIdForm(){
    for (UserAccount userAccount:userAccountList){
        if(userAccount.getUserName().equals(idForm.getText())){
            return true;
        }
    }
    return false;
}
public void alertCheckIdForm(){
    Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
    if(checkIdForm()){
        alert.setContentText("Tên đăng nhập đã tồn tại!");
        alert.show();
    } else {
        alert.setContentText("Tên đăng nhập hợp lệ!");
        alert.show();
    }
}
public void display(){
   for (UserAccount userAccount:userAccountList){
       System.out.println(userAccount.toString());
   }

}



}
