package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name=name;
        this.balance=balance;
        this.minBalance=minBalance;
    }

    public BankAccount() {

    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if((digits==1) && (sum<10)){
            return Integer.toString(sum);
        }
        int digit=0;
        int count=0;
        String accNumber="";
        if((sum%2) != 0){
            sum-=1;
            accNumber+="1";
            digits-=1;
        }
        for(int i=1;i<=sum;i++){
            double tmp=(double)sum/i;
            if(tmp==digits){
                count=(int)tmp;
                digit=i;
                break;
            }
            if((tmp<digits) && (tmp==Math.floor(tmp))){
                digit=i;
                count=(int)tmp;
                break;
            }
        }
        if((digit==0) || (digit==1) || (count==1) || (count==0)){
            throw new myException("Account Number can not be generated");
        }

        for(int i=1;i<=digits;i++){
            if(i <= count){
                accNumber+=Integer.toString(digit);
            }
            else{
                accNumber+="0";
            }
        }
        return accNumber;
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance+=amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if ((this.balance - amount) < (this.minBalance)) {
            throw new myException("Insufficient Balance");
        }else {
            this.balance=this.balance-amount;
        }
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

}