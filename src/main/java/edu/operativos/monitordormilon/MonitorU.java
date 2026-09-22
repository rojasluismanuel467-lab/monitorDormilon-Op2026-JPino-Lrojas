package edu.operativos.monitordormilon;

import java.util.concurrent.Semaphore;


public class MonitorU extends Thread{

   
    private Semaphore  monitorChair;
    private Semaphore  corridorChairs; 
    private Semaphore  isSleep;

    public MonitorU(Semaphore monitorChair, Semaphore corridorChair, Semaphore isSleep){
        super();
        this.monitorChair = monitorChair;
        this.corridorChairs = corridorChair;
        this.isSleep = isSleep;
    }


    public void run(){


        while(true){

            try {

                System.out.println("MONITOR DURMIENDO");
                isSleep.acquire();

                System.out.println("ME DESPERTARON ATENDERE A UNA PERSONA");

                

            

    
            } catch (Exception e) {

                System.out.println(e.toString());
            }

    


        }

    }


   

    


}