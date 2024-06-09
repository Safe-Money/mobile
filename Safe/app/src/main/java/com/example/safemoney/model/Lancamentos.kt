data class Lancamentos(
    val nome: String,
    val valor: Double,
    val data: String,
    val fkConta: Conta1,
    val fkUsuario: Usuario1,
    val fkTipoTransacao: TipoTransacao,
    val fkCategoria: Categoria1
)

data class Conta1(
    val id: Int
)

data class Usuario1(
    val id: Int
)

data class TipoTransacao(
    val id: Int
)

data class Categoria1(
    val id: Int,
    val nome: String? = null
)

data class fkCont1(
    val id: Int,
    val nome: String,
    val banco: String,

)


data class LancamentosGet(
    val nome: String,
    val valor: Double,
    val data: String,
    val fkCategoria: Categoria1? = null,
    val fkConta: fkCont1? = null
)

data class LancFixoTotal(
    val receita: Double,
    val despesa: Double,
    val saldo: Double
)