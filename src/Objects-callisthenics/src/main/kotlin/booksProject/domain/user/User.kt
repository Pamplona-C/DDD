package booksProject.domain.user

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
@Table(name = "users")
data class User(
    @Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false, unique = true)
    var username: String? = null,

    @JsonIgnore
    @Column(nullable = false)
    private val password: String,

    @Column(nullable = true, unique = true)
    val email: String? = null,

    @Column(nullable = false)
    val enable: Boolean = true,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val role : Roles = Roles.USER

) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf(SimpleGrantedAuthority("ROLRE_${role.name}"))
    }

    override fun getPassword(): String = password

    override fun getUsername(): String = username ?: ""

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = enable
}
