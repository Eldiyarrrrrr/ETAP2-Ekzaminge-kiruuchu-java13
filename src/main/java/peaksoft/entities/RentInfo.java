package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

@Entity
@Table(name = "rent_info")
@Getter @Setter
@NoArgsConstructor
@SequenceGenerator(name = "base_gen_id", sequenceName = "rentInfos_seq", allocationSize = 1)
public class RentInfo extends BaseEntityId {
    @Column(name = "check_in", nullable = false)
    private LocalDate checkIn;
    @Column(name = "check_out", nullable = false)
    private LocalDate checkOut;
    @ManyToOne
    private Agency agency;
    @OneToOne
    private House house;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Owner owner;

    public RentInfo(LocalDate checkIn, LocalDate checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "RentInfo{" +
                "checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                '}';
    }
}
