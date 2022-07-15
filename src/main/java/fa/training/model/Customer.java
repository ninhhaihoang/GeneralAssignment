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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "KhachHang")
public class Customer implements Serializable{
    @Id
    @Column(name = "ma_kh")
    private String customerCode;
    @Column(name = "ten_kh")
    private String fullName;
    @Column(name = "dia_chi")
    private String address;
    @Column(name = "dien_thoai")
    private String phone;
    @Column(name = "email")
    private String email;
}
