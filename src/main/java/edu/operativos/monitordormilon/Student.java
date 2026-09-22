package edu.operativos.monitordormilon;

import java.util.concurrent.Semaphore;


public class Student extends Thread{

    private String name;
    private Semaphore monitorChair; 
    private Semaphore corridorChairs; 
    private Semaphore isSleep;
    private Semaphore  call;
    private Semaphore teaching;
    
    

    public Student(String name, Semaphore monitorChair, Semaphore corridorChairs, Semaphore isSleep, Semaphore call, 
        Semaphore teaching
    ){
        super();
        this.name = name;
        this.monitorChair = monitorChair; 
        this.corridorChairs = corridorChairs; 
        this.isSleep = isSleep;
        this.call = call;
        this.teaching = teaching;
    }

    public void run(){

        while(true){

            try {


                if(this.monitorChair.tryAcquire()){
                    this.isSleep.release();
                    System.out.println(this.name + "EN MONITORIA");
                    this.call.acquire();
                    this.monitorChair.release();
                    
                }else if(this.corridorChairs.tryAcquire()){

                    System.out.println(this.name + "EN SALA DE ESPERA");

                    this.monitorChair.acquire();
                    this.isSleep.release();
                    this.call.acquire();
                    this.corridorChairs.release();
                    this.monitorChair.release();

                }else{

                    System.out.println("ME VOY A LA SALA DE COMPUTO");
                }
              

                
            } catch (Exception e) {
                
                System.out.println(e.toString());


            }

           




        }


    }

    

    


}