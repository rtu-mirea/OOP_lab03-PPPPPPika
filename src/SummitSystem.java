import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SummitSystem {
    public static List<User> users = new ArrayList<User>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("1 Admin");
        System.out.println("2 User");
        System.out.println("0 Exit");

        int numSwitch = input.nextInt();

        while(numSwitch != 0)
        {
            switch (numSwitch)
            {
                case 1:
                    System.out.println("Admin");
                    System.out.println("Enter your data (login, password)");

                    Scanner input1 = new Scanner(System.in);

                    String login = input1.nextLine();
                    String password = input1.nextLine();

                    if(login.equals("adm") && password.equals("123")){
                        System.out.println("Welcom to the system");

                        Admin adm = new Admin();

                        System.out.println("1 Add user");
                        System.out.println("2 Print list users");
                        System.out.println("3 Selection of the summit variant");

                        int n1 = input1.nextInt();

                            switch (n1)
                            {
                                case 1:
                                    adm.AddUserADM();
                                    break;
                                case 2:
                                    adm.PrintListUsers();
                                    break;
                                case 3:
                                    processRequests();
                                    break;
                                default:
                                    System.out.println("ERROR");
                                    break;
                        }
                    }
                    else {
                        System.out.println("1 Admin");
                        System.out.println("2 User");
                        System.out.println("0 Exit");

                        numSwitch = 0;
                        numSwitch = input.nextInt();
                    }
                    break;
                case 2:
                    System.out.println("Choose your name");

                    for (int i = 0; i < users.size(); i++){ System.out.println("[" + i + "]" + " " + users.get(i).getName()); }

                    System.out.println("[123] Exit");

                    Scanner input2 = new Scanner(System.in);
                    Scanner input3 = new Scanner(System.in);

                    int numCN = input2.nextInt();

                    if (numCN > users.size() || numCN == 123) {
                        System.out.println("1 Admin");
                        System.out.println("2 User");
                        System.out.println("0 Exit");

                        numSwitch = 0;
                        numSwitch = input.nextInt();
                        break;

                    }
                    else{ System.out.println("Enter your details (login, password)"); }

                    String loginUs = input3.nextLine();
                    String passwordUs = input3.nextLine();

                    if (loginUs.equals("\n") && passwordUs.equals("\n") ){
                        System.out.println("1 Admin");
                        System.out.println("2 User");
                        System.out.println("0 Exit");

                        numSwitch = 0;
                        numSwitch = input.nextInt();
                    }

                    else if (loginUs.equals(users.get(numCN).getLogin()) && passwordUs.equals(users.get(numCN).getPassword()) ){
                        System.out.println("Welcom");
                        System.out.println("Choose action");
                        System.out.println("1 Add request");
                        System.out.println("2 Print your request");

                        Scanner input4 = new Scanner(System.in);

                        int numAc = input4.nextInt();

                        switch (numAc)
                        {
                            case 1:
                                Scanner input5 = new Scanner(System.in);

                                Leader ldr = new Leader();

                                String coun = input5.nextLine();
                                int mon = input5.nextInt();
                                int frm = input5.nextInt();
                                int t = input5.nextInt();

                                ldr.addRequests(coun, mon, frm, t);

                                break;
                            case 2:
                               System.out.println( Leader.PrintListRequests(numCN));
                                break;
                        }
                    }
                    else{
                        System.out.println("1 Admin");
                        System.out.println("2 User");
                        System.out.println("0 Exit");

                        numSwitch = 0;
                        numSwitch = input.nextInt();
                    }
                    break;
                case 0:
                    numSwitch = 0;
                default:
                    System.out.println("Error");
                    break;
            }
        }
    }

    public static void addUser(String name, String login, String password) { users.add(new User(name, login, password)); }

    private static void processRequests(){
        List<Request> uniq = new ArrayList<Request>();
        int voice = 0;

        uniq.add(new Request(null, 0, 0 , 0));

        for(int i = 0; i < Leader.requests.size(); i++){
            if(!Leader.requests.get(i).getCountry().equals(uniq.get(uniq.size() - 1).getCountry()) ||
                Leader.requests.get(i).getMonth() != uniq.get(uniq.size() - 1).getMonth() ||
                Leader.requests.get(i).getStartDay() != uniq.get(uniq.size() - 1).getStartDay() ||
                Leader.requests.get(i).getEndDay() != uniq.get(uniq.size() - 1).getEndDay()) { uniq.add(Leader.requests.get(i)); }

            for(int k = 0; k < Leader.requests.size(); k++){
                if(Leader.requests.get(i).getCountry().equals(Leader.requests.get(k).getCountry()) &&
                   Leader.requests.get(i).getMonth() == Leader.requests.get(k).getMonth() &&
                   Leader.requests.get(i).getStartDay() == Leader.requests.get(k).getStartDay() &&
                   Leader.requests.get(i).getEndDay() == Leader.requests.get(k).getEndDay()) { voice++; }
        }
            if(i > 0) { System.out.println("Country:" + uniq.get(i).getCountry() + " Month:" + uniq.get(i).getMonth() + " Start day:" + uniq.get(i).getStartDay() +
                        " End day:" + uniq.get(i).getEndDay() + " Number of voices:" + voice); }
            voice = 0;
        }
    }
}
//Идем оп массиву запросов ,проверяем есть ли запрос в массиве уникальных запросов , если встречаем новый уникальный запрос ,
// добавляем его в лист уникальных запросов и ставим ему 1 голос . Если этот запрос есть в массиве увеличчиваем количество голосов на 1
/*
requests:
uk 1 1 1
uk 1 1 1
uk 1 2 2
ua 1 2 2.

uniquereq:
(uk 1 1 1), 2
(uk 1 2 2), 1
(ua 1 2 2), 1
 */