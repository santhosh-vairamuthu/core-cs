import random
from tkinter import *
from xml.dom.pulldom import START_ELEMENT
from PIL import Image,ImageTk

import numpy as np
from requests import delete
import math



def multiply(mat1,mat2):
    result = [[]]
    for i in range(len(mat1[0])):
        result[0].append(0)
    # iterating by row of A
    for i in range(len(mat1)):
 
        # iterating by column by B
        for j in range(len(mat2[0])):
 
                # iterating by rows of B
            for k in range(len(mat2)):
                result[i][j] += mat1[i][k] * mat2[k][j]
    return result



def determination(mat):
    val = np.array(mat) 
    det = np.linalg.det(val)
    return det
    "#000000"
def generateKeyMatrix(len): 
    keyMatrix=[]
    for i in range(len):
        val=[]
        for j in range(len):
            r=random.randint(0,9)
            val.append(r)
        keyMatrix.append(val)
    if determination(keyMatrix)!=0:
        return keyMatrix
    else:
        generateKeyMatrix(len(keyMatrix))

def strToMatrix(str):
    eMatrix=[[]]
    for i in str:
        if i==" ":
            eMatrix[0].append(226)
        else:
            eMatrix[0].append(ord(i))
    return eMatrix


def matrixToStr(mat):
    message=""
    for i in mat:
        for j in i:
            if j==226:
                message+=" "
            else:
                message+=chr(j)

    return message

def matrixInversion(mat):
    rough_inversion=np.linalg.inv(mat)
    iMatrix=[]
    for i in rough_inversion:
        val=[]
        for j in i:
            val.append(float(j))
        iMatrix.append(val)
    return iMatrix


#getting input



#print(encode_matrix)
global imatrix,decode_matrix,encode_matrix,key_matrix
def decode():
    global imatrix,decode_matrix,encode_matrix,key_matrix
    imatrix=matrixInversion(key_matrix)


    decode_matrix=multiply(encode_matrix,imatrix)

    print(decode_matrix)
    for i in decode_matrix:
        c=0
        for j in i:
            decode_matrix[0][c]=round(j)
            c+=1
        
    message=matrixToStr(decode_matrix)
    return message

def encode(input_message):
    global imatrix,decode_matrix,encode_matrix,key_matrix
    #input_message=str(input("Enter Your message : "))



    ascci_matrix=strToMatrix(input_message)


    key_matrix=generateKeyMatrix(len(input_message))
    

    encode_matrix=multiply(ascci_matrix,key_matrix)

    encode_value="#"
    for i in encode_matrix:
        for j in i:
            encode_value+=":"
            encode_value+=str(j)
            
    #print(encode_value)
    return encode_value[2::]
