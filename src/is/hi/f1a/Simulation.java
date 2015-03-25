package is.hi.f1a;

import java.util.ArrayList;

public class Simulation {
    private Game game;
    private Team homeTeam;
    private Team awayTeam;
    private ArrayList<Player> home;
    private ArrayList<Player> away;

    public Simulation(Game game) {
        this.game = game;
        this.awayTeam = this.game.getHomeTeam();
        this.homeTeam = this.game.getAwayTeam();
        this.home = homeTeam.calculateStartingTeam();
        this.away = awayTeam.calculateStartingTeam();
    }
    public ArrayList<GameEvent> simulate(){
        throw new UnsupportedOperationException("Not implemented yet");
    }
    public void calculateGoals(ArrayList<Player> team, int minute) {
        ArrayList<Player> tempTeam = new ArrayList<Player>(team);
        for(Player player:team){
            if(player.getPosition() == Player.Position.MIDFIELDER) {
                tempTeam.add(player);
            }
            if(player.getPosition() == Player.Position.FORWARD) {
                tempTeam.add(player);
                tempTeam.add(player);
                if(player.getPrice()>= 8) {
                    tempTeam.add(player);
                }
            }
            if(player.getPrice()>= 7) {
                tempTeam.add(player);
            }
            if(player.getPrice()>= 10) {
                tempTeam.add(player);
            }
        }
        for(Player player:tempTeam){
            if(player.getPosition()== Player.Position.GOALKEEPER) {
                tempTeam.remove(player);
            }
        }
        int rand = ((int)(Math.random()))*tempTeam.size();
        GameEvent gameEvent = new GameEvent(minute,tempTeam.get(rand), GameEvent.Event.GOAL);

        game.addGameEvent(gameEvent);
    }

    public void calculateInjuries() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void calculateYellowCards(ArrayList<Player> team, int minute) {
        //throw new UnsupportedOperationException("Not implemented yet");
        ArrayList<Player> tempTeam = new ArrayList<Player>(team);
        for(Player player:team){
            if(player.getPosition() == Player.Position.DEFENDER) {
                tempTeam.add(player);
            }
            if (player.getGames()!=0){
                if (player.getYellowCards()/player.getGames() > 0.5) {
                    tempTeam.add(player);
                }
            }
        }
        int rand = ((int)(Math.random()))*tempTeam.size();
        GameEvent gameEvent = new GameEvent(minute,tempTeam.get(rand), GameEvent.Event.YELLOW_CARD);

        game.addGameEvent(gameEvent);
    }


    public void calculateRedCards(ArrayList<Player> team, int minute) {
        //throw new UnsupportedOperationException("Not implemented yet");
        ArrayList<Player> tempTeam = new ArrayList<Player>(team);
        for(Player player:team){
            if(player.getPosition() == Player.Position.DEFENDER) {
                tempTeam.add(player);
            }
            if (player.getGames()!=0){
                if (player.getRedCards()/player.getGames() > 0.2) {
                    tempTeam.add(player);
                }
            }
        }
        int rand = ((int)(Math.random()))*tempTeam.size();
        GameEvent gameEvent=new GameEvent(minute,tempTeam.get(rand), GameEvent.Event.RED_CARD);

        game.addGameEvent(gameEvent);
    }

}
