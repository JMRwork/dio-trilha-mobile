enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String) {
    override fun toString(): String {
        return nome
    }
}

data class ConteudoEducacional(var nome: String, val nivel: Nivel, val duracao: Int = 60){
    override fun toString(): String {
        return "$nome ${nivel.toString()} $duracao horas"
    }
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        this.inscritos.add(usuario)
    }

    override fun toString(): String {
        return """
            Formação: 
            $nome
            Conteudo: 
            ${conteudos.toString()}
            inscritos: 
            $inscritos
        """.trimIndent()
    }
}

fun main() {
    val curso1 = Formacao(
        "curso 1",
        listOf(
            ConteudoEducacional("Conteudo 1", Nivel.BASICO, 10),
            ConteudoEducacional("Conteudo 2", Nivel.INTERMEDIARIO, 12),
            ConteudoEducacional("Conteudo 3", Nivel.DIFICIL, 18)
        )
    )
    val usuario1 = Usuario("José")
    val usuario2 = Usuario("João")

    curso1.matricular(usuario1)
    curso1.matricular(usuario2)
    println(curso1)
}