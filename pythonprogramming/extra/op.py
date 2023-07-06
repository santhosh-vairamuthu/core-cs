from tkinter import*
from random import randint

color_changer= Tk()

def update():
    color="%05x" %randint(0,0xFFFFFF)
    color_changer.config(background ='#fcba03' + color)
    color_changer.after(1000, update)

update()
color_changer.title('color')
color_changer.geometry("400x400")
color_changer.mainloop()                                                                        