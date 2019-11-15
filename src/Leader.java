import java.util.ArrayList;
import java.util.List;

public class Leader extends User {
    public static List<Request> requests = new ArrayList<Request>();

    Leader(){}

    public void addRequests (String county, int month, int from, int to) { requests.add(new Request(county, month, from, to)); }
    public static String PrintListRequests(int number){
        if(requests.size() > 0) {
            if (requests.get(number) != null)
                return "Country: " + requests.get(number).getCountry() + " Month:" + requests.get(number).getMonth() + " Start day:" + requests.get(number).getStartDay() + " End day:" + requests.get(number).getEndDay();
            else return "Not found request";
        }
        else return "Not found request";
    }
}
