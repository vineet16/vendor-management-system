package com.vineet.sample_project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class ProductRegistration {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String Kyc;

    private String Description;

    public ProductRegistration(Long id, Company company, Product product, String kyc, String description) {
        this.id = id;
        this.company = company;
        this.product = product;
        Kyc = kyc;
        Description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRegistration that = (ProductRegistration) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ProductRegistration{" +
                "id=" + id +
                ", company=" + company +
                ", product=" + product +
                ", Kyc='" + Kyc + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
