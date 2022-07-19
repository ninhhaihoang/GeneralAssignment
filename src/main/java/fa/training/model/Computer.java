package fa.training.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.*;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "May")
public class Computer implements Serializable{
    @Id
    @Column(name = "ma_may")
    private String computerCode;
    @Column(name = "vi_tri")
    private String location;
    @Column(name = "trang_thai")
    private String status;


}
