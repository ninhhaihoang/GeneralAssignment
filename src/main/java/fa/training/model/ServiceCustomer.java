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
@Table(name = "SuDungDichVu")
public class ServiceCustomer implements Serializable{
    @EmbeddedId
    private ServiceCustomerKey id;

    @Column(name = "so_luong")
    private int number;

}
