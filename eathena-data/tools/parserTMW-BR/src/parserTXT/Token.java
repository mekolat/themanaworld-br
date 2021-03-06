/**
 * Define o objeto Token. Utilizado pela classe Script.
 * 
 * @data 10/05/2010
 * @author Diogo_RBG - http://diogorbg.blogspot.com/
 * 
 * Wikipédia: Token em computação é um segmento de texto ou símbolo que pode ser manipulado por
 * um parser, que fornece um significado ao texto; em outras palavras, é um conjunto de caracteres
 * (de um alfabeto, por exemplo) com um significado coletivo.
 */

package parserTXT;

public class Token {

	public enum TipoToken{
		CMD, // Comando
		TXT, // Texto
		NUM, // Número
		VAR, // Variável ou constante
		EXP  // Uma expressão complexa.
	}

	private TipoToken tipo;
	private String valor;

	public Token(TipoToken _tipo, String _valor) {
		tipo = _tipo;
		valor = _valor;
	}

	/**
	 * O tipo de token. Que pode ser comando, texto, valor ou variável/constante.
	 * @return Um objeto do tipo TipoToken.
	 */
	public TipoToken getTipo() {
		return tipo;
	}

	/**
	 * Converte o tipo do token para CMD.
	 * @return Retorna true caso seja possível converter para CMD.
	 */
	public boolean paraComando(){
		if(tipo==TipoToken.VAR){
			String sub = valor.substring(0,1);
			if( sub.equals("@") ) return false;
			if( sub.equals("#") ) return false;
			if( sub.equals("$") ) return false;
			tipo = TipoToken.CMD;
			return true;
		}
		return false;
	}

	/**
	 * Retorna o valor do token. Tokens do tipo TXT não possuem aspas duplas >> " << e nem caracteres de escape >> \ <<.
	 * @return Uma string contendo o token em si.
	 */
	public String getValor() {
		return valor;
	}

}
