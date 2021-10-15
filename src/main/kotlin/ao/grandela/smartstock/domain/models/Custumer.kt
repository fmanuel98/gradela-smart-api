package ao.grandela.smartstock.domain.models

import javax.persistence.*
@Entity
@Table(name = "custumer")
data class Custumer(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,val name:String="") {}
