/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author meshboy
 */
public class CalendarAssignment {

    static Date date;

    public static void main(String[] args) throws FileNotFoundException, IOException {

        System.out.println("Enter your year of choice");

        Scanner input = new Scanner(System.in);

        int year = input.nextInt();

//        instantiate calendar 
        Calendar calendar = new GregorianCalendar(year, 0, Calendar.SUNDAY);

        calendar.set(Calendar.DAY_OF_WEEK, year);

        int i = 1;
        
        StringBuffer buffer = new StringBuffer(); 

        while (calendar.get(Calendar.YEAR) == year) {

            date = calendar.getTime();

            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

            int month = calendar.get(Calendar.MONTH);

           /**
            * observe public holidays 
            * that are not changing 
            */
            switch (month) {

                case 0:
                    if (dayOfWeek == 1) {
                        calendar.add(Calendar.DATE, 1);
                    }

         
                case 4:
                    if (dayOfWeek == 1 || dayOfWeek == 27 || dayOfWeek == 29) {

                        calendar.add(Calendar.DATE, 2);
                    }
                    break;
              

                case 11:
                    if (dayOfWeek == 25) {

                        calendar.add(Calendar.DATE, 2);
                    }
                    break;

            }

            /**
             * check out the working days
             */
//            If it's Friday so skip to Monday
            if (dayOfWeek == Calendar.FRIDAY) {

                calendar.add(Calendar.DATE, 3);

            } 
//            If it's Saturday skip to Monday
            else if (dayOfWeek == Calendar.SATURDAY) {

                calendar.add(Calendar.DATE, 2);

            } else {

                calendar.add(Calendar.DATE, 1);
            }

//            System.out.println(date);
            
            buffer.append(String.valueOf(date + "\n"));
            
            
            i++;

        }
        /**
         * output result to a text file 
         */
        BufferedWriter writer = null;
            try {                                    
                
                writer = new BufferedWriter(new FileWriter("output.txt"));
                writer.write(String.valueOf(buffer));

            } catch (IOException e) {
                
            } finally {
                try {
                    if (writer != null) {
                        writer.close();
                        System.out.println("Date now in file...");
                    }
                } catch (IOException e) {
                }
            }      


    }

}
