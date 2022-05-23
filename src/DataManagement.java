import java.io.*;

public class DataManagement {
    String data, data1;

    public void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter first and last name");
        data = br.readLine();
    }

    public void writeDataToFile() throws IOException {
        System.out.println("Saving data");
        try (FileWriter fw = new FileWriter("namelist.txt", true)){
            fw.write("\n" + data);
        }catch (IOException e){
            System.out.println("Data write error");
        }
    }

    public void readDataFromFile() throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader("namelist.txt"))){
            System.out.println("Reading data");
            while ((data1 = br.readLine()) != null){
                System.out.println(data1);
            }
        } catch (IOException e){
            System.out.println("Data loading error");
        }
    }
}

class Main{
    public static void main(String[] args) throws IOException {
        DataManagement dm = new DataManagement();
        dm.readData();
        dm.writeDataToFile();
        dm.readDataFromFile();
    }
}