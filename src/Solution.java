/*
* File: Solution.java
* Author: Hanák Renáta
* Copyright: 2025, Hanák Renáta
* Group: Szoft 1/N
* Date: 2025-03-11
* Github: https://github.com/Reni-dev
* Licenc: MIT
*/

import java.time.LocalDate;
import java.util.ArrayList;

public class Solution {
    
    public void findOlderWorker(){
        Reader reader = new Reader();
        ArrayList<Worker> workerList = reader.readFile();

        int counter = 0;
        System.out.println("30 év feletti dolgozók száma:");
        LocalDate age = LocalDate.parse("1995-03-11");
        for(Worker worker : workerList) {
            if(worker.birth.isBefore(age)) {
                counter ++;
            }
        }
        System.out.println(counter);
    }


    public void avarageBudapest(){
        Reader reader = new Reader();
        ArrayList<Worker> workerList = reader.readFile();

        Double sumSalary = 0.0;
        int counter = 0;
        System.out.println("\nBudapesti dolgozók átlagbére:");
        for(Worker worker : workerList) {
            if(worker.city.equals("Budapest")) {
                sumSalary += worker.salary;
                counter ++;
            }            
         }
        
        System.out.println(sumSalary / counter);
    }

}
