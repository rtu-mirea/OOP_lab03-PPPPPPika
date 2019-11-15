import java.util.Scanner;

public class Admin extends User {
    Admin(){}

    public void AddUserADM(){
        Scanner input = new Scanner(System.in);

        String name = input.nextLine();
        String login = input.nextLine();
        String password = input.nextLine();

        SummitSystem.addUser(name, login, password);
    }

    public void PrintListUsers() { for(User host : SummitSystem.users){ System.out.println(host.getName()); } }
}