class GUI:
    def __init__(self):
        print("Started")
        self.win=Tk()
        self.win['bg']="#b3ecec"
        self.win.geometry("1500x1000")
        self.val=StringVar()
        self.ret=StringVar()
        self.com="A"
        self.calcfont=("Times",18,"bold","italic")
        self.writfont=("Times",18,"bold","italic")

        if(self.com=="A"):
            self.Mess_Box("A")
        elif(self.com=="I"):
            self.Mess_Box("I")
    def eval2(self):
            a=str(self.val.get())
            self.t2.delete(1.0,END)
            self.t2.insert(END,decode())

    def eval1(self):
            a=str(self.val.get())
            self.t2.delete(1.0,END)
            self.t2.insert(END,encode(a))
    def send(self):
        self.val.set(self.t2.get(1.0,"end-1c"))
        self.Mess_Box(self.com)


    def Mess_Box(self,com):
            if(com=="A"):
                a_img=Image.open("D:\Files\pics\wallpaper\images (3).jpg")
                a_frm=ImageTk.PhotoImage(a_img.resize((1600,850)))
                a_im=Label(self.win,image=a_frm).place(x=0,y=0)
                
            else:
                a_img=Image.open("D:\Files\pics\wallpaper\images (3).jpg")
                a_frm=ImageTk.PhotoImage(a_img.resize((1600,850)))
                a_im=Label(self.win,image=a_frm).place(x=0,y=0)

                load=Image.open("D:\Files\pics\wallpaper\images (3).jpg")
                    #rend=ImageTk.PhotoImage(load.resize((1600,850)),format="gif - index".format(self.win))
                frames=[(ImageTk.PhotoImage(load,format="gif -index %d"%i)) for i in range(13)] 
                img=Label(self.win,image=frames[0]).place(x=0,y=0)
                def run():
                    load=Image.open("D:\Files\pics\wallpaper\images (3).jpg")
                    #rend=ImageTk.PhotoImage(load.resize((1600,850)),format="gif - index".format(self.win))
                    frames=[(ImageTk.PhotoImage(load,format="gif -index %i"%i)) for i in range(13)] 
                    for i in frames:
                            img=Label(self.win,image=i)
                            img.place(x=0,y=0)       
            self.f1=Frame(self.win,bg="#f0f0f0") # #910000 #ff9d1c #ff5c5c
            print(self.val)
            #head=Label(self.win,text="Message Encryptor",font=(c"Times new roman",60,"bold","italic"),fg="#00ffff",bg="#b3ecec",bd=4)
            self.t1=Entry(self.f1,textvariable=self.val,bd=4,justify="center",bg="#ffffff",fg="#000000")
            self.t2=Text(self.f1,bd=4,bg="#3b3b3b",fg="#41eb3b",height=5,width=100)
            #t3=Text(f1,font=("Helvetica",10,"bold","italic"),bd=4,height=4,width=37)
            self.enc=Button(self.f1,text='Encode',command=self.eval1,height=1,width=20,font=("Times New Roman",17,"bold","italic"),bd=2,bg="#ffffff",fg="#41eb3b")
            self.dec=Button(self.f1,text='Decode',command=self.eval2,height=1,width=20,font=("Times New Roman",17,"bold","italic"),bd=2,bg="#ffffff",fg="#41eb3b")
            self.send=Button(self.f1,text='Send->>',command=self.send,height=1,width=20,font=("Times New Roman",17,"bold","italic"),bd=2,bg="#ffffff",fg="#41eb3b")
            #dec=Button(f1,text='Decode',command=eval2,height=1,width=20,font=("Times New Roman",17,"bold","italic"),bd=4,bg="#fff9a8")
            #run=Button(self.win,text='run',command=run).place(x=50,y=50)
            if(self.com=="A"):
                self.f1.configure(width=933,height=235)
                self.t1.configure(font=self.writfont)
                self.t2.configure(width=59,height=2,font=self.calcfont)
                self.f1.place(x=520,y=180)
                self.t1.place(x=108,y=8,width=710,height=50)
                self.t2.place(x=108,y=90)
                #t3.place(x=500,y=100)
                self.enc.place(x=148,y=170)
                self.send.place(x=519,y=170) #462
                #dec.place(x=125,y=200)
                self.com="I"
            else:
                self.f1.configure(width=923,height=195)
                self.t1.configure(font=self.calcfont,justify="left",bg="#3b3b3b",fg="#41eb3b")
                self.t2.configure(width=54,height=1,font=self.writfont,bg="#ffffff",fg="#000000")
                self.f1.place(x=287,y=83)
                #head.place(x=400,y=10)
                self.t1.place(x=108,y=8,width=710,height=50)
                self.t2.place(x=108,y=90)
                #t3.place(x=500,y=100)
                self.dec.place(x=340,y=145)
                #dec.place(x=125,y=200)
                self.com="A"
            self.win.mainloop()

def decode():
    imatrix=matrixInversion(key_matrix)


    decode_matrix=multiply(encode_matrix,imatrix)

    print(decode_matrix)
    for i in decode_matrix:
        c=0
        for j in i:
            decode_matrix[0][c]=round(j)
            c+=1
        
    message=matrixToStr(decode_matrix)
    return message

def main():
        disp=GUI()
main()
while(1):
    main()




        