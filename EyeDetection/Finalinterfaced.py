import cv2
import serial
import numpy as np
#from matplotlib import pyplot as plt
import time
from pygame import mixer
import sqlite3
from time import sleep
import pyautogui




conn = sqlite3.connect('blink.db')
c = conn.cursor()
sql = "SELECT * FROM threeorfive WHERE common = ? "
wordused='select'

##3 second blink detected. modify data of column 1 to 1
##elsekeep it to 0
def tableCreate():
    c.execute("CREATE TABLE threeorfive(common Text,ID INT, keyword TEXT, value REAL)")

def dataEntry():
    c.execute("INSERT INTO threeorfive VALUES('select',1,'Three seconds',1)")
    c.execute("INSERT INTO threeorfive VALUES('select',2,'Five seconds',1)")
    c.execute("INSERT INTO threeorfive VALUES('select',3,'light',1)")
    c.execute("INSERT INTO threeorfive VALUES('select',4,'fan',1)")
    conn.commit()

def update3():
    #if detected then
    c.execute("UPDATE threeorfive SET value = 0 WHERE ID=1")
    c.execute("UPDATE threeorfive SET value = 1 WHERE ID=2")
    conn.commit()
    #else elsecondi()
    
def update5(): 
    c.execute("UPDATE threeorfive SET value = 1 WHERE ID=1")
    c.execute("UPDATE threeorfive SET value = 0 WHERE ID=2")
    conn.commit()
    
def elsecondi():
    c.execute("UPDATE threeorfive SET value = 1 WHERE ID=1")
    c.execute("UPDATE threeorfive SET value = 1 WHERE ID=2")
    c.execute("UPDATE threeorfive SET value = 1 WHERE ID=3")
    c.execute("UPDATE threeorfive SET value = 1 WHERE ID=4")
    conn.commit()
def fan():
    
    c.execute("UPDATE threeorfive SET value = 0 WHERE ID=4")
    conn.commit()
def fanloop():
    if "value = 0 WHERE ID=4":
        print 'oolaalaaa'

def printonconsole():
   
    for i in c.execute(sql,[(wordused)]):
        print i       
        


count=0

'''
zigbee_port = "COM3"
budrate=9600
ser=serial.Serial(zigbee_port,9600)

'''
#time.sleep(k)

cap = cv2.VideoCapture(1)                                   #change ur parameter as 0 or 1 depending on which cam u using
k=0
k1=0
ini=1
loo=0
pyautogui.click(726, 109)

while(True):
    #time.sleep(1)
    ret, img_rgb = cap.read()
    img_gray = cv2.cvtColor(img_rgb, cv2.COLOR_BGR2GRAY)
    template = cv2.imread('temp.jpg',0)                     #this temp.jpg is a small image of your eye....this is the template that it is going to examine the presence of
    w, h = template.shape[::-1]

    res = cv2.matchTemplate(img_gray,template,cv2.TM_CCOEFF_NORMED)
    threshold = 0.909                  #u can change this value to fiddle with detection...i m getting best result at 0.8...(must be bw 0 to 1)
    loc = np.where(res >= threshold)
    empty=[]
    
    c.execute("SELECT value FROM threeorfive") 
    
    result = c.fetchall()
    
    if result[2]==(0.0,):
        
        if k==0:
            #ser.write("a")#'light on'
            print 'light on'
            k=1
        elif k==1:
            #ser.write("b")#'light off'
            print 'light off'
            k=0
        c.execute("UPDATE threeorfive SET value = 1 WHERE ID=3")
        conn.commit()
    if result[3]==(0.0,):
        if k1==0:
            #ser.write("c")#'light on'
            print 'FAN IS ON'
            k1=1
        elif k1==1:
            #ser.write("d")#'light off'
            k1=0
        print "fan is oFF"
        c.execute("UPDATE threeorfive SET value = 1 WHERE ID=4")
        conn.commit()
        
    
    
        
    
    start = time.clock()
    empty=[]

    if zip(*loc[::-1]) != empty:
        end = time.clock()

        time_count = end - start

        count=count+time_count
        #print count 
                
    
    elif zip(*loc[::-1]) == empty:

        
        counter= count*2900
        if counter!=0:
            print counter
        
        
        
        if counter>=1 and counter<=3:
           update3()
           #pyautogui.click(10, 10)
           pyautogui.press('right')
           printonconsole()


        if counter>4:
           update5()
           #pyautogui.click(10, 10)
           
           pyautogui.typewrite('\n')
           printonconsole()


        count = 0
        
        



    
    for pt in zip(*loc[::-1]):
        cv2.rectangle(img_rgb, pt, (pt[0] + w, pt[1] + h), (0,0,255), 2)
        
                  
    cv2.imshow('res.jpg',img_rgb)


    
    if cv2.waitKey(1) & 0xFF == ord('q'):
        
        break



cv2.waitKey(0)
cv2.destroyAllWindows()
