package ro.itschool.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "countries")
@ToString
public class Country {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 100)
  private String name;

  @Column
  private String phonecode;

  @Column
  private String capital;

  @Column
  private String currency;

  @Column(name = "currency_name")
  private String currencyName;

  @Column(name = "currency_symbol")
  private String currencySymbol;

  @Column
  private String nationality;

  @Column(precision = 10, scale = 8)
  private BigDecimal latitude;

  @Column(precision = 11, scale = 8)
  private BigDecimal longitude;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updatedAt;

  @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
  private List<City> cities = new ArrayList<>();

}

