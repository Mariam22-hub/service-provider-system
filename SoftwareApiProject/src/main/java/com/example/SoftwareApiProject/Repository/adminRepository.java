package com.example.SoftwareApiProject.Repository;

import com.example.SoftwareApiProject.Models.AddWalletTransactions;
import com.example.SoftwareApiProject.Models.Discounts.overall;
import com.example.SoftwareApiProject.Models.Discounts.specific;
import com.example.SoftwareApiProject.Models.NewService;
import com.example.SoftwareApiProject.Models.Transactions;
import com.example.SoftwareApiProject.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.example.SoftwareApiProject.Models.Admin.allTransactions;
import static com.example.SoftwareApiProject.Repository.userRepository.usersArray;


@Service
public class adminRepository {
    public static ArrayList<Transactions> transactionPays = new ArrayList<>();
    public static ArrayList<AddWalletTransactions> walletTransactions = new ArrayList<>();
    public static overall overallDiscount = new overall();
    public static specific specific= new specific();

    @Autowired
    public servicesProvidersRepository servicesRepo;

    public ArrayList<Transactions> findAllRefund() {
        if(allTransactions.size() > 0){
            return allTransactions;
        }
        return null;
    }


    public String updateUserRefund(int transId, int refundState) {
        String userName = allTransactions.get(transId).getUser();
        User user = null;

        for (User users : usersArray) {
            if (users.getUsername().equals(userName)) {
                user = users;
                break;
            }
        }
        if(refundState == 1) {
            for (int i = 0; i < user.transactionPay.size(); i++) {

                if (user.transactionPay.get(i).getService().getName().toLowerCase().equals(allTransactions.get(transId).getService().getName().toLowerCase())) {

                    user.transactionPay.get(i).setRefunded(true);
                    user.transactionPay.get(i).setChecked(true);
                    user.transactionPay.get(i).setRefund(false);

                    allTransactions.remove(allTransactions.get(transId));

                    return "user request accepted";
                }
            }
        }
        else {
            for (int i = 0; i < user.transactionPay.size(); i++) {
                if (user.transactionPay.get(i).getService().getName().toLowerCase().equals(allTransactions.get(transId).getService().getName().toLowerCase())) {

                    user.transactionPay.get(i).setRefunded(false);
                    user.transactionPay.get(i).setChecked(true);
                    user.transactionPay.get(i).setRefund(false);

                    allTransactions.remove(allTransactions.get(transId));

                    return "request rejected";
                }
            }
        }
        return "";
    }
    public ArrayList<Transactions> userPayTrans(String userName) {
        ArrayList<Transactions>userTrans = new ArrayList<>();

        for (int i=0;i<transactionPays.size();i++) {
            if (transactionPays.get(i).getUser().toLowerCase().equals(userName.toLowerCase())) {
                userTrans.add(transactionPays.get(i));
            }
        }

        if(userTrans!= null){
            return userTrans;
        }
        return  null;
    }

    public ArrayList<AddWalletTransactions> userWalletTrans(String userName) {
        ArrayList<AddWalletTransactions> userWalletTrans = new ArrayList<>();
        User user = null;

        for (int i=0; i < walletTransactions.size();i++) {
            if (walletTransactions.get(i).username.toLowerCase().equals(userName.toLowerCase())) {
                userWalletTrans.add(walletTransactions.get(i));
            }
        }

        if(userWalletTrans != null){
            return userWalletTrans;
        }
        return  null;
    }

    public String addProvider(NewService service) {
        servicesRepo.insert(service);
        return "service " + service.getName() + " is added to the list of service providers";
    }
}
