/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ismart.ismartonline.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class NotificationUser {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    private Notification notification;

    @ManyToOne
    private User user;
    
    private boolean visualized;

    public NotificationUser() {
    }

    public NotificationUser(Long id, Notification notification, User user, boolean visualized) {
        this.id = id;
        this.notification = notification;
        this.user = user;
        this.visualized = visualized;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isVisualized() {
        return visualized;
    }

    public void setVisualized(boolean visualized) {
        this.visualized = visualized;
    }    
}
