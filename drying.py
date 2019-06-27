#!/usr/bin/python3
import RPi.GPIO as GPIO
import Adafruit_DHT
import time
from firebase.firebase import FirebaseApplication
from firebase import firebase
from Adafruit_IO import *


GPIO.setmode(GPIO.BCM)
GPIO.setup(27, GPIO.OUT)
GPIO.setup(22, GPIO.OUT)
GPIO.setup(4, GPIO.OUT)
GPIO.setup(17, GPIO.IN)
Temperature = 0
Humidity = 0


def GetTempHumid():
  global Temperature, Humidity
  Humidity,Temperature = (Adafruit_DHT.read_retry(Adafruit_DHT.AM2302, 17))
  print(Temperature,Humidity)
  
 
#switching off relays/components
def switchingoff():
    GPIO.output(27,True)
    GPIO.output(22,True)
    GPIO.output(4,True)
    
 #for vegetables and fruits drying can be done in parallel  
def switchingon1():
    if (Temperature <=36):  
        time.sleep(1)
        #air distributor
        GPIO.output(27,False)
        print('air Distributor is on')
        #extractor fan
        GPIO.output(4,True)
        print('extractor fan is off')
        #heater
        GPIO.output(22, False)
        print ('heater is on')
        time.sleep(1)
        #GPIO.output(4, GPIO.HIGH)
        print ('four')
        time.sleep(1)
        
#    #cooling the inside if temperature goes above threshold
    elif (Temperature > 38):
        #Distributor fan on
        GPIO.output(27, False)
        print ('distributor fan on and working properly')
        time.sleep(1)
        #extractor fan on
        GPIO.output(4, False)
        print ('Extractor fan on and working properly')
        time.sleep(1)
        #heater is off
        GPIO.output(22, True)
        print('heater turned off')
    elif(Temperature >= 40):
        #extractor fan on
        GPIO.output(4, False)
        print ('Extractor fan working properly')
        time.sleep(1)
        #Distributor fan on
        GPIO.output(27, False)
        print ('distributor fan off working properly')
        time.sleep(1)
         #heater is off
        GPIO.output(22, True)
        print('heater turned off')
        

 #for meat and fish       
def switchingon2():
    #minimum threshold
    if (Temperature <= 71.1):  
        time.sleep(1)
        #air distributor on
        GPIO.output(27,False)
        print('air Distributor is on')
        #extractor fan off
        GPIO.output(4,True)
        print('extractor fan is off')
        #heater is on
        GPIO.output(22, False)
        print ('heater is on')
        time.sleep(1)
        #GPIO.output(4, GPIO.HIGH)
        print ('four')
        time.sleep(1)
     #moderate/in between threshold
#    #cooling the inside if temperature goes above threshold
    elif (Temperature > 72):
        #Distributor fan on
        GPIO.output(27, False)
        print ('distributor fan working properly')
        time.sleep(1)
        #extractor fan off
        GPIO.output(4, False)
        print ('Extractor fan working properly')
        time.sleep(1)
        #heater is off
        GPIO.output(22, True)
        print('heater turned off')
        
    #maximum threshold
    elif(temperature >= 73.9):
        #extractor fan on
        GPIO.output(4, False)
        print ('Extractor fan working properly')
        time.sleep(1)
        #Distributor fan on
        GPIO.output(27, False)
        print ('distributor fan off working properly')
        time.sleep(1)
         #heater is off
        GPIO.output(22, True)
        print('heater turned off')
        


        
        print('zikuchitika')
                
        
   
     
  
print('chiyauyyh')
while True:
    GetTempHumid()
    
    app=FirebaseApplication('https://iot-drier-1050f.firebaseio.com/',None)
    #posting data to to firebase realtime DB
    #result1 = app.post("/Temperature",str(Temperature))
    result1 = app.post('TempHumid' , {'Temperature':str(Temperature),'Humidity' : str(Humidity)})
    #result2= app.post('Humidity',str(Humidity))
   #reading from realtime firebase DB
    result = app.get('Commands',None)
    print(result)
    
    
    if(result== 0):
       switchingoff()
      
    elif(result==1):
          
       switchingon1()
       print('Drying for vegFruits')
       
    if (result==0):
       switchingoff()
       
    elif(result==2):
       switchingon2()
       print('Drying for fishmeat')
       
  #visualisation on Adafruit-io    
    aio = Client('chiya', '05afb239ccd44c36a09d140c7cb39bbf')
    print('loaded')

    aio.send("temperature",Temperature)
    print('temperature sent')
    aio.send("humidity",Humidity)
    print('humidity sent')     
                
    
 

        
        # GPIO.output(33, GPIO.HIGH)
        
    
print('ZIKUTHEKA')
GPIO.cleanup()
