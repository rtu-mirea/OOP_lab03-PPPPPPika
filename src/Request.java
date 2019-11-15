public class Request {
    private String country;
    private int month;
    private int startDay;
    private int endDay;

    Request (String country, int month, int from, int to) {
        this.country = country;
        this.month = month;
        this.startDay = from;
        this.endDay = to;
    }

    public String getCountry(){ return  country; }
    public int getMonth(){ return month; }
    public int getStartDay(){ return startDay; }
    public int getEndDay(){ return endDay; }
}
