package entities.enums;

public enum TipoDeTransacao {

	RECEITA {
		@Override
		public Boolean getTipo() {
			return true;
		}
	}, DESPESA {
		@Override
		public Boolean getTipo() {
			return false;
		}
	};

	public abstract Boolean getTipo();
	
}
