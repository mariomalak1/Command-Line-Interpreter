package Commands;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public  class cat implements ICommand {
    @Override
    public Boolean isValidArgs(String[] args) {
        return null;
    }

    @Override
    public void runCommand() {
        Scanner input = new Scanner(System.in);
        System.out.print("choose: \n 1- cat 1 file \n 2- cat 2 file \n");
        int choose= input.nextInt();

        if(choose == 1){
            System.out.print("enter file name: ");
            String file1 = input.next();
            OneFile(file1);
        }
        else{
            System.out.print("enter file1 name: ");
            String file1 = input.next();
            System.out.print("enter file2 name: ");
            String file2 = input.next();
            TwoFiles(file1,file2);
        }

    }


    public  void OneFile(String filename){
                try{
                    int fread;
                    FileInputStream file= new FileInputStream(filename);
                    ArrayList<Character> LookAheadBuffer = new ArrayList();

                    while((fread= file.read())!=-1)
                    {
                        LookAheadBuffer.add((char)fread);
                    }
                    for(int i=0; i<LookAheadBuffer.size(); i++){
                        System.out.print(LookAheadBuffer.get(i));
                    }

                }
                catch(Exception e){
                    System.out.print(e.getMessage());
                }

            }
            public static void TwoFiles(String filename1, String filename2){
                try{
                    int fread;
                    FileInputStream file1= new FileInputStream(filename1);
                    FileInputStream file2= new FileInputStream(filename2);

                    ArrayList<Character> LookAheadBuffer = new ArrayList();

                    while((fread= file1.read())!=-1)
                    {
                        LookAheadBuffer.add((char)fread);
                    }
                    while((fread= file2.read())!=-1)
                    {
                        LookAheadBuffer.add((char)fread);
                    }
                    for(int i=0; i<LookAheadBuffer.size(); i++){
                        System.out.print(LookAheadBuffer.get(i));
                    }
                }
                catch(Exception e){
                    System.out.print(e.getMessage());
                }
            }

    @Override
    public void PutArgs(String[] args) throws Exception {

    }
}

