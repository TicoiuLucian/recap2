package ro.itschool.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cities")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class City {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(name = "country_id", nullable = false)
  @JsonBackReference
  private Country country;

  @Column(name = "country_code", nullable = false)
  private String countryCode;

  @Column(nullable = false, precision = 10, scale = 8)
  private BigDecimal latitude;

  @Column(nullable = false, precision = 11, scale = 8)
  private BigDecimal longitude;

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;

  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updatedAt;

  public City(Long id, String name, String countryCode, BigDecimal latitude, BigDecimal longitude, LocalDateTime updatedAt, LocalDateTime createdAt) {
    this.id = id;
    this.name = name;
    this.countryCode = countryCode;
    this.latitude = latitude;
    this.longitude = longitude;
    this.updatedAt = updatedAt;
    this.createdAt = createdAt;
  }
}

