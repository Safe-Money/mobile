import retrofit2.Response

interface ICadastrarRepository {
    suspend fun cadastrarUsuario(nome: String, dtNascimento: String, email: String, senha: String): Response<Usuario>
}
