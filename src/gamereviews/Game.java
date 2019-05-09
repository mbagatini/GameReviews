/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamereviews;

/**
 *
 * @author morganabagatini
 */
public class Game {
    //title;platform;score_phrase;score;genre;editors_choice;release_year
    
    private String title;
    private String platform;
    private String score_phrase;
    private float score;
    private String editors_choice;
    private int release_year;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getScore_phrase() {
        return score_phrase;
    }

    public void setScore_phrase(String score_phrase) {
        this.score_phrase = score_phrase;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getEditors_choice() {
        return editors_choice;
    }

    public void setEditors_choice(String editors_choice) {
        this.editors_choice = editors_choice;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }
    
    
    
}
