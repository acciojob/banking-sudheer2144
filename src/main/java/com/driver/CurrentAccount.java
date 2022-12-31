package com.driver;

import java.io.CharConversionException;
import java.util.HashMap;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        if( (balance) < (getMinBalance()) ){
            throw new myException("Insufficient Balance");
        }
        this.tradeLicenseId=tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        int idLength=tradeLicenseId.length();
        boolean even=false;
        if((idLength%2)==0){
            even=true;
        }
        HashMap<Character,Integer> freq=new HashMap<>();
        for(int i=0;i<idLength;i++){
            freq.put(tradeLicenseId.charAt(i),freq.getOrDefault(tradeLicenseId.charAt(i),0)+1);
        }
        for(int val:freq.values()){
            if( ( even && (val>idLength/2) ) || (!even && (val>((idLength/2)+1)) ) ){
                throw new myException("Valid License can not be generated");
            }
        }
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

}
