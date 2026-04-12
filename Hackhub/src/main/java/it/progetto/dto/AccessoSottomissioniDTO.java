package it.progetto.dto;

public class AccessoSottomissioniDTO {
    private final int hackathonId;
    private final int teamId;
    private final String submissionLink;
    private final String messaggio;

    public AccessoSottomissioniDTO(int hackathonId, int teamId, String submissionLink, String messaggio) {
        this.hackathonId = hackathonId;
        this.teamId = teamId;
        this.submissionLink = submissionLink;
        this.messaggio = messaggio;
    }

    public int getHackathonId() {
        return hackathonId;
    }

    public int getTeamId() {
        return teamId;
    }

    public String getSubmissionLink() {
        return submissionLink;
    }

    public String getMessaggio() {
        return messaggio;
    }

    @Override
    public String toString() {
        return "AccessoSottomissioniDTO{" +
                "hackathonId=" + hackathonId +
                ", teamId=" + teamId +
                ", submissionLink='" + submissionLink + '\'' +
                ", messaggio='" + messaggio + '\'' +
                '}';
    }
}
