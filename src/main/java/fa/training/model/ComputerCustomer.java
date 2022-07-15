package fa.training.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "SuDungMay")
public class ComputerCustomer implements Serializable{
    @EmbeddedId
    private ComputerCustomerKey id;

    @Column(name = "thoi_gian_su_dung")
    private int usedDuration;
}
