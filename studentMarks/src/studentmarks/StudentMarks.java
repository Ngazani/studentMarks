/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmarks;

import javax.swing.*;

/**
 *
 * @author ngazani
 */
public class StudentMarks {

    static double lowest, highest, passRate; //variable store lowest and highest marks as well as the passRate
    static int passedStudent = 0; //variable to keep track of the number of students that passed

    public static void main(String[] args) {

        String[] headings = {"Names", "Exam", "Ament'", "Test", "Final"}; //array that stores the headings
        int noOfStudents = Integer.parseInt(JOptionPane.showInputDialog(null, "How many students are there")); //user prompt
        double[][] Marks = new double[noOfStudents][4];     //array to store the marks based on how many students there are
        double finalMark[] = new double[noOfStudents]; //array to store the final marks calculated
        String[] studentNames = new String[noOfStudents]; // array to store the names of each student

        System.out.print(headings[0] + "\t" + headings[1] + "\t"
                + headings[2] + "\t" + headings[3] + "\t" + headings[4] + "\t \n"); //heading display

        for (int i = 0; i < noOfStudents; i++) { //loop to display the rows of the table based on how many students there are
            studentNames[i] = JOptionPane.showInputDialog(null, "enter name of student"); //prompt
            System.out.print(studentNames[i] + "\t"); //output the enterd name
            Marks[i][0] = Double.parseDouble(JOptionPane.showInputDialog(null, "enter exam mark")); //initializing the first column of the "i"th row of the table
            Marks[i][1] = Double.parseDouble(JOptionPane.showInputDialog(null, "enter assignment mark")); //initializing the second column of the "i"th row of the table
            Marks[i][2] = Double.parseDouble(JOptionPane.showInputDialog(null, "enter test mark"));//initializing the third column of the "i"th row of the table
            finalMark[i] = (Marks[i][0] / 100 * 50) + (Marks[i][1] / 100 * 25) + (Marks[i][2] / 100 * 25);// calculation of the final mark
            Marks[i][3] = finalMark[i]; //assigning the final mark to the last index of the table

            for (int x = 0; x < 4; x++) { //loop to display the columns 
                System.out.print(Marks[i][x] + "%" + "\t");   //display
            }
            System.out.println();//moving to the next line
        }
        //assigning the highest and lowest to the last column of the table
        highest = Marks[0][3];
        lowest = Marks[0][3];
        //loop to search the final mark column in the 2d array for the highest and lowest value 
        for (int j = 0; j < noOfStudents; j++) {
            for (int x = 0; x < 3; x++) {
                //determining the highest value in the final column
                if (highest > Marks[j][3]) {
                    highest = highest;
                } else {
                    highest = Marks[j][3];
                }
                //determining the lowest vallue in the final column
                if (lowest < Marks[j][3]) {
                    lowest = lowest;
                } else {
                    lowest = Marks[j][3];
                }

            }
            //detremining how many students got above 50
            if (Marks[j][3] >= 50) {
                passedStudent = passedStudent + 1;
            } else {
                passedStudent = passedStudent;
            }
            //calculating pass rate based on passed students
            passRate = (passedStudent * 100) / noOfStudents;
        }
        //displaying the highest mark,lowest mark, students that passed, and the pass rate
        System.out.println("Highest final mark recorded: " + highest);
        System.out.println("Lowest final mark recorded: " + lowest);
        System.out.println("Students that passed: " + passedStudent);
        System.out.println("Student Pass Rate " + passRate + "%");
    }

}
