/*
* File: Reader.java
* Author: Hanák Renáta
* Copyright: 2025, Hanák Renáta
* Group: Szoft 1/N
* Date: 2025-03-11
* Github: https://github.com/Reni-dev
* Licenc: MIT
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

    public ArrayList<Worker> readFile() {
        try {
            return tryReadFile();
        } catch (FileNotFoundException e) {
            System.err.println("Hiba! Fájl nem található!");
            System.err.println(e.getMessage());
            return null;
        }        
    }

    private ArrayList<Worker> tryReadFile() throws FileNotFoundException {
        ArrayList<Worker> workerList = new ArrayList<>();

        File file = new File("laktatkft.txt");
        try(Scanner sc = new Scanner(file, "utf8")) {

            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] arr = line.split(";");
                Worker worker = new Worker();

                worker.name = arr[0];
                worker.city = arr[1];
                worker.address = arr [2];
                worker.birth = LocalDate.parse(arr[3]);
                worker.salary = Double.parseDouble(arr[4]);
                
                workerList.add(worker);
            }
        }  
        return workerList;      
    }
}
