package app;

import app.servise.FileReadService;
import app.servise.FileWriteService;
import app.utils.Constants;

import java.nio.file.Paths;
import java.util.Scanner;


public class Main {
    static String fileName;
    static String content;
    static Scanner scanner;
    static String strPath = Constants.BASE_PATH_IN;

    public static void main(String[] args) {
        runOption(getOption());

    }

    private static int getOption() {
        System.out.println("Choose an option : " + "\n1 - create file and enter data." +
                "\n2 - read file." + "\n0 - close app.");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();

    }

    private static void runOption(int option) {
        switch (option) {
            case 1 -> {
                doWriteFile();
                getOutput(handleCreateData());
                getOutput(handleWriteData());
            }
            case 2 -> {
                doReadFile();
                getOutput(handleReadData());

            }
            case 0 -> {
                System.out.println("App closed.");
                System.exit(0);
            }
            default -> System.out.println("Error. Wrong value " + option);


        }
    }

    public static void doWriteFile() {
        scanner = new Scanner(System.in);
        System.out.print("Enter file name: ");
        fileName = scanner.nextLine() + Constants.EXTENTION;
        System.out.print("Write the text: ");
        content = scanner.nextLine();
    }

    private static String handleCreateData() {
        strPath = Constants.BASE_PATH_IN + fileName;
        return new FileWriteService().createFile(strPath);
    }

    private static String handleWriteData() {
        strPath = Constants.BASE_PATH_IN + fileName;
        return new FileWriteService().writeFile(Paths.get(strPath), content);
    }

    public static void doReadFile() {
        scanner = new Scanner(System.in);
        System.out.print("Enter file name from which you need to read data : ");
        fileName = scanner.nextLine() + Constants.EXTENTION;

    }

    public static String handleReadData() {
        strPath = Constants.BASE_PATH_IN + fileName;
        return new FileReadService().readFile(strPath);

    }

    private static void getOutput(String output) {
        System.out.println(output);
    }


}
