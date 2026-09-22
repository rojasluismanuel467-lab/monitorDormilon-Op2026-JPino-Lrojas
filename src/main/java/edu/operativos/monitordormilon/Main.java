package edu.operativos.monitordormilon;

import java.util.concurrent.Semaphore;


/**
 * Punto de entrada del proyecto monitorDormilon.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("monitorDormilon: proyecto inicializado.");

        Semaphore monitorChair = new Semaphore(1, true);
        Semaphore corridorChairs = new Semaphore(3, true);
        Semaphore isSleep = new Semaphore(0, true);
        Semaphore call = new Semaphore(0, true);
        Semaphore teaching  = new Semaphore(0,true);

        MonitorU monitor = new MonitorU(monitorChair, corridorChairs, isSleep, call, teaching);
        Student student0 = new Student("Estudiante-1", monitorChair, corridorChairs, isSleep, call, teaching);
        Student student1 = new Student("Estudiante-2", monitorChair, corridorChairs, isSleep, call, teaching);
        Student student2 = new Student("Estudiante-3", monitorChair, corridorChairs, isSleep,  call, teaching);


        monitor.start();
        student0.start();
        student1.start();
        student2.start();


        
    }
}
