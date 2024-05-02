
data class UserConta(
    val id: Int? = null,
    val nome: String,
    val banco: String,
    val tipo: Int,
    val saldo: Double,
    val fkUsuario: FkUsuario
)

