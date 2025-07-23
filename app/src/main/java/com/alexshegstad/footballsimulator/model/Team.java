public class Team {

    private String name;
    private String location;
    private String stadiumName;
    private String ownerName;
    private Coach coach;
    private List<Player> roster;
    private boolean division;

    public Team(String name, String location, String stadium, String owner, Coach coach) {
        this.name = name;
        this.stadium = stadium;
        this.location = location;
        this.owner = owner;
        this.coach = coach;
        this.roster = new ArrayList<>();
    }

    public String getTeamName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getOwnerName() {
        return owner;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public List<Player> getRoster() {
        return roster;
    }

    public String getDivision() {
        if (division) {
            return East;
        } else {
            return West;
        }
    }

    @Override
    public String toString() {
        return "Team: " + name + "\nOwner: " + owner + "\nCoach: " + coach + "\nPlayers:\n " + roster;
    }
}
