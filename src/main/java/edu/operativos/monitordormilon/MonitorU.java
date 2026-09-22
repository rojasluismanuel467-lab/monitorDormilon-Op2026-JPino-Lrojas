package edu.operativos.monitordormilon;

import java.util.concurrent.Semaphore;


public class MonitorU extends Thread{

   
    private Semaphore  monitorChair;
    private Semaphore  corridorChairs; 
    private Semaphore  isSleep;
    private Semaphore  call;
    private Semaphore teaching;

    public MonitorU(Semaphore monitorChair, Semaphore corridorChair, Semaphore isSleep, Semaphore call, Semaphore teaching){
        super();
        this.monitorChair = monitorChair;
        this.corridorChairs = corridorChair;
        this.isSleep = isSleep;
        this.call =  call;
        this.teaching = teaching;
    }


    public void run(){


        while(true){

            try {

                System.out.println("MONITOR DURMIENDO");
                isSleep.acquire();
                System.out.println("ME DESPERTARON ATENDERE A UNA PERSONA");
                call.release();
                teaching.release();
                Thread.sleep(1000 + (int)(Math.random() * 2000));
                teaching.acquire();
    
            } catch (Exception e) {

                System.out.println(e.toString());
            }

    


        }

    }


   

    


}