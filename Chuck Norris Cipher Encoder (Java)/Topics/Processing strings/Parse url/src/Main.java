import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String urlInput = scanner.nextLine();

        String[] components = urlInput.split("\\?");
        components[1] = components[1].replaceAll("=&", "=not found&");
        String[] pieces = components[1].split("&");

        String password = "";
        Boolean containsPass = false;


        for (int i = 0; i < pieces.length; i++){
            pieces[i].replaceAll("\\=  ", "not found");
            System.out.println(pieces[i].replaceAll("\\=", " : "));
            if (pieces[i].contains("pass")){
                password = pieces[i];
                containsPass = true;
            }
        } if (containsPass == true){
            System.out.println(password.replaceAll("pass=", "password : "));
        }


    }
}