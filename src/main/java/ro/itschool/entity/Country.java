package ro.itschool.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

  @OneToMany(mappedBy = "country")
  private List<City> cities = new ArrayList<>();

  public Country(
          final Long id, final String name, final String phonecode, final String capital, final String currency,
          final String currencyName,
          final String currencySymbol, final String nationality, final BigDecimal latitude, final BigDecimal longitude,
          final LocalDateTime createdAt,
          final LocalDateTime updatedAt) {
    this.id = id;
    this.name = name;
    this.phonecode = phonecode;
    this.capital = capital;
    this.currency = currency;
    this.currencyName = currencyName;
    this.currencySymbol = currencySymbol;
    this.nationality = nationality;
    this.latitude = latitude;
    this.longitude = longitude;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }
}

