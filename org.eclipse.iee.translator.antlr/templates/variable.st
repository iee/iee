
variable(type, id, variable, path) ::= <<
	new Runnable() {
		private  <type> variable;
		private Runnable init (<type> var)
		{
			variable = var;return this;
		}
		@Override
		public void run() {
			org.eclipse.iee.document.api.EvaluationContextHolder.putResult("<id>", String.valueOf(variable));
		}
	}.init(<variable>).run();
>>