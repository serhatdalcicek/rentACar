package com.etiya.rentACar.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity // Bu sınıfın bir veritabanı nesnesi olduğunu belirtmek için
@AllArgsConstructor
@NoArgsConstructor
@Table(name="statuses") // Veritabanında karşılık geldiği tablo.
public class Status {
  @Id  // Id alanı olduğunu belirtmek için.
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Otomatik artan alanı belirtmek.
  @Column(name = "id") // Veritabanında karşılık geldiği alan.
  private int id;
  
  @Column(name = "name")
  private String name;
  
  @OneToMany(mappedBy = "status")
  private List<Maintenance> maintenances;
}
