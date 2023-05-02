package application;

import entities.Funcionarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.printf("%nHow many employees will be  registered? ");
        int n = sc.nextInt();
        List <Funcionarios> funcList = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            System.out.printf("%nEmployee #%d:",(i+1));
            System.out.printf("%nId: ");
            int id = sc.nextInt();

            //Testar se já existe o Id escolhido
            while (hasID(funcList, id)){
                System.out.println("Id already taken! Try again: ");
                id = sc.nextInt();
            }

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            Funcionarios func = new Funcionarios(id, name, salary);

            funcList.add(func);
        }

        System.out.printf("%nEnter the employee id that will have salary increase: ");
        int findId = sc.nextInt();

        Funcionarios func = funcList.stream().filter(x-> x.getId() == findId).findFirst().orElse(null);
//        Integer pos = position(funcList, findId);

        if (func == null){
//        if (pos == null){
                System.out.print("This id does not exist!");
            }
            else {
                System.out.print("Enter the percentage: ");
                double percentage = sc.nextDouble();
                func.increaseSalary(percentage);
//                funcList.get(pos).increaseSalary(percentage);
        }

        System.out.printf("%nList of Employees:%n");
        for (Funcionarios x :
                funcList) {
            System.out.println(x);
        }

        System.out.println();
        sc.close();
    }


//Encontrar ID na lista (substituido pelo predicado)
    public static Integer position(List<Funcionarios> list, int id){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == id){
                return i;
            }
        }
        return null;
    }

    public static boolean hasID(List<Funcionarios> list, int id){
        Funcionarios emp = list.stream().filter(x-> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }





}
