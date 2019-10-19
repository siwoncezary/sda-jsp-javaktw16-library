package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class RentBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private BookBean book;
    @ManyToOne
    private UserBean user;
    private LocalDate rentDate;
    private LocalDate returnDate;

    @PrePersist
    private void rentDateToCurrentDate(){
        //Lepiej wywoływać z obiektem Clock np. LocalDate.now(clock)
        rentDate = LocalDate.now();
    }
}
