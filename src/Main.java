import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) throws IOException {
        // Method 1
        System.out.println("Method 1");
        Path path = Path.of("..", "..", "Desktop", "biostats.csv");
        List<String[]> collectedList = Files.lines(path)
                .map((line) -> {
                    String[] fields = line.split(",");
                    return fields;
                })
                .collect(Collectors.toList());

        for (int i = 0; i < collectedList.size(); i++) {
            String[] tempArr = collectedList.get(i);
            for (int j = 0; j < tempArr.length; j++) {
                System.out.print(tempArr[j]);
            }
            System.out.println();
        }

        // Method 2
        System.out.println("Method 2");
        List<String[]> List = new ArrayList<>();
        Path path_2 = Path.of("..", "..", "Desktop", "biostats.csv");
        BufferedReader br = new BufferedReader(new FileReader(path.toFile()));
        String tempLine = "";
        while ((tempLine = br.readLine()) != null) {
            // String[] tempString = tempLine.split(",");
            List.add(tempLine.split(","));
        }
        br.close();

        for (int i = 0; i < List.size(); i++) {
            String[] tempArr = List.get(i);
            for (int j = 0; j < tempArr.length; j++) {
                System.out.print(tempArr[j]);
            }
            System.out.println();
        }

        // Method 3
        System.out.println("Method 3");
        List<String[]> List_1 = CSV_1();
        for (int i = 0; i < List.size(); i++) {
            String[] strings = List.get(i);
            for (int j = 0; j < strings.length; j++) {
                System.out.print(strings[j] + " ");
            }
            System.out.println();
        }

        // Method 4
        System.out.println("Method 4");
        CSV_2();

    }

    private static List<String[]> CSV_1() throws IOException {
        Path path = Path.of("..", "..", "Desktop", "biostats.csv");
        List<String[]> collectedList = Files.lines(path)
                .map((line) -> {
                    String fields[] = line.split(",");
                    return fields;
                })
                .collect(Collectors.toList());
        return collectedList;
    }

    private static void CSV_2() {
        Path path = Path.of("..", "..", "Desktop", "biostats.csv");
        ArrayList<String> List = new ArrayList<>();
        String tempLine = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path.toFile()));
            while ((tempLine = br.readLine()) != null) {
                List.add(tempLine);
            }
            br.close();
            List.forEach((n) -> System.out.println(n));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



