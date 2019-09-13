/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Mitrajit
 *
 * Created on July 31, 2019, 10:49 PM
 */

#include <cstdlib>
#include <iostream>
using namespace std;

/*tictactoe
 * 
 */
int main() {    
    int index;
    char  a='1',b='2',c='3',d='4',e='5',f='6',g='7',h='8',i='9',play='X';
    for(int j=0;j<=9;j++){
         cout<<"\033[2J";
    cout<<"Player 1(X) - Player 2(O)"<<endl;
    cout<<"     |     |     "<<endl;
    cout<<"  "<<a<<"  |  "<<b<<"  |  "<<c<<"  "<<endl;
    cout<<"_____|_____|_____"<<endl;
    cout<<"     |     |     "<<endl;
    cout<<"  "<<d<<"  |  "<<e<<"  |  "<<f<<"  "<<endl;
    cout<<"_____|_____|_____"<<endl;
    cout<<"     |     |     "<<endl;
    cout<<"  "<<g<<"  |  "<<h<<"  |  "<<i<<"  "<<endl;
    cout<<"     |     |     "<<endl;
    if((a==b&&b==c)||(a==d&&d==g)||(a==e&&e==i)||(b==e&&e==h)||(c==f&&f==i)||(d==e&&e==f)||(g==h&&h==i)||(g==e&&e==c))
    {
        if(j%2==1)
            cout<<"Player 1(X) wins";
        else
            cout<<"Player 2(O) wins";
        return 0;}
    if(j<9){
    if(j%2==0){
        cout<<"Player 1(X) : ";
        play='X';
    }
    else
    {
        cout<<"Player 2(O) : ";
        play='O';
    }   
    cin>>index;
    switch(index)
    {
        case 1:
            if(a!='X'&&a!='O')
                a=play;
            else
            {
                j--;
                continue;
            }
            break;
        case 2:
            if(b!='X'&&b!='O')
                b=play;
               else
            {
                j--;
                continue;
            }
            break;
        case 3:
            if(c!='X'&&c!='O')
                c=play;
               else
            {
                j--;
                continue;
            }
            break;          
        case 4:
            if(d!='X'&&d!='O')
                d=play;
            else
            {
                j--;
                continue;
            }
            break;
        case 5:
             if(e!='X'&&e!='O')
                e=play;
             else
            {
                j--;
                continue;
            }
            break;
        case 6:
           if(f='X'&&f!='O')
                f=play;
           else
            {
                j--;
                continue;
            }
            break;
        case 7:
            if(g!='X'&&g!='O')
                g=play;
            else
            {
                j--;
                continue;
            }
            break;
        case 8:
            if(h!='X'&&h!='O')
                h=play;
            else
            {
                j--;
                continue;
            }
            break;
        case 9:
            if(i!='X'&&i!='O')
                i=play;
            else
            {
                j--;
                continue;
            }
            break;
        default :
            cout<<"enter choice again"<<endl;
                j--;
                continue;
       }   
    }
    }
    cout<<"Match draw";
    return 0;
}

