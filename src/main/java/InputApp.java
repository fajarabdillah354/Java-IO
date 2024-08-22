import java.util.Scanner;

public class InputApp {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//untuk input melalui console

        System.out.print("Masukan name : ");
        String nama = scanner.nextLine();
        System.out.print("Masukan Id : ");
        String id = scanner.nextLine();
        System.out.println("nama : "+nama+"\n"+"ID : "+id);
    }

}
