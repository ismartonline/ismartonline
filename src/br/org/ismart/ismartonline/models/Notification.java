/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ismart.ismartonline.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Notification {

    @Id
    @GeneratedValue
    private Long id;
    
    private String title;
    private String brief;
    @Column(columnDefinition="TEXT")
    private String content;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="NotificationUnits", joinColumns=@JoinColumn(name="notification_id"))
    @Column(name="units")
    private List<String> units = new ArrayList();
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="NotificationYears", joinColumns=@JoinColumn(name="notification_id"))
    @Column(name="years")
    private List<String> years = new ArrayList();
    private Date date;
    
    @OneToMany(mappedBy = "notification", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<NotificationUser> notificationsUser;

    public Notification() {
    }

    public Notification(Long id, String title, String brief, String content, List<String> units, List<String> years, Date date) {
        this.id = id;
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.units = units;
        this.years = years;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getUnits() {
        return units;
    }

    public void setUnits(List<String> units) {
        this.units = units;
    }

    public List<String> getYears() {
        return years;
    }

    public void setYears(List<String> years) {
        this.years = years;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<NotificationUser> getNotificationsUser() {
        return notificationsUser;
    }

    public void setNotificationsUser(List<NotificationUser> notificationsUser) {
        this.notificationsUser = notificationsUser;
    }
    
    public String getFormattedDate() {
        if(this.getDate() != null)
            return new SimpleDateFormat("dd/MM/YYYY HH:mm").format(this.getDate());
        return this.getDate().toString();
    }
}
