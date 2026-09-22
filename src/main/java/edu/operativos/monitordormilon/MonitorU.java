package edu.operativos.monitordormilon;

import java.util.concurrent.Semaphore;


public class MonitorU extends Thread{

   
    private Semaphore  monitorChair;
    private Semaphore  corridorChairs; 
    private Semaphore  isSleep;
    private Semaphore  attending;

    public MonitorU(Semaphore monitorChair, Semaphore corridorChair, Semaphore isSleep, Semaphore attending){
        super();
        this.monitorChair = monitorChair;
        this.corridorChairs = corridorChair;
        this.isSleep = isSleep;
        this.attending =  attending;
    }


    public void run(){


        while(true){

            try {

                System.out.println("MONITOR DURMIENDO");
                isSleep.acquire();
                System.out.println("ME DESPERTARON ATENDERE A UNA PERSONA");
                attending.release();




            

    
            } catch (Exception e) {

                System.out.println(e.toString());
            }

    


        }

    }


   

    


}