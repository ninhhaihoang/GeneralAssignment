package fa.training.model;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name = "DichVu")
public class Service implements Serializable{
    @Id
    @Column(name = "ma_dv")
    private String serviceCode;
    @Column(name = "ten_dv")
    private String serviceName;
    @Column(name = "don_vi_tinh")
    private String unit;
    @Column(name = "don_gia")
    private long price;
}
