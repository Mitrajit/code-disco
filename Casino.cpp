/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Mitrajit
 *
 * Created on August 5, 2019, 2:41 PM
 */

#include <cstdlib>
#include <iostream>

using namespace std;

/* Casino
 * 
 */
int main(int argc, char** argv) {
    int balance,guess,bid;
    char pa;
    cout<<"Welcome to our Casino"<<endl;
    cout<<"Enter your balance: $ ";
    cin>>balance;
    do{cout<<"\033[2J";
    cout<<"\nGuess a number between 1 to 10 if u guess correct u will win 10 times the money else you will lose all of it"<<endl;
    cout<<"Enter betting amount $ ";
    cin>>bid;
    balance-=bid;
    if(balance>=0){
    cout<<"\nEnter the guessing number:  ";
    do{
        cin>>guess;
        if(guess<1||guess>10)
            cout<<"Not range, enter the number again: ";
    }while(guess<1||guess>10);
    if(rand()%10+1==guess){
        cout<<"\nCongratulations you have won $ "<<bid*10<<endl;
        balance+=bid*10;
    }
    else
        cout<<"\nBad luck! You have lost the guess"<<endl;
    
    cout<<"Do you want to play again(Y/N): ";
    cin>>pa;
    }
    else
    {   cout<<"\nlow balance"<<endl;
        balance+=bid;
        break;
    }
         
    }while(pa=='Y');
        
    cout<<"You return with $ "<<balance;
    return 0;
}
