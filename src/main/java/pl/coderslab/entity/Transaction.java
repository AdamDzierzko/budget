package pl.coderslab.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaction")
public class Transaction {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime timeAdded;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate timeTransaction;

    @NotBlank
    @Size(max = 50)
    @Column(length = 50)
    private String name;

    @NotNull
    @Digits(integer = 15, fraction = 2)
    @Column(precision = 15, scale = 2, nullable = false)
    private Double value;   //

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Budget budget;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Type type;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Subcategory subcategory;

}
