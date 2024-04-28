
data class UserConta(
    val nome: String,
    val banco: String,
    val tipo: Int,
    val saldo: Double,
    val fkUsuario: FkUsuario
)

