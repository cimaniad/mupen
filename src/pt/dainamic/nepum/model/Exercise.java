/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.dainamic.nepum.model;


/**
 *
 * @author jorge
 */
public class Exercise {

    private int idExercise;
    private String description;
    private int level;
    private String name;
    private String picture;
    private int time;
    private String domain;
    private String subDomain;

    public Exercise(int idExercise, String description, int level, String name, String picture, int time, String domain, String subDomain) {
        this.idExercise = idExercise;
        this.description = description;
        this.level = level;
        this.name = name;
        this.picture = picture;
        this.time = time;
        this.domain = domain;
        this.subDomain = subDomain;
    }

    public int getIdExercise() {
        return idExercise;
    }

    public String getDescription() {
        return description;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public String getPicture() {
        return picture;
    }

    public int getTime() {
        return time;
    }

    public String getDomain() {
        return domain;
    }

    public String getSubDomain() {
        return subDomain;
    }

    
}
