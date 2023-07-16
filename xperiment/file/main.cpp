#include <iostream>
#include <fstream>
using namespace std;

int main(){
    fstream file;
    // file.open("out.txt",ios::out);
    // file<<"Message from out Hello World !!!"<<endl;
    // file.close();
    file.open("out.txt",ios::app);
    if(file.is_open()){
        file<<"Message from out Hello World 3 !!!";//<<endl;
        file.close();
    }
    file.open("out.txt",ios::in);
    if(file.is_open()){
        string ln;
        while(getline(file,ln)){
            cout<<ln<<endl;
        }
        file.close();
    }


}