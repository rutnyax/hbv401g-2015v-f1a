package is.hi.f1a;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, world. How are you?");
        League league = new League();
        league.createSchedule();
        for (int i=0;i<45;i++) {
            System.out.println(i+". "+league.getGames().get(i).getHomeTeam().getName()+" : "+league.getGames().get(i).getAwayTeam().getName());
        }
    }
}
