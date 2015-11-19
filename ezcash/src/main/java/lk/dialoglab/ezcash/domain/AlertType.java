package lk.dialoglab.ezcash.domain;

// Generated Mar 30, 2015 2:46:26 PM by Hibernate Tools 3.6.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * AlertType generated by hbm2java
 */
@Entity
@Table(name = "alert_type", catalog = "cashatm")
public class AlertType implements java.io.Serializable {

    private Integer alertTypeId;
    private String alertName;
    private String priority;
    private Set<Alerts> alertses = new HashSet<Alerts>(0);

    public AlertType() {
    }

    public AlertType(String alertName, String priority) {
        this.alertName = alertName;
        this.priority = priority;
    }

    public AlertType(String alertName, String priority, Set<Alerts> alertses) {
        this.alertName = alertName;
        this.priority = priority;
        this.alertses = alertses;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "alert_type_id", unique = true, nullable = false)
    public Integer getAlertTypeId() {
        return this.alertTypeId;
    }

    public void setAlertTypeId(Integer alertTypeId) {
        this.alertTypeId = alertTypeId;
    }

    @Column(name = "alert_name", nullable = false, length = 45)
    public String getAlertName() {
        return this.alertName;
    }

    public void setAlertName(String alertName) {
        this.alertName = alertName;
    }

    @Column(name = "priority", nullable = false, length = 15)
    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "alertType")
    public Set<Alerts> getAlertses() {
        return this.alertses;
    }

    public void setAlertses(Set<Alerts> alertses) {
        this.alertses = alertses;
    }

}
