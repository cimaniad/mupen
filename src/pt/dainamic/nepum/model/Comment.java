/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.dainamic.nepum.model;

/**
 *
 * @author Utilizador
 */
public class Comment {
    
    private int idComment;
    private int idAnswer;
    private String comment;
    private int idExercise;
    private String name;
    private String lastName;

    public Comment(int idComment, int idAnswer, String comment, int idExercise, String name, String lastName) {
        this.idComment = idComment;
        this.idAnswer = idAnswer;
        this.comment = comment;
        this.idExercise = idExercise;
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
    
    

    public int getIdComment() {
        return idComment;
    }

    public int getIdExercise() {
        return idExercise;
    }



    public int getIdAnswer() {
        return idAnswer;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" + "idComment=" + idComment + ", idAnswer=" + idAnswer + ", comment=" + comment + '}';
    }
    
    
    
    
}
