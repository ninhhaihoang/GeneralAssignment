package fa.training.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
//import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ServiceCustomerKey implements Serializable{

    private static final long serialVersionUID = 1L;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Customer customer;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Service service;

    @Column(name = "ngay_su_dung")
    private Date usageDate;

    @Column(name = "gio_su_dung")
    private String usageTime;

}
