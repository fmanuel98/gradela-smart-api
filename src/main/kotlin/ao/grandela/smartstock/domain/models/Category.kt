package ao.grandela.smartstock.domain.models

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepositoryBase
import java.time.LocalDate
import javax.enterprise.context.ApplicationScoped
import javax.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp

@Entity
@Table(name = "category")
data class Category(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    @Column(nullable = false) val name: String = "",
    @Column(updatable = false) @CreationTimestamp val createdAt: LocalDate? = null,
    @Column(nullable = false) @UpdateTimestamp val updatedAt: LocalDate? = null,
) {
  constructor(id: Long) : this(id, "")
}

@ApplicationScoped class CategoryRepository : PanacheRepositoryBase<Category, Long>
