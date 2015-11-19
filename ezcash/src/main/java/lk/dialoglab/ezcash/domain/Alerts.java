package lk.dialoglab.ezcash.domain;

// Generated Mar 30, 2015 2:46:26 PM by Hibernate Tools 3.6.0

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Alerts generated by hbm2java
 */
@Entity
@Table(name = "alerts", catalog = "cashatm")
public class Alerts implements java.io.Serializable {

    private Integer alertId;
    private AlertType alertType;
    private Atm atm;
    private Date triggeredTime;
    private Date solvedTime;

    public Alerts() {
    }

    public Alerts(AlertType alertType) {
        this.alertType = alertType;
    }

    public Alerts(AlertType alertType, Atm atm, Date triggeredTime, Date solvedTime) {
        this.alertType = alertType;
        this.atm = atm;
        this.triggeredTime = triggeredTime;
        this.solvedTime = solvedTime;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "alert_id", unique = true, nullable = false)
    public Integer getAlertId() {
        return this.alertId;
    }

    public void setAlertId(Integer alertId) {
        this.alertId = alertId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "alert_type_id", nullable = false)
    public AlertType getAlertType() {
        return this.alertType;
    }

    public void setAlertType(AlertType alertType) {
        this.alertType = alertType;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "atm_id")
    public Atm getAtm() {
        return this.atm;
    }

    public void setAtm(Atm atm) {
        this.atm = atm;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "triggered_time", length = 19)
    public Date getTriggeredTime() {
        return this.triggeredTime;
    }

    public void setTriggeredTime(Date triggeredTime) {
        this.triggeredTime = triggeredTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "solved_time", length = 19)
    public Date getSolvedTime() {
        return this.solvedTime;
    }

    public void setSolvedTime(Date solvedTime) {
        this.solvedTime = solvedTime;
    }

}
